package kingmc.gradle.platform

/**
 * An enum extended {@link kingmc.gradle.platform.Platform} listed few implemented platforms
 */
enum ListedPlatforms {
    COMMON("common"),
    BUKKIT("bukkit"),
    VELOCITY("velocity");

    String id

    ListedPlatforms(id) {
        this.id = id
    }
}