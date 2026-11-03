package devs.lair.idenn.model.project;

import org.jetbrains.annotations.NotNull;

import static devs.lair.idenn.ui.IdeStrings.Project.*;

public enum ProjectCategory {
    CATEGORY_MODEL(CATEGORY_MODELS),
    CATEGORY_ENGINE(CATEGORY_ENGINES),
    CATEGORY_BUILD(CATEGORY_BUILDS),
    CATEGORY_DATASET(CATEGORY_DATASETS),
    CATEGORY_TRAIN(CATEGORY_TRAINS);

    private final String name;

    ProjectCategory(String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }
}
