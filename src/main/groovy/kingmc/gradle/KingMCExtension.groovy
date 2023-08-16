package kingmc.gradle

import org.gradle.api.Action
import org.gradle.api.Project

class KingMCExtension {
    String version = '0.1.12-SNAPSHOT'
    PlatformConfiguration platformConfiguration = new PlatformConfiguration(this)

    def platform(Action<? super PlatformConfiguration> action) {
        action.execute(platformConfiguration)
    }

    def apply(Project project) {
        platformConfiguration.apply(project)
    }
}
