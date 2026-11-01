package devs.lair.idenn.ui.project;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.componets.IdeTreeCellRenderer;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.project.nodes.*;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import javax.swing.tree.*;

public class ProjectTree extends JTree {

    public ProjectTree() {
        setModel(new DefaultTreeModel(createTree()));

        setName(IdeUiNames.PROJECT_TREE);
        setRootVisible(false);
        setBorder(BorderFactory
                .createEmptyBorder(0, IdeSizes.SMALL_IDENT, 0, IdeSizes.MEDIUM_IDENT));
        setCellRenderer(new IdeTreeCellRenderer());
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        expandAll();
    }

    private void expandAll() {
        for (int i = 0; i < getRowCount(); i++) {
            expandRow(i);
        }
    }

    private TreeNode createTree() {
        ProjectTreeRoot projectTreeRoot = new ProjectTreeRoot();
        NetworkPlanCategoryNode planCategoryNode = new NetworkPlanCategoryNode();
        IconTreeNode p1 = new IconTreeNode("Perceptrone AND",
                IdeIcons.getIcon(CoreUiFree.APPS_SETTINGS));
        IconTreeNode p2 = new IconTreeNode("Perceptrone XOR",
                IdeIcons.getIcon(CoreUiFree.APPS_SETTINGS));

        planCategoryNode.add(p1);
        planCategoryNode.add(p2);

        projectTreeRoot.add(planCategoryNode);
        projectTreeRoot.add(new NetworkEngineCategoryNode());
        projectTreeRoot.add(new NetworkTrainCategoryNode());

        return projectTreeRoot;
    }

    public @Nullable DefaultMutableTreeNode getSelectedNode() {
        TreePath selectionPath = getSelectionPath();
        if (selectionPath == null) {
            return null;
        }

        return (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
    }
}