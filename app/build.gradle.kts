plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.jenkinsplayground"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.jenkinsplayground"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += listOf("company", "price")

    productFlavors {
        create("companyA") {
            dimension = "company"
            applicationIdSuffix = ".companyA"
            versionNameSuffix = "-companyA"

            buildConfigField("String", "BASE_URL", "\"https://api.companyA.com/\"")
            buildConfigField("String", "API_KEY", "\"COMPANY_A_API_KEY\"")
            buildConfigField("String", "COMPANY", "\"COMPANY_A\"")
        }

        create("companyB") {
            dimension = "company"
            applicationIdSuffix = ".companyB"
            versionNameSuffix = "-companyB"

            buildConfigField("String", "BASE_URL", "\"https://api.companyB.com/\"")
            buildConfigField("String", "API_KEY", "\"COMPANY_B_API_KEY\"")
            buildConfigField("String", "COMPANY", "\"COMPANY_B\"")
        }

        create("free") {
            dimension = "price"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
        }

        create("paid") {
            dimension = "price"
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core)

    // companyA - flavor. Мы говорим Gradle, что это реализация для компании A.
    // Значит projects.whiteLabel.companyA будет добавлен только в сборке флейвора companyA.
    add("companyAImplementation", projects.whiteLabel.companyA)
    // companyB - flavor. Мы говорим Gradle, что это реализация для компании B.
    // Значит projects.whiteLabel.companyB будет добавлен только в сборке флейвора companyB.
    add("companyBImplementation", projects.whiteLabel.companyB)

    add("freeImplementation", libs.yandex.ads)
    add("paidImplementation", libs.mapbox)

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