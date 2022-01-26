//
//  ContentView.swift
//  iosApp
//
//  Created by Juan Rodríguez on 23/1/22.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        RedView()
    }
}

struct RedView: View {
    var body: some View {
        let list = RouteService().getRoutes()
        NavigationView {
            List {
                ForEach(list, id: \.self) { route in
                    HStack {
                        Text(route.name)
                        NavigationLink(destination: RutesDetail()) {
                            EmptyView()
                        }
                        .buttonStyle(PlainButtonStyle())
                    }
                }
            }
            .navigationTitle("Rutas")
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}


struct RutesDetail: View {
    var body: some View {
        TabView {
            Text("Friends Screen")
                .tabItem {
                    Image(systemName: "heart.fill")
                    Text("Favourites")
                }
            DView()
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

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        DView()
    }
}


struct DView: View {
    @State private var score = 0

    var body: some View {
        NavigationView {
            
        }
    }
}
