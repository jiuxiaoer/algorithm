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

    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static int calculate1(String s) {
        //栈顶 记录 当前符号
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        int res = 0, num = 0, op = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
                continue;
            }
            res += op * num;                //计算一个运算符
            num = 0;                        //数值清空

            if (s.charAt(i) == '+') {
                op = deque.peek();
            }
            if (s.charAt(i) == '-') {
                op = -deque.peek();
            }
            if (s.charAt(i) == '(') {
                deque.push(op);  //进入左括号，把左括号之前的符号置于栈顶
            }
            if (s.charAt(i) == ')') {
                deque.pop();     //退出括号，弹出栈顶符号
            }

        }
        res += op * num;                    //计算最后一个数

        return res;
    }


    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate1(s));
    }
}
