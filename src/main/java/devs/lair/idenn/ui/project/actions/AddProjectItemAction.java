package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.mainframe.IdeMainFrame;
import devs.lair.idenn.ui.project.ProjectTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddProjectItemAction extends IdeAction {

    public AddProjectItemAction() {
        super(IdeStrings.Actions.ADD_PROJECT_ITEM,
                IdeStrings.Actions.ADD_PROJECT_ITEM_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.PLUS),
                KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0));

        setEnabled(false);
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);
        if (projectTree == null || !projectTree.hasFocus()) {
            return;
        }

        postEvent(e);
    }

    @Override
    public void update(@Nullable Object object) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);

        if (projectTree == null) {
            return;
        }

        setEnabled(projectTree.getSelectedNode() != null);
    }
}
