package devs.lair.idenn.ui;

import com.formdev.flatlaf.FlatLaf;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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

    public static Icon getIcon(@NotNull Ikon ikon, @NotNull Color color, int size) {
        FontIcon fontIcon = new FontIcon();
        fontIcon.setIkon(ikon);
        fontIcon.setIconSize(size);
        fontIcon.setIconColor(color);
        return fontIcon;
    }

    public static @NotNull Icon createGreyIcon(@NotNull Icon icon) {
        Image iconImage = iconToImage(icon);
        return new ImageIcon(GrayFilter.createDisabledImage(iconImage));
    }

    public static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        }

        if (icon instanceof FontIcon fontIcon) {
            return fontIcon.toImageIcon().getImage();
        }

        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage image = gc.createCompatibleImage(w, h);
        Graphics2D g = image.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return image;
    }
}
