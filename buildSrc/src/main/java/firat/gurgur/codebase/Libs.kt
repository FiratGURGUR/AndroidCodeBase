package firat.gurgur.codebase

object Libs {

    object Gradle {
        const val buildGradlePlugin = "com.android.tools.build:gradle:" + Versions.gradle
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:" + Versions.kotlin
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:" + Versions.kotlin
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:" + Versions.kotlin
    }

    object Design {
        const val material = "com.google.android.material:material:" + Versions.material
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:" + Versions.core_ktx
        const val appCompat = "androidx.appcompat:appcompat:" + Versions.appcompat
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:" + Versions.constraint_layout


        // Navigation
        const val safeArgsGradlePlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:" + Versions.navigation

    }

}