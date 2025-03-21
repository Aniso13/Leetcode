import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>(); 
        Map<String, Integer> inDegree = new HashMap<>(); 
        
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); 
            
            for (String ingredient : ingredients.get(i)) {
                adj.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) queue.offer(supply);
        
        List<String> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            String node = queue.poll(); 
            
            if (inDegree.containsKey(node)) { 
                result.add(node);
            }
            
            if (!adj.containsKey(node)) continue; 
            
            for (String recipe : adj.get(node)) {
                inDegree.put(recipe, inDegree.get(recipe) - 1); 
                if (inDegree.get(recipe) == 0) queue.offer(recipe); 
            }
        }
        
        return result;
    }
}
