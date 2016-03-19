package algoritms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by luben on 2016-03-15.
 */
public class postfixCalc {
    private final String OPERATORS = "+-/*";
    private Stack<Integer> stack=new Stack<>();

    public static void main(String[] args) {
        postfixCalc p = new postfixCalc();
        String line = "",tmp=" ";
        Scanner in = new Scanner(System.in);
        while (!tmp.equals("")) {
            System.out.printf("feed me: ");
            line = in.nextLine();
            System.out.println(p.eval(line));
        }
    }

    private int evalOp(char op) throws Exception {
        int a = stack.pop();
        int b = stack.pop();
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
            default:
                throw new Exception("operand not allowed");
        }
    }

    private boolean isOp(char op) {
        return OPERATORS.indexOf(op) != -1;
    }

    private Integer eval(String line) {
        Arrays.asList(line.split(" +")).forEach(s -> {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else if (isOp(s.charAt(0))) {
                try {
                    stack.push(evalOp(s.charAt(0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return stack.pop();
    }


}
