// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 925.
// Date: 2019.7.11

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int nameIdx = 0;
        int nameDuplicatedCnt = 0;
        int typedIdx = 0;
        int typedDuplicatedCnt = 0;

        while (nameIdx < name.length() && typedIdx < typed.length()) {
            while (nameIdx != name.length() - 1 && name.charAt(nameIdx) == name.charAt(nameIdx + 1)) {
                nameIdx++;
                ++ nameDuplicatedCnt;
            }

            while (typedIdx != typed.length() - 1 && typed.charAt(typedIdx) == typed.charAt(typedIdx + 1)) {
                typedIdx++;
                ++ typedDuplicatedCnt;
            }

            if (nameDuplicatedCnt > typedDuplicatedCnt) {
                return false;
            }

            if (name.charAt(nameIdx) == typed.charAt(typedIdx)) {
                nameIdx ++;
                typedIdx ++;
                nameDuplicatedCnt = 0;
                typedDuplicatedCnt = 0;
            } else {
                return false;
            }
        }

        return nameIdx == name.length() && typedIdx == typed.length();
    }
}
