package devs.lair.idenn.services;

import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.model.project.ProjectItemType;
import org.jetbrains.annotations.NotNull;

public interface IProjectItemsService {
    @NotNull ProjectItem createProjectItem(@NotNull String name, @NotNull ProjectItemType type);
}