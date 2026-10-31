package devs.lair.idenn.ui.project;

import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.mainframe.IdeMainFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveProjectItemAction extends IdeAction {

    public RemoveProjectItemAction() {
        super(IdeStrings.Actions.REMOVE_ITEM,
                IdeStrings.Actions.REMOVE_ITEM,
                IdeIcons.getIcon(CoreUiFree.MINUS),
                KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

        setEnabled(false);
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        super.actionPerformed(e);

        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);
        if (projectTree == null || !projectTree.hasFocus()) {
            return;
        }
    }

    @Override
    public void update(@Nullable Object object) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);

        if (projectTree == null) {
            return;
        }

        setEnabled(projectTree.getSelectionCount() > 0);
    }
}
