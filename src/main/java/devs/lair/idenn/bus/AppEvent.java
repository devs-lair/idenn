package devs.lair.idenn.bus;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppEvent {
    private final String name;
    private final String description;

    public AppEvent(@NotNull String name,
                    @Nullable String description) {
        this.name = name;
        this.description = description;
    }

    public AppEvent(@NotNull String name) {
        this(name, null);
    }

    public @NotNull String getName() {
        return name;
    }

    public @Nullable String getDescription() {
        return description;
    }

    public @Nullable String getLogString() {
        return name + (description == null ? "" : " (" + description + ")");
    }

    //can be null
    public @Nullable String getStateString() {
        return name;
    }
}
