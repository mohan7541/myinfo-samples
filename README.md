plugins {
    id 'com.android.application'
    id 'com.google.gms.google-services'
    id 'org.jetbrains.kotlin.android' // Add Kotlin plugin for better compatibility
}

android {
    namespace 'com.dbs.cybersecure.android'
    compileSdk 34 // Updated to Android 14

    defaultConfig {
        applicationId "com.dbs.cybersecure.android"
        minSdk 24 // Android 7.0
        targetSdk 34 // Android 14
        versionCode 28
        versionName "3.5"
        
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        
        // MultiDex support for larger apps
        multiDexEnabled true
    }

    compileOptions {
        // JDK 17 compatibility
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding true // Recommended over legacy view binding libraries
        buildConfig true
    }

    packagingOptions {
        resources {
            excludes += ['META-INF/DEPENDENCIES', 'META-INF/LICENSE', 'META-INF/LICENSE.txt', 
                        'META-INF/license.txt', 'META-INF/NOTICE', 'META-INF/NOTICE.txt', 
                        'META-INF/notice.txt', 'META-INF/ASL2.0']
        }
    }
}

dependencies {
    // AndroidX Core (Updated versions)
    implementation 'androidx.core:core-ktx:1.13.2'
    implementation 'androidx.appcompat:appcompat:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.2.0-alpha13'
    implementation 'androidx.vectordrawable:vectordrawable:1.2.0-beta01'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01'
    
    // Lifecycle (Updated from extensions to individual components)
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.1'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.8.1'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.8.1'
    implementation 'androidx.lifecycle:lifecycle-common-java8:2.8.1'
    
    // Security & Biometric
    implementation "androidx.biometric:biometric:1.2.0-alpha05"
    implementation "androidx.security:security-crypto:1.1.0-alpha06"

    // Google Material Design
    implementation 'com.google.android.material:material:1.12.0'

    // Firebase (Updated versions)
    implementation platform('com.google.firebase:firebase-bom:33.0.0')
    implementation 'com.google.firebase:firebase-messaging'
    implementation 'com.google.firebase:firebase-appindexing:20.0.0'
    implementation 'com.google.android.gms:play-services-auth:21.2.0'

    // Gson
    implementation 'com.google.code.gson:gson:2.11.0'

    // Other dependencies (Updated versions)
    implementation 'com.mikhaellopez:circularprogressbar:3.1.0'
    
    // Replace deprecated android-async-http with OkHttp or Retrofit
    implementation 'com.squareup.okhttp3:okhttp:4.12.0'
    implementation 'com.squareup.retrofit2:retrofit:2.11.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.11.0'
    
    // Lombok (if still needed)
    compileOnly 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'

    implementation "joda-time:joda-time:2.12.7"
    implementation 'com.thoughtbot:expandablerecyclerview:1.4'
    implementation 'org.jsoup:jsoup:1.18.3'
    
    // JWT (Updated versions)
    api 'io.jsonwebtoken:jjwt-api:0.12.6'
    runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.6'
    runtimeOnly('io.jsonwebtoken:jjwt-orgjson:0.12.6') {
        exclude group: 'org.json', module: 'json'
    }

    implementation files('libs/cuckoofilter4j-1.0.2.jar')
    implementation 'com.getkeepsafe.relinker:relinker:1.4.5'

    // QR scanner (Updated versions)
    implementation 'com.google.zxing:core:3.5.3'
    implementation 'com.journeyapps:zxing-android-embedded:4.3.0' {
        exclude group: 'com.android.support'
    }

    // CameraX (Updated versions)
    def camerax_version = "1.4.0-alpha04"
    implementation "androidx.camera:camera-core:${camerax_version}"
    implementation "androidx.camera:camera-camera2:${camerax_version}"
    implementation "androidx.camera:camera-lifecycle:${camerax_version}"
    implementation "androidx.camera:camera-view:${camerax_version}"
    implementation "androidx.camera:camera-mlkit-vision:${camerax_version}"
    implementation "com.google.mlkit:barcode-scanning:17.2.0"

    // MultiDex for larger apps
    implementation 'androidx.multidex:multidex:2.0.1'

    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    
    // Optional: Kotlin stdlib for better compatibility
    implementation 'org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.24'
}
