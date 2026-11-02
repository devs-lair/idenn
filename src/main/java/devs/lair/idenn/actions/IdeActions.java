package devs.lair.idenn.actions;

import devs.lair.idenn.ui.project.actions.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdeActions {
    private final static Map<String, IdeAction> actions = new ConcurrentHashMap<>();

    static {
        registerAction(new AddProjectItemAction());
        registerAction(new RemoveProjectItemAction());
        registerAction(new CloneProjectItemAction());
        registerAction(new ExpandProjectTreeAction());
        registerAction(new CollapseProjectTreeAction());
    }

    private IdeActions() {
        throw new IllegalStateException();
    }

    public static void registerAction(@NotNull IdeAction action) {
        if (actions.containsKey(action.getId())) {
            throw new IllegalStateException("Duplicate id or duplicate register action, %s".formatted(action.getId()));
        }
        actions.put(action.getId(), action);
    }

    //granularity
    public static void updateActions(@NotNull AWTEvent event) {
        actions.values().forEach(action -> action.update(event));
    }

    public static IdeAction getAction(@NotNull Class<?> actionClass) {
        return actions.get(actionClass.getCanonicalName());
    }
}
