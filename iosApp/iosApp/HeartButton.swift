//
//  Hearth.swift
//  iosApp
//
//  Created by juan on 6/2/22.
//

import SwiftUI

struct HeartButton: View {
    var isLiked : Bool
    var action:  (Bool) -> Void
    private let animationDuration = 0.1
    private var animationScale: CGFloat {
        isLiked ? 0.7 : 1.3
    }
    @State private var animate = false
     
    
    var body: some View {
        Button(action: {
            self.animate = true
            DispatchQueue.main.asyncAfter(deadline: .now() + self.animationDuration, execute: {
                self.animate = false
                self.action(!isLiked)
            })
        }, label: {
            Image(systemName: isLiked ? "heart.fill": "heart")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 100)
                .foregroundColor(isLiked ? .red : .gray)
        })
            .scaleEffect(animate ? animationScale : 1)
            .animation(.easeIn(duration: animationDuration))
        
    }
    }
