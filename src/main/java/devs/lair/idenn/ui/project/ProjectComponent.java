package devs.lair.idenn.ui.project;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.ui.componets.IdeScrollPane;
import devs.lair.idenn.ui.keys.IdeUIKeys;
import devs.lair.idenn.ui.keys.IdeUiNames;

import javax.swing.*;
import java.awt.*;

public class ProjectComponent extends JPanel {
    private final ProjectTree projectTree;
    private final ProjectToolbar projectToolbar;

    public ProjectComponent() {
        super(new BorderLayout());
        setName(IdeUiNames.PROJECT_COMPONENT);

        this.projectTree = new ProjectTree();
        this.projectToolbar = new ProjectToolbar(projectTree);

        add(projectToolbar, BorderLayout.NORTH);
        add(new IdeScrollPane(projectTree), BorderLayout.CENTER);

        IdeMainFrame.putByKey(IdeUIKeys.PROJECT_TREE, projectTree);
        IdeMainFrame.putByKey(IdeUIKeys.PROJECT_COMPONENT, this);
    }

    @Override
    public void requestFocus() {
        projectTree.requestFocus();
    }

    public ProjectTree getProjectTree() {
        return projectTree;
    }

    public ProjectToolbar getProjectToolbar() {
        return projectToolbar;
    }
}
