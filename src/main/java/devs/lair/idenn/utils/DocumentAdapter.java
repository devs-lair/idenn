package devs.lair.idenn.utils;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface DocumentAdapter extends DocumentListener {

    void onChange(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        onChange(e);
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        onChange(e);
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        onChange(e);
    }
}
