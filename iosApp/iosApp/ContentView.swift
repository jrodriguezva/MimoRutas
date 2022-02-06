//
//  ContentView.swift
//  iosApp
//
//  Created by Juan Rodríguez on 30/1/22.
//

import SwiftUI
import shared
import MapKit
import FirebaseAuth



struct MainView: View {
    @State var isLogged: Bool = true
    
    var body: some View {
        if isLogged {
            let list = RouteService().getAllSpaces()
            NavigationView {
                List {
                    ForEach(list, id: \.self) { route in
                        HStack {
                            Text(route.name)
                            NavigationLink(destination: RutesDetail(route: route)) {
                                EmptyView()
                            }
                            .buttonStyle(PlainButtonStyle())
                        }
                    }
                }
                .navigationTitle("Todos los espacios")
                .navigationBarTitleDisplayMode(.inline)
                .toolbar {
                    Button("Cerrar sesión") {
                        do {
                            try Auth.auth().signOut()
                            isLogged = false
                        }catch {
                            
                        }
                    }
                }
            }
        }else {
            InitScreen()
        }
    }
}


struct RutesDetail: View {
    let route: Space
    init(route: Space) {
        self.route = route
        UITabBar.appearance().backgroundColor = .systemBackground
    }
    
    var body: some View {
        VStack{
            TabView {
                DetailScreen(route:route)
                    .tabItem {
                        Image(systemName: "location.fill")
                        Text("Espacios")
                    }
            }
        }
    }
}
