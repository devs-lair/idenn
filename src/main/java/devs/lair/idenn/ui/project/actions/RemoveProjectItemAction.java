package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.actions.UpdatableAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.project.ProjectTree;
import devs.lair.idenn.ui.project.nodes.ProjectItemNode;
import devs.lair.idenn.ui.project.nodes.ProjectTreeCategoryNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveProjectItemAction extends IdeAction implements UpdatableAction {

    public RemoveProjectItemAction() {
        super(IdeStrings.Actions.REMOVE_PROJECT_ITEM,
                IdeStrings.Actions.REMOVE_PROJECT_ITEM_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.MINUS),
                KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

        setEnabled(false);
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (!isEnabled()) {
            return;
        }

        ProjectTree projectTree = IdeMainFrame.getByKeyOrThrow(IdeUIKeys.PROJECT_TREE);
        DefaultMutableTreeNode selectedNode = projectTree.getSelectedNode();

        if (selectedNode instanceof ProjectItemNode projectItemNode) {
            TreePath treePath = new TreePath(projectTree.getMyModel().getPathToRoot(projectItemNode));

            int beforeDeleteRow = projectTree.getRowForPath(treePath);
            projectTree.removeItem(projectItemNode);
            projectTree.setSelectionRow(beforeDeleteRow - 1);

            postEvent(e, "Project Item ('%s', %s) was removed"
                    .formatted(projectItemNode.getName(), projectItemNode.getType()));
        }

    }

    @Override
    public void update(@Nullable Object object) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);

        if (projectTree == null) {
            return;
        }

        DefaultMutableTreeNode selectedNode = projectTree.getSelectedNode();
        setEnabled(selectedNode != null && !(selectedNode instanceof ProjectTreeCategoryNode));
    }

    @Override
    public @NotNull UiKey<?> getOwnerComponentKey() {
        return IdeUIKeys.PROJECT_TREE;
    }
}
