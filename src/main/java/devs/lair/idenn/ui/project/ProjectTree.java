package devs.lair.idenn.ui.project;

import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.keys.IdeUiNames;

import javax.swing.*;
import javax.swing.tree.TreeSelectionModel;

public class ProjectTree extends JTree {

    public ProjectTree() {
        setName(IdeUiNames.PROJECT_TREE);
        setRootVisible(false);
        setBorder(BorderFactory
                .createEmptyBorder(0, IdeSizes.SMALL_IDENT, 0, IdeSizes.MEDIUM_IDENT));

        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        //FocusManager.getCurrentManager().getF
    }
}