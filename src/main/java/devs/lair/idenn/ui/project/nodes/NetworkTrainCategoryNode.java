package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.ui.IdeStrings;

import javax.swing.tree.DefaultMutableTreeNode;

//IdeIcons.getIcon(CoreUiFree.EDUCATION)
public class NetworkTrainCategoryNode extends DefaultMutableTreeNode
        implements TreeCategoryNode {

    public NetworkTrainCategoryNode() {
        super(IdeStrings.Project.CATEGORY_TRAINS);
    }
}
