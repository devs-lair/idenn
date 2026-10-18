package devs.lair.idenn.ui;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class IdeColors {
    public static final UIDefaults defaults = UIManager.getDefaults();
    public static final Color MENU_BACKGROUND = defaults.getColor("MenuBar.background");
    public static final Color MENU_BORDER_COLOR = defaults.getColor("MenuBar.borderColor");

    private IdeColors() {
        throw new IllegalStateException();
    }

    public static @NotNull Color getColor(@NotNull String key, @NotNull Color defaultColor) {
        Color color = defaults.getColor(key);
        return color == null ? defaultColor : color;
    }

    public static @NotNull Color getColor(@NotNull String key) {
        return Objects.requireNonNull(defaults.getColor(key),
                "Color is null for key = %s".formatted(key));
    }
}
