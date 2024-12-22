plugins {
    alias(libs.plugins.runtrack.android.library)
    alias(libs.plugins.runtrack.android.room)
}

android {
    namespace = "com.bibin.babu.software.developer.core.database"

}

dependencies {

    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
    
}