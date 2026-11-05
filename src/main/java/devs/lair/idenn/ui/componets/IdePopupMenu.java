package devs.lair.idenn.ui.componets;

import devs.lair.idenn.ui.project.actions.RenameAction;
import devs.lair.idenn.utils.ActionUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IdePopupMenu extends JPopupMenu {
    private final JComponent owner;

    public IdePopupMenu(@NotNull JComponent owner) {
        this.owner = owner;
    }

    public JMenuItem add(@NotNull Action action, boolean registerKeyStroke) {
        return registerKeyStroke ? add(action) : super.add(action);
    }

    @Override
    public JMenuItem add(@NotNull Action action) {
        JMenuItem add = super.add(action);
        if (action instanceof RenameAction ideAction) {
            ActionUtils.registerIdeActionKeyStroke(ideAction, owner);
        }

        return add;
    }
}
