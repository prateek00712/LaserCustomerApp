import Dependencies

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.utilities"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material3)
//    testImplementation(libs.junit)
//    androidTestImplementation(Dependencies.androidxJUnit)
//    androidTestImplementation(Dependencies.espressoCore)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(Dependencies.uiTestJunit4)
//    implementation(Dependencies.hiltAndroid)
//    implementation(Dependencies.hiltAndroidCompiler)
//    implementation(Dependencies.hiltCompiler)
}