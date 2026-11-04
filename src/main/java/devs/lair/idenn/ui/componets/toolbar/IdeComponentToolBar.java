package devs.lair.idenn.ui.componets.toolbar;

import devs.lair.idenn.actions.IdeAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class IdeComponentToolBar extends IdeToolbar {
    public final JComponent ownerComponent;

    public IdeComponentToolBar(@Nullable JComponent ownerComponent, int orientation) {
        super(orientation);
        this.ownerComponent = ownerComponent;
    }

    public IdeComponentToolBar(@Nullable JComponent ownerComponent) {
        this(ownerComponent, JToolBar.HORIZONTAL);
    }

    @Override
    protected void registerIdeActionKeyStroke(@NotNull IdeAction ideAction) {
        KeyStroke keyStroke = ideAction.getKey();
        if (keyStroke != null) {
            ownerComponent.getActionMap().put(ideAction.getId(), ideAction);
            ownerComponent.getInputMap(JComponent.WHEN_FOCUSED).put(keyStroke, ideAction.getId());
        }
    }
}