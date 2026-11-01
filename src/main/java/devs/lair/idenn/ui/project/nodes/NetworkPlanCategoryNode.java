package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.ui.IdeStrings;

import javax.swing.tree.DefaultMutableTreeNode;

//IdeIcons.getIcon(CoreUiFree.APPS_SETTINGS
public class NetworkPlanCategoryNode extends DefaultMutableTreeNode implements TreeCategoryNode {

    public NetworkPlanCategoryNode() {
        super(IdeStrings.Project.CATEGORY_PLANS);
    }
}
