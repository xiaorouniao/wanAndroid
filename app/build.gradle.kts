plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lowpower.wanandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lowpower.wanandroid"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.50")

    implementation("io.reactivex.rxjava2:rxjava:2.2.0")
    implementation("com.squareup.retrofit2:retrofit:2.2.0")
    implementation("com.squareup.retrofit2:converter-gson:2.2.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.2.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")

//    compile "com.trello.rxlifecycle2:rxlifecycle:$rootProject.ext.rxlifecycle"
    //compile "com.trello.rxlifecycle2:rxlifecycle-android:$rootProject.ext.rxlifecycle"
//    compile "com.trello.rxlifecycle2:rxlifecycle-components:$rootProject.ext.rxlifecycle"

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}