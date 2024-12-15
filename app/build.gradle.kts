plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.garciarodriguez.juanmiguel.pmdm02.marioapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.garciarodriguez.juanmiguel.pmdm02.marioapp"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation ("androidx.navigation:navigation-fragment-ktx:2.8.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.8.2")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("com.google.code.gson:gson:2.8.5")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}