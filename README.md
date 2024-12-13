
README Documentation

Speech Management App

A modern Android application for managing, recording, and viewing speech-related content. This app utilizes Jetpack Compose for UI, integrates Firebase Authentication, and supports video recording, audio processing, and navigation through multiple features like history, video speeches, and learning paths.

Features

	•	Speech Search: Search for specific speeches using keywords.
	•	Video Recording: Record videos directly within the app.
	•	Audio Processing: Handle audio data efficiently.
	•	Navigation: Smooth transitions between pages like history, videos, audio, and learning paths.
	•	Firebase Integration: User authentication and profile management.
	•	Material Design 3: Built with modern UI principles.

Getting Started

Prerequisites

Ensure you have the following:
	•	Android Studio: Latest version.
	•	Kotlin 1.9.0 or later.
	•	Jetpack Compose: Set up for Material 3.
	•	Firebase Authentication: Configured in your project.
	•	Required Permissions:
	•	Camera
	•	Audio Recording
	•	External Storage Read/Write

Installation

	1.	Clone the repository: https://github.com/presentation-app-capstone-bangkit/Komura-App.git

git clone https://github.com/presentation-app-capstone-bangkit/Komura-App.git


	2.	Open the project in Android Studio.
	3.	Sync Gradle and resolve dependencies.
	4.	Set up Firebase in the google-services.json file.

Usage

Running the App

	•	Launch the app in Android Studio using an emulator or a physical device.
	•	Grant required permissions when prompted.
	•	Use the search bar to find speeches or navigate using the provided buttons.

Key Components

Main Activity

The main entry point of the app, handling:
	•	Video recording using ActivityResultContracts.CaptureVideo.
	•	Search functionality with real-time updates using ViewModel.
	•	Navigation between pages via NavController.

Floating Action Button (FAB)

Allows quick access to:
	•	Record audio.
	•	Start video recording.

Search

Implemented with a TextField to filter speech history.

Code Example

Video Recording

private fun Context.createVideoFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val dir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        ?: throw IllegalStateException("Failed to create video storage directory")
    return File.createTempFile("VIDEO_${timeStamp}_", ".mp4", dir)
}

Dependencies

Add these to your build.gradle.kts:

dependencies {
    implementation("androidx.compose.material3:material3:<version>")
    implementation("com.google.firebase:firebase-auth-ktx:<version>")
    implementation("androidx.navigation:navigation-compose:<version>")
    implementation("io.coil-kt:coil-compose:<version>")
    implementation("com.arthenica:ffmpeg-kit-full-gpl:<version>")
}

Contributing

	1.	Fork the repository.
	2.	Create a new branch.
	3.	Make your changes and commit them.
	4.	Submit a pull request for review.

License

This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgments

	•	Firebase for authentication.
	•	FFmpeg for video processing.
	•	Jetpack Compose for UI design.


