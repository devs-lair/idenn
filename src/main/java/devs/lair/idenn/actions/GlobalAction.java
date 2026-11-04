package devs.lair.idenn.actions;

import devs.lair.idenn.IdeMainFrame;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;

//Marker
public interface GlobalAction {
    default boolean isGlobalCall(@NotNull ActionEvent e) {
        return e.getSource() instanceof IdeMainFrame;
    }
}