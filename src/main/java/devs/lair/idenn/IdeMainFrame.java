package devs.lair.idenn;

import devs.lair.idenn.bus.AppEvent;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.componets.IdeSpliter;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class IdeMainFrame extends JFrame {
    private static IdeMainFrame INSTANCE;

    private JPanel mainPanel;
    private StateLine stateLine;
    private JSplitPane topBottom;
    private JSplitPane leftRight;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

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
        mainPanel = new JPanel(new BorderLayout());

//        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
//        mainPanel.add(createWestPanel(),  BorderLayout.WEST );
//        mainPanel.add(createEastPanel(), BorderLayout.EAST);

        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
        add(mainPanel);
    }

    private JComponent createSouthPanel() {
        stateLine = new StateLine();
        return stateLine;
    }

    private JComponent createCenterPanel() {
        leftRight = new IdeSpliter(JSplitPane.HORIZONTAL_SPLIT);
        leftRight.setLeftComponent(leftPanel = new JPanel());
        leftRight.setRightComponent(rightPanel = new JPanel());
        leftRight.setResizeWeight(0.2);

        topBottom = new IdeSpliter(JSplitPane.VERTICAL_SPLIT);
        topBottom.setLeftComponent(leftRight);
        topBottom.setRightComponent(bottomPanel = new JPanel());
        topBottom.setResizeWeight(0.7);

        return topBottom;
    }

    private JComponent createEastPanel() {
        return null;
    }

    private JComponent createWestPanel() {
        return null;
    }

    private JComponent createNorthPanel() {
        return null;
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
