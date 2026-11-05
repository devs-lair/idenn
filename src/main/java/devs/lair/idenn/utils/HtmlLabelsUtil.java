package devs.lair.idenn.utils;

import devs.lair.idenn.ui.IdeColors;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.HTML;
import java.awt.*;

import static javax.swing.text.html.HTML.Tag.*;

//TODO : need builder flow pattern
public class HtmlLabelsUtil {

    public static String html(@NotNull String text) {
        return openTag(HTML) + text + closeTag(HTML);
    }

    public static String bold(@NotNull String text) {
        return crateOneTagWrapper(text, B);
    }

    public static String colorSpan(@NotNull String text, @NotNull Color color) {
        return openTag(SPAN, "color='" + IdeColors.getHexColor(color) + "'") + text + closeTag(SPAN);
    }

    private static String crateOneTagWrapper(@NotNull String text, @NotNull HTML.Tag tag) {
        return openTag(HTML) + openTag(tag) + text + closeTag(tag) + closeTag(HTML);
    }

    private static String crateOneTagWrapper(@NotNull String text, @NotNull HTML.Tag tag, @NotNull String attr) {
        return openTag(HTML) + openTag(tag, attr) + text + closeTag(tag) + closeTag(HTML);
    }

    private static String openTag(@NotNull HTML.Tag tag) {
        return "<" + tag + ">";
    }

    private static String openTag(@NotNull HTML.Tag tag, @NotNull String attr) {
        return "<" + tag + " " + attr + ">";
    }

    private static String closeTag(@NotNull HTML.Tag tag) {
        return "</" + tag + "/>";
    }
}
