package devs.lair.idenn.model.common;

import org.jetbrains.annotations.NotNull;

public interface NamedEntity {
    @NotNull String getName();
    void setName(@NotNull String name);
}