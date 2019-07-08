// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 8.

#ifndef LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP
#define LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP

#include <iostream>

class StringToInteger
{
public:
  int myAtoi(std::string str)
  {
    unsigned int zero = 0;
    unsigned int MAX = (~zero) >> 1;
    unsigned int MIN = MAX + 1;
    int max_lower = MAX / 10, min_lower = MIN / 10;
    size_t len = str.size();
    int ret = 0, sign = 1, index = 0;
    unsigned int n = 0;
    if (0 == len)
    {
      return ret;
    }

    int i = 0;
    while (i < len && ' ' == str[i])
    {
      ++i;
    }

    if (i < len && ('-' == str[i] || '+' == str[i]))
    {
      if ('-' == str[i])
      {
        sign = -1;
      }
      ++i;
    }

    while (i < len && '0' <= str[i] && '9' >= str[i])
    {
      int c = str[i] - '0';

      if (sign > 0 && (n > max_lower || (n == max_lower && c > MAX % 10)))
      {
        n = MAX;
        break;
      }
      else if (sign < 0 && (n > min_lower || (n == min_lower && c > MIN % 10)))
      {
        n = MIN;
        break;
      }
      n = n * 10 + c;
      ++i;
    }

    return sign > 0 ? n : -n;
  }

  int myAtoi2(std::string str)
  {
    unsigned int zero = 0;
    unsigned int MAX = (~zero) >> 1;
    unsigned int MIN = MAX + 1;
    int max_lower = MAX / 10, min_lower = MIN / 10;
    size_t len = str.size();
    int ret = 0, sign = 1, index = 0;
    bool begin = false;
    while (index < len)
    {
      if (str[index] != ' ' &&
          str[index] != '+' &&
          str[index] != '-' &&
          (str[index] < '0' || str[index] > '9'))
        break;

      if (!begin)
      {
        if (' ' == str[index])
        {
          ++index;
          continue;
        }
        if ('+' == str[index] || '-' == str[index])
        {
          begin = true;
          if ('-' == str[index++])
            sign = -1;
          continue;
        }
      }
      else if (str[index] < '0' || str[index] > '9')
        break;

      if (ret > max_lower)
        return MAX;
      if (ret < min_lower)
        return MIN;

      begin = true;
      ret = ret * 10 + sign * (str[index++] - '0');
    }

    if (sign == 1 && ret < 0)
      return MAX;
    if (sign == -1 && ret > 0)
      return MIN;
    return ret;
  }
};

#endif // LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP
