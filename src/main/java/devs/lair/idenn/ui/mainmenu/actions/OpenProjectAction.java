package devs.lair.idenn.ui.mainmenu.actions;

import devs.lair.idenn.actions.GlobalAction;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenProjectAction extends IdeAction implements GlobalAction {

    public OpenProjectAction() {
        super(IdeStrings.Actions.OPEN_PROJECT,
                IdeStrings.Actions.OPEN_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.FOLDER_OPEN),
                KeyStroke.getKeyStroke("ctrl O"),
                IdeStrings.Actions.OPEN_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        System.out.println("DA");
    }
}
