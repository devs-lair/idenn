package devs.lair.idenn;

import devs.lair.idenn.actions.IdeActions;
import devs.lair.idenn.bus.AppEvent;
import devs.lair.idenn.ui.*;
import devs.lair.idenn.ui.componets.IdeSpliter;
import devs.lair.idenn.ui.componets.IdeToolBar;
import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.mainframe.StateLine;
import devs.lair.idenn.ui.mainframe.actions.ProjectTreeToggleAction;
import devs.lair.idenn.ui.mainmenu.MainMenu;
import devs.lair.idenn.ui.project.ProjectComponent;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kordamp.ikonli.coreui.CoreUiFree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class IdeMainFrame extends JFrame {
    private static final HashMap<UiKey<?>, JComponent> keyedComponents = new HashMap<>();
    private static IdeMainFrame INSTANCE;

    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JSplitPane topBottom = new IdeSpliter(JSplitPane.VERTICAL_SPLIT);
    private final JSplitPane leftRight = new IdeSpliter(JSplitPane.HORIZONTAL_SPLIT);

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
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(new Dimension(IdeSizes.SCREEN_WIDTH - 400,
                IdeSizes.SCREEN_HEIGHT - 200));

        createUI();
        //createListeners();
        showFrame();
    }

    @SuppressWarnings("unchecked")
    public static <T extends JComponent> T getByKey(@NotNull UiKey<T> key) {
        return (T) keyedComponents.get(key);
    }

    public static <T extends JComponent> void putByKey(@NotNull UiKey<T> key, @Nullable T component) {
        keyedComponents.put(key, component);
    }

    public <T extends JComponent> void setLeftComponent(@NotNull UiKey<T> key) {
        T byKey = getByKey(key);

        JComponent topComponent = (JComponent) leftRight.getTopComponent();

        if (topComponent == byKey) {
            leftRight.setTopComponent(null);
        } else {
            leftRight.setTopComponent(byKey);
            byKey.requestFocus();
        }
    }

    private void createListeners() {
        long eventMask = AWTEvent.ACTION_EVENT_MASK;
        Toolkit.getDefaultToolkit().addAWTEventListener(e -> {
            //(e.getID() == MouseEvent.MOUSE_RELEASED) ||
            if (e.getID() == ActionEvent.ACTION_PERFORMED) {
                IdeActions.updateActions(e);
            }
        }, eventMask);
    }

    private void showFrame() {
        setLocationRelativeTo(null);
        setVisible(true);

        EventBus.getDefault()
                .post(new AppEvent("Application started"));
    }

    private void createUI() {
        setJMenuBar(new MainMenu());

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
        leftRight.setLeftComponent(new ProjectComponent());
        leftRight.setRightComponent(contentPanel);
        leftRight.setResizeWeight(0.1);

        topBottom.setLeftComponent(leftRight);
        return topBottom;
    }

    private JComponent createWestToolbar() {
        //DIRTY!!! after added new on, refactor

        JToolBar westToolbar = new IdeToolBar(JToolBar.VERTICAL);
        westToolbar.setFloatable(false);

        JToggleButton toggleButton = new JToggleButton(IdeIcons.getIcon(CoreUiFree.FOLDER, 16));

        toggleButton.setBorder(IdeBorders.emptyBorder(5));
        ProjectTreeToggleAction toggleAction = IdeActions.getAction(ProjectTreeToggleAction.class);
        toggleAction.setOwner(toggleButton);
        toggleButton.addActionListener(toggleAction);
        toggleButton.setSelected(true);
        toggleButton.setToolTipText(toggleAction.getTooltip());

        westToolbar.add(toggleButton);

        JPanel toolbarWrapper = new JPanel();
        toolbarWrapper.add(westToolbar);
        toolbarWrapper.setBorder(IdeBorders.rightBorder(IdeColors.DEFAULT_BORDER_COLOR));
        return toolbarWrapper;
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
