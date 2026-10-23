package devs.lair.idenn.ui.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.abstarcts.IdeAction;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveProjectAction extends IdeAction {

    public SaveProjectAction() {
        super(IdeStrings.Actions.SAVE,
                IdeStrings.Actions.SAVE_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.SAVE),
                KeyStroke.getKeyStroke("ctrl S"),
                IdeStrings.Actions.SAVE_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DA");
    }
}