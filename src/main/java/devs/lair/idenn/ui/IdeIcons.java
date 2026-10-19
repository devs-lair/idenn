package devs.lair.idenn.ui;

import com.formdev.flatlaf.FlatLaf;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class IdeIcons {

    private IdeIcons() {
        throw new IllegalStateException();
    }

    public static @NotNull Icon getIcon(@NotNull Ikon ikon) {
        return getIcon(ikon, IdeSizes.TOOLBAR_ICONS_SIZE);
    }

    public static Icon getIcon(@NotNull Ikon ikon, int size) {
        FontIcon fontIcon = new FontIcon();
        fontIcon.setIkon(ikon);
        fontIcon.setIconSize(size);

        if (FlatLaf.isLafDark()) {
            fontIcon.setIconColor(Color.WHITE);
        }

        return fontIcon;
    }
}
