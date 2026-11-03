package devs.lair.idenn.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.HTML;

import static javax.swing.text.html.HTML.Tag.B;
import static javax.swing.text.html.HTML.Tag.HTML;

public class HtmlLabelsUtil {

    public static String bold(@NotNull String text) {
        return crateOneTagWrapper(text, B);
    }

    private static String crateOneTagWrapper(@NotNull String text, @NotNull HTML.Tag tag) {
        return openTag(HTML) + openTag(tag) + text + closeTag(tag) + closeTag(HTML);
    }

    private static String openTag(@NotNull HTML.Tag tag) {
        return "<" + tag + ">";
    }

    private static String closeTag(@NotNull HTML.Tag tag) {
        return "</" + tag + "/>";
    }
}
