package devs.lair.idenn.ui.dialogs;

import devs.lair.idenn.actions.IdeLightAction;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainActionDialogButton extends JButton {

    public MainActionDialogButton(@NotNull String buttonText, @NotNull IdeDialog<?> dialog) {
        setText(buttonText);
        addActionListener(new IdeLightAction("Main button") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.doMainAction();
                postEvent(e, "Dialog '%s' main action performed".formatted(dialog.getTitle()));
            }
        });
    }

    public MainActionDialogButton(@NotNull IdeDialog<?> dialog) {
        this(IdeStrings.Buttons.OK, dialog);
    }
}
