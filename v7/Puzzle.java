import java.util.ArrayList; 

public class Puzzle implements PuzzleMaster{

    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private ArrayList<String> _clues;
    private int _wordCount;
    private ArrayList<String> _words;
    public String[][] _outputArrAnswer;
    private String[][] _outputArr;
    private ArrayList<String> _correspondence;
    private static String _alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int GREEN = 32;
    private static final int YELLOW = 33;
    private static final int RED = 31;
    private static final int BLUE = 34;
    private static final int ITALICS = 3;
    private static final String RESET = color(40,37);

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public Puzzle(){
        _wordCount = 0;
        _words = new ArrayList<String>();
        _clues = new ArrayList<String>();
        _correspondence = new ArrayList<String>();
        _outputArr = new String[1][1]; 
        _outputArrAnswer = new String[1][1]; 
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

        _outputArr = new String[2*outputDim][2*outputDim];

        for(int i = 0; i < _outputArr.length; i++){
            for(int j = 0; j < _outputArr[i].length; j++){
                _outputArr[i][j] = " ";
            }
        }
        
        _outputArrAnswer = new String[2*outputDim][2*outputDim];

        for(int i = 0; i < _outputArrAnswer.length; i++){
            for(int j = 0; j < _outputArrAnswer[i].length; j++){
                _outputArrAnswer[i][j] = " ";
            }
        }
    }

    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
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
        
        s += RESET + "\nHERE IS THE ANSWER\n\n";

        int arrayLine = 0;
        

        for(String[] a : _outputArrAnswer){
            for(String g : a){
                s += g + " ";
            }
            s += "\t\t" + arrayLine;

            s += "\n";

            arrayLine++;
        }

        for(int i = 0; i < _outputArrAnswer.length; i++){
            s += _alphabet.substring(i, i + 1) + " ";
        }

        s += "\n";

        for(int i = 0; i < _outputArr.length; i++){
            s += color(ITALICS,RED,background(YELLOW)) + "\nWarning: ANSWERS ABOVE!!!";
        }

        s += "\n" + RESET + "\nPUZZLE HERE\n\n";

        arrayLine = 0;
        
        for(String[] a : _outputArr){
            for(String g : a){
                s += g + " ";
            }
            s += "\t\t" + arrayLine;

            if(wordNum/2 < _words.size() && wordNum % 2 == 0){
                s += "\t" + "\t" + _correspondence.get(wordNum/2);
                
            }
            wordNum++;

            s += "\n";

            arrayLine++;
        }

        for(int i = 0; i < _outputArr.length; i++){
            s += _alphabet.substring(i, i + 1) + " ";
        }

        return s;
    }

    public void fillWords(){ 
        int k = 0;
        for(String s : _words){
            boolean validPos = false;
            while(validPos == false){
                //pick random orientation from 0-1
                int orientation = (int) (Math.random()*2);

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
                            _outputArr[ycor][xcor+i] = "*";
                            _outputArrAnswer[ycor][xcor+i] = (s.substring(i, i+1)).toUpperCase();
                        }
                        _correspondence.add(_alphabet.substring(xcor, xcor+1) + ycor + " across: " + _clues.get(k));
                        k++;
                    }
                }

                /* orientation: |
                                |
                                |
                                v  */
                if(orientation == 1){
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
                            _outputArr[ycor+i][xcor] = "*";
                            _outputArrAnswer[ycor+i][xcor] = (s.substring(i, i+1)).toUpperCase();
                        }
                        _correspondence.add(_alphabet.substring(xcor, xcor+1) + ycor + " down: " + _clues.get(k));
                        k++;
                    }
                }   

            } 

        }  

    }

}
