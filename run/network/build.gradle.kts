plugins {
    alias(libs.plugins.runtrack.android.library)
    alias(libs.plugins.runtrack.jvm.ktor)
}

android {
    namespace = "com.bibin.babu.software.developer.run.network"

}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
   
}