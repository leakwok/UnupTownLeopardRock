import java.util.ArrayList;

public class WSearch implements PuzzleMaster{
    
    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    public int _wordCount;
    public ArrayList<String> _words;
    public String[][] _outputArr;

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public WSearch(){
        _wordCount = 0;
        _words = new ArrayList<String>();
        _outputArr = new String[1][1]; 
    }

    //~~~~~~~~~~ OVERLOADED CONSTRUCTOR ~~~~~~~~~~
    public WSearch(ArrayList<String> words){
        this();

        for(int i = 0; i < words.size(); i++){
            _words.add(words.get(i));
        }
        _wordCount = _words.size();

        int longest = longestWord(words);

        int outputDim = _wordCount;
        if(longest > outputDim){
            outputDim = longest;
        }

        _outputArr = new String[outputDim][outputDim];
    }

    public WSearch(String[][] outputArr){

    }

    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    public int longestWord(ArrayList<String> words){
        int tracker = 0;
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).length() > tracker){
                tracker = words.get(i).length();
            }   
        }
        return tracker;
    }
    
    public String toString(){
        String s = "";
        for(String[] a : _outputArr){
            for(String g : a){
                s += g + " ";
            }
            s += "\n";
        }
        return s;
    }

    public String[] setWords(String[] w){
        return new String[1];
    }

    public void fillWords(){

    }
    public void fillRand(){

    }
    public void sortWords(){

    }

}