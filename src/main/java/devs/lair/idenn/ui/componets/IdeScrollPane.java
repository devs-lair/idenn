package devs.lair.idenn.ui.componets;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IdeScrollPane extends JScrollPane {

    public IdeScrollPane(@NotNull JComponent view) {
        super(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setBorder(null);
        getViewport().setBorder(null);
    }
}