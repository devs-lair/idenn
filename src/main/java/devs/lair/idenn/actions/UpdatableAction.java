package devs.lair.idenn.actions;


import devs.lair.idenn.ui.keys.UiKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//Marker
public interface UpdatableAction {
    void update(@Nullable Object object);

    @NotNull UiKey<?> getOwnerComponentKey();
}