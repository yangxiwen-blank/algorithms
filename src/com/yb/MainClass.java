package com.yb;

import com.yb.array.P1566;
import com.yb.array.P88;
import com.yb.array.Profit;
import com.yb.bfs.P127;
import com.yb.bfs.P279;
import com.yb.bfs.P310;
import com.yb.bfs.P407;
import com.yb.dfs.Courses;
import com.yb.dfs.P1210;
import com.yb.dfs.P1579;
import com.yb.math.O13;
import com.yb.math.P119;
import com.yb.matrix.sudoku.P37;
import com.yb.mid.Pxxx;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        List<List<Integer>> nums = new ArrayList<>();
//        List<Integer>
        System.out.println(new P407().trapRainWater(new int[][]{{1, 4, 3, 3, 3, 2}, {3, 2, 1, 1, 2, 4}, {3, 2, 1, 1, 2, 4},
                {2, 3, 3, 2, 3, 1}}));
        System.out.println(new P310().findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(new Pxxx().firstBadVersion(2126753390));
        for (int i = 1; i <= 30; ++i) {
            System.out.println(new P279().numSquares(i));
        }
        System.out.println(new P127().findLadders("cet", "ism",
                new ArrayList<String>(Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay",
                        "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay",
                        "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum",
                        "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez",
                        "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box",
                        "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply",
                        "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed",
                        "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log",
                        "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus",
                        "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei",
                        "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag",
                        "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy",
                        "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
                        "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere",
                        "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye",
                        "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx",
                        "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus",
                        "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash",
                        "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue",
                        "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you",
                        "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep",
                        "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex",
                        "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog",
                        "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix",
                        "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw",
                        "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin",
                        "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep",
                        "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo",
                        "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec",
                        "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc",
                        "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid",
                        "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did",
                        "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag",
                        "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap",
                        "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan",
                        "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego",
                        "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh",
                        "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac",
                        "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo",
                        "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor",
                        "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid",
                        "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air",
                        "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
                        "mob"))));
        new P88().merge(new int[]{1, 2, 3, 7, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
        System.out.println("P1424:" + new P37().solveSudoku(new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}}));
//                {'5', '3', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '8', '1', '6', '5', '2', '.', '.', '.'},
//                {'4', '2', '6', '1', '3', '9', '.', '.', '.'},
//                {'3', '5', '7', '9', '8', '6', '2', '4', '1'},
//                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
//                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
//                {'9', '1', '5', '8', '6', '3', '7', '2', '4'},
//                {'8', '7', '2', '4', '9', '1', '.', '3', '6'},
//                {'6', '4', '3', '2', '7', '5', '9', '.', '.'}}));

