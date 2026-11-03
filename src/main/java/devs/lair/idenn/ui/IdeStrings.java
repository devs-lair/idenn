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
        String REMOVE_PROJECT_ITEM = bundle.getString("action.RemoveItem");
        String REMOVE_PROJECT_ITEM_TOOLTIP = bundle.getString("action.RemoveProjectItem.tooltip");
        String ADD_PROJECT_ITEM = bundle.getString("action.AddItem");
        String ADD_PROJECT_ITEM_TOOLTIP = bundle.getString("action.AddProjectItem.tooltip");
        String CLONE_PROJECT_ITEM = bundle.getString("action.CloneItem");
        String CLONE_PROJECT_ITEM_TOOLTIP = bundle.getString("action.CloneProjectItem.tooltip");
        String COLLAPSE_PROJECT_TREE = bundle.getString("action.CollapseAll");
        String EXPAND_PROJECT_TREE = bundle.getString("action.ExpandAll");
    }

    public interface Menus {
        String FILE = bundle.getString("menu.File");
        String FILE_MNEMONIC = bundle.getString("menu.File.mnemonic");
    }

    public interface Labels {
        String READY = bundle.getString("labels.ready");
    }

    public interface Project {
        String CATEGORY_MODELS = bundle.getString("project.category.models");
        String CATEGORY_ENGINES = bundle.getString("project.category.engines");
        String CATEGORY_BUILDS = bundle.getString("project.category.builds");
        String CATEGORY_DATASETS = bundle.getString("project.category.datasets");
        String CATEGORY_TRAINS = bundle.getString("project.category.trains");

        String ITEM_MODEL = bundle.getString("project.item.model");
        String ITEM_ENGINE = bundle.getString("project.item.engine");
        String ITEM_BUILD = bundle.getString("project.item.build");
        String ITEM_DATASET = bundle.getString("project.item.dataset");
        String ITEM_TRAIN = bundle.getString("project.item.train");

        String PROJECT_TREE = bundle.getString("project.labels.projectTree");
    }

    public interface Buttons {
        String CANCEL = bundle.getString("buttons.cancel");
        String ADD = bundle.getString("buttons.add");
        String OK = bundle.getString("buttons.ok");
    }

    public interface Dialogs {
        String ADD_PROJECT_ITEM_DIALOG = bundle.getString("dialogs.AddProjectItem.title");
    }
}
