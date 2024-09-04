plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    //   id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.homework"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.homework"
        minSdk = 24
        targetSdk = 34
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

    implementation("com.github.bumptech.glide:glide:4.14.2")
    // Skip this if you don't want to use integration libraries or configure Glide.



    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.moshi)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Moshi
//    implementation("com.squareup.moshi:moshi:1.15.1")
//    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")

    implementation("com.google.code.gson:gson:2.10.1")

    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment)
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    kaptTest("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
    kaptAndroidTest("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
}