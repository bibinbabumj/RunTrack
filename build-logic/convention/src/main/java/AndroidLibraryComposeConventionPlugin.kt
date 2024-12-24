import com.android.build.api.dsl.LibraryExtension
import com.bibin.babu.software.developer.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType


class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runtrack.android.library")
            }
            val extension=extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

        }
    }
}