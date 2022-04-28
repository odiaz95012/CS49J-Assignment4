package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyCollections {

    public static void printFiles(Queue<File> files){
        while (!files.isEmpty()){
            //get and remove the current file
            File current = files.poll();
            printFile(current);
        }
    }

    private static void printFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            System.out.println("***");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void downsize(LinkedList<String> employees, int n){
        int index = 1;
        Iterator<String> iterator = employees.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            if(index % n == 0) iterator.remove();
            index++;
        }
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        // Make sure expression isn't empty
        if (expression.length() == 0 || expression == null) return false;

        for (int i = 0; i < expression.length(); i++) {
            //if we see a ( push ) or if we see a [ push ]
            if (expression.charAt(i) == '(' || expression.charAt(i) == '[') stack.push(expression.charAt(i));
            // if we see a ), make sure the stack isn't empty and that the top of the stack is (, if not return false
            else if (expression.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            // if we see a ], make sure the stack isn't empty and that the top of the stack is [, if not return false
            else if (expression.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        //if the stack is empty then the ()s and []s in the expression are balanced
        return stack.isEmpty();
    }

}
