package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.model.project.ProjectCategory;
import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.model.project.ProjectItemType;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.project.ProjectTree;
import devs.lair.idenn.ui.project.dialogs.AddItemDialog;
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
import java.util.Arrays;

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

        ProjectItemType preferType = fetchPreferItemType(projectTree);
        AddItemDialog addItemDialog = new AddItemDialog(preferType);
        addItemDialog.setVisible(true);

        if (!addItemDialog.isCanceled()) {
            ProjectItem projectItem = addItemDialog.getResult();
            TreePath addPath = projectTree.addItem(projectItem);
            projectTree.setSelectionPath(addPath);

            postEvent(e, "Project Item ('%s', %s) was added"
                    .formatted(projectItem.getName(), projectItem.getType()));
        }
    }

    private @Nullable ProjectItemType fetchPreferItemType(ProjectTree projectTree) {
        ProjectItemType preferType = null;
        DefaultMutableTreeNode selectedNode = projectTree.getSelectedNode();
        if (selectedNode instanceof ProjectTreeCategoryNode categoryNode) {
            ProjectCategory category = categoryNode.getType();
            preferType = Arrays.stream(ProjectItemType.values())
                    .filter(type -> type.getCategory() == category).findFirst().orElse(null);
        } else if (selectedNode instanceof ProjectItemNode itemNode) {
            preferType = itemNode.getType();
        }
        return preferType;
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
