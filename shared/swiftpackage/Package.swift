// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "MimoRutas",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "MimoRutas",
            targets: ["MimoRutas"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "MimoRutas",
            path: "./MimoRutas.xcframework"
        ),
    ]
)
