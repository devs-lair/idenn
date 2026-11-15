package devs.lair.idenn.model.project;

import org.jetbrains.annotations.NotNull;

import static devs.lair.idenn.ui.IdeStrings.Project.*;

public enum ProjectCategory {
    CATEGORY_MODEL(CATEGORY_MODELS_LABEL),
    CATEGORY_ENGINE(CATEGORY_ENGINES_LABEL),
    CATEGORY_BUILD(CATEGORY_BUILDS_LABEL),
    CATEGORY_DATASET(CATEGORY_DATASETS_LABEL),
    CATEGORY_TRAIN(CATEGORY_TRAINS_LABEL);

    private final String name;

    ProjectCategory(String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }
}
