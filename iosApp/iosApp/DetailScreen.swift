//
//  DetailScreen.swift
//  iosApp
//
//  Created by Juan Rodríguez on 31/1/22.
//
import SwiftUI
import shared
import MapKit


class ObservableDetailModel: ObservableObject {
    private var viewModel: DetailViewModel?
    
    @Published
    var loading = false
    
    @Published
    var data: GeoJsonServerResult?
    
    @Published
    var error: String?
    
    @Published
    var geoJson: String?
    
    func activate(_ route: Space) {
        viewModel = DetailViewModel { [weak self] dataState in
            self?.loading = dataState.loading
            self?.geoJson = dataState.data?.second as String?
            self?.data = dataState.data?.first
            self?.error = dataState.exception
            
        }
        viewModel?.getRoute(sigren: route.args)
    }
    
    func deactivate() {
        viewModel?.onDestroy()
        viewModel = nil
    }
    
    func getRoute(_ sigren: String) {
        viewModel?.getRoute(sigren: sigren)
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
    
    var body: some View {
        VStack {
            MapView()
            List {
                if let features = observableModel.data?.features {
                    
                    ForEach(features, id: \.self) { feature in
                        HStack {
                            Text(feature.properties?.espacioNombre ?? feature.properties?.equipBNombre ?? "")
                                .buttonStyle(PlainButtonStyle())
                        }
                    }
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
  
  func makeUIView(context: Context) -> MKMapView {
    let mapView = MKMapView()

    let region = MKCoordinateRegion(
      center: CLLocationCoordinate2D(latitude: 40.71, longitude: -74),
      span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5))
    mapView.setRegion(region, animated: true)
      
    return mapView
  }

  func updateUIView(_ uiView: MKMapView, context: Context) {}
}
