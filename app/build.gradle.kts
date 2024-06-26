plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id("com.google.devtools.ksp")

}
android {
    namespace = "com.example.interviewproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.interviewproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)
    ksp("androidx.hilt:hilt-compiler:1.2.0")
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.work)
    implementation(libs.androidx.work.runtime.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.androidx.navigation.compose.v274)
    implementation (libs.accompanist.flowlayout)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation (libs.kotlinx.coroutines.android.v164)
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v262)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.converter.gson)
    implementation (libs.okhttp)
    implementation (libs.logging.interceptor)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation (libs.ktor.client.websocket)
    implementation ("io.ktor:ktor-client-json:2.3.12")
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.serialization.json)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}