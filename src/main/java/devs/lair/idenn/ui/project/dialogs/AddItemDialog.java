package devs.lair.idenn.ui.project.dialogs;

import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.dialogs.IdeDialog;

import javax.swing.*;

public class AddItemDialog extends IdeDialog<String> {

    public AddItemDialog() {
        super(IdeStrings.Actions.ADD_PROJECT_ITEM_TOOLTIP);

        setSize(IdeSizes.SCREEN_WIDTH / 6, IdeSizes.LINE_HEIGHT * 10);

        JPanel centerPanel = getCenterPanel();
        centerPanel.add(new JLabel("Name"));
        centerPanel.add(new JTextField());
        centerPanel.add(new JLabel("Type"));
        centerPanel.add(new JComboBox<>(new DefaultComboBoxModel<>(new String[]{"Network Schema", "Engine", "Dataset", "Training"})));
    }

    @Override
    public String getResult() {
        return "Add button";
    }

    @Override
    public void doMainAction() {
        setVisible(false);
    }
}