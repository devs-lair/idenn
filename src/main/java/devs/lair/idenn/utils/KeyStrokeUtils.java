package devs.lair.idenn.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyStrokeUtils {

    private KeyStrokeUtils() {
    }

    public static @NotNull String getKeyStrokeText(@NotNull KeyStroke accelerator) {
        String acceleratorText = "";
        int modifiers = accelerator.getModifiers();
        if (modifiers > 0) {
            acceleratorText = InputEvent.getModifiersExText(modifiers);
            acceleratorText += "+";
        }
        acceleratorText += KeyEvent.getKeyText(accelerator.getKeyCode());

        return acceleratorText;
    }
}
