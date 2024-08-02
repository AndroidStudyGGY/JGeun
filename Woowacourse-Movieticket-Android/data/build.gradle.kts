plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	id("kotlin-kapt")
	id("dagger.hilt.android.plugin")
	alias(libs.plugins.kotlinx.serialization)
}

android {
	namespace = "com.jgeun.data"
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
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_17.toString()
	}
	buildFeatures {
		buildConfig = true
	}
}

dependencies {
	implementation(project(":domain"))

	implementation(libs.androidx.paging.runtime)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)

	implementation(libs.retrofit)
	implementation(libs.okhttp.logging.interceptor)
	implementation(libs.kotlinx.serialization.converter)

	implementation(libs.kotlinx.serialization)
}