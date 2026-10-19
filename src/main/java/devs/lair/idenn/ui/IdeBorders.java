package devs.lair.idenn.ui;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IdeBorders {

    public IdeBorders() {
        throw new IllegalStateException();
    }

    public static Border topBorder(@NotNull Color color) {
        return BorderFactory.createMatteBorder(1, 0, 0,0, color);
    }

    public static Border rightBorder(Color color) {
        return BorderFactory.createMatteBorder(0, 0, 0,1, color);
    }
}
