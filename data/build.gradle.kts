plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.data"

    compileSdk = 34
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "API_KEY", "\"\"")
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    api(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    //retrofit
    implementation(libs.squareup.retrofit.core)
    implementation(libs.squareup.retrofit.converter)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

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