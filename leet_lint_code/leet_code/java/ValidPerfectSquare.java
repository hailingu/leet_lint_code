// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 367.
// Date: 2019.8.26


class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int right = 46340;
        int left = 1;
        int mid = (right + left) / 2;
        int guess = mid * mid;

        while (guess != num) {
            if (left * left > num || (right * right < num)) {
                return false;
            } else if (guess > num || guess < 0) {
                right = mid - 1;
            } else if (guess < num) {
                left = mid + 1;
            }

            mid = (right + left) / 2;
            guess = mid * mid;
        }

        return true;
    }
}