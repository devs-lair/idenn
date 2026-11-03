package devs.lair.idenn.actions;

import devs.lair.idenn.bus.ActionPerformedEvent;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;

abstract public class IdeLightAction extends AbstractAction {
    private final String name;

    public IdeLightAction(@NotNull String name) {
        super(name);
        this.name = name;
    }

    protected void postEvent(@NotNull ActionEvent e, @Nullable String performedDescription) {
        //Java bug fix
        //Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(e);

        EventBus.getDefault().post(new ActionPerformedEvent(name, performedDescription));
    }

    protected void postEvent(@NotNull ActionEvent e) {
        postEvent(e, null);
    }

    public void update(Object object) {

    }
}

