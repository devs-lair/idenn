package devs.lair.idenn.ui.componets.toolbar;

import devs.lair.idenn.actions.IdeAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IdeMainFrameToolBar extends IdeToolbar {

    public IdeMainFrameToolBar(int orientation) {
        super(orientation);
    }

    @Override
    protected void registerIdeActionKeyStroke(@NotNull IdeAction ideAction) {
        KeyStroke keyStroke = ideAction.getKey();
        if (keyStroke != null) {
            getActionMap().put(ideAction.getId(), ideAction);
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, ideAction.getId());
        }
    }
}
