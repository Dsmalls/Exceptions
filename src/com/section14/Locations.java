package com.section14;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    // Filewriter, writing the data out to a file, pass a filename to the constructor
    // uses the write method to write data to  the file
    // file is closed once the data is written
    public static void main(String[] args) {
        FileWriter locFile = null;
        try{
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values()){
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n"); // end of line count
            }

        } catch (IOException e){
            System.out.println("In catch block to handle the Exception");
            e.printStackTrace();
        } finally {
            System.out.println("in the finally block"); // proper way to close an exception
            try{
                if (locFile != null){
                    System.out.println("Testing the finally/ closing method on the locfile");
                    locFile.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // only one copy of static data, will only execute once....static block below
    static {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "I'm sitting on my computer learning java", null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "I am standing at the end of the road in front of the gym", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "Im and the top of the hill", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "I am outside the the gym, near the small spring", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "Im on the street near the main highway", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "Im somewhere near something", tempExit));
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
