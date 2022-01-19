import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Woo{
    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private InputStreamReader _isr;
    private BufferedReader _in;
    public int _wordCount; //number of word/clue pairs user would like to input
    public int _currentMaxPairs; //number of word/clue pairs our program can handle
    public ArrayList<String> _words;
    public ArrayList<String> _clues;

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public Woo(){
	_isr = new InputStreamReader(System.in);
	_in = new BufferedReader(_isr);
	_currentMaxPairs = 1;
    	newGame();
    }
    
    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    public void newGame(){
	_wordCount = 0;
	System.out.println("Welcome to... Why Did the Leopard Rock Cross the Road? : The All-in-One Crossword Generator + Player!");
	System.out.println("Let's generate your crossword puzzle!");
	System.out.println("The current maximum number of word/clue pairs we can handle is " + _currentMaxPairs);
	System.out.println("How many word/clue pairs would you like to input?");
	try{
		_wordCount = Integer.parseInt(_in.readLine());			
	}
	catch(IOException e){
	}
	while(_wordCount > _currentMaxPairs || _wordCount <= 0){
		System.out.println("Please input a valid number. It must be at least 1 and less than or equal to " + _currentMaxPairs + ".");
		try {
			_wordCount = Integer.parseInt(_in.readLine());			
		}
		catch(IOException e){
		}
	}
	collectWords();		
     }	

     public void collectWords(){
	String currentWord = "";
	String currentClue;
	System.out.println("Perfect! Let's get started.");
	for(int i = 1; i < _wordCount+1; i++){
		System.out.println("Input word " + i + ":");
		try{
			currentWord = _in.readLine();
		}
		catch(IOException e){
		}
		System.out.println("Input the clue for " + currentWord + ":");
		try{
			currentClue = _in.readLine();
		}
		catch(IOException e){
		} 
	}
     }
    public static void main (String[] args){
/*
	Woo game = new Woo();     	
	game._words.add("hello");
	game._words.add("five");
	game._words.add("seven");
	game._clues.add("bye bye");
	game._clues.add("nice");
	game._clues.add("twenty");
*/
	ArrayList<String> testW = new ArrayList<String>();
	testW.add("hello");
	testW.add("five");
	testW.add("seven");
	ArrayList<String> testC = new ArrayList<String>();
	testC.add("bye bye");
	testC.add("nice");
	testC.add("twenty");
	Puzzle cross = new Puzzle(testW, testC);
	System.out.println(cross);
    }
}
