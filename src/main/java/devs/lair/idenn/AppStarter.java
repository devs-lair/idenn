package devs.lair.idenn;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.util.UIScale;
import devs.lair.idenn.bus.EventHandler;
import devs.lair.idenn.ui.IdeSizes;
import org.greenrobot.eventbus.EventBus;

import javax.swing.*;
import java.util.Locale;

public class AppStarter {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        EventBus.builder().throwSubscriberException(true)
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .installDefaultEventBus();

        EventHandler.init();

        SwingUtilities.invokeLater(() -> {
            FlatIntelliJLaf.setup();
            UIScale.setZoomFactor(IdeSizes.SCALE);
            //FlatDarkFlatIJTheme.setup();
            //FlatDarculaLaf.setup();
            IdeMainFrame.init();
        });
    }
}
