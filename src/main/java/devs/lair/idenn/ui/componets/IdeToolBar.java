package devs.lair.idenn.ui.componets;

import devs.lair.idenn.actions.IdeAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IdeToolBar extends JToolBar {

    public IdeToolBar(int orientation) {
        super(orientation);
    }

    public IdeToolBar() {
    }

    @Override
    public Component add(Component comp) {
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

    private void registerIdeActionKeyStroke(IdeAction ideAction) {
        KeyStroke keyStroke = ideAction.getKey();
        if (keyStroke != null) {
            getActionMap().put(ideAction.getId(), ideAction);
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, ideAction.getId());
        }
    }
}
