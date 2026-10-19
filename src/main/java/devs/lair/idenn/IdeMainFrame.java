package devs.lair.idenn;

import devs.lair.idenn.bus.AppEvent;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.componets.IdeScrollPane;
import devs.lair.idenn.ui.componets.IdeSpliter;
import devs.lair.idenn.ui.componets.ProjectToolbar;
import devs.lair.idenn.ui.componets.ProjectTree;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class IdeMainFrame extends JFrame {
    private static IdeMainFrame INSTANCE;

    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JSplitPane topBottom = new IdeSpliter(JSplitPane.VERTICAL_SPLIT);
    private final JSplitPane leftRight = new IdeSpliter(JSplitPane.HORIZONTAL_SPLIT);

    private final JPanel projectPanel = new JPanel(new BorderLayout());
    private final JPanel contentPanel = new JPanel(new BorderLayout());
    private JPanel bottomPanel;

    private StateLine stateLine;

    public static @NotNull IdeMainFrame getInstance() {
        return INSTANCE;
    }

    public static void init() {
        new IdeMainFrame();
    }

    private IdeMainFrame() {
        super(IdeStrings.Titles.FRAME_TITLE);

        if (INSTANCE != null) {
            throw new IllegalStateException("Main Frame was already created");
        } else {
            INSTANCE = this;
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        createUI();
        showFrame();
    }

    private void showFrame() {
        setLocationRelativeTo(null);
        setVisible(true);

        EventBus.getDefault()
                .post(new AppEvent("Application started"));
    }

    private void createUI() {
        createMenu();
        createMainPanel();
    }

    private void createMainPanel() {
//      //mainPanel.add(createEastPanel(), BorderLayout.EAST);
        mainPanel.add(createWestToolbar(), BorderLayout.WEST);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
        add(mainPanel);
    }

    private JComponent createSouthPanel() {
        stateLine = new StateLine();
        return stateLine;
    }

    private JComponent createCenterPanel() {
        leftRight.setLeftComponent(createProjectPanel());
        leftRight.setRightComponent(contentPanel);
        leftRight.setResizeWeight(0.1);

        topBottom.setLeftComponent(leftRight);
        return topBottom;
    }

    private Component createProjectPanel() {
        projectPanel.add(new ProjectToolbar(), BorderLayout.NORTH);
        projectPanel.add(new IdeScrollPane(new ProjectTree()), BorderLayout.CENTER);
        return projectPanel;
    }

    private JComponent createWestToolbar() {
        JToolBar westToolbar = new JToolBar(JToolBar.VERTICAL);
        westToolbar.setFloatable(false);

        westToolbar.add(new AbstractAction("Project", IdeIcons.getIcon(CoreUiFree.FOLDER, 16)) {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel toolbarWrapper = new JPanel();
        toolbarWrapper.add(westToolbar);
        toolbarWrapper.setBorder(IdeBorders.rightBorder(IdeColors.DEFAULT_BORDER_COLOR));
        return toolbarWrapper;
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu(IdeStrings.Menus.FILE);
        menuBar.add(file);

        file.add(new JMenuItem(new AbstractAction(IdeStrings.Actions.OPEN_PROJECT) {
            @Override
            public void actionPerformed(ActionEvent e) {}
        }));

        file.add(new JMenuItem(new AbstractAction(IdeStrings.Actions.CLOSE) {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }));

        setJMenuBar(menuBar);
    }

    public StateLine getStateLine() {
        return stateLine;
    }

    @Override
    public void dispose() {
        super.dispose();
        EventBus.getDefault()
                .post(new AppEvent("Application closed"));
    }
}
