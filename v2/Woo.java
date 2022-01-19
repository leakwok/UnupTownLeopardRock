import java.io.*;
import java.util.*;

public class Woo{
    //~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private InputStreamReader isr;
    private BufferedReader in;
    public int wordCount; //number of word/clue pairs user would like to input
    public int currentMaxPairs = 1; //number of word/clue pairs our program can handle
    public String[] words;
    public String[] clues;

    //~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~
    public Woo(){
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
    	newGame();
    }
    
    //~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~
    public void newGame(){
	wordCount = 0;
	System.out.println("Welcome to... Why Did the Leopard Rock Cross the Road? : The All-in-One Crossword Generator + Player!");
	System.out.println("Let's generate your crossword puzzle!");
	System.out.println("The current maximum number of word/clue pairs we can handle is " + currentMaxPairs);
	System.out.println("How many word/clue pairs would you like to input?");
	try{
		wordCount = Integer.parseInt(in.readLine());			
	}
	catch(IOException e){
	}
	while(wordCount > currentMaxPairs || wordCount <= 0){
		System.out.println("Please input a valid number. It must be at least 1 and less than or equal to " + currentMaxPairs + ".");
		try {
			wordCount = Integer.parseInt(in.readLine());			
		}
		catch(IOException e){
		}
	}
	words = new int[wordCount];
	clues = new int[wordCount];
	collectWords();		
     }	

     public void collectWords(){
	String currentWord;
	String currentClue;
	System.out.println("Perfect! Let's get started.");
	for(int i = 1; i < wordCount+1; i++){
		System.out.println("Input word " + i + ":");
		try{
			currentWord = in.readLine();
		}
		catch(IOException e){
		}
		System.out.println("Input the clue for " + currentWord + ":");
		try{
			currentWord = 
	}
     }
    public static void main (String[] args){
	Woo game = new Woo();     	

    }
}
