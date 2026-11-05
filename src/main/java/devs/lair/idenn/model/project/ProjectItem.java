package devs.lair.idenn.model.project;

import devs.lair.idenn.model.common.NamedEntity;
import devs.lair.idenn.model.common.UuidIdentity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ProjectItem implements NamedEntity, UuidIdentity {
    private final UUID id;
    private final ProjectItemType type;

    private String name;
    private boolean hasChanges = false;

    public ProjectItem(@NotNull String name, @NotNull ProjectItemType type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
    }

    @Override
    public @NotNull UUID getId() {
        return id;
    }

    public ProjectItemType getType() {
        return type;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void setName(@NotNull String name) {
        if (!this.name.equals(name)) {
            this.name = name;
            hasChanges = true;
        }
    }
}
