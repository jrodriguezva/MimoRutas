//
//  iosAppApp.swift
//  iosApp
//
//  Created by Juan Rodríguez on 30/1/22.
//

import SwiftUI
import Firebase
@main
struct iosAppApp: App {
    init() {
        FirebaseApp.configure()
    }
    var body: some Scene {
        WindowGroup {
            InitScreen()
        }
    }
}
