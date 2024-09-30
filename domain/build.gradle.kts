plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.domain"
    compileSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //mockito
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)

    //turbine
    testImplementation(libs.turbine)
    testImplementation( "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")


    //truth
    testImplementation(libs.truth)

    //hilt android
    implementation(libs.androidx.hilt.compose)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)

    //paging3
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
}