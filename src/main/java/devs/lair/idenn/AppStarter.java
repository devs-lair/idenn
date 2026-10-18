package devs.lair.idenn;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.util.Locale;

public class AppStarter {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SwingUtilities.invokeLater(() -> {
            FlatIntelliJLaf.setup();
            new IdeMainFrame().showFrame();
        });
    }
}
