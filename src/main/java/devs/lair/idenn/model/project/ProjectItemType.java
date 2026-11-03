package devs.lair.idenn.model.project;

import devs.lair.idenn.ui.IdeIcons;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.*;

import static devs.lair.idenn.model.project.ProjectCategory.*;
import static devs.lair.idenn.ui.IdeStrings.Project.*;

public enum ProjectItemType {
    MODEL(ITEM_MODEL, CATEGORY_MODEL, IdeIcons.getIcon(CoreUiFree.APPS_SETTINGS, Color.BLUE, 16)),
    ENGINE(ITEM_ENGINE, CATEGORY_ENGINE, IdeIcons.getIcon(CoreUiFree.APERTURE, Color.ORANGE, 16)),
    BUILD(ITEM_BUILD, CATEGORY_BUILD, IdeIcons.getIcon(CoreUiFree.APPLICATIONS, Color.GREEN, 16)),
    DATASET(ITEM_DATASET, CATEGORY_DATASET, IdeIcons.getIcon(CoreUiFree.GRID, Color.BLACK, 16)),
    TRAIN(ITEM_TRAIN, CATEGORY_TRAIN, IdeIcons.getIcon(CoreUiFree.EDUCATION, Color.MAGENTA, 16));

    private final String name;
    private final ProjectCategory category;
    private final Icon icon;

    ProjectItemType(@NotNull String name, @NotNull ProjectCategory category, @NotNull Icon icon) {
        this.name = name;
        this.category = category;
        this.icon = icon;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull ProjectCategory getCategory() {
        return category;
    }

    public @NotNull Icon getIcon() {
        return icon;
    }
}
