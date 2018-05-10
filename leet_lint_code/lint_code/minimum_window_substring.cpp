// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 32.

#ifndef LEETLINTCODE_LINTCODE_MINIMUMWINDOWSUBSTRING_CPP
#define LEETLINTCODE_LINTCODE_MINIMUMWINDOWSUBSTRING_CPP

#include <iostream>
#include <map>
#include <vector>

class CharInfo {
 public:
  CharInfo(char ch, int index) {
    this->ch = ch;
    this->index = index;
  }

  char ch;
  int index;
};

class MinimumWindowSubstring {
 public:
  std::string minWindow(std::string &source, std::string &target) {
    size_t s_len = source.length(), t_len = target.length();
    int i = 0, min_len = (int)s_len+1, cnt = (int)t_len, min_begin = 0, min_end = 0;
    int queue_begin_index = 0;

    std::map<char, int> char_set;
    while (i < t_len) {
      if (char_set[target[i]]) ++ char_set[target[i]];
      else char_set[target[i]] = 1;
      ++ i;
    }

    i = 0;
    std::vector<CharInfo> queue;
    while (i < s_len) {
      if (char_set.find(source[i]) != char_set.end()) {
        if (cnt > 0) {
          if (char_set[source[i]] > 0) -- cnt;
          queue.push_back(CharInfo(source[i], i));
          -- char_set[source[i]];
        }

        if (0 == cnt) {
          while (queue_begin_index < queue.size() && 0 == cnt) {
            int tmp_len = queue[queue.size() - 1].index - queue[queue_begin_index].index;
            if (tmp_len < min_len && 0 == cnt) {
              min_len = tmp_len;
              min_begin = queue[queue_begin_index].index;
              min_end = queue[queue.size() - 1].index;
            }

            if (char_set[queue[queue_begin_index].ch] == 0) {
              ++ char_set[queue[queue_begin_index].ch];
              ++ cnt;
              ++ queue_begin_index;
              break;
            }

            if (char_set[queue[queue_begin_index].ch] < 0) {
              ++ char_set[queue[queue_begin_index].ch];
              ++ queue_begin_index;
            }
          }
        }
      }
      ++ i;
    }
    if (s_len + 1 == min_len) return "";
    return source.substr(min_begin, min_len + 1);
  }
};

#endif // LEETLINTCODE_LINTCODE_MINIMUMWINDOWSUBSTRING_CPP
