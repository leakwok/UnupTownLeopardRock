import java.io.*;
import java.util.ArrayList;

public class Woo{
    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private InputStreamReader _isr;
    private BufferedReader _in;
    private int _wordCount; //number of word/clue pairs user would like to input
    private int _currentMaxPairs; //number of word/clue pairs our program can handle
    private ArrayList<String> _words;
    private ArrayList<String> _clues;
	private int _puzzlePick;

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public Woo(){
	_isr = new InputStreamReader(System.in);
	_in = new BufferedReader(_isr);
	_currentMaxPairs = 10;
	_words = new ArrayList<String>();
	_clues = new ArrayList<String>();
	_puzzlePick =0;
    	newGame();
    }
    
    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    public void newGame(){
	_wordCount = 0;
	System.out.println("Welcome to... Why Did the Leopard Rock Cross the Road? : The All-in-One Crossword and Word Search Generator!");
	System.out.println("Let's generate your puzzle!");
	System.out.println("What kind of puzzle would you like to make? Input 1 for crossword and 2 for word search. [Our favorite is the word search ;)]");
	try{
		_puzzlePick = Integer.parseInt(_in.readLine());
		while(_puzzlePick != 1 && _puzzlePick != 2){
			System.out.println("Please input 1 for crossword and 2 for word search.");
			try{
				_puzzlePick = Integer.parseInt(_in.readLine());
			}
			catch(IOException e){
			}
		}
		
	}
	catch(IOException e){
	}

	if(_puzzlePick == 1){
		System.out.println("\nYou have picked the crossword.");
		System.out.println("The maximum number of word/clue pairs we recommended for best display is " + _currentMaxPairs + ". However, you may go above it. Do not go above 52.");
		System.out.println("How many word/clue pairs would you like to input?");
		try{
			_wordCount = Integer.parseInt(_in.readLine());			
		}
		catch(IOException e){
		}
		while(_wordCount > 53 || _wordCount <= 0){
			System.out.println("Please input a valid number. It must be at least 1 and less than 53.");
			try {
				_wordCount = Integer.parseInt(_in.readLine());			
			}
			catch(IOException e){
			}
		}
		collectWordsC();	
	}
	else{
		System.out.println("\nYou have picked the word search. Keep in mind our word search only goes horizontally and vertically, but not diagonally. Words can be reversed as well.");
		System.out.println("The maximum number of words we recommended for best display is " + _currentMaxPairs + ". However, you may go above it.");
		System.out.println("How many words would you like to input? Please do not include spaces with the words.");
		try{
			_wordCount = Integer.parseInt(_in.readLine());			
		}
		catch(IOException e){
		}
		while(_wordCount <= 0){
			System.out.println("Please input a valid number. It must be at least 1.");
			try {
				_wordCount = Integer.parseInt(_in.readLine());			
			}
			catch(IOException e){
			}
		}
		collectWordsW();
	}
    
	}	

    public void collectWordsC(){
		String currentWord = "";
		String currentClue = "";
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
			_words.add(currentWord);
			_clues.add(currentClue);
		}
     }

	 public void collectWordsW(){
		String currentWord = "";
		System.out.println("Perfect! Let's get started.");
		for(int i = 1; i < _wordCount+1; i++){
			System.out.println("Input word " + i + ":");
			try{
				currentWord = _in.readLine();
			}
			catch(IOException e){
			}
			while(currentWord.indexOf(" ") >= 0){
				System.out.println("Please input the word again without spaces.");
				try{
					currentWord = _in.readLine();
				}
				catch(IOException e){
				}
			}
			_words.add(currentWord);
		}
     }
    public static void main (String[] args){
		Woo game = new Woo();     	

		/* game._words.add("hello");
		game._words.add("five");
		game._words.add("seven");
		game._words.add("watermelon");
		game._words.add("reading"); */
		/* game._clues.add("bye bye");
		game._clues.add("nice");
		game._clues.add("twenty"); */

		ArrayList<String> testW = new ArrayList<String>();
		ArrayList<String> testC = new ArrayList<String>();
		/*
		testW.add("hello");
		testW.add("five");
		testW.add("seven");
		testC.add("bye bye");
		testC.add("nice");
		testC.add("twenty");
	*/
		/* System.out.println(testW);
		System.out.println(testC); */
	/*
		
	*/
		if(game._puzzlePick == 1){
			Puzzle cross = new Puzzle(game._words, game._clues);
			cross.fillWords();
			System.out.println("\nYou have gone un and uptown to search for the perfect puzzle. Presenting....");
			System.out.println(cross);
		}
		else{
			WSearch wordSearch = new WSearch(game._words);
			wordSearch.fillWords();
			wordSearch.fillRand();
			System.out.println("\nYou have gone un and uptown to search for the perfect puzzle. The words you are looking for will be displayed on the right. \nPresenting....\n");
			System.out.println(wordSearch);

		}

    } //end main method
}
