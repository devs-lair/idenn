package devs.lair.idenn;

import devs.lair.idenn.ui.IdeBorders;
import devs.lair.idenn.ui.IdeColors;
import devs.lair.idenn.ui.IdeSizes;
import devs.lair.idenn.ui.IdeStrings;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class StateLine extends JPanel {
    private final JLabel stateLabel = new JLabel(IdeStrings.Labels.READY);

    public StateLine() {
        super(new FlowLayout(FlowLayout.LEFT));
        setSize(IdeSizes.SCREEN_WIDTH, IdeSizes.LINE_HEIGHT);
        setBackground(IdeColors.MENU_BACKGROUND);
        setBorder(IdeBorders.topBorder(IdeColors.MENU_BORDER_COLOR));

        add(stateLabel);
    }

    public void write(@NotNull String stateLine) {
        if (stateLine.isEmpty()) {
            clear();
        } else {
            stateLabel.setText(stateLine);
        }
    }

    public void clear() {
        stateLabel.setText("");
    }
}
