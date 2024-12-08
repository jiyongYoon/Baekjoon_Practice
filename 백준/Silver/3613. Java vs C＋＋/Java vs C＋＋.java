import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static Character[] chars;
  static boolean[] underScore;
  static boolean[] upperCase;
  static String word;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    word = br.readLine();
    char[] chars2 = word.toCharArray();
    chars = new Character[chars2.length];
    underScore = new boolean[chars2.length];
    upperCase = new boolean[chars2.length];

    for (int i = 0; i < chars2.length; i++) {
      chars[i] = chars2[i];
    }

    if (isWordCpp()) {
      convertToJava();
      System.out.println(word);
    } else if (isWordJava()) {
      convertToCpp();
      System.out.println(word);
    } else {
      System.out.println("Error!");
    }
  }

  private static boolean isWordCpp() {
    boolean isBeforeUnderScore = false;
    if (chars[0] >= 97 && chars[0] <= 122) {
      if (word.contains("_")) {
        for (int i = 0; i < chars.length; i++) {
          if (chars[i] >= 65 && chars[i] <= 90) {
            return false;
          }
          if (chars[i] == '_') {
            if (isBeforeUnderScore) {
              return false;
            }
            isBeforeUnderScore = true;
          } else {
            isBeforeUnderScore = false;
          }
        }
        if (isBeforeUnderScore) {
          return false;
        } else {
          return true;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private static void convertToJava() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '_') {
        underScore[i] = true;
      }
    }

    boolean isBeforeUnderscore = false;
    for (int i = 0; i < underScore.length; i++) {
      if (underScore[i]) {
        isBeforeUnderscore = true;
      } else {
        if (isBeforeUnderscore) {
          sb.append(chars[i].toString().toUpperCase());
        } else {
          sb.append(chars[i]);
        }
        isBeforeUnderscore = false;
      }
    }
    word = sb.toString();
  }

  private static boolean isWordJava() {
    if (chars[0] >= 97 && chars[0] <= 122) {
      for (char aChar : chars) {
        if ((aChar >= 97 && aChar <= 122) || (aChar >= 65 && aChar <= 90)) {
          continue;
        } else {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  private static void convertToCpp() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 65 && chars[i] <= 90) {
        upperCase[i] = true;
      }
    }

    for (int i = 0; i < upperCase.length; i++) {
      if (upperCase[i]) {
        sb.append("_").append(chars[i].toString().toLowerCase());
      } else {
        sb.append(chars[i].toString());
      }
    }
    word = sb.toString();
  }
}