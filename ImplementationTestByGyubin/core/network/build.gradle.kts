plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	id("org.jetbrains.kotlin.plugin.serialization")
}

android {
	namespace = "com.jgeun.core.network"
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
	implementation(project(":core:model"))

	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
	implementation("com.squareup.retrofit2:retrofit:2.11.0")
	implementation("com.squareup.retrofit2:converter-kotlinx-serialization:2.11.0")
	implementation("com.squareup.okhttp3:okhttp:4.12.0")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}