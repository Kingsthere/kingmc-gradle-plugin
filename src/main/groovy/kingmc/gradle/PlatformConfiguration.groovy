package kingmc.gradle

import kingmc.gradle.platform.BukkitPlatform
import kingmc.gradle.platform.CommonPlatform
import kingmc.gradle.platform.Platform
import org.gradle.api.Action
import org.gradle.api.Project

class PlatformConfiguration {
    KingMCExtension extension
    String defaultVersion = extension.version
    Map<String, Platform> installedPlatforms = new HashMap()

    PlatformConfiguration(KingMCExtension extension) {
        this.extension = extension
        common { }
    }

    void apply(Project project) {
        installedPlatforms.values().forEach { platform ->
            (platform as Platform).apply(project)
        }
    }

    void common() {
        installedPlatforms.computeIfAbsent("common") {
            new CommonPlatform(defaultVersion)
        }
    }

    void common(Action<? super CommonPlatform> action) {
        CommonPlatform platform = installedPlatforms.computeIfAbsent("common") {
            new CommonPlatform(defaultVersion)
        } as CommonPlatform
        action.execute(platform)
    }

    void bukkit() {
        installedPlatforms.computeIfAbsent("bukkit") {
            new BukkitPlatform(defaultVersion)
        }
    }

    void bukkit(Action<? super BukkitPlatform> action) {
        BukkitPlatform platform = installedPlatforms.computeIfAbsent("bukkit") {
            new BukkitPlatform(defaultVersion)
        } as BukkitPlatform
        action.execute(platform)
    }
}
