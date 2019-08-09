// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 702.
// Date: 2019.8.9

class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        return binarySearch(reader, 20000, 0, target);
    }

    int binarySearch(ArrayReader reader, int upper, int lower, int target) {
        if (lower > upper) {
            return -1;
        }

        int mid = (lower + upper) / 2;
        int ans = reader.get(mid);

        if (ans == 2147483647 || ans > target) {
            return binarySearch(reader, mid - 1, lower, target);
        } else if (ans < target) {
            return binarySearch(reader, upper, mid + 1,target);
        } else {
            return mid;
        }
    }
}