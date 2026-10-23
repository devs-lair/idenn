package devs.lair.idenn.ui.abstarcts;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.KeyEvent;

abstract public class IdeAction extends AbstractAction {

    public IdeAction(@NotNull String name,
                     @Nullable String tooltip,
                     @Nullable Icon icon,
                     @Nullable KeyStroke keyStroke,
                     @Nullable Character mnemonic) {
        super(name, icon);

        putValue(Action.SHORT_DESCRIPTION, tooltip);
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

    public IdeAction(@NotNull String name) {
        this(name, null, null, null, null);
    }

    public void setMnemonic(int mnemonic) {
        putValue(Action.MNEMONIC_KEY, mnemonic);
    }

    public void setKey(@NotNull KeyStroke keyStroke) {
        putValue(Action.ACCELERATOR_KEY, keyStroke);
    }
}

