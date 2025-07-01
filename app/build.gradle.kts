plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "co.com.alameda181.unidadresidencialalameda181"
    compileSdk = 34

    defaultConfig {
        applicationId = "co.com.alameda181.unidadresidencialalameda181"
        minSdk = 26
        targetSdk = 34
        versionCode = 1_0_20_014
        versionName = "V1.0.20 build 014 Se incorpora tarea de mensajes enviados por el administrador"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "FMC_TOPIC", "\"allUsers\"")
        }

        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "FMC_TOPIC", "\"allUsers\"")
        }

    }
    lint {
          baseline = file("lint-baseline.xml")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "jetified-httpclient-4.5.14.jar"
            excludes += "META-INF/DEPENDENCIES"
        }
    }
}

dependencies {

    implementation(project(":ui"))
    implementation(project(":ScheduleModule"))
    implementation(project(":aboutactivitymodule"))
    implementation(project(":alameda181-core"))
    implementation(project(":connect-gdrive"))
    implementation(project(":model"))
    implementation(project(":ServicesModule"))

    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation("com.google.android.gms:play-services-maps:19.0.0")
    implementation("com.google.android.play:integrity:1.4.0")
    implementation("com.google.maps.android:maps-compose:2.11.4")

    implementation("io.coil-kt:coil-compose:2.5.0")

    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")
    implementation("androidx.compose.compiler:compiler:1.5.15")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material:1.7.4")
    implementation("androidx.compose.material:material-icons-core:1.7.4")
    implementation("androidx.compose.material:material-icons-extended:1.7.4")
    implementation("androidx.work:work-runtime-ktx:2.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.firebase:firebase-messaging-ktx:24.0.3")

    kapt("com.google.dagger:hilt-android-compiler:2.52")
    implementation("com.google.dagger:hilt-android:2.52")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.hilt:hilt-common:1.2.0")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}
