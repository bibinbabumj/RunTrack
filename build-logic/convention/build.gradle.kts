plugins {
    `kotlin-dsl`
}
group = "com.bibin.babu.software.developer.runtrack.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)

}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "runtrack.android.application"
            implementationClass="AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "runtrack.android.application.compose"
            implementationClass="AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "runtrack.android.library"
            implementationClass="AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "runtrack.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

    }
}