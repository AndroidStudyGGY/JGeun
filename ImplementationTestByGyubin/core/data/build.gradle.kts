plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.jgeun.core.data"
	compileSdk = 34

	defaultConfig {
		minSdk = 26

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(project(":core:domain"))
	implementation(project(":core:network"))

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}