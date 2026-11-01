package devs.lair.idenn.ui.project;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.componets.IdeToolBar;
import devs.lair.idenn.ui.keys.IdeUiNames;

import javax.swing.*;

public class ProjectToolbar extends IdeToolBar {

    public ProjectToolbar() {
        setName(IdeUiNames.PROJECT_TOOLBAR);
        setOrientation(JToolBar.HORIZONTAL);
        setFloatable(false);
        setBorder(IdeBorders.bottomBorder(IdeColors.DEFAULT_BORDER_COLOR));

        add(IdeActions.getAction(IdeStrings.Actions.ADD_PROJECT_ITEM));
        add(IdeActions.getAction(IdeStrings.Actions.REMOVE_PROJECT_ITEM));
        add(IdeActions.getAction(IdeStrings.Actions.CLONE_PROJECT_ITEM));
        add(Box.createHorizontalGlue());

        add(IdeActions.getAction(IdeStrings.Actions.COLLAPSE_PROJECT_TREE));
        add(IdeActions.getAction(IdeStrings.Actions.EXPAND_PROJECT_TREE));
    }
}
