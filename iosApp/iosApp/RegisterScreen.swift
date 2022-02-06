//
//  RegisterScreen.swift
//  iosApp
//
//  Created by Juan Rodríguez on 30/1/22.
//

import SwiftUI
import shared
import FirebaseAuth

class ObservableRegisterModel: ObservableObject {
    private var viewModel: RegisterViewModel?
    
    @Published
    var loading = false
    
    @Published
    var loggedIn: Bool = false
    
    @Published
    var error: Bool = false
    
    func activate() {
        viewModel = RegisterViewModel { [weak self] dataState in
            self?.loading = dataState.loading
            self?.loggedIn = dataState.data as? Bool ?? false
        }
    }
    
    func deactivate() {
        viewModel?.onDestroy()
        viewModel = nil
    }
    
    func onRegister(_ user: String,_ email: String,_ pass: String) {
        //viewModel?.register(user: user,email: email,pass:pass)
        Auth.auth().createUser(withEmail: email, password: pass) { authResult, error in
            if let userFirebase = authResult?.user {
                let changeRequest = userFirebase.createProfileChangeRequest()
                changeRequest.displayName = user
                changeRequest.commitChanges { error in
                    if error != nil {
                        self.error = true
                    }
                }
                
            }else {
                self.error = true
            }
        }
    }
    
}


struct RegisterScreen : View {
    @ObservedObject
    var observableModel = ObservableRegisterModel()
    var body: some View {
        if observableModel.loggedIn {
            MainView()
        }else {
        RegisterView(
            loggedIn: observableModel.loggedIn ?? false,
            onLoginClick:{ observableModel.onRegister($0, $1, $2) }
        ).alert(isPresented: $observableModel.error) {
            Alert(title: Text("Error"), message: Text("Usuario o contraseña incorrectos"), dismissButton: .default(Text("OK")))
        }
        .onAppear(perform: {
            observableModel.activate()
        })
        .onDisappear(perform: {
            observableModel.deactivate()
        })
        }
    }
}
struct RegisterView: View {
    @State var username: String = ""
    @State var email: String = ""
    @State var password: String = ""
    var loggedIn: Bool
    var onLoginClick: (String,String,String) -> Void
    var body: some View {
        
        VStack {
            WelcomeText()
            TextField("Nombre de usuario", text: $username)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(5.0)
                .padding(.bottom, 20)
            TextField("Email", text: $email)
                .padding()
                .background(lightGreyColor)
                .textInputAutocapitalization(.never)
                .cornerRadius(5.0)
                .padding(.bottom, 20)
            SecureField("Password", text: $password)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(5.0)
                .padding(.bottom, 20)
            Button(action: {
                onLoginClick(username,email,password)
            }) {
                RegisterText()
            }
            
        }
        .padding()
    }
}

struct RegisterText : View {
    var body: some View {
        return Text("Sign Up!")
            .font(.largeTitle)
            .fontWeight(.semibold)
            .padding(.bottom, 20)
    }
}

