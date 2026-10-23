package devs.lair.idenn.ui;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdeStrings {

    public static final ResourceBundle bundle = ResourceBundle.getBundle("idenn-i18n", Locale.getDefault());

    public interface Titles {
        String FRAME_TITLE = bundle.getString("title.Idenn");
    }

    public interface Actions {

        String OPEN_PROJECT = bundle.getString("action.Open");
        String OPEN_TOOLTIP = bundle.getString("action.Open.tooltip");
        String OPEN_MNEMONIC = bundle.getString("action.Open.mnemonic");
        String NEW = bundle.getString("action.New");
        String NEW_TOOLTIP = bundle.getString("action.New.tooltip");
        String NEW_MNEMONIC = bundle.getString("action.New.mnemonic");
        String SAVE = bundle.getString("action.Save");
        String SAVE_TOOLTIP = bundle.getString("action.Save.tooltip");
        String SAVE_MNEMONIC = bundle.getString("action.Save.mnemonic");

        String CLOSE = bundle.getString("action.Close");
        String CLOSE_TOOLTIP = bundle.getString("action.Close.tooltip");
        String CLOSE_MNEMONIC = bundle.getString("action.Close.mnemonic");
    }
    public interface Menus {
        String FILE = bundle.getString("menu.File");
        String FILE_MNEMONIC = bundle.getString("menu.File.mnemonic");
    }

    public interface Labels {
        String READY = bundle.getString("labels.ready");
    }
}
