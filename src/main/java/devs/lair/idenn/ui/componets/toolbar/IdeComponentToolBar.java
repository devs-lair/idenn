package devs.lair.idenn.ui.componets.toolbar;

import devs.lair.idenn.actions.IdeAction;
import devs.lair.idenn.utils.ActionUtils;
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
        ActionUtils.registerIdeActionKeyStroke(ideAction, ownerComponent);
    }
}