package devs.lair.idenn.ui.componets;

import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeIcons;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProjectToolbar extends JToolBar {

    public ProjectToolbar() {
        setOrientation(JToolBar.HORIZONTAL);
        setFloatable(false);
        setBorder(IdeBorders.bottomBorder(IdeColors.DEFAULT_BORDER_COLOR));

        add(new AbstractAction("Add", IdeIcons.getIcon(CoreUiFree.PLUS)) {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(new AbstractAction("Remove", IdeIcons.getIcon(CoreUiFree.MINUS)) {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
