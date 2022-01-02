package Stack;

import java.util.*;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/2 10:47
 */

public class Solution {

    public static boolean isValid(String s) {
        int length = s.length();
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //如果匹配到右括号.查看是否匹配
            if (pairs.containsKey(c)) {
                //如果栈的第一个和右括号不相等（}
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                //匹配到左括号直接压栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            //若为左扩号直接 压栈 右 括号    若右括号（被压入的） 不等于下一个右括号直接 返货错误
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[()[]{}]";
        System.out.println(isValid1(s));
        ;
    }
}
