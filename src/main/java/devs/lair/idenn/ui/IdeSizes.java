package devs.lair.idenn.ui;

import javax.swing.*;
import java.awt.*;

public class IdeSizes {
    public final static int LINE_HEIGHT;
    public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    static {
        LINE_HEIGHT =  new JLabel("1").getFontMetrics(new JLabel().getFont()).getHeight();
    }

}
