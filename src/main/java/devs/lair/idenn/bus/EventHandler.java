package devs.lair.idenn.bus;

import devs.lair.idenn.IdeMainFrame;
import devs.lair.idenn.StateLine;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);

    private EventHandler() {
    }

    public static void init() {
        EventBus.getDefault().register(new EventHandler());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent(@NotNull AppEvent event) {
        String logString = event.getLogString();
        String stateString = event.getStateString();

        if (logString != null && !logString.isEmpty()) {
            String formatted = "Event was arrived: %s".formatted(event.getLogString());
            LOG.info(formatted);
        }

        if (stateString != null && !stateString.isEmpty()) {
            StateLine stateLine = IdeMainFrame.getInstance().getStateLine();
            stateLine.write(stateString);
        }
    }
}
