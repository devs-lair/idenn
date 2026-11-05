package devs.lair.idenn.ui.project.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.actions.UpdatableAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.project.ProjectTree;
import devs.lair.idenn.ui.project.nodes.ProjectTreeCategoryNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;

public class CloneProjectItemAction extends IdeAction implements UpdatableAction {

    public CloneProjectItemAction() {
        super(IdeStrings.Actions.CLONE_PROJECT_ITEM,
                IdeStrings.Actions.CLONE_PROJECT_ITEM_TOOLTIP,
                IdeIcons.getIcon(CoreUiFree.CLONE));

        setEnabled(false);
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (!isEnabled()) {
            return;
        }

        IdeMainFrame.getByKeyOrThrow(IdeUIKeys.PROJECT_TREE);
        postEvent(e, "Something cloned");
    }

    @Override
    public void update(@Nullable Object object) {
        ProjectTree projectTree = IdeMainFrame.getByKey(IdeUIKeys.PROJECT_TREE);

        if (projectTree == null) {
            return;
        }

        DefaultMutableTreeNode selectedNode = projectTree.getSelectedNode();
        setEnabled(selectedNode != null && !(selectedNode instanceof ProjectTreeCategoryNode));
    }

    @Override
    public @NotNull UiKey<?> getOwnerComponentKey() {
        return IdeUIKeys.PROJECT_TREE;
    }
}
