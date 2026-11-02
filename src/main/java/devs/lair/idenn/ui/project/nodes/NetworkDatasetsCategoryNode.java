package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.ui.IdeStrings;

import javax.swing.tree.DefaultMutableTreeNode;

public class NetworkDatasetsCategoryNode extends DefaultMutableTreeNode
        implements TreeCategoryNode {

    public NetworkDatasetsCategoryNode() {
        super(IdeStrings.Project.CATEGORY_DATASETS);
    }
}
