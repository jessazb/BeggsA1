import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("res/words.txt"); //Step 4
        HashMap<String, Integer> wordCounter = buildHashMap(words); //Step 5
        createHTMLfile(wordCounter);

        // Step 9. Based on the sample code given in Lab 6,
        // add code to the App class to create an ArrayList of WordFrequency
        // objects.Populate the ArrayList with the data stored
        // in the HashMap created in Step 5.

        // Converts the hashmap back into an array
        ArrayList<WordFrequency> WordList = new ArrayList<>();
        for (String key: wordCounter.keySet())
        {
            WordFrequency countWord = new WordFrequency(key, wordCounter.get(key));
            WordList.add(countWord);
        }
        Collections.sort(WordList);

        //Calls the function createSortedfile
        createSortedfile(WordList);
        System.out.println(WordList);
    }

    //Step 4 - Read Input File
    // Uses FileReader to read from the file and transfers them to wordList, as a new arrayList.
    private static ArrayList<String> readWords(String fileName){
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null) {

                String[] words = line.split("[ .,]+");
                for(String word: words)
                {
                    if(word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase());
                    }
                }
                line = bufferedReader.readLine();
                
            }
            bufferedReader.close();
        // catch blocks to catch errors during a try
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;
    }
        // Step 5: Count Word Occurances
        // Counts every time a word occurs and totals them into wordCounter.
        private static HashMap<String, Integer> buildHashMap(ArrayList<String> words) {
            HashMap<String, Integer> wordCounter = new HashMap<>();
            for(String word: words){
                Integer count = wordCounter.get(word);
                if(count == null)
                {
                    wordCounter.put(word, 1);
                }
                else
                {
                    wordCounter.put(word, count +1);
                }
            }
            return wordCounter;
        }

    //Step 6: Create Output HTML file
    // Countains the code to structure our html file, and inputs the data accordingly.
    private static void createHTMLfile(HashMap<String, Integer> wordCounter) {
        File file = new File("res/words.html");

        try {
            FileWriter FileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table border = 1>");
            for(String key: wordCounter.keySet()){
                builder.append("<tr>");
                builder.append("<td>" + key + "</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Prints out the table to console
        for(String keyWord: wordCounter.keySet()){
            System.out.println(keyWord + ": " + wordCounter.get(keyWord));
        }
    
    }

        // step 10 - creating the html file using a for loop to input data
        private static void createSortedfile(ArrayList<WordFrequency> wordCounter) {
            File file = new File("res/sorted.html");
    
            try {
                FileWriter FileWriter = new FileWriter(file);
                StringBuilder builder = new StringBuilder();
                builder.append("<h1>Word Count</h1>");
    
                builder.append("<table border = 1>");
                for(WordFrequency key: wordCounter){
                    builder.append("<tr>");
                    builder.append("<td>" + key.getWord() + "</td>");
                    builder.append("<td>" + key.getCount() + "</td>");
                    builder.append("</tr>");
                }
                builder.append("</table>");
                FileWriter.append(builder.toString());
                FileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

