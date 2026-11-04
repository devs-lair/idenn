package devs.lair.idenn.ui.project;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.componets.toolbar.IdeComponentToolBar;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.project.actions.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ProjectToolbar extends IdeComponentToolBar {

    public ProjectToolbar(@NotNull JComponent ownerComponent) {
        super(ownerComponent);

        setName(IdeUiNames.PROJECT_TOOLBAR);
        setOrientation(JToolBar.HORIZONTAL);
        setFloatable(false);
        setBorder(IdeBorders.bottomBorder(IdeColors.DEFAULT_BORDER_COLOR));

        add(IdeActions.getAction(AddProjectItemAction.class));
        add(IdeActions.getAction(RemoveProjectItemAction.class));
        add(IdeActions.getAction(CloneProjectItemAction.class));
        add(Box.createHorizontalGlue());

        add(IdeActions.getAction(CollapseProjectTreeAction.class));
        add(IdeActions.getAction(ExpandProjectTreeAction.class));
    }
}
