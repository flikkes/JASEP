import java.util.*;
class JASEP {
	private ArrayList<String> alphabet = new ArrayList<String>(); //our alphabet
	private ArrayList<String> undefinedSymbolLog = new ArrayList<String>(); //currently unused... maybe you'll develop some ideas :)
	private String[] collection = {"beg", "a", "begin", "b", "c", "d"}; //All of your symbols go here as shown
	private String message = "undefined: "; //Message to be shown if error
	
	public JASEP(String[] args) { //Simple constructor method where the alphabet is set
		orderCollection();
		for (int i = 0; i < this.collection.length; i++) {
			this.alphabet.add(this.collection[i]);
		}
		if (parsingSuccessful(args[0])) {
			System.out.println("No errors found");
		} else {
			System.out.println(message); //Whatever error is printed out here (can be changed without worries)
		}
	}
	
	public JASEP(String[] args, String[] collection) { //Advanced constructor where alphabet (collection of string values) can be added
		this.collection = collection;
		orderCollection();
		for (int i = 0; i < this.collection.length; i++) {
			this.alphabet.add(this.collection[i]);
		}
		if (parsingSuccessful(args[0])) {
			System.out.println("No errors found");
		} else {
			System.out.println(message); 
		}
	}
	
	public static void main(String[] args) {
		String[] testCollection = {"a", "lol", "v", "bc"}; //
		new JASEP(args, testCollection);
	}
	
	boolean parsingSuccessful(String arg0) { //Heart of the Parser, only edit if you know what you're doing!
		for (int i = 0; i < this.alphabet.size(); i++) {
			if (arg0.contains(this.alphabet.get(i))) {
				arg0 = arg0.replaceAll(this.alphabet.get(i), "");
			}
			if (arg0.length() == 0) return true;
		}
		if (arg0.length() > 0) {
			for (int i = 0; i < arg0.length(); i++) {
				message = message+arg0.substring(i, i+1)+" "; //Here you can influence the way undefined symbols are listed
			}		
		}
		return false;
	}
	
	void orderCollection() { //prepares the symbol collection for the parsing process as the parser needs symbols to be ordered their by length, descending
		String longestElement = null;
		String switchBuffer = "";
		for (int i = 0; i < this.collection.length; i++) {
			longestElement = this.collection[i];
			for (int j = i; j < this.collection.length; j++) {
				if (longestElement.length() < this.collection[j].length()) {
					switchBuffer = longestElement;
					longestElement = this.collection[j];
					this.collection[j] = switchBuffer;
					this.collection[i] = longestElement;
				}
			}
		}
	}
}
