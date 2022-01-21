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
        for(int i = 0; i < _outputArr.length; i++){
            for(int j = 0; j < _outputArr[i].length; j++){
                _outputArr[i][j] = " ";
            }
        } 
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

        for(int i = 0; i < _outputArr.length; i++){
            for(int j = 0; j < _outputArr[i].length; j++){
                _outputArr[i][j] = " ";
            }
        } 
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
        for(String s : _words){
            boolean validPos = false;
            while(validPos == false){
                //pick random orientation from 0-3
                int orientation = 0;
                //(int) (Math.random()*4);

                int xcor = 0;
                int ycor = 0;

                // orientation: --------> 
                if(orientation == 0){
                    xcor = (int) (Math.random()*(_outputArr[0].length - s.length() + 1));
                    ycor = (int) (Math.random()*_outputArr.length);
                    for(int i = xcor; i < xcor + s.length(); i++){
                        if(!(_outputArr[i][ycor].equals(" "))){
                            if(_outputArr[i][ycor].equals(s.substring(xcor-i, xcor-i+1).toUpperCase())){
                                validPos = true;
                            }
                        }
                    }
                    if(validPos == true){
                        for(int i = xcor; i < xcor + s.length(); i++){
                            _outputArr[i][ycor] = (s.substring(xcor-i, xcor-i+1)).toUpperCase();
                        }
                    }
                }
            } 
        }
        

    }

    public void fillRand(){

    }
    public void sortWords(){
	//sort using algorithm

    }

}
