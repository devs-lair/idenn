package devs.lair.idenn.ui.componets;

import devs.lair.idenn.ui.IdeSizes;

import javax.swing.*;

public class ProjectTree extends JTree {
    public ProjectTree() {
        setRootVisible(false);
        setBorder(BorderFactory.createEmptyBorder(0, IdeSizes.SMALL_IDENT, 0, IdeSizes.MEDIUM_IDENT));
    }
}