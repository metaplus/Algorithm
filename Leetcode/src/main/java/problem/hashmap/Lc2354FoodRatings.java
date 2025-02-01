package problem.hashmap;

import java.util.*;

public class Lc2354FoodRatings {

    class FoodRatings {

        private Map<String, Integer> foodRatings;
        private Map<String, String> foodCuisines;
        private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodRatings = new HashMap<>(foods.length);
            foodCuisines = new HashMap<>(foods.length);
            cuisineMap = new HashMap<>(32);
            for (int i = 0; i < foods.length; i++) {
                foodRatings.put(foods[i], ratings[i]);
                foodCuisines.put(foods[i], cuisines[i]);
                TreeMap<Integer, TreeSet<String>> rank = cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeMap<>(Comparator.reverseOrder()));
                rank.computeIfAbsent(ratings[i], k -> new TreeSet<>()).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            TreeMap<Integer, TreeSet<String>> rank = cuisineMap.get(foodCuisines.get(food));
            rank.get(foodRatings.get(food)).remove(food);
            foodRatings.put(food, newRating);
            rank.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
        }

        public String highestRated(String cuisine) {
            TreeMap<Integer, TreeSet<String>> rank = cuisineMap.get(cuisine);
            for (Map.Entry<Integer, TreeSet<String>> entry : rank.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    return entry.getValue().first();
                }
            }
            return null;
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
