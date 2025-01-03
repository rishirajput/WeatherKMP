# WeatherKMP

WeatherKMP is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop. This project demonstrates the use of Kotlin Multiplatform to share code across different platforms, leveraging Compose Multiplatform for shared UI and Kotlin for shared business logic and data handling. The app provides current weather information for a specified city.


| Android       | iOS | Desktop | Web |
|---------------|-----|---------|-----|
| <img src="screenshots/android.png" alt="Splash Screen" width="280"/> | <img src="screenshots/iOS.png" alt="Splash Screen" width="280"/> | <img src="screenshots/desktop.png" alt="Splash Screen" width="280"/> | <img src="screenshots/web.png" alt="Splash Screen" width="280"/> |

## Features

- Display current temperature with a degree icon
- Show error messages using Snackbar for network issues and invalid city names

## Project Setup

### Prerequisites

- Android Studio Ladybug | 2024.2.1 Patch 3
- Kotlin 1.8.0 or higher
- Gradle 7.0 or higher

### Clone the Repository

```sh
git clone https://github.com/rishirajput/WeatherKMP
cd WeatherKMP
```
### Provide Weather API Key

To provide the Weather API key, you have the following options:

1. **Via Android Studio Settings**:
    - Go to `Android Studio -> Settings -> Build, Execution, Deployment -> Gradle-Android-Compiler`
    - Enter the following in the command line options: `-PweatherApiKey=YOUR_API_KEY`

2. **Via `local.properties` File**:
    - Open `local.properties` file in the root of your project and add the following line:
    ```properties
    weatherApiKey=YOUR_API_KEY
    ```

3. **Via Command Line**:
    - Pass the API key as a command line option when building or running the project:
    ```sh
    ./gradlew assembleDebug -PweatherApiKey=YOUR_API_KEY
    ```
## Architecture

This project follows Clean Architecture principles with MVVM (Model-View-ViewModel) pattern to ensure clean, modular, and testable code. The architecture is divided into three main layers:

1. **Presentation Layer**: Contains UI components and ViewModels.
2. **Domain Layer**: Contains business logic and use cases.
3. **Data Layer**: Contains data sources and repositories.

### Presentation Layer

- **ViewModel**: Manages UI-related data and handles user interactions.
- **Composable Functions**: Define the UI components using Jetpack Compose.

### Domain Layer

- **Use Cases**: Encapsulate business logic and interact with repositories.
- **Entities**: Represent core business objects.

### Data Layer

- **Repositories**: Provide data from various sources (e.g., network, database).
- **Data Sources**: Handle data operations (e.g., API calls, database queries).

### Example

Here is an example of how the layers interact:

- **ViewModel**: Fetches weather data using a use case and exposes it to the UI.
- **Use Case**: Retrieves weather data from the repository.
- **Repository**: Fetches weather data from a remote data source (e.g., API).

### Dependency Injection

This project uses Koin for dependency injection.

## Project Structure
This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

## Getting Started

### Prerequisites

- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/)
- [Yarn](https://yarnpkg.com/)

### Building the Project

To build the project, run the following command:

```sh
./gradlew build
```

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
