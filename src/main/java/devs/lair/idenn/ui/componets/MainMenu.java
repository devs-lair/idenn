package devs.lair.idenn.ui.componets;

import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.actions.CloseProjectAction;
import devs.lair.idenn.ui.actions.NewProjectAction;
import devs.lair.idenn.ui.actions.OpenProjectAction;
import devs.lair.idenn.ui.actions.SaveProjectAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar {

    public MainMenu() {
        JMenu file = new JMenu(IdeStrings.Menus.FILE);
        file.setMnemonic(KeyEvent.getExtendedKeyCodeForChar(IdeStrings.Menus.FILE_MNEMONIC.charAt(0)));
        add(file);

        file.add(new JMenuItem(new NewProjectAction()));
        file.add(new JMenuItem(new OpenProjectAction()));
        file.add(new JMenuItem(new SaveProjectAction()));
        file.add(new JPopupMenu.Separator());
        file.add(new JMenuItem(new CloseProjectAction()));
    }
}
