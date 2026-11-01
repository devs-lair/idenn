package devs.lair.idenn.ui.project.nodes;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

@Deprecated
abstract class AbstractTreeCategoryNode extends DefaultMutableTreeNode {
    private final Icon icon;
    private final String name;

    public AbstractTreeCategoryNode(@NotNull String name, @NotNull Icon icon) {
        super(name, true);

        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }
}
