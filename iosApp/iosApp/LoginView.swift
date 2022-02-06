import SwiftUI
import shared
import FirebaseAuth

let lightGreyColor = Color(red: 239.0/255.0, green: 243.0/255.0, blue: 244.0/255.0, opacity: 1.0)


class ObservableAuthModel: ObservableObject {
    private var viewModel: AuthViewModel?
    
    @Published
    var loading = false
    
    @Published
    var loggedIn: Bool = false
    
    @Published
    var error: Bool = false
    
    func activate() {
        viewModel = AuthViewModel { [weak self] dataState in
            self?.loading = dataState.loading
            self?.loggedIn = dataState.data as? Bool ?? false
            
        }
        loggedIn = Auth.auth().currentUser != nil
    }
    
    func deactivate() {
        viewModel?.onDestroy()
        viewModel = nil
    }
    
    func onLogin(_ email: String,_ pass: String) {
        //viewModel?.login(user: email,pass:pass)
        Auth.auth().signIn(withEmail: email, password: pass) { [weak self] authResult, error in
          guard let strongSelf = self else { return }
            if authResult?.user != nil {
                strongSelf.loggedIn = true
            } else {
                strongSelf.error = true
            }

        }
    }
    
}

struct InitScreen : View {
    @StateObject
    var observableModel =  ObservableAuthModel()
    var body: some View {
        if observableModel.loggedIn {
            MainView()
        } else {
            LoginScreen(
                observableModel:  observableModel
            ).onAppear(perform: {
                observableModel.activate()
            }).onDisappear(perform: {
                    observableModel.deactivate()
                }).alert(isPresented: $observableModel.error) {
                    Alert(title: Text("Error"), message: Text("Usuario o contraseña incorrectos"), dismissButton: .default(Text("OK")))
                }
        }
    }
}


struct LoginScreen : View {
    var observableModel : ObservableAuthModel
    var body: some View {
        NavigationView {
            LoginView(
                onLoginClick:{ observableModel.onLogin($0, $1) }
            )
        }
    }
}
struct LoginView: View {
    @State var username: String = ""
    @State var password: String = ""
    var onLoginClick: (String,String) -> Void
    var body: some View {
        VStack {
            WelcomeText()
            TextField("Username", text: $username)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(5.0)
                .textInputAutocapitalization(.never)
                .padding(.bottom, 20)
            SecureField("Password", text: $password)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(5.0)
                .padding(.bottom, 20)
            Button(action: {
                onLoginClick(username,password)
            }) {
                LoginButtonContent()
            }
            
            NavigationLink(destination: RegisterScreen()) {
                RegisterButtonContent()
            }
            
            .buttonStyle(PlainButtonStyle())
            
            
        }
        .padding()
        
    }
}

struct WelcomeText : View {
    var body: some View {
        return Text("Welcome!")
            .font(.largeTitle)
            .fontWeight(.semibold)
            .padding(.bottom, 20)
    }
}

struct LoginButtonContent : View {
    var body: some View {
        return Text("LOGIN")
            .font(.headline)
            .foregroundColor(.white)
            .padding()
            .frame(width: 220, height: 60)
            .background(Color.green)
            .cornerRadius(15.0)
    }
}

struct RegisterButtonContent : View {
    var body: some View {
        return Text("SING UP")
            .font(.headline)
            .foregroundColor(.white)
            .padding()
            .frame(width: 220, height: 60)
            .background(Color.green)
            .cornerRadius(15.0)
    }
}
