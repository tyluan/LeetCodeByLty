package programming.art;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
	public static void main(String[] args){
		System.out.println(letterCombinations("23"));
		
	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits.length()==0 ||digits==null){
			return result;
		}
		if(digits.length()==1){
			result=letterChar(digits.charAt(0));
		}else{
		    List<String>firstLetter=letterChar(digits.charAt(0));
		    List<String>otherLetter=letterCombinations(digits.substring(1));
		    for(String first:firstLetter){
		    	for(String other:otherLetter){
		    		result.add(first+other);
		    	}
		    }
		}
		return result;
	}
	public static List<String>letterChar(char c){
		List<String> result = new ArrayList<String>();
		switch(c){
		case '2':
			result.add("a");
			result.add("b");
			result.add("c");
		    break;
		case '3':
			result.add("d");
			result.add("e");
			result.add("f");
			break;
		case '4':
			result.add("g");
			result.add("h");
			result.add("i");
			break;
		case '5':
			result.add("j");
			result.add("k");
			result.add("l");
			break;
		case '6':
			result.add("m");
			result.add("n");
			result.add("o");
			break;
		case '7':
			result.add("p");
			result.add("q");
			result.add("r");
			result.add("s");
			break;
		case '8':
			result.add("t");
			result.add("u");
			result.add("v");
			break;
		case '9':
			result.add("w");
			result.add("x");
			result.add("y");
			result.add("z");
			break;
		default:
			break;
		}
		return result;
	}

}
