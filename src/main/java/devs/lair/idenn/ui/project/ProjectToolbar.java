package devs.lair.idenn.ui.project;

import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.componets.IdeToolBar;
import devs.lair.idenn.ui.keys.IdeUiNames;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProjectToolbar extends IdeToolBar {

    public ProjectToolbar() {
        setName(IdeUiNames.PROJECT_TOOLBAR);
        setOrientation(JToolBar.HORIZONTAL);
        setFloatable(false);
        setBorder(IdeBorders.bottomBorder(IdeColors.DEFAULT_BORDER_COLOR));

        add(new AbstractAction("Add", IdeIcons.getIcon(CoreUiFree.PLUS)) {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        add(new RemoveProjectItemAction());
    }
}
