package devs.lair.idenn.ui.mainframe.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.ToggleAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProjectTreeToggleAction extends ToggleAction {

    public ProjectTreeToggleAction() {
        super(IdeStrings.Project.PROJECT_TREE,
                IdeStrings.Project.PROJECT_TREE,
                IdeIcons.getIcon(CoreUiFree.FOLDER),
                KeyStroke.getKeyStroke("alt 1"),
                null);

        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        IdeMainFrame.getInstance().setLeftComponent(IdeUIKeys.PROJECT_COMPONENT);
    }
}
