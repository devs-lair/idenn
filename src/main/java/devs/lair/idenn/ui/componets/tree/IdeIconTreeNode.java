package devs.lair.idenn.ui.componets.tree;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class IdeIconTreeNode extends DefaultMutableTreeNode implements HasIconNode {
    private final Icon icon;

    public IdeIconTreeNode(@NotNull Object object, @NotNull Icon icon) {
        super(object, true);

        this.icon = icon;
    }

    public String getName() {
        return getUserObject().toString();
    }

    @Override
    public @NotNull Icon getIcon() {
        return icon;
    }
}
