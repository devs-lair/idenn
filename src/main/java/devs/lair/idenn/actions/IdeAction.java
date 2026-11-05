package devs.lair.idenn.actions;

import devs.lair.idenn.ui.IdeIcons;
import devs.lair.idenn.utils.HtmlLabelsUtil;
import devs.lair.idenn.utils.KeyStrokeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
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
        putValue(Action.ACCELERATOR_KEY, keyStroke);
        putValue(Action.SHORT_DESCRIPTION, tooltip != null && keyStroke != null
                ? createHtmlTooltip(tooltip, keyStroke)
                : tooltip);

        putValue(Action.MNEMONIC_KEY, mnemonic == null
                ? null
                : KeyEvent.getExtendedKeyCodeForChar(mnemonic));
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

    //TODO : move dataskink
    public void update(@Nullable Object object) {
        //no op by default
    }

    public @NotNull String getId() {
        return id;
    }

    public @Nullable KeyStroke getKey() {
        return (KeyStroke) getValue(Action.ACCELERATOR_KEY);
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

    public void setDisabledIcon(@Nullable Icon disabledIcon) {
        this.disabledIcon = disabledIcon;
    }

    public @Nullable Icon getIcon() {
        return icon;
    }

    public void setIcon(@Nullable Icon icon) {
        this.icon = icon;
    }

    public boolean hasIcon() {
        return icon != null;
    }

    private String createHtmlTooltip(@NotNull String tooltip, @NotNull KeyStroke keyStroke) {
        String keyStrokeText = "(" + KeyStrokeUtils.getKeyStrokeText(keyStroke) + ")";
        return HtmlLabelsUtil.html(tooltip + HtmlLabelsUtil.colorSpan(keyStrokeText, Color.GRAY));
    }
}

