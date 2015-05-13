package programming.art;

public class StringShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(stringMoveStupid("abcdef", 2));
		System.out.println(stringMoveSmart("abcdef", 2));

	}
	//把前n个字母移动到后面,例如abcde变成cdeab,笨方法，暴力移动
	public static String stringMoveStupid(String s,int n){
		String string=s;
		while(n>0){
			string=leftShiftOne(string);
			n--;
		}
		return string;
	}
	
    static String leftShiftOne(String s){
    	String d="";
    	char t=s.charAt(0);
    	for(int i=1;i<s.length();i++){
    		d+=s.charAt(i);	
    	}
    	d+=t;
    	return d;
    }
    //三步反转方法,(0,n-1)反转一次 abc->cba;(n,end)反转一次 def->fed cbafed再反转一次defabc
    public static String stringMoveSmart(String s,int n){
    	String string=s;
    	string=reverseString(reverseString(s, 0, n-1)+reverseString(s, n, s.length()-1),0,s.length()-1);
    	return string;
    }
    
    
    static String reverseString(String s,int from,int to){
    	String string="";
    	while(from<=to){
    		string+=s.charAt(to);
    		to--;	
    	}
    	return string;
    }
    

}
