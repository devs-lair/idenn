package devs.lair.idenn.ui.mainmenu.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.GlobalAction;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;

public class CloseProjectAction extends IdeAction implements GlobalAction {

    public CloseProjectAction() {
        super(IdeStrings.Actions.CLOSE, IdeStrings.Actions.CLOSE_TOOLTIP, null, null,
                IdeStrings.Actions.CLOSE_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        IdeMainFrame.getInstance().dispose();
    }
}
