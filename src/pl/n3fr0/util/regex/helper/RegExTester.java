package pl.n3fr0.util.regex.helper;


import java.util.regex.Matcher;

public class RegExTester {
    public String testExpression(Matcher matcher) {
        String result = "";

        result += "Matches: " + matcher.matches() + "\n";
        while (matcher.find()) {
            String group = matcher.group();

            result += String.format("Group[text: %s, pos: %d-%d]\n", group, matcher.start(), matcher.end());
        }
        return result;
    }
}
