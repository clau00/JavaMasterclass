package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapCourse {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else{
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else{
            languages.put("Java", "this course is about Java");
        }
        System.out.println(languages.get("Java"));

        printMap(languages);

//        languages.remove("Lisp");
        if(languages.remove("Algol", "a family of algorithmic languages")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed, key:value pair not found");
        }
        printMap(languages);

        if(languages.remove("Algol", "an algorithmic language")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed, key:value pair not found");
        }
        printMap(languages);

        System.out.println(languages.replace("Lisp", "a functional programming language with imperative features"));
        // make sure you update the right information (like the right person's name after he got married)
        if(languages.replace("Lisp", "This will not work", "a functional programming language with imperative features")){
            System.out.println("Lisp replaced");
        }else{
            System.out.println("Lisp was not replaced");
        }

        System.out.println(languages.replace("Scala", "this will not be added"));
        printMap(languages);
    }

    private static void printMap(Map<String, String> map){
        System.out.println("\n ================================================== ");
        for(String key: map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println(" ================================================== \n");
    }
}
