// Task 20. Valid Parentheses

import java.util.Stack;

public class Task_20 {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();                             // преобразование строки в символьный массив

        for (int i = 0; i < c.length; i++) {

            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);                               // заполнение  стека только открывающими скобкамми
            } else if (!stack.isEmpty() && ((c[i] == ')' && stack.peek() == '(')
                    || (c[i] == '}' && stack.peek() == '{')     // если в стеке и в символьном массиве скобок
                    || (c[i] == ']' && stack.peek() == '['))) {
                stack.pop();                                    // удаление из стека парных скобок (открывающую скобку при закрывающей скобке)
            } else {
                return false;
            }
        }
        return stack.isEmpty();                                 // когда стек пустой - True, при удалении парных скобок
    }

    public static void main(String[] args) {
        String s = "{(([()]))}";
        System.out.println(isValid(s));
    }
}
