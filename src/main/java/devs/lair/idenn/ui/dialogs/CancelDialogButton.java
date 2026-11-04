package devs.lair.idenn.ui.dialogs;

import devs.lair.idenn.actions.IdeSimpleAction;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CancelDialogButton extends JButton {

    public CancelDialogButton(@NotNull String buttonText, @NotNull IdeDialog<?> dialog) {
        setText(buttonText);
        addActionListener(new IdeSimpleAction("Cancel button") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.doCancel();
                postEvent(e, "Dialog '%s' was closed".formatted(dialog.getTitle()));
            }
        });
    }

    public CancelDialogButton(@NotNull IdeDialog<?> dialog) {
        this(IdeStrings.Buttons.CANCEL, dialog);
    }
}