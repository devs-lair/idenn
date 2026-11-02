package devs.lair.idenn.ui.componets.tree;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.componets.CompoundIcon;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class IdeTreeCellRenderer extends DefaultTreeCellRenderer {

    public IdeTreeCellRenderer() {
        setClosedIcon(IdeIcons.getIcon(CoreUiFree.PLUS, IdeSizes.MEDIUM_IDENT));
        setOpenIcon(IdeIcons.getIcon(CoreUiFree.MINUS, IdeSizes.MEDIUM_IDENT));
        setLeafIcon(null);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        Icon treeIcon = label.getIcon();

        if (value instanceof HasIconNode hasIconNode) {
            if (treeIcon != null) {
                CompoundIcon compoundIcon = new CompoundIcon(CompoundIcon.Axis.X_AXIS, IdeSizes.SMALL_IDENT, treeIcon, hasIconNode.getIcon());
                label.setIcon(compoundIcon);
            } else {
                label.setIcon(hasIconNode.getIcon());
            }

            label.setIconTextGap(6);
        } else {
            label.setIcon(treeIcon);
        }
        return label;
    }
}
