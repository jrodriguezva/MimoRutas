//
//  RouteDetailViewModel.swift
//  iosApp
//
//  Created by Juan Rodríguez on 25/1/22.
//

import Foundation
import shared

final class RouteDetailViewModel: ObservableObject {
    @Published var state: UiState = UiState()
    
    private let userDefaults: UserDefaults = .standard
    
    init() {
        notes = getAllNotes()
    }
    
    func saveNote(description: String) {
        let newNote = NoteModel(description: description)
        notes.insert(newNote, at: 0)
        encodeAndSaveAllNotes()
    }
    
    private func encodeAndSaveAllNotes() {
        if let encoded = try? JSONEncoder().encode(notes) {
            userDefaults.set(encoded, forKey: "notes")
        }
    }
    struct UiState {
        let location: Location? = nil
        let data: GeoJsonServerResult? = nil
        let loading: Bool = false
        let error: Int? = nil
    }
}
