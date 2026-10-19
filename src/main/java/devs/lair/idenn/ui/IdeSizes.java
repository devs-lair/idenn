package devs.lair.idenn.ui;

import javax.swing.*;
import java.awt.*;

public class IdeSizes {
    public final static int LINE_HEIGHT;
    public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int TOOLBAR_ICONS_SIZE = 16;
    public static final int SMALL_IDENT = 6;
    public static final int MEDIUM_IDENT = 12;

    static {
        LINE_HEIGHT =  new JLabel("1").getFontMetrics(new JLabel().getFont()).getHeight();
    }

}
