public class Solution {
//     public String decodeString(String s) {
//         // stack， bug-free, but too slow
//         if (s == null || s.length() == 0) {
//             return s;
//         }
        
//         Stack<Character> charStack = new Stack<>();
//         Stack<Integer> numStack = new Stack<>();
        
//         int i = 0;
//         for (; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (isDigit(ch)) {
//                 int num = ch - '0';
//                 while (isDigit(s.charAt(++i))) {
//                     num = num * 10 + s.charAt(i) - '0';
//                 }
//                 numStack.push(num);
//                 charStack.push(s.charAt(i)); // '[', assume valid input
//             } else if (ch == ']') {
//                 int num = numStack.pop();
//                 StringBuilder sb = new StringBuilder();
//                 while (charStack.peek() != '[') {
//                     sb.append(charStack.pop());
//                 }
//                 charStack.pop(); // '['
//                 while (num-- > 0) {
//                     for (int j = sb.length() - 1; j >= 0; j--) {
//                         charStack.push(sb.charAt(j));
//                     }
//                 }
//             } else {
//                 charStack.push(ch);
//             }
//         }
        
//         StringBuilder sbResult = new StringBuilder();
//         while (!charStack.isEmpty()) {
//             sbResult.append(charStack.pop());
//         }
//         return sbResult.reverse().toString();
//     }
    
    public String decodeString(String s) {
        // stack， use Stack<String> rather than <Character>
        if (s == null || s.length() == 0) {
            return s;
        }
        final String SEPERATOR = "[";
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                int num = ch - '0';
                while (isDigit(s.charAt(++i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                strStack.push(SEPERATOR); // '[', assume valid input
            } else if (ch == ']') {
                int num = numStack.pop();
                StringBuilder tmp = new StringBuilder(sb);
                sb = new StringBuilder();
                while (strStack.peek() != SEPERATOR) {
                    tmp.insert(0, strStack.pop());
                }
                strStack.pop(); // '['
                String t = tmp.toString();
                while (--num > 0) {
                    tmp.append(t);
                }
                strStack.push(tmp.toString());
            } else {
                sb.append(ch);
            }
        }
        
        while (!strStack.isEmpty()) {
            sb.insert(0, strStack.pop());
        }
        return sb.toString();
    }
    private boolean isDigit(char ch) {
        return (ch >= '0') && (ch <= '9');
    }
}