//                {'3', '5', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '8', '1', '6', '5', '2', '.', '.', '.'},
//                {'4', '2', '6', '1', '3', '9', '.', '.', '.'},
//                {'5', '3', '7', '9', '8', '6', '2', '4', '1'},
//                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
//                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
//                {'.', '.', '.', '8', '6', '3', '.', '2', '.'},
//                {'.', '.', '.', '4', '9', '1', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}}));
        System.out.println("P1210:" + new P1210().minimumMoves(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println("P118:" + new P119().getRow(5));
        System.out.println("o13:" + new O13().movingCount(1, 8, 4));
        System.out.println("P1579: " + new P1579().maxNumEdgesToRemove(13, new int[][]
                {{1, 1, 2}, {2, 1, 3},
                        {3, 1, 2}, {1, 1, 3}, {2, 11, 12},
                        {3, 1, 5}, {1, 10, 11}, {1, 7, 12}, {2, 3, 5},
                        {3, 1, 7}, {1, 4, 9}, {1, 10, 12}, {2, 6, 13}, {2, 2, 12}, {2, 1, 11}, {2, 5, 9}, {1, 3, 8},
                        {1, 7, 8}, {1, 2, 12}, {1, 5, 11}, {2, 7, 12},
                        {3, 1, 8}, {2, 1, 8},
                        {3, 1, 9}, {1, 5, 10},
                        {3, 1, 11},
                        {3, 1, 12}, {2, 7, 8}, {2, 5, 6},
                        {3, 1, 13}, {2, 4, 11}, {2, 3, 9}, {2, 6, 9}, {2, 1, 13},
                        {3, 2, 4},
                        {3, 2, 5}, {1, 2, 6},
                        {3, 2, 6}, {2, 1, 5}, {2, 5, 11}, {2, 1, 7}, {2, 3, 8}, {2, 8, 9},
                        {3, 2, 9},
                        {3, 2, 11}, {1, 9, 10}, {2, 6, 12},
                        {3, 2, 13}, {2, 3, 6}, {2, 2, 10},
                        {3, 3, 4}, {2, 4, 6}, {2, 7, 11}, {2, 7, 10}, {2, 3, 12},
                        {3, 3, 8},
                        {3, 3, 10}, {1, 6, 12},
                        {3, 3, 11}, {2, 9, 11},
                        {3, 3, 12}, {2, 4, 8},
                        {3, 3, 13}, {2, 1, 10}, {2, 6, 11},
                        {3, 4, 10}, {2, 3, 11}, {1, 5, 12},
                        {3, 4, 11}, {1, 4, 13},
                        {3, 4, 12}, {2, 4, 7}, {1, 1, 10}, {1, 3, 7}, {1, 7, 11},
                        {3, 4, 13},
                        {3, 5, 10}, {1, 4, 10}, {1, 1, 8},
                        {3, 5, 11},
                        {3, 5, 13}, {1, 9, 12}, {1, 6, 8},
                        {3, 6, 7},
                        {3, 6, 9},
                        {3, 6, 10}, {1, 3, 4}, {2, 7, 9}, {1, 3, 11}, {2, 2, 8}, {1, 2, 8}, {1, 11, 13}, {1, 2, 13},
                        {2, 2, 6}, {1, 4, 6}, {1, 6, 11},
                        {3, 6, 13}, {2, 1, 4}, {1, 1, 13}, {2, 9, 10}, {2, 1, 6}, {2, 10, 13}, {2, 2, 9},
                        {3, 7, 8},
                        {3, 7, 11},
                        {3, 8, 9}, {1, 9, 13}, {2, 4, 10}, {1, 6, 9},
                        {3, 8, 13}, {2, 10, 11},
                        {3, 9, 10}, {2, 11, 13}, {1, 1, 12}, {1, 7, 13}, {1, 4, 11}, {2, 4, 5}, {1, 3, 10}, {2, 12, 13},
                        {3, 9, 12},
                        {3, 10, 11},
                        {3, 10, 13}, {1, 7, 10}, {1, 1, 11}, {2, 4, 9},
                        {2, 10, 12}}));
        char[] aaa = new char[3];
        System.out.println(aaa[0]);
        String a = "2019";
        String b = "2020";
        System.out.println("compare : " + StringUtils.compare(a, b));
        int[][] M = new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10},
                {11, 12, 13}, {14, 15, 16}};

        System.out.println(findTwoSwapped(new int[]{1, 19, 11, 12, 13, 10}));
        // int2dArrayToString(M);
        // int[][] ret = new Solution().imageSmoother(M);
        Map map = new HashMap();
        System.out.println(map.get("key"));
        System.out.println(P1566.containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));

//        int[][] can = new int[9][5];
//        System.out.println(can.length);
//        System.out.println(can[0].length);
        // System.out.println(new Solution().sumNums(9999));
        // System.out.println(new Solution().quickMulti(7, 8));
        // int2dArrayToString(ret);
        Solution slt = new Solution();
