// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 158.
// Date: 2019.7.17


public class ReadNCharactersGivenRead4 extends Reader4 {
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int sum = 0;
        int j = 0;
        int rn = 0;
        while ((rn = read4(tmp)) > 0 && sum < n){
            for (int i = 0; i <  Math.min(n - sum, rn);) {
                buf[j ++] = tmp[i ++];
            } 
            sum += rn;
        }
        return Math.min(sum, n);
    }
}