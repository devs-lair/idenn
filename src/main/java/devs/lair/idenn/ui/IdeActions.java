package devs.lair.idenn.ui;

import devs.lair.idenn.ui.abstarcts.IdeAction;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class IdeActions {
    private final static Map<String, IdeAction> actions = new HashMap<>();

    private IdeActions() {
        throw new IllegalStateException();
    }

    public IdeAction getAction(@NotNull String actionId) {
        return actions.get(actionId);
    }
}
