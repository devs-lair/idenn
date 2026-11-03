package devs.lair.idenn.ui.dialogs;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.actions.IdeLightAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class IdeDialog<T> extends JDialog {
    private final JPanel centerPanel;
    private final JPanel bottomButtons;

    private boolean canceled = false;

    public IdeDialog(@NotNull String title) {
        this(title, true);
    }

    public IdeDialog(@NotNull String title, boolean modal) {
        super(IdeMainFrame.getInstance());

        setTitle(title);
        setModal(modal);
        setResizable(false);
        setScreenLocation();
        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        bottomButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(centerPanel, BorderLayout.CENTER);
        add(bottomButtons, BorderLayout.SOUTH);

        createBottomButtons();
        pack();
    }

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

        bottomButtons.add(okAction);
        bottomButtons.add(new CancelDialogButton(this));

        getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC");
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
