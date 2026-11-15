package devs.lair.idenn.ui;

import javax.swing.*;
import java.awt.*;

public class IdeSizes {

    public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    //TODO: can be changed by scale
    public static float SCALE = 1.00f;
    public static int TOOLBAR_ICONS_SIZE = scale(16);
    public static int LINE_HEIGHT = getLineHeight();
    ;
    public static int SMALL_IDENT = scale(6);
    public static int MEDIUM_IDENT = scale(12);

    private static int getLineHeight() {
        return scale(new JLabel("1")
                .getFontMetrics(new JLabel().getFont()).getHeight());
    }

    public static int scale(int value) {
        return (int) (value * SCALE);
    }
}
