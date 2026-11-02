package devs.lair.idenn.ui.componets.tree;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class IdeIconTreeNode extends DefaultMutableTreeNode implements HasIconNode {
    private final Icon icon;
    private final String name;

    public IdeIconTreeNode(@NotNull String name, @NotNull Icon icon) {
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
