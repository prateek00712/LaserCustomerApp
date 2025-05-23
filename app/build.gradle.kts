plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
    alias(libs.plugins.hilt)


}
apply(plugin = "io.objectbox")

android {
    namespace = "com.example.customermobileapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.customermobileapplication"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.runtimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.material3)
    implementation(Dependencies.androidui)
    implementation(Dependencies.toolingPreview)
    implementation(libs.androidx.ui.graphics)
    implementation(Dependencies.hiltAndroid)
    implementation(libs.androidx.foundation.android)
    kapt(Dependencies.hiltAndroidCompiler)
    kapt(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.androidxJUnit)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(Dependencies.uiTestJunit4)
    debugImplementation(Dependencies.uiTooling)
    debugImplementation(Dependencies.uiTestManifest)
    testImplementation(libs.junit)
//    implementation(project(Modules.utilities))
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
    implementation ("com.github.ozcanalasalvar:otpview:2.0.1")
    // ObjectBox Core
    implementation("io.objectbox:objectbox-android:4.2.0")

    // ObjectBox Kotlin Extensions
    implementation("io.objectbox:objectbox-kotlin:4.2.0")

    // ObjectBox Annotation Processor
    kapt("io.objectbox:objectbox-processor:4.2.0")
}

kapt{
    correctErrorTypes = true
    arguments {
        arg("objectbox.modelPath", "$projectDir/schemas/objectbox.json")
        arg("objectbox.myObjectBoxPackage", "com.example.customermobileapplication") // Change to your package name
        arg("objectbox.debug", true)
    }
}

