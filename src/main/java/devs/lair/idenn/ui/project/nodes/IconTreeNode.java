package devs.lair.idenn.ui.project.nodes;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class IconTreeNode extends DefaultMutableTreeNode implements HasIconNode {
    private final Icon icon;
    private final String name;

    public IconTreeNode(@NotNull String name, @NotNull Icon icon) {
        super(name, true);

        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    @Override
    public @NotNull Icon getIcon() {
        return icon;
    }
}
