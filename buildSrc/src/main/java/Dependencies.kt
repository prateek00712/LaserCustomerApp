object Dependencies {

//    implementation(libs.androidx.core.ktx)

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val runtimeKtx by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"}
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val androidui by lazy { "androidx.compose.ui:ui:${Versions.androidui}" }
    val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.toolingPrv}" }
    val material3 by lazy { "androidx.compose.material3:material3:${Versions.material3}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val androidxJUnit by lazy { "androidx.test.ext:junit:${Versions.androidxJUnit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val uiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.uiTestJunit4}" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.uiTooling}" }
    val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.uiTestManifest}" }
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
    val retrofit by lazy{"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val okhttp by lazy {"com.squareup.okhttp3:okhttp:${Versions.okhttp}"}
    val gsonConverter by lazy {"com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"}
    val loggingInterceptor by lazy{"com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"}
}

object Modules{
    const val utilities = ":utilities"
}