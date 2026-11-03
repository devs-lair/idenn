package devs.lair.idenn.ui.project.dialogs;

import devs.lair.idenn.model.project.ProjectItem;
import devs.lair.idenn.model.project.ProjectItemType;
import devs.lair.idenn.services.ProjectItemService;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.ui.dialogs.IdeDialog;
import devs.lair.idenn.utils.DocumentAdapter;
import devs.lair.idenn.utils.GridBagHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddItemDialog extends IdeDialog<ProjectItem> {
    private final ProjectItemType preferType;
    private JTextField nameTextField;
    private JComboBox<?> typeCombox;
    private ProjectItem result;

    public AddItemDialog(@Nullable ProjectItemType preferType) {
        super(IdeStrings.Dialogs.ADD_PROJECT_ITEM_DIALOG, true, true);

        this.preferType = preferType;

        setOkButtonText(IdeStrings.Buttons.ADD);
        getOkButton().setEnabled(false);

        init();
    }

    @Override
    public void createCenterPanel() {
        JPanel centerPanel = getCenterPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagHelper helper = new GridBagHelper();
        helper.nextCell().gap(5).alignLeft();

        centerPanel.add(new JLabel("Name"), helper.get());

        helper.nextCell().fillHorizontally();
        centerPanel.add(creteNameTextfield(), helper.get());

        helper.nextRow().nextCell().gap(5).alignLeft();
        centerPanel.add(new JLabel("Type"), helper.get());

        helper.nextCell().fillHorizontally();
        centerPanel.add(createProjectItemTypeCombobox(preferType), helper.get());
    }

    private @NotNull JTextField creteNameTextfield() {
        nameTextField = new JTextField(10);
        nameTextField.getDocument().addDocumentListener((DocumentAdapter) e ->
                getOkButton().setEnabled(!nameTextField.getText().isBlank()));
        nameTextField.addActionListener(e -> doMainAction());
        return nameTextField;
    }

    private @NotNull JComponent createProjectItemTypeCombobox(@Nullable ProjectItemType preferType) {
        typeCombox =
                new JComboBox<>(new DefaultComboBoxModel<>(ProjectItemType.values()));
        typeCombox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof ProjectItemType type) {
                    label.setText(type.getName());
                    label.setIcon(type.getIcon());
                    label.setIconTextGap(IdeSizes.SMALL_IDENT);
                } else {
                    label.setIcon(null);
                }
                return label;
            }
        });

        if (preferType != null) {
            typeCombox.setSelectedItem(preferType);
        }

        return typeCombox;
    }

    @Override
    public ProjectItem getResult() {
        return result;
    }

    @Override
    public void doMainAction() {
        result = ProjectItemService.getInstance()
                .createProjectItem(nameTextField.getText(), (ProjectItemType) typeCombox.getSelectedItem());
        setVisible(false);
        dispose();
    }
}