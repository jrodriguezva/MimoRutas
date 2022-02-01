//
//  ContentView.swift
//  iosApp
//
//  Created by Juan Rodríguez on 30/1/22.
//

import SwiftUI
import shared
import MapKit


struct ContentView: View {
    var body: some View {
        MainView()
    }
}

struct MainView: View {
    var body: some View {
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
        }
    }
}


struct RutesDetail: View {
    let route: Space
    var body: some View {
        TabView {
            Text("Friends Screen")
                .tabItem {
                    Image(systemName: "heart.fill")
                    Text("Favourites")
                }
            DetailScreen(route:route)
                .tabItem {
                    Image(systemName: "person.fill")
                    Text("Friends")
                }
            Text("Nearby Screen")
                .tabItem {
                    Image(systemName: "mappin.circle.fill")
                    Text("Nearby")
                }
        }
    }
}
