package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //  =========== Introduction, Character Classes and Boundary Matchers ===========

        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondAlphanumeric = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondAlphanumeric.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^heloo"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("jkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "<< I replaced a letter here >>"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(alphanumeric.replaceAll("\\d", "X"));
        System.out.println(alphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\t", ""));
        System.out.println(hasWhiteSpace.replaceAll("\\S", "_"));
        System.out.println(alphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b", "_"));

        //  =========== Quantifiers - specify how often an element occurs in a RegExp ===========

        String newAlphanumeric = "abcDeeeF12GhhiiijabcDeeeijkl99z";
        System.out.println(newAlphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("abcDeee", "YYY"));
        //  1 or more "e"
        System.out.println(newAlphanumeric.replaceAll("^abcDe+", "YYY"));
        //  0 or more "e"
        System.out.println(newAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("h+i*j", "_Y_"));

        //  =========== Pattern amd Matcher Classes ===========

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        while(groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(/h2)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while(h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        //  =========== AND, OR, NOT ===========

        // "abc" means "a" and "b" and "c"
        // [Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc]
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String usTelephoneTegExp = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[-]{1}[0-9]{4})$";
        String phone1 = "12345677890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)  456-7890";

        System.out.println("phone1 = " + phone1.matches(usTelephoneTegExp));
        System.out.println("phone2 = " + phone2.matches(usTelephoneTegExp));
        System.out.println("phone3 = " + phone3.matches(usTelephoneTegExp));
        System.out.println("phone4 = " + phone4.matches(usTelephoneTegExp));
    }
}

