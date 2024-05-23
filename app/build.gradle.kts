

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.surprize_gift"
    compileSdk = 34

    buildFeatures{
        //noinspection DataBindingWithoutKapt
        dataBinding = true
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.surprize_gift"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        addManifestPlaceholders(mapOf(
            "VKIDRedirectHost" to "vk.com", // обычно vk.com
            "VKIDRedirectScheme" to "vk51913537", // обычно vk{ID приложения}
            "VKIDClientID" to "51913537",
            "VKIDClientSecret" to "wb3A2KvPjEpoqZGQG5sV"
        ))
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
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.material3:material3:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    implementation("com.vk.id:vkid:2.0.0-alpha")
    implementation("com.vk.id:onetap-xml:1.3.2")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("com.vk:android-sdk-core:4.1.0")
    implementation("com.vk:android-sdk-api:4.1.0")
}