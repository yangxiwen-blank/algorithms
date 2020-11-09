package com.yb.string;

import java.util.Stack;

public class P71 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("\\/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (".".equals(dir) || "".equals(dir)) continue;
            else if ("..".equals(dir)) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(dir);
        }
//        StringBuilder<String> sb = new StringBuilder();
//        while (!stack.isEmpty()){
//            sb.append(stack.pop());
//            sb.append("/");
//        }
        return "sb.reverse().toString()";

    }
}
