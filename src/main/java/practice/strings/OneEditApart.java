package main.java.practice.strings;

public class OneEditApart {

  public static void main(String[] args) {
    int n = 10;
    System.out.println(oneEditApart("cat", "cast"));
    System.out.println(oneEditApart("cat", "csat"));
    System.out.println(oneEditApart("cat", "dog")); //= false
    System.out.println(oneEditApart("cat", "cats")); //= true
    System.out.println(oneEditApart("cat", "cut")); //= true
    System.out.println(oneEditApart("cat", "cast")); //= true
    System.out.println(oneEditApart("cat", "at")); //= true
    System.out.println(oneEditApart("cat", "act"));// = false
  }

  //length is same, only one diff allowed
  private static boolean oneEditApart(String s1, String s2) {

    int len1 = s1.length();
    int len2 = s2.length();

    if (Math.abs(len1 - len2) > 1) {
      return false;
    }

    int diff = 0;
    String longerString = s1;
    String shorterString = s2;
    if (len2 > len1) {
      longerString = s2;
      shorterString = s1;
    }

    int index1 = 0;
    int index2 = 0;
    while (index1 < len1 && index2 < len2) {
      char c1 = longerString.charAt(index1);
      char c2 = shorterString.charAt(index2);
      if (c1 != c2) {
        if (diff > 1) {
          return false;
        }
        diff++;
        if (len1 != len2) {
          index2--;
        }
      }
      index1++;
      index2++;
    }

    return diff <= 1;

  }

}
