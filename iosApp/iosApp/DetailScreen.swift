//
//  DetailScreen.swift
//  iosApp
//
//  Created by Juan Rodríguez on 31/1/22.
//
import SwiftUI
import shared
import MapKit
import FirebaseDatabase
import FirebaseAuth
import CoreMedia

class ObservableDetailModel: ObservableObject {
    private var viewModel: DetailViewModel?
    var ref: DatabaseReference = Database.database().reference()
    private let auth = Auth.auth()
    
    @Published
    var loading = false
    
    @Published
    var data: GeoJsonServerResult?
    
    @Published
    var error: String?
    var sigren: String?
    
    var gsonResult : [GeoJsonServerResult.Feature]?
    
    @Published
    var geoJson: String?
    
    func activate(_ route: Space) {
        viewModel = DetailViewModel { [weak self] dataState in
            self?.loading = dataState.loading
            self?.geoJson = dataState.data?.second as String?
            self?.data = dataState.data?.first
            self?.error = dataState.exception
            
        }
        sigren = route.args
        viewModel?.getRoute(sigren: route.args)
        self.ref.child("favorites").child(auth.currentUser!.uid).child(route.args).observe(DataEventType.value, with: { snapshot in
            
            self.gsonResult = snapshot.children.compactMap { ($0 as! DataSnapshot).value as? GeoJsonServerResult.Feature }
        });
    }
    
    func deactivate() {
        viewModel?.onDestroy()
        viewModel = nil
    }
    
    func getRoute(_ sigren: String) {
        viewModel?.getRoute(sigren: sigren)
    }
    
    func setFavorite( feature: GeoJsonServerResult.Feature, isLiked: Bool) {
        if let authUid = auth.currentUser?.uid {
            let refer = ref.child("favorites").child(authUid).child(sigren ?? "").child("\(feature.properties?.atrGrId ?? -1)")
            if isLiked {
                refer.setValue(feature)
            }else {
                refer.removeValue()
            }
        }
    }
    
}



struct DetailScreen: View {
    private struct DefaultRegion {
        static let latitude = 9.9333
        static let longitude = -84.0833
    }
    
    private struct Span {
        static let delta = 0.1
    }
    let route: Space
    @StateObject
    var observableModel =  ObservableDetailModel()
    
    @State var coordinateRegion: MKCoordinateRegion = .init(center: CLLocationCoordinate2D(latitude: DefaultRegion.latitude, longitude: DefaultRegion.longitude),span: .init(latitudeDelta: Span.delta, longitudeDelta: Span.delta))
    @State private var showModal = false
    var body: some View {
        
        VStack {
            if let geo = observableModel.geoJson {
                MapView(geoJson: geo)
                List {
                    if let features = observableModel.data?.features {
                        ForEach(features, id: \.self) { feature in
                            HStack {
                                Button(action: {
                                    showModal.toggle()
                                }){
                                    
                                    Text(feature.properties?.espacioNombre ?? feature.properties?.equipBNombre ?? "")
                                }
                                .buttonStyle(PlainButtonStyle())
                                .alert(isPresented: $showModal) {
                                    Alert(title: Text(feature.properties?.espacioNombre ?? feature.properties?.equipBNombre ?? ""),
                                          message: Text("Observaciones: \(feature.properties?.equipAObservaciones ?? "")")
                                          , dismissButton: .default(Text("Cerrar")))
                                }
                                Spacer()
                            }
                        }}
                }
            }
        }.onAppear(perform: {
            observableModel.activate(route)
        }).onDisappear(perform: {
            observableModel.deactivate()
        })
    }
}


struct MapView: UIViewRepresentable {
    typealias UIViewType = MKMapView
    let geoJson: String
    func makeUIView(context: Context) -> MKMapView {
        let mapView = MKMapView()
        
        mapView.delegate = context.coordinator
        let geoson = self.parseGeoJSon(geoJson)
        mapView.addOverlays(geoson.0)
        mapView.addAnnotations(geoson.1)
        
        
        return mapView
    }
    
    func parseGeoJSon(_ json: String) -> ([MKOverlay] ,[MKAnnotation]) {
        var geoJson = [MKGeoJSONObject]()
        do {
            let data = json.data(using: .utf8)
            geoJson = try MKGeoJSONDecoder().decode(data!)
        }catch {
        }
        var overlays = [MKOverlay]()
        var anotation = [MKAnnotation]()
        for item in geoJson {
            if let feature = item as? MKGeoJSONFeature {
                for geo in feature.geometry {
                    if let polygon = geo as? MKPolygon {
                        overlays.append(polygon)
                    }else if let polygon = geo as? MKMultiPolygon {
                        overlays.append(polygon)
                    }else if let anot = geo as? MKPointAnnotation {
                        anotation.append(anot)
                    }else if let poly = geo as? MKMultiPolyline {
                        overlays.append(poly)
                    }else {
                        print("\(geo)")
                    }
                }
            }
        }
        return (overlays,anotation)
    }
    func updateUIView(_ uiView: MKMapView, context: Context) {}
    
    func makeCoordinator() -> MapCoordinator {
        .init()
    }
}



final class MapCoordinator: NSObject, MKMapViewDelegate {
    
    func mapView(_ mapView: MKMapView, rendererFor overlay: MKOverlay) -> MKOverlayRenderer {
        if let polygon = overlay as? MKPolygon {
            let renderer  = MKPolygonRenderer(polygon: polygon)
            renderer.fillColor = UIColor.red
            renderer.strokeColor = UIColor.black
            return renderer
        }
        
        if let polygon = overlay as? MKMultiPolygon {
            let renderer  = MKMultiPolygonRenderer(overlay: polygon)
            renderer.fillColor = UIColor.red
            renderer.strokeColor = UIColor.black
            return renderer
        }
        
        if let line = overlay as? MKMultiPolyline {
            let renderer  = MKMultiPolylineRenderer(overlay: line)
            renderer.strokeColor = UIColor.black
            renderer.lineWidth = 2
            return renderer
        }
        
        if overlay is MKPolyline {
            let polyline = MKPolylineRenderer(overlay: overlay)
            polyline.strokeColor = UIColor.blue
            return polyline
        }
        return MKOverlayRenderer(overlay: overlay)
    }
    
}


struct SheetView: View {
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        Button("Press to dismiss") {
            dismiss()
        }
        .font(.title)
        .padding()
        .background(Color.black)
    }
}

struct ContentView: View {
    @State private var showingSheet = false
    
    var body: some View {
        Button("Show Sheet") {
            showingSheet.toggle()
        }
        .sheet(isPresented: $showingSheet) {
            SheetView()
        }
    }
}
