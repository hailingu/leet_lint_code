// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 33.

#ifndef LEETLINTCODE_LINTCODE_NQUEENS_CPP
#define LEETLINTCODE_LINTCODE_NQUEENS_CPP

#include <vector>
#include <iostream>
#include <math.h>

class NQueens {
 public:
  std::vector<std::vector<std::string> > solveNQueens(int n) {
    std::vector<std::vector<std::string> > result;
    std::vector<std::string> vs;
    if (1 == n) {
      vs.push_back("Q");
      result.push_back(vs);
    }
    
    if (n < 4) return result;
    std::string s(n, '.');
    placeQueen(n, 0, vs, result);
    return result;
  }
  
  void placeQueen(int n, int layer, std::vector<std::string> vs, std::vector<std::vector<std::string> > & result) {
    if (layer == n) {
      result.push_back(vs);
      return ;
    }
    
    for (int i = 0; i < n; ++ i) {
      std::string str(n, '.');
      str[i]='Q';
      vs.push_back(str);
      
      if(valid(vs, layer, i))
        placeQueen(n, layer + 1 , vs, result);
      
      vs.pop_back();
    }
  }
  
  bool valid(std::vector<std::string> &vs, int layer, int col) {
    int count = 0;
    for (int i = 0; i <= layer; ++ i) {
      if (vs[i][col] == 'Q') ++ count;
      if (count > 1) return false;
    }
    
    count = 0;
    for (int i = layer, j = col; i >=0 && j >= 0; --i, --j) {
      if (vs[i][j] == 'Q') ++ count;
      if (count > 1) return false;
    }
    
    count = 0;
    for (int i = layer, j = col; i >= 0 && j <= vs[0].size(); -- i, ++ j) {
       if (vs[i][j] == 'Q') ++ count;
      if (count > 1) return false;
    }
    
    return true;
  }
};

#endif // LEETLINTCODE_LINTCODE_NQUEENS_CPP
