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

        _outputArr = new String[2*outputDim][2*outputDim];
    }

    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    //returns length of longest word in a String ArrayList
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

    //fills _words with elements of String ArrayList argument, updates _wordCount accordingly
    public void setWords(ArrayList<String> w){
        _words = new ArrayList<String>();
	for(int i = 0; i < w.size(); i++){
		_words.add(w.get(i));
	}
	_wordCount = w.size();
    }

    public void fillWords(){
    	

    }
    public void fillRand(){

    }
    public void sortWords(){
	//sort using algorithm
    }

}
