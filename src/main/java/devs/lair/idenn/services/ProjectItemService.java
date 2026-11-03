package devs.lair.idenn.services;

import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.model.project.ProjectItemType;
import org.jetbrains.annotations.NotNull;

public class ProjectItemService implements IProjectItemsService {
    private static ProjectItemService INSTANCE;

    private ProjectItemService() {
    }

    public static ProjectItemService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProjectItemService();
        }
        return INSTANCE;
    }

    @Override
    public @NotNull ProjectItem createProjectItem(@NotNull String name, @NotNull ProjectItemType type) {
        return new ProjectItem(name, type);
    }
}