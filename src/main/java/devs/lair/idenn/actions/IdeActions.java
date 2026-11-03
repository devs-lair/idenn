package devs.lair.idenn.actions;

import devs.lair.idenn.ui.mainframe.actions.ProjectTreeToggleAction;
import devs.lair.idenn.ui.project.actions.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        registerAction(new ProjectTreeToggleAction());
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
    public static void updateActions(@Nullable @Deprecated AWTEvent event) {
        actions.values().forEach(action -> action.update(event));
    }

    public static void updateActions() {
        updateActions(null);
    }


    @SuppressWarnings("unchecked")
    public static <T extends IdeAction> T getAction(@NotNull Class<T> actionClass) {
        return (T) actions.get(actionClass.getCanonicalName());
    }
}
