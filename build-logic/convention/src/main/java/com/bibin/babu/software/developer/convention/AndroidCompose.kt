package com.bibin.babu.software.developer.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("composeCompiler").get().toString()
        }

        dependencies {
            val composeBom = libs.findLibrary("androidx-compose-bom").get()
            "implementation"(platform(composeBom))
            "androidTestImplementation"(platform(composeBom))
            "debugImplementation"(libs.findLibrary("androidx-ui-tooling-preview").get())
        }
    }


}