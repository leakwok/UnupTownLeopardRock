import java.util.ArrayList;

public class WSearch implements PuzzleMaster{
    
    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private int _wordCount;
    private ArrayList<String> _words;
    public String[][] _outputArrAnswer;
    private String[][] _outputArr;
    private static final int GREEN = 32;
    private static final int YELLOW = 33;
    private static final int RED = 31;
    private static final int BLUE = 34;
    private static final int ITALICS = 3;
    private static final String RESET = color(40,37);

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
        
        _outputArrAnswer = new String[2*outputDim][2*outputDim];
    }

    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    //use this to convert from color to background (30 to 37 becomes 40 to 47)
    public static int background(int color)
    {
        return color + 10;
    }

    private static String color(int a, int b)
    {
        return ("\033[0;" + a+ ";" + b + "m");
    }
    private static String color(int a, int b, int c)
    {
        return ("\033[0;" + a+ ";" + b + ";" + c+ "m");
    }
    private static String color(int a, int b, int c, int d)
    {
        return ("\033[0;" + a+ ";" + b + ";" + c + ";" + d + "m");
    }
    
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
        int wordNum = 0;
        
        s += RESET + "HERE IS THE ANSWER\n\n";

        for(String[] a : _outputArrAnswer){
            for(String g : a){
                s += g + " ";
            }

            s += "\n";

        }

        for(int i = 0; i < _outputArr.length; i++){
            s += color(ITALICS,RED,background(YELLOW)) + "\nWarning: ANSWERS ABOVE!!!";
        }

        s += "\n" + RESET + "\nPUZZLE HERE\n\n";

        for(String[] a : _outputArr){
            for(String g : a){
                s += g + " ";
            }
            if(wordNum/2 < _words.size() && wordNum % 2 == 0){
                s += "\t" + "\t" + _words.get(wordNum/2).toUpperCase();
                
            }
            wordNum++;

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
                int orientation = (int) (Math.random()*4);

                int xcor = 0;
                int ycor = 0;

                // orientation: --------> 
                if(orientation == 0){
                    xcor = (int) (Math.random()*(_outputArr[0].length - s.length() + 1));
                    ycor = (int) (Math.random()*_outputArr.length);
                    //System.out.println(xcor);
                    //System.out.println(ycor);
                    
                    boolean allEmpty = true;
                    int problem = 0;

                    for(int i = xcor; i < xcor + s.length(); i++){
                        if(!(_outputArr[ycor][i].equals(" "))){
                            if(!(_outputArr[ycor][i].equals(s.substring(i-xcor, i-xcor+1).toUpperCase()))){
                                problem += 1;
                            }
                        	allEmpty = false;
                        }
                        
                    }

                    if(allEmpty == true){
                        validPos = true;
                    }
                    if(problem == 0){
                        validPos = true;
                    }
                    
                    if(validPos == true){
                        for(int i = 0; i < s.length(); i++){
                            _outputArr[ycor][xcor+i] = (s.substring(i, i+1)).toUpperCase();
                            _outputArrAnswer[ycor][xcor+i] = color(GREEN,background(BLUE)) + (s.substring(i, i+1)).toUpperCase();
                        }
                    }
                }
                
                // orientation: <-------- 
                if(orientation == 1){
                    xcor = (int) (Math.random()*(_outputArr[0].length - s.length() + 1));
                    ycor = (int) (Math.random()*_outputArr.length);
                    //System.out.println(xcor);
                    //System.out.println(ycor);
                    
                    boolean allEmpty = true;
                    int problem = 0;
                    
                    for(int i = xcor; i < xcor + s.length(); i++){
                        if(!(_outputArr[ycor][i].equals(" "))){
                            if(!(_outputArr[ycor][i].equals(s.substring(s.length()+xcor-i-1, s.length()+xcor-i).toUpperCase()))){
                                problem += 1;
                            }
                        	allEmpty = false;
                        }
                    }

                    if(allEmpty == true){
                        validPos = true;
                    }
                    if(problem == 0){
                        validPos = true;
                    }
                    
                    if(validPos == true){
                        for(int i = xcor; i < xcor + s.length(); i++){
                            _outputArr[ycor][i] = (s.substring(s.length()+xcor-i-1, s.length()+xcor-i)).toUpperCase();
                            _outputArrAnswer[ycor][i] = color(GREEN,background(BLUE)) + (s.substring(s.length()+xcor-i-1, s.length()+xcor-i)).toUpperCase();
                        }
                    }
                }

                /* orientation: |
                                |
                                |
                                v  */
                if(orientation == 2){
                    ycor = (int) (Math.random()*(_outputArr.length - s.length() + 1));
                    xcor = (int) (Math.random()*_outputArr[0].length);
                    //System.out.println(xcor);
                    //System.out.println(ycor);
                    
                    boolean allEmpty = true;
                    int problem = 0;

                    for(int i = ycor; i < ycor + s.length(); i++){
                        if(!(_outputArr[i][xcor].equals(" "))){
                            if(!(_outputArr[i][xcor].equals(s.substring(i-ycor, i-ycor+1).toUpperCase()))){
                                problem += 1;
                            }
                        	allEmpty = false;
                        }
                    }

                    if(allEmpty == true){
                        validPos = true;
                    }
                    if(problem == 0){
                        validPos = true;
                    }
                    
                    if(validPos == true){
                        for(int i = 0; i < s.length(); i++){
                            _outputArr[ycor+i][xcor] = (s.substring(i, i+1)).toUpperCase();
                            _outputArrAnswer[ycor+i][xcor] = color(GREEN,background(BLUE)) + (s.substring(i, i+1)).toUpperCase();
                        }
                    }
                }   

                /* orientation: ^
                                |
                                |
                                |  */
                if(orientation == 3){
                    ycor = (int) (Math.random()*(_outputArr.length - s.length() + 1));
                    xcor = (int) (Math.random()*_outputArr[0].length);
                    //System.out.println(xcor);
                    //System.out.println(ycor);
                    
                    boolean allEmpty = true;
                    int problem = 0;
                    
                    for(int i = ycor; i < ycor + s.length(); i++){
                        if(!(_outputArr[i][xcor].equals(" "))){
                            if(!(_outputArr[i][xcor].equals(s.substring(s.length()+ycor-i-1, s.length()+ycor-i).toUpperCase()))){
                                problem += 1;
                            }
                        	allEmpty = false;
                        }
                    }

                    if(allEmpty == true){
                        validPos = true;
                    }
                    if(problem == 0){
                        validPos = true;
                    }
                    
                    if(validPos == true){
                        for(int i = ycor; i < ycor + s.length(); i++){
                            _outputArr[i][xcor] = (s.substring(s.length()+ycor-i-1, s.length()+ycor-i)).toUpperCase();
                            _outputArrAnswer[i][xcor] = color(GREEN,background(BLUE)) + (s.substring(s.length()+ycor-i-1, s.length()+ycor-i)).toUpperCase();
                        }
                    }
                }   

            } 
        }  

    }

    public void fillRand(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int randomNum = 0;
        for(int i = 0; i < _outputArr.length; i++){
            for(int j = 0; j < _outputArr[0].length; j++){
                if(_outputArr[i][j].equals(" ")){
                    randomNum = (int) (Math.random()*26);
                    _outputArr[i][j] = alphabet.substring(randomNum, randomNum + 1);
                    _outputArrAnswer[i][j] = RESET + alphabet.substring(randomNum, randomNum + 1);
                }
            }
        }
    }


    public void sortWords(){
	//sort using algorithm

    }

}
