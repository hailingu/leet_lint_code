// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 204.

#ifndef LEETLINTCODE_LINTCODE_SINGLETON_CPP
#define LEETLINTCODE_LINTCODE_SINGLETON_CPP

#include <iostream>

class Singleton {
 public:
   static Singleton* getInstance() {
     if (NULL == instance) instance = new Singleton();
     return instance;
   }

 private:
   static Singleton* instance;
};

Singleton* Singleton::instance = NULL;

#endif // LEETLINTCODE_LINTCODE_SINGLETON_CPP
