plugins {
    alias(libs.plugins.runtrack.android.feature.ui)

}

android {
    namespace = "com.bibin.babu.software.developer.auth.presentation"

}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)

}