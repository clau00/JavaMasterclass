package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapCourse {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "1 a compiled high level");
        languages.put("Python", "2 sada asdad");
        System.out.println(languages.put("Basic", "3 sada asdadsadas dsada"));
        System.out.println(languages.put("Lisp", "4 3rtg ggrg sada asdad"));
        languages.put("Algol", "5 qe qweqw esada asdarggd");

        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map.");
        }else {
            languages.put("Java", "1.1 fdsfds ge greger");
        }

        System.out.println("========================================");

        //languages.remove("Lisp");
        if(languages.remove("Algol", "000  asada dasdad")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed, key/value pair not found.");
        }

        System.out.println("========================================");
        if(languages.replace("Lisp", "This will not work", "121212 3r3432424")){
            System.out.println("Lisp replaced");
        }else{
            System.out.println("Lisp was not repleaced");
        }

        //System.out.println(languages.replace("Scala", "99999 sadsda"));
        System.out.println("========================================");

        for(String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }


    }
}
