package devs.lair.idenn.ui.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.abstarcts.IdeAction;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenProjectAction extends IdeAction {

    public OpenProjectAction() {
        super(IdeStrings.Actions.OPEN_PROJECT,
                IdeStrings.Actions.OPEN_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.FOLDER_OPEN),
                KeyStroke.getKeyStroke("ctrl O"),
                IdeStrings.Actions.OPEN_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DA");
    }
}
