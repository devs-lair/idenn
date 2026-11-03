package devs.lair.idenn.ui.project.nodes;

import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.model.project.ProjectItemType;
import devs.lair.idenn.ui.componets.tree.HasIconNode;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectItemNode extends DefaultMutableTreeNode implements HasIconNode {

    public ProjectItemNode(@NotNull ProjectItem projectItem) {
        super(projectItem, false);
    }

    @Override
    public @NotNull Icon getIcon() {
        return getType().getIcon();
    }

    public @NotNull String getName() {
        return getProjectItem().getName();
    }

    public @NotNull ProjectItem getProjectItem() {
        return (ProjectItem) getUserObject();
    }

    public @NotNull ProjectItemType getType() {
        return getProjectItem().getType();
    }

    @Override
    public String toString() {
        return getName();
    }
}