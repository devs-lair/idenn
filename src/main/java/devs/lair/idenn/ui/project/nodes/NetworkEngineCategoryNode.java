package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.ui.IdeStrings;

import javax.swing.tree.DefaultMutableTreeNode;

public class NetworkEngineCategoryNode extends DefaultMutableTreeNode
        implements TreeCategoryNode {

    public NetworkEngineCategoryNode() {
        super(IdeStrings.Project.CATEGORY_ENGINES);
    }
}
