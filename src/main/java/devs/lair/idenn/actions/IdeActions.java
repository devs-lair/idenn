package devs.lair.idenn.actions;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdeActions {
    private final static Map<String, IdeAction> actions = new ConcurrentHashMap<>();

    private IdeActions() {
        throw new IllegalStateException();
    }

    public static void registerAction(@NotNull IdeAction action) {
        actions.put(action.getName(), action);
    }

    //granularity
    public static void updateActions(@NotNull AWTEvent event) {
        actions.values().forEach(action -> action.update(event));
    }

    public IdeAction getAction(@NotNull String actionId) {
        return actions.get(actionId);
    }
}
