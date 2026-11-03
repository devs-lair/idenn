package devs.lair.idenn.ui.mainframe.actions;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProjectTreeToggleAction extends IdeAction {
    private JComponent owner;

    public ProjectTreeToggleAction() {
        super(IdeStrings.Project.PROJECT_TREE,
                IdeStrings.Project.PROJECT_TREE,
                IdeIcons.getIcon(CoreUiFree.FOLDER),
                KeyStroke.getKeyStroke("alt 1"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IdeMainFrame.getInstance().setLeftComponent(IdeUIKeys.PROJECT_COMPONENT);

        if (owner instanceof JToggleButton toggleButton) {
            toggleButton.setSelected(!toggleButton.isSelected());
            postEvent(e, toggleButton.isSelected() ? "Project Tree was showed" : "Project Tree was hidden");
        }
    }

    public @Nullable JComponent getOwner() {
        return this.owner;
    }

    //DIRTY WAY
    public void setOwner(@Nullable JComponent component) {
        this.owner = component;
    }
}
