package devs.lair.idenn.ui.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.abstarcts.IdeAction;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewProjectAction extends IdeAction {

    public NewProjectAction() {
        super(IdeStrings.Actions.NEW,
                IdeStrings.Actions.NEW_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.NOTE_ADD),
                KeyStroke.getKeyStroke("ctrl shift N"),
                IdeStrings.Actions.NEW_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DA");
    }
}
