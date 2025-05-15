import java.util.*;
public class WordFreq {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        Map<String, Integer> wordFrequencies = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (!cleanWord.isEmpty()) {
                wordFrequencies.put(cleanWord, wordFrequencies.getOrDefault(cleanWord, 0) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencies.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue()); // Descending order
            }
        });
        System.out.println("Word frequencies (sorted):");
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}