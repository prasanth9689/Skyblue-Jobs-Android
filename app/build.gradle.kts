
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.skyblue.skybluefindjob"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.skyblue.skybluefindjob"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
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
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.material3:material3-android:1.2.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Retrofit with Scalar Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
//    implementation ("androidx.activity:activity-compose:1.5.1")
//    implementation ("androidx.compose:compose-bom:2022.10.00")
//    implementation ("androidx.compose.ui:ui")
//    implementation ("androidx.compose.ui:ui-graphics")
//    implementation ("androidx.compose.ui:ui-tooling-preview")
//    implementation ("androidx.compose.material3:material3")
//    androidTestImplementation ("androidx.compose:compose-bom:2022.10.00")
//    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
//    debugImplementation ("androidx.compose.ui:ui-tooling")
//    debugImplementation ("androidx.compose.ui:ui-test-manifest")
//
//    // Splash API
//    implementation ("androidx.core:core-splashscreen:1.0.1")
}