import java.util.Stack;
import java.util.Scanner;
import java.lang.*;

public class StackExercise {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        //create Stack using built in Java class

        //push elements into stack
        push();
        //call methods
        System.out.println("Reversed Stack: ");
        printReversedStack();
        System.out.println();

        System.out.println(stack);
        insertElement(5, 3);
        System.out.println(stack);
        System.out.println(getSmallestIndex(stack, 34));

        System.out.println(isPalindrome("bonob"));
        System.out.println(isPalindrome("hello"));

    }

    public static void push() {
        Scanner scan = new Scanner(System.in);
        boolean continuePush = true;

        while (continuePush) {
            System.out.print("Enter a value (or enter 'stop' to finish): ");
            if (scan.hasNextInt()) {
                int input = scan.nextInt();
                stack.push(input);
            } else {
                String userInput = scan.next();
                if (userInput.equalsIgnoreCase("stop")) {
                    continuePush = false;
                } else {
                    System.out.println("Invalid input. Please enter an integer or 'stop'.");
                }
            }
        }

        scan.close(); // Close the Scanner
    }

    public static void printReversedStack() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) { //print reverse order
            int element = stack.pop();
            temp.push(element);
            System.out.print(element + " ");
        }
        while (!temp.isEmpty()) { //return to original order
            stack.push(temp.pop());
        }
    }

    /* uncurl stack until at index, place stack and then replace
    * make temp stack and rebuild the stack with the correct one
    *  */
    public static void insertElement(int element, int index) {
        int counter = 0;
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) {
            int tempElement = stack.pop();
            temp.push(tempElement);
        }
        while(!temp.isEmpty()) {
            if(counter == index) {
                stack.push(element);
            }
            else {
                stack.push(temp.pop());
            }
            counter++;
        }
    }

    public static int getSmallestIndex(Stack<Integer> stack, int value) {
        int index = -1;
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()) {
            int currentElement = stack.pop();
            temp.push(currentElement);

            if(currentElement == value && (index == -1 || temp.size() - 1 < index)) {
                index = temp.size() - 1;
            }
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return index;
    }

    /*
    * Use stack index to make sure that each letter works, as we move one way up the stack
    * the temp stack should match moving down the other way
    * */
    public static boolean isPalindrome(String input) {
        boolean isPalindrome = true;
        Stack<Character> stringInput = new Stack<>();
        //Stack<Character> stringTemp = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            stringInput.push(input.charAt(i));
        }
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != stringInput.pop()) {
                return false;
            }
        }
        return isPalindrome; //return true by default and can only be changed with "if"
    }
}