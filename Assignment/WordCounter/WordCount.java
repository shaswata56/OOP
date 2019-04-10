import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    private static int counter = 0;
    static int WordCount(Map<String, Integer> words) throws FileNotFoundException {
        Scanner file = new Scanner(new File("input.txt"));
        while (file.hasNext()) {
            String word = file.next();
            Integer count = words.get(word);
            count = (count != null) ? count + 1 : 1;
            words.put(word, count);
            counter++;
        }
        return counter;
    }
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream print= new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt")), true);
        Map <String, Integer> words = new HashMap<>();
        int count = WordCount(words);
        Map<String, Integer> sortedMap = words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        print.println("Number of Words :"+ count);
        for(String key: sortedMap.keySet())
            print.println(key +"\t\t\t"+ sortedMap.get(key));
    }
}
