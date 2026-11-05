package devs.lair.idenn.ui.dialogs;

import devs.lair.idenn.model.common.NamedEntity;
import devs.lair.idenn.ui.IdeStrings;
import devs.lair.idenn.utils.DocumentAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RenameDialog extends IdeDialog<String> {
    private final JTextField name = new JTextField(20);
    private final NamedEntity entity;

    public RenameDialog(@NotNull NamedEntity entity) {
        super(IdeStrings.Dialogs.RENAME, true, true);

        this.entity = entity;
        init();
    }

    @Override
    protected void createCenterPanel() {
        JPanel centerPanel = getCenterPanel();
        centerPanel.add(name);

        name.setText(entity.getName());
        name.addActionListener(e -> doMainAction());
        name.getDocument().addDocumentListener((DocumentAdapter) e ->
                getOkButton().setEnabled(!name.getText().isBlank()));
    }

    @Override
    public String getResult() {
        return name.getText();
    }

    @Override
    protected boolean doValidate() {
        return !name.getText().isBlank();
    }

    @Override
    protected void doMainAction() {
        if (!doValidate()) {
            return;
        }

        dispose();
    }
}
