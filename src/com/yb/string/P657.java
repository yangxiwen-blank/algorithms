package com.yb.string;

public class P657 {
    /**
     * 657. 机器人能否返回原点<br>
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。<br>
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。<br>
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。<br>
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
     */
    public boolean judgeCircle(String moves) {
        int len = moves.length();
        if (len % 2 == 1) return false;
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') ++x;
            else if (c == 'L') --x;
            else if (c == 'U') ++y;
            else --y;
        }
        return x == 0 && y == 0;
    }
}
