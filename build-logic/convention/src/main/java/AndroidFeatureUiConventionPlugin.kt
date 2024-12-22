import com.android.build.api.dsl.LibraryExtension
import com.bibin.babu.software.developer.convention.addUiLayerDependencies
import com.bibin.babu.software.developer.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


class AndroidFeatureUiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runtrack.android.library.compose")
            }
            dependencies {
                addUiLayerDependencies(target)
            }

        }
    }
}