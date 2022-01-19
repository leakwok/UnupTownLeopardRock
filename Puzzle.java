import java.util.ArrayList; 

public class Puzzle{

    public int _wordCount;
    public ArrayList<String> _words;
    public ArrayList<String> _clues;
    public String[][] _outputArr;

    public Puzzle(){
    }

    public Puzzle(ArrayList<String> words, ArrayList<String> clues){
	for(String s : words){
		_words.add(s);
	}
	for(String s : clues){
		_clues.add(s);
	}
	_wordCount = _words.size();
    }

    public Puzzle(String[][] _outputArr){

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

    public void fillWords(String[] _words){

    }

    public void fillRand(){

    }

}
