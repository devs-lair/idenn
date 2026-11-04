package devs.lair.idenn.bus;

import devs.lair.idenn.actions.IdeSimpleAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionEvent;

public class ActionPerformedEvent extends AppEvent {

    public ActionPerformedEvent(@NotNull IdeSimpleAction action,
                                @NotNull ActionEvent actionEvent,
                                @Nullable String performDescription) {
        super(action.getName(), performDescription);

        //TODO Store event and action?
    }

    public @Nullable String getStateString() {
        return "Action (" + name + ")" + (description == null ? "" : ": " + description);
    }
}