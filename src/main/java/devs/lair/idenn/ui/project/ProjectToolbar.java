package devs.lair.idenn.ui.project;

import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.componets.IdeToolBar;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.project.actions.AddProjectItemAction;
import devs.lair.idenn.ui.project.actions.RemoveProjectItemAction;

import javax.swing.*;

public class ProjectToolbar extends IdeToolBar {

    public ProjectToolbar() {
        setName(IdeUiNames.PROJECT_TOOLBAR);
        setOrientation(JToolBar.HORIZONTAL);
        setFloatable(false);
        setBorder(IdeBorders.bottomBorder(IdeColors.DEFAULT_BORDER_COLOR));

        add(new AddProjectItemAction());
        add(new RemoveProjectItemAction());
    }
}
