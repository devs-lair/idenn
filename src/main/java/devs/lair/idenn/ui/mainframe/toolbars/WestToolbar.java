package devs.lair.idenn.ui.mainframe.toolbars;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.componets.toolbar.IdeMainFrameToolBar;
import devs.lair.idenn.ui.mainframe.actions.ProjectTreeToggleAction;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;

public class WestToolbar extends JPanel {
    public WestToolbar() {
        JToolBar westToolbar = new IdeMainFrameToolBar(JToolBar.VERTICAL);
        westToolbar.setFloatable(false);

        JToggleButton toggleButton = new JToggleButton(IdeIcons.getIcon(CoreUiFree.FOLDER));
        toggleButton.setBorder(IdeBorders.emptyBorder(5));
        toggleButton.setAction(IdeActions.getAction(ProjectTreeToggleAction.class));
        toggleButton.setText(null);

        westToolbar.add(toggleButton);

        add(westToolbar);
        setBorder(IdeBorders.rightBorder(IdeColors.DEFAULT_BORDER_COLOR));
    }
}
