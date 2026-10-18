package devs.lair.idenn.ui;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdeStrings {

    public static final ResourceBundle bundle = ResourceBundle.getBundle("idenn-i18n", Locale.getDefault());

    public interface Titles {
        String FRAME_TITLE = bundle.getString("title.Idenn");
    }

    public static interface Actions {
        String CLOSE = bundle.getString("action.Close");
        String OPEN_PROJECT = bundle.getString("action.OpenProject");

    }
    public interface Menus {
        String FILE = bundle.getString("menu.File");

    }

    public interface Labels {
        String READY = bundle.getString("labels.ready");
    }
}
