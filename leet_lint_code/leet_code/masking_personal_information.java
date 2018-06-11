// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 831.

class MaskingPersonalInformation {
  public String maskPII(String S) {
      if ((S.charAt(0) >= 'a' && S.charAt(0) <= 'z') ||
              (S.charAt(0) >= 'A' && S.charAt(0) <= 'Z')) return maskPIIMaskEmail(S);
      return maskPIIMaskPhone(S);
  }

  public String maskPIIMaskEmail(String s) {
      int index = s.indexOf("@");
      String name1 = s.substring(0, index + 1);
      String maskName = "";
      if (name1.length() < 7) {
          maskName = name1.charAt(0) + "*****" + name1.charAt(name1.length() - 2);
      } else {
          maskName = maskName + name1.charAt(0);
          maskName = maskName + "*****" + name1.charAt(name1.length() - 2);
      }
      maskName = maskName + s.substring(index, s.length());
      return maskName.toLowerCase();
  }

  public String maskPIIMaskPhone(String s) {
      StringBuffer sb = new StringBuffer();
      int j = 0;
      for (int i = 0; i < s.length(); ++i) {
          if (s.charAt(i) >= '0' && s.charAt(i) <= '9') ++j;
      }

      int m = 0;
      for (int i = 1; m < 4; ++i) {
          char c = s.charAt(s.length() - i);
          if (c >= '0' && c <= '9') {
              sb.insert(0, c);
              ++m;
          }
      }

      sb.insert(0, "-");
      for (int i = 1; i <= 3; ++i)
          sb.insert(0, "*");
      sb.insert(0, "-");
      for (int i = 1; i <= 3; ++i)
          sb.insert(0, "*");

      if (j == 10) return sb.toString();
      else {
          sb.insert(0, "-");
          sb.insert(0, "+");
          for (int q = 10; q < j; ++q)
              sb.insert(1, "*");
      }
      return sb.toString();
  }
}
