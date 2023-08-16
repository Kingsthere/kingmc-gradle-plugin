package kingmc.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * The implementation main class of kingmc gradle plugin
 *
 * @author kingsthere
 * @since 0.1.0
 */
class KingMCPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        def extension = target.extensions.create('kingmc', KingMCExtension)
        extension.apply(target)
    }
}
