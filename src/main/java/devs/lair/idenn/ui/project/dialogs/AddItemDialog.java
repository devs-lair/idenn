package devs.lair.idenn.ui.project.dialogs;

import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.dialogs.IdeDialog;
import devs.lair.idenn.utils.GridBagHelper;

import javax.swing.*;
import java.awt.*;

public class AddItemDialog extends IdeDialog<String> {

    public AddItemDialog() {
        super(IdeStrings.Dialogs.ADD_PROJECT_ITEM_DIALOG, true, true);
    }

    @Override
    public void createCenterPanel() {
        JPanel centerPanel = getCenterPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagHelper helper = new GridBagHelper();
        helper.nextCell().gap(5).alignLeft();

        centerPanel.add(new JLabel("Name"), helper.get());

        helper.nextCell().fillHorizontally();
        centerPanel.add(new JTextField(10), helper.get());

        helper.nextRow().nextCell().gap(5).alignLeft();
        centerPanel.add(new JLabel("Type"), helper.get());

        helper.nextCell().fillHorizontally();

        centerPanel.add(new JComboBox<>(new DefaultComboBoxModel<>
                (new String[]{"Network Schema", "Engine", "Dataset", "Training"})), helper.get());
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