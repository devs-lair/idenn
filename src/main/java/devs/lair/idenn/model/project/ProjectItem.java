package devs.lair.idenn.model.project;

import org.jetbrains.annotations.NotNull;

public class ProjectItem {

    private final String name;
    private final ProjectItemType type;

    public ProjectItem(@NotNull String name, @NotNull ProjectItemType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ProjectItemType getType() {
        return type;
    }
}
