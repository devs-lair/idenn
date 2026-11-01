package devs.lair.idenn.actions;

import devs.lair.idenn.bus.ActionPerformedEvent;
import devs.lair.idenn.ui.IdeIcons;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

abstract public class IdeAction extends AbstractAction {
    protected final String id;

    protected String name;
    protected Icon icon;
    protected Icon disabledIcon;

    protected String performedDescription;

    public IdeAction(@NotNull String name,
                     @Nullable String tooltip,
                     @Nullable Icon icon,
                     @Nullable KeyStroke keyStroke,
                     @Nullable Character mnemonic) {
        super(name);

        this.id = getClass().getCanonicalName();
        this.name = name;
        this.icon = icon;

        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, tooltip);
        putValue(Action.ACCELERATOR_KEY, keyStroke);

        if (mnemonic != null) {
            putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(mnemonic));
        }

        IdeActions.registerAction(this);
    }

    public IdeAction(@NotNull String name,
                     @NotNull String tooltip,
                     @NotNull Icon icon,
                     @NotNull KeyStroke keyStroke) {
        this(name, tooltip, icon, keyStroke, null);
    }

    public IdeAction(@NotNull String name,
                     @NotNull String tooltip,
                     @NotNull Icon icon) {
        this(name, tooltip, icon, null, null);
    }

    public IdeAction(@NotNull String name,
                     @NotNull String tooltip) {
        this(name, tooltip, null, null, null);
    }

    public String getId() {
        return id;
    }

    public void postEvent(@NotNull ActionEvent e) {
        //Java bug fix
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(e);

        EventBus.getDefault()
                .post(new ActionPerformedEvent(name, performedDescription));
    }

    public void update(Object object) {
    }

    public void setMnemonic(int mnemonic) {
        putValue(Action.MNEMONIC_KEY, mnemonic);
    }

    public @Nullable KeyStroke getKey() {
        try {
            return (KeyStroke) getValue(Action.ACCELERATOR_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }

    public void setKey(@NotNull KeyStroke keyStroke) {
        putValue(Action.ACCELERATOR_KEY, keyStroke);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        if (icon == null) {
            return;
        }

        if (disabledIcon == null) {
            disabledIcon = createDisabledIcon(icon);
        }

        putValue(Action.SMALL_ICON, enabled ? icon : disabledIcon);
    }

    private @NotNull Icon createDisabledIcon(@NotNull Icon icon) {
        return IdeIcons.createGreyIcon(icon);
    }

    public @Nullable Icon getDisabledIcon() {
        return disabledIcon;
    }

    public void setDisabledIcon(Icon disabledIcon) {
        this.disabledIcon = disabledIcon;
    }

    public @Nullable Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void setName(@NotNull String name) {
        this.name = name;
        putValue(Action.NAME, name);
    }

    public String getName() {
        return name;
    }

    public boolean hasIcon() {
        return icon != null;
    }

    public @Nullable String getTooltip() {
        String tooltip = (String) getValue(Action.SHORT_DESCRIPTION);
        return tooltip == null ? name : tooltip;
    }
}

