//
//  MapViewControllerBridge.swift
//  iosApp
//
//  Created by Juan Rodríguez on 31/1/22.
//

import GoogleMaps
import SwiftUI

struct MapViewControllerBridge: UIViewControllerRepresentable {

  func makeUIViewController(context: Context) -> MapViewController {
    return MapViewController()
  }

  func updateUIViewController(_ uiViewController: MapViewController, context: Context) {
  }
}
