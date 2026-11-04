package devs.lair.idenn.ui.componets.toolbar;

import devs.lair.idenn.actions.IdeAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract public class IdeToolbar extends JToolBar {

    public IdeToolbar(int orientation) {
        super(orientation);
    }

    @Override
    public Component add(@NotNull Component comp) {
        Component add = super.add(comp);

        if (add instanceof AbstractButton button
                && button.getActionListeners() != null
                && button.getActionListeners().length != 0) {
            ActionListener action = button.getActionListeners()[0];
            if (action instanceof IdeAction ideAction) {
                registerIdeActionKeyStroke(ideAction);
            }
        }
        return add;
    }

    protected abstract void registerIdeActionKeyStroke(@NotNull IdeAction ideAction);
}
