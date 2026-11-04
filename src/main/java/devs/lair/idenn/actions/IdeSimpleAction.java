package devs.lair.idenn.actions;

import devs.lair.idenn.bus.ActionPerformedEvent;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;

abstract public class IdeSimpleAction extends AbstractAction {

    public IdeSimpleAction(@NotNull String name) {
        super(name);
    }

    public @NotNull String getName() {
        return getValue(Action.NAME).toString();
    }

    public void setName(@NotNull String name) {
        putValue(Action.NAME, name);
    }

    protected void postEvent(@NotNull ActionEvent e, @Nullable String performedDescription) {
        EventBus.getDefault().post(new ActionPerformedEvent(this, e, performedDescription));
    }

    public void update(Object object) {
        //no op by default
    }
}

