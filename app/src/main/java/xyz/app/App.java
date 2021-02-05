/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xyz.app;

import xyz.list.LinkedList;

import static xyz.utilities.StringUtils.join;
import static xyz.utilities.StringUtils.split;
import static xyz.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}
