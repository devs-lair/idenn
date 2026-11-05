package devs.lair.idenn;

import devs.lair.idenn.bus.AppEvent;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.componets.IdeSpliter;
import devs.lair.idenn.ui.keys.IdeUiNames;
import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.mainframe.StateLine;
import devs.lair.idenn.ui.mainframe.toolbars.WestToolbar;
import devs.lair.idenn.ui.mainmenu.MainMenu;
import devs.lair.idenn.ui.project.ProjectComponent;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

        setName(IdeUiNames.MAIN_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(new Dimension(IdeSizes.SCREEN_WIDTH - 400, IdeSizes.SCREEN_HEIGHT - 200));
        setJMenuBar(new MainMenu());

        //createListeners();

        createMainPanel();
        showFrame();
    }

    @SuppressWarnings("unchecked")
    public static <T extends JComponent> @Nullable T getByKey(@NotNull UiKey<T> key) {
        return (T) keyedComponents.get(key);
    }

    @SuppressWarnings("unchecked")
    public static <T extends JComponent> @NotNull T getByKeyOrThrow(@NotNull UiKey<T> key) {
        JComponent jComponent = keyedComponents.get(key);
        if (jComponent == null) {
            throw new IllegalStateException("No component for key: %s".formatted(key.name()));
        }

        return (T) jComponent;
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
            //TODO : Need work
            byKey.requestFocus();
        }
    }

    private void createListeners() {
        long eventMask = AWTEvent.ACTION_EVENT_MASK;
        Toolkit.getDefaultToolkit().addAWTEventListener(e -> {
            //(e.getID() == MouseEvent.MOUSE_RELEASED) ||
            if (e.getID() == ActionEvent.ACTION_PERFORMED) {
                //IdeActions.updateActions(e);
            }
        }, eventMask);
    }

    private void showFrame() {
        setLocationRelativeTo(null);
        setVisible(true);

        EventBus.getDefault().post(new AppEvent("Application started"));
    }

    private void createMainPanel() {
//      //mainPanel.add(createEastPanel(), BorderLayout.EAST);
        mainPanel.add(new WestToolbar(), BorderLayout.WEST);
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

    public StateLine getStateLine() {
        return stateLine;
    }

    @Override
    public void dispose() {
        super.dispose();
        EventBus.getDefault().post(new AppEvent("Application closed"));
    }
}
