package devs.lair.idenn.ui.keys;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.ui.project.ProjectComponent;
import devs.lair.idenn.ui.project.ProjectTree;

public class IdeUIKeys {
    public static final UiKey<ProjectTree> PROJECT_TREE = new UiKey<>(IdeUiNames.PROJECT_TREE);
    public static final UiKey<ProjectComponent> PROJECT_COMPONENT = new UiKey<>(IdeUiNames.PROJECT_COMPONENT);
    public static final UiKey<IdeMainFrame> MAIN_FRAME = new UiKey<>(IdeUiNames.MAIN_FRAME);
}

