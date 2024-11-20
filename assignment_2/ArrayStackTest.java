public class ArrayStackTest{
    public static void main(String args[]){
        String postfix = "26+35-/";
        System.out.println("Postfix: " + postfix);
        double infix = evaluatePostfix(postfix);
        System.out.println("Infix: " + infix); //"(a+e)/(b-d)";−4
        System.out.println("Test: " + (infix==-4.0));
        
        postfix = "234*5*-";
        System.out.println("Postfix: " + postfix);
        infix = evaluatePostfix(postfix);
        System.out.println("Infix: " + infix); //"a-b*c*d";-58
        System.out.println("Test: " + (infix==-58.0));
        
        postfix = "234-/5*";
        System.out.println("Postfix: " + postfix);
        infix = evaluatePostfix(postfix);
        System.out.println("Infix: " + infix); //"a/(b-c)*d";-10
        System.out.println("Test: " + (infix==-10.0));
        
        postfix = "6342^*+5-";
        System.out.println("Postfix: " + postfix);
        infix = evaluatePostfix(postfix);
        System.out.println("Infix: " + infix); //"(e+(b*(c^a)))-d";49
        System.out.println("Test: " + (infix==49.0));
    }
    
    public static double evaluatePostfix(String postfix){
        StackInterface<Double> valueStack = new ResizeableArrayStack<Double>();
        for(char nextCharacter:postfix.toCharArray()){
            switch(nextCharacter){
                case '+': case '-': case '*': case '/': case '^':
                    double operandTwo = valueStack.pop();
                    double operandOne = valueStack.pop();
                    valueStack.push(eval(operandOne,operandTwo,nextCharacter));
                    break;
                default:
                    if(Character.isDigit(nextCharacter)){
                        valueStack.push((double)Integer.parseInt(""+nextCharacter));
                    }
                    break;
            }
        }
        return valueStack.peek();
    }
    
    private static double eval(double operandOne, double operandTwo, char operator){
        switch(operator){
            case '+': return operandOne+operandTwo;
            case '-': return operandOne-operandTwo;
            case '*': return operandOne*operandTwo;
            case '/': return operandOne/operandTwo;
            case '^': return Math.pow(operandOne,operandTwo);
            default : break;
        }
        return -1.0;
    }
}