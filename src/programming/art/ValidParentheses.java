package programming.art;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		boolean flag = false;
		if (s.length() % 2 == 1 || s.length() < 0) {
			return flag;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			}else{
				if(stack.empty()){
					return flag;
				}
				char s1=stack.pop();
				if((c=='}'&& s1=='{')||(c==']'&& s1=='[')||(c==')'&& s1=='(')){
					flag=true;
				}else{
					flag=false;
					break;
				}
			}
		}

		return flag;

	}
}
