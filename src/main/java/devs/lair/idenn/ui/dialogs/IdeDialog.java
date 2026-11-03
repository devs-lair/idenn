package devs.lair.idenn.ui.dialogs;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeLightAction;
import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.utils.HtmlLabelsUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class IdeDialog<T> extends JDialog {
    private final JPanel bottomButtonsPanel;
    private final JPanel centerPanel;
    private JPanel titlePanel;

    private boolean canceled = false;

    public IdeDialog(@NotNull String title) {
        this(title, true, false);
    }

    public IdeDialog(@NotNull String title, boolean modal, boolean undecorated) {
        super(IdeMainFrame.getInstance());

        setUndecorated(undecorated);
        setTitle(title);
        setModal(modal);
        setResizable(false);
        setScreenLocation();
        setLayout(new BorderLayout(0, 0));

        ((JPanel) getContentPane()).setBorder(IdeBorders.emptyBorder(IdeSizes.SMALL_IDENT));

        if (undecorated) {
            add(createTitlePanel(), BorderLayout.NORTH);
        }

        add(centerPanel = new JPanel(), BorderLayout.CENTER);
        add(bottomButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0)), BorderLayout.SOUTH);
        bottomButtonsPanel.setBorder(BorderFactory.createEmptyBorder(IdeSizes.SMALL_IDENT, 0, 0, 0));

        createBottomButtons();
        createCenterPanel();
        pack();
    }

    private JComponent createTitlePanel() {
        if (titlePanel == null) {
            this.titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            this.titlePanel.setBorder(new EmptyBorder(0, 0, IdeSizes.MEDIUM_IDENT, 0));
            this.titlePanel.add(new JLabel(HtmlLabelsUtil.bold(getTitle())));
        }
        return titlePanel;
    }

    public void setCustomTitle(boolean tilted) {
        if (tilted) {
            centerPanel.add(createTitlePanel(), BorderLayout.NORTH);
        } else {
            centerPanel.remove(titlePanel);
        }
    }

    protected abstract void createCenterPanel();

    protected void setScreenLocation() {
        setLocationRelativeTo(IdeMainFrame.getInstance());
        Point location = getLocation();
        Point newLocation = new Point(location.x, location.y / 2);
        setLocation(newLocation);
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    abstract public T getResult();

    abstract protected void doMainAction();

    protected void createBottomButtons() {
        MainActionDialogButton okAction = new MainActionDialogButton(this);
        CancelDialogButton cancelDialogButton = new CancelDialogButton(this);

        bottomButtonsPanel.add(okAction);
        bottomButtonsPanel.add(new CancelDialogButton(this));

        getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC");
        getRootPane().getActionMap().put("ESC", (IdeLightAction) cancelDialogButton.getActionListeners()[0]);

        okAction.requestFocus();
    }

    public void doCancel() {
        canceled = true;
        dispose();
    }

    public boolean isCanceled() {
        return canceled;
    }
}
