import java.util.Scanner;


public class Postfix {

	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
				
		StringBuffer postfixSB = new StringBuffer();
		
		boolean cont;
		
		double result;
		
		
		
		do{
			
			System.out.print("Enter infix expression: ");
			
			String inf = input.nextLine();
			
			StringBuffer infixSB = new StringBuffer(inf);
			
			try{
				postfixSB = infixToPostfix(infixSB);
				
				cont = false;
				
			}
			catch( InvalidCharacterException ICE){
			
				System.out.println(ICE);
				
				cont = true;
			
			}
		
		}while(cont);
		
		System.out.print("The postfix expression is: " + postfixSB.toString() + "\n");
		
		result = evaluatePost(postfixSB);
		
		System.out.println("The expression evaluates to: " + result);
		
		
	
		
		
		
		
	}
	
	

	public static  StringBuffer infixToPostfix(StringBuffer infix) throws InvalidCharacterException{
		
		Stack <Character> stackIF = new Stack<Character>("infix");
		
		StringBuffer postSB = new StringBuffer();
		
		stackIF.push('(');
		
		infix.append(')');
		
		for(int x = 0; x < infix.length(); x++){
			if(Character.isDigit(infix.charAt(x))){
				
				postSB.append(infix.charAt(x));
				

				
			}
			
			else if(infix.charAt(x) == ' '){
				
			}
			
			else if(infix.charAt(x) == '('){
				stackIF.push('(');
			}
			
			else if(infix.charAt(x) == ')'){
				
				while(true){
					if(stackIF.peek() != '('){
					
						postSB.append(stackIF.pop());
						

						
					}
					else{
						
						char temp = stackIF.pop();
						
						break;
						
					}
				}
			}
			else if(isOp(infix.charAt(x))){
				
				boolean precident = false;
				
				
				
				while(true){
					
					if((stackIF.peek() ==  '*' || stackIF.peek() == '/' || stackIF.peek() == '%')){
					
						postSB.append(stackIF.pop());
					
						precident = true;
					
					}
				
					if(infix.charAt(x) !=  '*' && infix.charAt(x) != '/' && infix.charAt(x) != '%' ){
				
					if(stackIF.peek() == '+' || stackIF.peek() == '-' && precident == false ){
					postSB.append(stackIF.pop());
					

					}
				
					}
					
					if(stackIF.peek() == '+' || stackIF.peek() == '-' && precident == true){
						break;
					}
					
					if(stackIF.peek() != '(' || !stackIF.isEmpty()){
						break;
					}
					
					
				}// end while loop
				
				stackIF.push(infix.charAt(x));
				
			}// end char case
			
			else if(!isvalid(infix.charAt(x)) && !isOp(infix.charAt(x)) && !Character.isDigit(infix.charAt(x)) ) {
				
				
				throw new InvalidCharacterException(infix.charAt(x));
				
			}
			
			
		}//end for loop for cycling through infix SB
		
		return postSB;
		
		
	}// end infix to postfix conversion
	
	public static double evaluatePost(StringBuffer postfix){
		
		double result = 0;
		double operand;
		
		
		Stack <Double> stackPF = new Stack<Double>("infix");

		for(int x = 0; x < postfix.length(); x++){
		
			if(postfix.charAt(x) == ' '){
				
			}
			
			else if(Character.isDigit(postfix.charAt(x)) ){
								
				
				double d= Double.parseDouble(Character.toString(postfix.charAt(x)));
				
				
				stackPF.push(d);

			}//end char condition
			
			else if(isOp(postfix.charAt(x))){
				
				result = stackPF.pop();
				
				operand = stackPF.pop();
				
				if(postfix.charAt(x) == '+'){
					result = result + operand;
					
					stackPF.push(result);
					
				}
				
				if(postfix.charAt(x) == '-'){
					result = operand - result;
					
					stackPF.push(result);
				}

				if(postfix.charAt(x) == '/'){
					result = operand / result;
					
					stackPF.push(result);
				}

				if(postfix.charAt(x) == '*'){
					result = operand * result;
					
					stackPF.push(result);
				}
				
				
				if(postfix.charAt(x) == '%'){
					
					result = operand % result;
					
					stackPF.push(result);
					
				}
				
			}
		
		}
		
		return result;
	}
	
	
	public static boolean isvalid(char ch){
		
		switch(ch){
		
		case ' ': return true;
		
		case '(': return true;
		
		case ')': return true;
		
		case '/': return true;
		
		default: return false;
		}
		
	}
	
	
	public static boolean isOp(char op){
		
		switch(op){
			
		case '%': return true;
		
		case '*': return true;
		
		case '-': return true;
		
		case '+': return true;
		
		case '/': return true;
		
		default: return false;
		
		
		}
		
	}
	
}