//    int2
        System.out.println("maxProfit: " + new Profit().maxProfit(2, new int[]{10, 1, 2, 7, 6, 3, 6, 2, 5, 1, 1, 1, 1}));
        System.out.println("longestIncreasingPath: " + slt.longestIncreasingPath(new int[][]{
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
//        slt.solve(new char[][]{"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOOX".toCharArray()});
//        System.out.println("combinationSum2: " + slt.combinationSum2(new int[]{10, 1, 2, 7, 6, 2, 4, 1, 5, 1, 1, 1, 1}, 8));
        System.out.println("countSmaller: " + slt.countSmaller(new int[]{10, 1, 2, 7, 6, 2, 4, 1, 5, 1, 1, 1, 1}));
        System.out.println("restoreIpAddresses: " + slt.restoreIpAddresses("010010"));
//        System.out.println("shortestPalindrome : " + slt.shortestPalindrome("aaceecaaa"));
//        System.out.println("spiralMatrixIII :  " + int2dArrayToString(slt.spiralMatrixIII(5, 6, 1, 4)));
        System.out.println("canFinish : " + new Courses().canFinish(6, new int[][]{new int[]{1, 0}, new int[]{1, 3},
                new int[]{4, 5}, new int[]{0, 3}, new int[]{3, 4}, new int[]{5, 3}}));

        // ListNode head = stringToListNode("[1,2,3,4,5,6,7,8,9,0,13,435,465,787]");
        // System.out.println(listNodeToString(slt.reverseKGroup(head, 4)));
        // System.out.println(slt.strStr("hello", "lo"));
        // System.out.println(slt.maxScoreSightseeingPair(new int[] { 30, 13, 28, 32,
        // 16, 8, 11, 78, 83, 5, 22, 93, 61, 60,
        // 100, 8, 6, 48, 87, 43, 41, 86, 93, 5, 19, 29, 59, 31, 7, 51, 99, 47, 40, 24,
        // 20, 98, 41, 42, 81, 92, 55,
        // 85, 51, 92, 84, 21, 84, 92, 1, 73, 93, 51, 44, 27, 23, 54, 32, 57, 60, 9, 69,
        // 14, 28, 86, 15, 92, 47,
        // 63, 12, 99, 54, 6, 16, 52, 28, 86, 38, 73, 16, 52, 37, 30, 84, 81, 46, 97,
        // 84, 17, 21, 14, 52, 19, 74,
        // 20, 20, 56, 89, 7, 34, 21 }));
        System.out.println("addBinary: " + slt.addBinary("11101301001010110001", "10101010010101010"));
        System.out.println("addStrings : " + slt.addStrings("51321363", "694"));
        System.out.println("rob2 : " + slt.rob2(new int[]{2, 7, 9, 3, 1}));

        // String tmp = "abcdefghijklmnopqrstuvwxyz0123456789";
        // char[] tc = tmp.toCharArray();
        // for (int i = 0; i < tc.length; i++) {
        // System.out.println("" + tc[i] + (int) tc[i]);
        // }
        // String out = (ret.serialize(root));

        // System.out.println(out);
        // System.out.println(
        // slt.longestConsecutive(new int[] { 100, 99, 98, 97, 96, 70, 73, 74, 75, 71,
        // 69, 72, 76, 73, 100 }));

        // new Solution().trap(new int[] { 0, 1, 0, 3, 1, 0, 1, 99, 2, 1, 4, 1 });

        // System.out.println(new Solution().equationsPossible(new String[] { "a==b",
        // "e==c", "b==c", "a!=e" }));
        // System.out.println(new
        // Solution().longestValidParentheses("()(())))))((((()))))"));

    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(intArrayToString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // public static int[][] stringToInt2dArray(String input) {
    // JsonArray jsonArray = JsonArray.readFrom(input);
    // if (jsonArray.size() == 0) {
    // return new int[0][0];
    // }
    //
    // int[][] arr = new int[jsonArray.size()][];
    // for (int i = 0; i < arr.length; i++) {
    // JsonArray cols = jsonArray.get(i).asArray();
    // arr[i] = stringToIntegerArray(cols.toString());
    // }
    // return arr;
    // }

    public static String intArrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int item : array) {
            sb.append(Integer.toString(item));
            System.out.print(item + " ");
            sb.append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static int[] findTwoSwapped(int[] nums) {
        int n = nums.length;
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i + 1] < nums[i]) {
                y = nums[i + 1];
                if (x == -1) {
                    x = nums[i];
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public static int[][] stringToInt2dArray(String input) {
        if (input.length() == 0) {
            return new int[0][0];
        }

        String[] strs = input.split("],\\[");
        int[][] arr = new int[strs.length][];
        for (int i = 0; i < arr.length; i++) {
            String[] parts = strs[i].replaceAll("\\[", "")
                    .replaceAll("]", "").split(",");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            arr[i] = output;
        }
        return arr;
    }
//    private static List<Integer> stringToIntegerList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        List<Integer> arr = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            arr.add(jsonArray.get(i).asInt());
//        }
//        return arr;
//    }
//
//    public static List<List<Integer>> stringToInt2dList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToIntegerList(cols.toString()));
//        }
//        return list;
//    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
