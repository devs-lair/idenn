package devs.lair.idenn.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.utils.KeyStrokeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.KeyEvent;

abstract public class IdeAction extends IdeSimpleAction {
    protected final String id;

    protected Icon icon;
    protected Icon disabledIcon;

    public IdeAction(@NotNull String name,
                     @Nullable String tooltip,
                     @Nullable Icon icon,
                     @Nullable KeyStroke keyStroke,
                     @Nullable Character mnemonic) {
        super(name);

        this.id = getClass().getCanonicalName();
        this.icon = icon;

        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, createHtmlTooltip(tooltip, keyStroke));
        putValue(Action.ACCELERATOR_KEY, keyStroke);

        if (mnemonic != null) {
            putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(mnemonic));
        }
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

    private String createHtmlTooltip(@Nullable String tooltip, @Nullable KeyStroke keyStroke) {
        if (keyStroke == null) {
            return tooltip;
        }

        //TODO to HtmlLabelsUtil
        String keyStrokeText = KeyStrokeUtils.getKeyStrokeText(keyStroke);
        String htmlKeyStroke = " <span color='GRAY'>(" + keyStrokeText + ")</span>";

        return "<html>" + tooltip + htmlKeyStroke + "</html>";
    }

    public @NotNull String getId() {
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
    public void setEnabled(boolean newValue) {
        if (this.enabled == newValue) {
            return;
        }

        if (icon != null) {
            if (disabledIcon == null) {
                disabledIcon = IdeIcons.createGreyIcon(icon);
            }

            putValue(Action.SMALL_ICON, newValue ? icon : disabledIcon);
        }

        super.setEnabled(newValue);
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

    public boolean hasIcon() {
        return icon != null;
    }
}

