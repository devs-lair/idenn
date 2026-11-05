package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.actions.UpdatableAction;
import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.dialogs.RenameDialog;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.project.ProjectTree;
import devs.lair.idenn.ui.project.nodes.ProjectItemNode;
import devs.lair.idenn.ui.project.nodes.ProjectTreeCategoryNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;

public class RenameAction extends IdeAction implements UpdatableAction {

    public RenameAction() {
        super(IdeStrings.Actions.RENAME,
                IdeStrings.Actions.RENAME_TOOLTIP,
                null,
                KeyStroke.getKeyStroke("shift F6"),
                null);

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
            ProjectItem projectItem = projectItemNode.getProjectItem();
            RenameDialog dialog = new RenameDialog(projectItem);
            dialog.setVisible(true);

            if (!dialog.isCanceled()) {
                String newName = dialog.getResult();
                String oldName = projectItem.getName();
                projectItem.setName(newName);
                projectTree.updateNode(projectItemNode);

                postEvent(e, "Project Item was renamed, old name = '%s', new name = '%s'".
                        formatted(oldName, newName));
            }
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
