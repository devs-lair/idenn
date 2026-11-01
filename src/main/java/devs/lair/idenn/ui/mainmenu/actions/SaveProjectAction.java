package devs.lair.idenn.ui.mainmenu.actions;

import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;
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
    public void actionPerformed(@NotNull ActionEvent e) {
        System.out.println("DA");
    }
}