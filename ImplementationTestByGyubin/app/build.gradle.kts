plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.jgeun.study"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.jgeun.study"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
	buildFeatures {
		dataBinding = true
	}
}

dependencies {
	implementation(project(":core:domain"))
	implementation(project(":core:model"))

	implementation("androidx.activity:activity-ktx:1.1.0")
	implementation("androidx.fragment:fragment-ktx:1.2.5")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	implementation("com.github.bumptech.glide:glide:4.16.0")

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}