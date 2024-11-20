public class LinkedStackTest{
    public static void main(String args[]){
        String infix = "(a+b)/(c-d)";
        System.out.println("Infix: " + infix);
        String postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Test: " + postfix.equals("ab+cd-/"));
        
        infix = "a/(b-c)*d";
        System.out.println("Infix: " + infix);
        postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Test: " + postfix.equals("abc-/d*"));
        
        infix = "a-(b/(c-d)*e+f)^g";
        System.out.println("Infix: " + infix);
        postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix); //"abcd-/e*f+g^-"
        System.out.println("Test: " + postfix.equals("abcd-/e*f+g^-"));
        
        infix = "(a-b*c)/(d*e^f*g+h)";
        System.out.println("Infix: " + infix);
        postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix); //"abc*-def^*g*h+/"
        System.out.println("Test: " + postfix.equals("abc*-def^*g*h+/"));
    }
    
    public static String convertToPostfix(String infix){
        StackInterface<Character> operatorStack = new LinkedStack<Character>();
        String postfix = "";
        for(char nextCharacter:infix.toCharArray()){
            switch(nextCharacter){
                case '^': 
                    operatorStack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while(!operatorStack.isEmpty() && prec(nextCharacter)<=prec(operatorStack.peek())){
                        postfix += operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    Character topOperator = operatorStack.pop();
                    while(topOperator != '('){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    if(Character.isLetterOrDigit(nextCharacter)){
                        postfix += nextCharacter;
                    }
                    break;
            }
        }
        while(!operatorStack.isEmpty()){
            postfix += operatorStack.pop();
        }
        return postfix;
    }

    private static int prec(char c){
        switch (c){
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
