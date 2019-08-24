// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 999.
// Date: 2019.8.24


class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int cnt=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    for(int k=i+1;k<8;k++){
                        if(board[k][j]=='B'){break;}
                        else if(board[k][j]=='p'){cnt++;break;}
                    }
                    for(int k=i-1;k>=0;k--){
                        if(board[k][j]=='B'){break;}
                        else if(board[k][j]=='p'){cnt++;break;}
                    }
                    for(int k=j+1;k<8;k++){
                        if(board[i][k]=='B'){break;}
                        else if(board[i][k]=='p'){cnt++;break;}
                    }
                    for(int k=j-1;k>=0;k--){
                        if(board[i][k]=='B'){break;}
                        else if(board[i][k]=='p'){cnt++;break;}
                    }
                }
            }
        }
        return cnt;  
    }
}