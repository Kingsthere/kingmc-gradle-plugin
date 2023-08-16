package kingmc.gradle.platform

import org.gradle.api.Project

/**
 * The common platform
 *
 * @author kingsthere
 * @since 0.1.0
 */
class CommonPlatform extends AbstractPlatform {
    CommonPlatform(String version) {
        super("common", version)
    }

    @Override
    void apply(Project project) {
        project.afterEvaluate {
            project.dependencies.add('compileOnly', 'net.kingmc.platform:common:' + version())
        }
    }
}
