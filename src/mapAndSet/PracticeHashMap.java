package mapAndSet;

import java.util.HashMap;

public class PracticeHashMap {

    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Canada", "Ottawa");
        capitalCities.put("USA", "Washington DC");

        HashMap copy = (HashMap) capitalCities.clone();
        copy.put("India", "Delhi");
//        copy.remove("Germany");
//        copy.compute("England", (k,v) -> v + "(" + k + ")");
//        capitalCities.computeIfAbsent("Canada", (k) -> "Toronto (" + k + ")");
//        capitalCities.computeIfPresent("Norway", (k, v) -> v + "(" + k + ")");
        System.out.println(capitalCities);
        System.out.println(copy);
        System.out.println(capitalCities.containsKey("England"));
        System.out.println(capitalCities.containsValue("Ottawa"));
        System.out.println(capitalCities.entrySet());
        capitalCities.forEach((k,v) -> {
            System.out.println(k + " -> " + v);
        });
        System.out.println(copy.get("India"));
        copy.remove("England");
        System.out.println(copy.getOrDefault("England" , "Unknown"));
        System.out.println(copy);
        System.out.println(capitalCities.keySet());
        capitalCities.merge("Canada", "Ottawa", (a, b) -> a + " -> " + b);
        capitalCities.merge("England", "London", (a, b) -> a + " -> " + b);
        capitalCities.merge("Germany", "Berlin", (a, b) -> a + " -> " + b);
//        capitalCities.replaceAll((k, v) -> "The capital of " + k + " is " + v);
        System.out.println(capitalCities);
        capitalCities.putAll(copy);
        System.out.println(capitalCities);
        System.out.println(capitalCities.values());
    }
}


