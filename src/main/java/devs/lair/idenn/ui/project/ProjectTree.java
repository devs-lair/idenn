package devs.lair.idenn.ui.project;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.model.project.ProjectCategory;
import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.componets.tree.IdeTreeCellRenderer;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.project.actions.AddProjectItemAction;
import devs.lair.idenn.ui.project.actions.CloneProjectItemAction;
import devs.lair.idenn.ui.project.actions.RemoveProjectItemAction;
import devs.lair.idenn.ui.project.nodes.ProjectItemNode;
import devs.lair.idenn.ui.project.nodes.ProjectTreeCategoryNode;
import devs.lair.idenn.ui.project.nodes.ProjectTreeRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.Arrays;
import java.util.Enumeration;

public class ProjectTree extends JTree {
    private ProjectTreeRoot root;

    public ProjectTree() {
        setModel(new DefaultTreeModel(createTree()));

        setName(IdeUiNames.PROJECT_TREE);
        setRootVisible(false);
        setBorder(BorderFactory
                .createEmptyBorder(0, IdeSizes.SMALL_IDENT, 0, IdeSizes.MEDIUM_IDENT));
        setComponentPopupMenu(createPopup());

        setCellRenderer(new IdeTreeCellRenderer());
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        addTreeSelectionListener(e ->
                IdeActions.updateActions(IdeUIKeys.PROJECT_TREE));
        expandAll();
    }

    public @NotNull DefaultTreeModel getMyModel() {
        return (DefaultTreeModel) getModel();
    }

    private TreeNode createTree() {
        root = new ProjectTreeRoot();
        Arrays.stream(ProjectCategory.values()).forEach(
                type -> root.add(new ProjectTreeCategoryNode(type)));

        return root;
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

    public @NotNull TreePath addItem(@NotNull ProjectItem projectItem) {
        ProjectTreeCategoryNode categoryNode = findCategoryNode(projectItem.getType().getCategory());
        ProjectItemNode projectItemNode = new ProjectItemNode(projectItem);

        getMyModel().insertNodeInto(projectItemNode, categoryNode, categoryNode.getChildCount());

        TreeNode[] pathToRoot = getMyModel().getPathToRoot(projectItemNode);
        return new TreePath(pathToRoot);
    }

    private @NotNull ProjectTreeCategoryNode findCategoryNode(@NotNull ProjectCategory category) {
        for (int i = 0; i < root.getChildCount(); i++) {
            TreeNode childAt = root.getChildAt(i);
            if (childAt instanceof ProjectTreeCategoryNode categoryNode && categoryNode.getType() == category) {
                return categoryNode;
            }
        }

        throw new IllegalStateException("Category '%s' not found".formatted(category.getName()));
    }

    public void removeItem(@NotNull ProjectItemNode projectItemNode) {
        getMyModel().removeNodeFromParent(projectItemNode);
    }
}