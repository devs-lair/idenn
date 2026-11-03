package devs.lair.idenn.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.utils.KeyStrokeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.KeyEvent;

abstract public class IdeAction extends IdeLightAction {
    protected final String id;

    protected String name;
    protected Icon icon;
    protected Icon disabledIcon;

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
        putValue(Action.SHORT_DESCRIPTION, createHtmlTooltip(tooltip, keyStroke));
        putValue(Action.ACCELERATOR_KEY, keyStroke);

        if (mnemonic != null) {
            putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(mnemonic));
        }
    }

    private String createHtmlTooltip(@Nullable String tooltip, @Nullable KeyStroke keyStroke) {
        if (keyStroke == null) {
            return tooltip;
        }

        String keyStrokeText = KeyStrokeUtils.getKeyStrokeText(keyStroke);
        String htmlKeyStroke = " <span color='GRAY'>(" + keyStrokeText + ")</span>";

        return "<html>" + tooltip + htmlKeyStroke + "</html>";
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

    public @Nullable KeyStroke getKey() {
        try {
            return (KeyStroke) getValue(Action.ACCELERATOR_KEY);
        } catch (ClassCastException e) {
            return null;
        }
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

