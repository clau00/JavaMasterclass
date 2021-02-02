package InputOutput.IO;

import java.io.*;
import java.util.*;

public class Locations  implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException{
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")){
            System.out.println("Writing to file...");
            for (Location location : locations.values()){
                System.out.println("...");
                locFile.write(location.getLocationID() + ", " + location.getDescription() + " \n");
                for(String direction : location.getExits().keySet()){
                    System.out.println("...");
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
            System.out.println("Writing completed!");
        }

//        FileWriter locFile = null;
//        try{
//            locFile = new   FileWriter("locations.txt");
//            for (Location location : locations.values()){
//                locFile.write(location.getLocationID() + ", " + location.getDescription() + " \n");
//            }
//        } finally {
//            System.out.println("In finally block");
//            if (locFile != null) {
//                System.out.println("Attempting to close file");
//                locFile.close();
//            }
//        }
    }

    static {
        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the exits from file
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println("Imported exit: " + loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Map<String, Integer> tempExits = new HashMap<>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//        tempExits.put("W", 2);
//        tempExits.put("E", 3);
//        tempExits.put("N", 5);
//        tempExits.put("S", 4);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("N", 5);
//        locations.put(2, new Location(2, "You are at a top of a hill", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 2);
//        tempExits.put("N", 1);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 2);
//        tempExits.put("S", 1);
//        locations.put(5, new Location(5, "You are in the forest", tempExits));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
