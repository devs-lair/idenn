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

public class CollapseProjectTreeAction extends IdeAction {

    public CollapseProjectTreeAction() {
        super(IdeStrings.Actions.COLLAPSE_PROJECT_TREE,
                IdeStrings.Actions.COLLAPSE_PROJECT_TREE,
                IdeIcons.getIcon(CoreUiFree.SORT_ASCENDING));
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);
        if (projectTree != null) {
            projectTree.collapseAll();
        }

        performedDescription = "Project Tree was collapsed";
        postEvent(e);
    }
}
