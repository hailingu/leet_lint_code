// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1138.
// Date: 2019.7.28

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();

        int or = 0;
        int ol = 0;
        for (int i = 0; i < target.length(); ++i) {
            StringBuilder path = new StringBuilder();
            char c = target.charAt(i);
            int tr = (c - 'a') / 5;
            int tl = (c - 'a') - tr * 5;

            walk(or, ol, tr, tl, path);
            or = tr;
            ol = tl;

            ans.append(path);
        }

        return ans.toString();
    }

    String walk(int or, int ol, int tr, int tl, StringBuilder path) {
        if (or == tr && ol == tl) {
            path.append("!");
            return path.toString();
        }

        if (or == 4 && tr == 5) {
            if (ol > 0) {
                path.append("L");
                return walk(or, ol - 1, tr, tl, path);
            } else {
                path.append("D!");
                return path.toString();
            }
        }

        if (or < tr) {
            path.append("D");
            return walk(or + 1, ol, tr, tl, path);
        } else if (or > tr) {
            path.append("U");
            return walk(or - 1, ol, tr, tl, path);
        }

        if (ol > tl) {
            path.append("L");
            return walk(or, ol - 1, tr, tl, path);
        } else {
            path.append("R");
            return walk(or, ol + 1, tr, tl, path);
        }
    }
}
