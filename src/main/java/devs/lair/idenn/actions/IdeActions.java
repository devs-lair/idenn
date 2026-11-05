package devs.lair.idenn.actions;

import devs.lair.idenn.ui.keys.UiKey;
import devs.lair.idenn.ui.mainframe.actions.ProjectTreeToggleAction;
import devs.lair.idenn.ui.project.actions.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//TODO :getInstance() for diff project?
public class IdeActions {
    private final static Map<String, IdeAction> actions = new ConcurrentHashMap<>();

    static {
        //TODO find class by reflection?
        registerAction(new AddProjectItemAction());
        registerAction(new RemoveProjectItemAction());
        registerAction(new CloneProjectItemAction());
        registerAction(new ExpandProjectTreeAction());
        registerAction(new CollapseProjectTreeAction());
        registerAction(new ProjectTreeToggleAction());
        registerAction(new RenameAction());
    }

    private IdeActions() {
        throw new IllegalStateException();
    }

    public static void registerAction(@NotNull IdeAction action) {
        if (actions.containsKey(action.getId())) {
            throw new IllegalStateException("Duplicate id or duplicate register action, %s"
                    .formatted(action.getId()));
        }
        actions.put(action.getId(), action);
    }

    //TODO : add datasink second parameter and pass to update()
    public static void updateActions(@NotNull UiKey<?> componentKey) {
        actions.values().stream()
                .filter(action ->
                        action instanceof UpdatableAction updatableAction &&
                                updatableAction.getOwnerComponentKey() == componentKey)
                .forEach(action -> action.update(null));
    }

    @SuppressWarnings("unchecked")
    public static <T extends IdeAction> T getAction(@NotNull Class<T> actionClass) {
        return (T) actions.get(actionClass.getCanonicalName());
    }
}
