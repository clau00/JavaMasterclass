package Collections.Set.Operations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for( int i=1; i <= 100; i++){
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("\nThere are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("\nUnion contains " + union.size() + " elements.\n");

//      ========================================================

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("\nIntersection contains " + intersection.size() + " elements.");
        System.out.println("------------------------------------------");
        for(int i: intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }
        System.out.println();

//      =======================================================

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        System.out.println();
        for(String word : words){
            System.out.println(word);
        }

//      =======================================================

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", " thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("\n nature: ");
        printSet(nature);
        System.out.println("divine: ");
        printSet(divine);
        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);
        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

//      =======================================================

        Set<String> unionNatureDivine = new HashSet<>(nature);
        unionNatureDivine.addAll(divine);
        Set<String> intersectionNatureDivine = new HashSet<>(nature);
        intersectionNatureDivine.retainAll(divine);
        System.out.println("Symmetric difference:");
        unionNatureDivine.removeAll(intersectionNatureDivine);
        printSet(unionNatureDivine);

//      =======================================================

        System.out.println();
        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }else{
            System.out.println("divine is NOT a subset of nature");
        }
        if(nature.containsAll(intersectionNatureDivine)){
            System.out.println("intersection is a subset of nature");
        }else{
            System.out.println("intersection is NOT a subset of nature");
        }
        if(divine.containsAll(intersectionNatureDivine)){
            System.out.println("intersection is a subset of divine");
        }else{
            System.out.println("intersection is NOT a subset of divine");
        }
    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for(String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
