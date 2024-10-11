plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    id("kotlin-kapt")
}
android {
    namespace = "com.ezgieren.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ezgieren.weatherapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.androidx.activity.compose)
    implementation (libs.ui)
    implementation (libs.ui.tooling.preview)
    implementation (libs.androidx.material)

    // Hilt
    implementation (libs.hilt.android)
    implementation(libs.androidx.material3.android)
    kapt (libs.hilt.compiler)

    // Retrofit & Gson
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Coroutine Support
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    // ViewModel & LiveData
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.lifecycle.livedata.ktx)

    // Coil (Image Loading)
    implementation (libs.coil.compose)

    // Testing Libraries
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.espresso.core)
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.ui.tooling)
}