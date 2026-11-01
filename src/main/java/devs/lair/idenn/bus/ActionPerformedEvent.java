package devs.lair.idenn.bus;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ActionPerformedEvent extends AppEvent {

    public ActionPerformedEvent(@NotNull String actionName, @Nullable String performDescription) {
        super(actionName, performDescription);
    }

    public @Nullable String getStateString() {
        return "Action (" + name + ")" + (description == null ? "" : ": " + description);
    }
}