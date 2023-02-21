
// Part 2. Step 8
public class WordFrequency implements Comparable<WordFrequency> {

    String word;
    Integer count;

    public WordFrequency(String word, Integer count){
        this.word = word;
        this.count = count;
    }

    public String getWord(){ return word; }

    public void setWord(String newWord){
        this.word = newWord;
    }

    public Integer getCount(){ return count; }

    public void setCount(Integer newCount){
        this.count = newCount;
    }

    @Override
    public String toString(){
        return "Wordcount [" + word + "] count: " + count;
    }

    // compare the data to be sorted.
    @Override
    public int compareTo(WordFrequency newCount){
        int compareValue = 2;
        if(this.count > newCount.count){
            compareValue = 1;
        }
        if(this.count < newCount.count){
            compareValue = -1;
        }
        if(this.count == newCount.count){
            compareValue = 0;
        }
        return compareValue;
    }
}