plugins {
    alias(libs.plugins.runtrack.android.library)
    alias(libs.plugins.runtrack.jvm.ktor)
}

android {
    namespace = "com.bibin.babu.software.developer.core.data"

}

dependencies {
    implementation(libs.timber)
    implementation(projects.core.domain)
    implementation(projects.core.database)
}