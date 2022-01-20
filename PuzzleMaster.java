import java.util.ArrayList;

public interface PuzzleMaster{
    public void fillWords();
    public String toString();
    public String[] setWords(String[] w);
    public void sortWords();
    public int longestWord(ArrayList<String> words);
}