package devs.lair.idenn.ui.componets;

import devs.lair.idenn.actions.IdeAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IdeToolBar extends JToolBar {

    public IdeToolBar() {
    }

    @Override
    public @NotNull JButton add(Action action) {
        JButton button = super.add(action);

        if (action instanceof IdeAction ideAction) {
            getActionMap().put(ideAction.getName(), ideAction);

            KeyStroke keyStroke = ideAction.getKey();
            if (keyStroke != null) {
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, ideAction.getName());
            }
        }

        return button;
    }
}
