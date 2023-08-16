package kingmc.gradle.platform

import org.gradle.api.Project

/**
 * Represent a platform that could be installed
 *
 * @author kingsthere
 * @since 0.1.0
 */
interface Platform {
    /**
     * Get the id of this platform (to maven)
     */
    String id()

    /**
     * Get the version of this platform
     */
    String version()

    /**
     * Set the version of this platform
     */
     Platform version(String version)

    /**
     * Apply to the given project
     */
     void apply(Project project)
}