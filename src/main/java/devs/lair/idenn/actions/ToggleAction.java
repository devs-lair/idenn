package devs.lair.idenn.actions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleAction extends IdeAction {

    public ToggleAction(@NotNull String name,
                        @Nullable String tooltip,
                        @Nullable Icon icon,
                        @Nullable KeyStroke keyStroke,
                        @Nullable Character mnemonic) {
        super(name, tooltip, icon, keyStroke, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        putValue(Action.SELECTED_KEY, !isSelected());
    }

    public boolean isSelected() {
        return (boolean) getValue(Action.SELECTED_KEY);
    }
}
