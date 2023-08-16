package kingmc.gradle.platform

import org.gradle.api.Project

/**
 * The bukkit platform implementation
 *
 * @author kingsthere
 * @since 0.1.0
 */
class BukkitPlatform extends AbstractPlatform {
    BukkitPlatform(String version) {
        super("bukkit", version)
    }

    @Override
    void apply(Project project) {
        project.repositories.maven {
            setUrl(URI.create("https://hub.spigotmc.org/nexus/content/repositories/snapshots/"))
            setName("spigot-repo")
        }
        project.repositories.maven {
            setUrl(URI.create("https://repo.codemc.org/repository/maven-public/"))
            setName("codemc-repo")
        }
        project.repositories.maven {
            setUrl(URI.create("https://repo.dmulloy2.net/repository/public/"))
        }
        project.repositories.maven {
            setUrl(URI.create("https://repo.papermc.io/repository/maven-public/"))
            setName("papermc-repo")
        }
        project.afterEvaluate {
            project.dependencies.add('compileOnly', 'net.kingmc.platform:bukkit:' + version())
        }
    }
}
