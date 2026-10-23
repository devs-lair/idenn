package devs.lair.idenn.ui.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.abstarcts.IdeAction;

import java.awt.event.ActionEvent;

public class CloseProjectAction extends IdeAction {

    public CloseProjectAction() {
        super(IdeStrings.Actions.CLOSE, IdeStrings.Actions.CLOSE_TOOLTIP, null, null,
                IdeStrings.Actions.CLOSE_MNEMONIC.charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IdeMainFrame.getInstance().dispose();
    }
}
