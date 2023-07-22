import java.util.*;
import java.io.*;
public class Kristina {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Kristina.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < cases; i++) {
            String type = scan.next();
            String operations = (scan.nextLine()).trim();
            int sum = 0;
            if (type.equals("POST")) { // post
                    Stack<String> opStack = postFill(operations);     
                    // System.out.println(current);
                    Stack<Integer> workStack = new Stack<>();
                    while (!opStack.isEmpty()) {
                        
                        if (!checkOp(opStack)) { // its a number
                           workStack.add(Integer.parseInt(opStack.pop()));
                        } else { // its an operand
                            String operand = opStack.pop();
                            int num1 = workStack.pop();
                            int num2 = workStack.pop();
                            sum += doTheWork(num1, num2, operand);
                        }
                    }
                    System.out.println(sum);
                } else { // pre
                    continue;
            }

        }
    }

    public static boolean checkOp (Stack<String> s) {
        if (s.peek().equals("+") || s.peek().equals("-") || s.peek().equals("*") || s.peek().equals("/"))
            return true;
        return false;
    }

    public static Stack<String> postFill(String op) {
        Stack<String> current = new Stack<String>();
        Scanner currScan = new Scanner(op);

        while (currScan.hasNext()) {
            current.push(currScan.next());
        }
        Collections.reverse(current);
        return current;
    }
    
    public static int doTheWork(int num1, int num2, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "^":
                result = (int) Math.pow(num1, num2);
                break;
            default:
                break;
            
        }
        return result;
    }
}