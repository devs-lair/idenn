package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.mainframe.IdeMainFrame;
import devs.lair.idenn.ui.project.ProjectTree;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.coreui.CoreUiFree;

import java.awt.event.ActionEvent;

public class ExpandProjectTreeAction extends IdeAction {

    public ExpandProjectTreeAction() {
        super(IdeStrings.Actions.EXPAND_PROJECT_TREE,
                IdeStrings.Actions.EXPAND_PROJECT_TREE,
                IdeIcons.getIcon(CoreUiFree.SORT_DESCENDING));
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);
        if (projectTree != null) {
            projectTree.expandAll();
        }

        performedDescription = "Project Tree was expanded";
        postEvent(e);
    }
}
