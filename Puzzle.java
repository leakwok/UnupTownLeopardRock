import java.util.ArrayList; 

public class Puzzle implements PuzzleMaster{

    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    public int _wordCount;
    public ArrayList<String> _words;
    public ArrayList<String> _clues;
    public String[][] _outputArr;

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public Puzzle(){
        _wordCount = 0;
        _words = new ArrayList<String>();
        _clues = new ArrayList<String>();
        _outputArr = new String[1][1]; 
    }

    //~~~~~~~~~~ OVERLOADED CONSTRUCTOR ~~~~~~~~~~
    public Puzzle(ArrayList<String> words, ArrayList<String> clues){
        
        this();

        for(int i = 0; i < words.size(); i++){
            _words.add(words.get(i));
            _clues.add(clues.get(i));
        }
        _wordCount = _words.size();

        int longest = longestWord(words);

        int outputDim = _wordCount;
        if(longest > outputDim){
            outputDim = longest;
        }

        _outputArr = new String[outputDim][outputDim];
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

    public void fillWords(){

    }

    public void fillRand(){

    }

    public void sortWords(){

    }

    public void setWords(ArrayList<String> w){
	        
    }


    /* for(int i = 0; i < _words.size(); i++){
            for(int j = 0; j < _words.get(i).length; j++){
                _words.get(i).substring(j,j+1);
            }
    } */

}
