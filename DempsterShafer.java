import java.util.HashMap;
import java.util.Map;

public class DempsterShafer {

    // Combines two belief functions using Dempster's rule of combination
    public static Map<String, Double> combineBeliefs(Map<String, Double> belief1, Map<String, Double> belief2) {
        Map<String, Double> combinedBelief = new HashMap<>();
        for (Map.Entry<String, Double> entry1 : belief1.entrySet()) {
            for (Map.Entry<String, Double> entry2 : belief2.entrySet()) {
                String key = entry1.getKey() + entry2.getKey();
                double value = entry1.getValue() * entry2.getValue();
                if (combinedBelief.containsKey(key)) {
                    combinedBelief.put(key, combinedBelief.get(key) + value);
                } else {
                    combinedBelief.put(key, value);
                }
            }
        }
        return combinedBelief;
    }

    // Normalizes the belief function
    public static Map<String, Double> normalizeBelief(Map<String, Double> belief) {
        double sum = belief.values().stream().mapToDouble(Double::doubleValue).sum();
        Map<String, Double> normalizedBelief = new HashMap<>();
        for (Map.Entry<String, Double> entry : belief.entrySet()) {
            normalizedBelief.put(entry.getKey(), entry.getValue() / sum);
        }
        return normalizedBelief;
    }

    // Make decision based on the fused belief
    public static void makeDecision(Map<String, Double> fusedBelief) {
        double maxBelief = 0;
        String decision = "";
        for (Map.Entry<String, Double> entry : fusedBelief.entrySet()) {
            if (entry.getValue() > maxBelief) {
                maxBelief = entry.getValue();
                decision = entry.getKey();
            }
        }
        System.out.println("Decision: " + decision);
    }

    public static void main(String[] args) {
        // Example beliefs
        Map<String, Double> belief1 = new HashMap<>();
        belief1.put("A", 0.2);
        belief1.put("B", 0.3);
        belief1.put("C", 0.5);

        Map<String, Double> belief2 = new HashMap<>();
        belief2.put("A", 0.4);
        belief2.put("B", 0.2);
        belief2.put("C", 0.4);

        // Combine beliefs using Dempster's rule of combination
        Map<String, Double> fusedBelief = combineBeliefs(belief1, belief2);

        // Normalize the fused belief
        fusedBelief = normalizeBelief(fusedBelief);

        // Make decision based on the fused belief
        makeDecision(fusedBelief);
    }
}
