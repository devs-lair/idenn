package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.model.project.ProjectCategory;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectCategoryNode extends DefaultMutableTreeNode implements TreeCategoryNode {

    public ProjectCategoryNode(@NotNull ProjectCategory type) {
        super(type, true);
    }

    @Override
    public String toString() {
        return getType().getName();
    }

    public @NotNull ProjectCategory getType() {
        return (ProjectCategory) getUserObject();
    }
}
