package devs.lair.idenn.ui.project;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.model.project.ProjectCategory;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.componets.tree.IdeTreeCellRenderer;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.project.actions.AddProjectItemAction;
import devs.lair.idenn.ui.project.actions.CloneProjectItemAction;
import devs.lair.idenn.ui.project.actions.RemoveProjectItemAction;
import devs.lair.idenn.ui.project.nodes.ProjectCategoryNode;
import devs.lair.idenn.ui.project.nodes.ProjectTreeRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.Arrays;
import java.util.Enumeration;

public class ProjectTree extends JTree {

    public ProjectTree() {
        setModel(new DefaultTreeModel(createTree()));

        setName(IdeUiNames.PROJECT_TREE);
        setRootVisible(false);
        setBorder(BorderFactory
                .createEmptyBorder(0, IdeSizes.SMALL_IDENT, 0, IdeSizes.MEDIUM_IDENT));
        setComponentPopupMenu(createPopup());

        setCellRenderer(new IdeTreeCellRenderer());
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        expandAll();
    }

    private TreeNode createTree() {
        ProjectTreeRoot projectTreeRoot = new ProjectTreeRoot();
        Arrays.stream(ProjectCategory.values()).forEach(
                type -> projectTreeRoot.add(new ProjectCategoryNode(type)));

        return projectTreeRoot;
    }

    private JPopupMenu createPopup() {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(IdeActions.getAction(AddProjectItemAction.class));
        popupMenu.add(IdeActions.getAction(RemoveProjectItemAction.class));
        popupMenu.add(IdeActions.getAction(CloneProjectItemAction.class));
        return popupMenu;
    }

    public @Nullable DefaultMutableTreeNode getSelectedNode() {
        TreePath selectionPath = getSelectionPath();
        if (selectionPath == null) {
            return null;
        }

        return (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
    }

    public void expandAll() {
        for (int i = 0; i < getRowCount(); i++) {
            expandRow(i);
        }
    }

    public void collapseAll() {
        TreeNode root = (TreeNode) getModel().getRoot();
        collapseAll(new TreePath(root));
    }

    private void collapseAll(@NotNull TreePath parent) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();

        for (Enumeration<?> e = node.children(); e.hasMoreElements(); ) {
            TreeNode child = (TreeNode) e.nextElement();
            TreePath path = parent.pathByAddingChild(child);
            collapseAll(path);
        }

        if (!(node instanceof ProjectTreeRoot)) {
            collapsePath(parent);
        }
    }
}