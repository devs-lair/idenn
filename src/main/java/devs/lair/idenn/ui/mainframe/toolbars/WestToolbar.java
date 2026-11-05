package devs.lair.idenn.ui.mainframe.toolbars;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.componets.toolbar.IdeMainFrameToolBar;
import devs.lair.idenn.ui.mainframe.actions.ProjectTreeToggleAction;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.*;

public class WestToolbar extends JPanel {
    public WestToolbar() {
        JToolBar westToolbar = new IdeMainFrameToolBar(JToolBar.VERTICAL);
        westToolbar.setFloatable(false);

        //TODO : to separate class
        JToggleButton toggleButton = new JToggleButton(IdeIcons.getIcon(CoreUiFree.FOLDER)) {
            @Override
            public void paintComponent(Graphics g) {
                //TODO : color ?
                setBackground(isSelected()
                        ? IdeColors.DEFAULT_SELECT_COLOR
                        : IdeColors.TOGGLE_BUTTON_BACKGROUND);
                super.paintComponent(g);
            }
        };

        toggleButton.setBorder(IdeBorders.emptyBorder(IdeSizes.SMALL_IDENT));
        toggleButton.setAction(IdeActions.getAction(ProjectTreeToggleAction.class));
        toggleButton.setText(null);

        westToolbar.add(toggleButton);

        add(westToolbar);
        setBorder(IdeBorders.rightBorder(IdeColors.DEFAULT_BORDER_COLOR));
    }
}
