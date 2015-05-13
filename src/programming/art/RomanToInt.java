package programming.art;
/**
 * Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
 * @author Administrator
 *
 */
public class RomanToInt {
	
	public static void main(String[] args){
		System.out.println(RomanToInt("CMXXII"));
		
	}
	
	public static int RomanToInt(String s){
		int result=0;
		char first='I';
		for(int i=s.length()-1;i>=0;i--){
			if(CharToInt(s.charAt(i))<CharToInt(first)){
				result=result-CharToInt(s.charAt(i));
			}else {
				result=result+CharToInt(s.charAt(i));		
			}
			first=s.charAt(i);	
		}
		return result;
		
	}
	private static int CharToInt(char c){
		switch (c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default : return 0;
		}
	}

}
