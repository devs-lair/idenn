package devs.lair.idenn.utils;

import devs.lair.idenn.actions.IdeAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ActionUtils {

    private ActionUtils() {
    }

    public static void registerIdeActionKeyStroke(@NotNull IdeAction ideAction,
                                                  @NotNull JComponent component) {
        KeyStroke keyStroke = ideAction.getKey();
        if (keyStroke != null) {
            component.getActionMap().put(ideAction.getId(), ideAction);
            component.getInputMap(JComponent.WHEN_FOCUSED).put(keyStroke, ideAction.getId());
        }
    }
}