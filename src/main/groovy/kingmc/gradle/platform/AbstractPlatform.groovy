package kingmc.gradle.platform

import org.jetbrains.annotations.NotNull

/**
 * An abstract {@link Platform} implementation
 *
 * @author kingsthere
 * @since 0.1.0
 */
abstract class AbstractPlatform implements Platform {
    private String id
    private String version

    AbstractPlatform(String id, String version) {
        this.id = id
        this.version = version
    }

    @Override
    String id() {
        return this.id
    }

    @Override
    String version() {
        return this.version
    }

    @Override
    Platform version(@NotNull String version) {
        this.version = version
        return this
    }
}
