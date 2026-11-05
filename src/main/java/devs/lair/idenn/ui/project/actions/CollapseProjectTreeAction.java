package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
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
        IdeMainFrame.getByKeyOrThrow(IdeUIKeys.PROJECT_TREE).collapseAll();
        postEvent(e, "Project Tree was collapsed");
    }
}
