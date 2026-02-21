import java.util.Map;

public class PerformanceTest {
  private static final long ONE_SECOND_IN_NANOSECONDS = 1_000_000_000L;
  private static final Map<String, Integer> MONTHS = Map.ofEntries(
      Map.entry("jan", 1),
      Map.entry("feb", 2),
      Map.entry("mar", 3),
      Map.entry("apr", 4),
      Map.entry("may", 5),
      Map.entry("jun", 6),
      Map.entry("jul", 7),
      Map.entry("aug", 8),
      Map.entry("sep", 9),
      Map.entry("oct", 10),
      Map.entry("nov", 11),
      Map.entry("dec", 12)
  );

  private static final String[] months_x = {
      null, null, null, null, null, null, null, null, null, "12",
      "02", null, null, null, null, null, null, null, null, null,
      null, null, "01", null, null, null, "08", null, null, "03",
      null, null, "04", null, null, "10", "05", "09", null, null,
      "07", null, "06", null, null, null, null, null, "11"
  };

  private static final int[] MONTH_ARR = {
      -1, -1, -1, -1, -1, -1, -1, -1, -1, 12,
      2, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, 1, -1, -1, -1, 8, -1, -1, 3,
      -1, -1, 4, -1, -1, 10, 5, 9, -1, -1,
      7, -1, 6, -1, -1, -1, -1, -1, 11
  };

  private static final int[][][] TRIE = new int[26][26][26];

  static {
    put("jan", 1); put("feb", 2); put("mar", 3); put("apr", 4);
    put("may", 5); put("jun", 6); put("jul", 7); put("aug", 8);
    put("sep", 9); put("oct", 10); put("nov", 11); put("dec", 12);
  }

  private static void put(String key, int month) {
    int i0 = key.charAt(0) - 'a';
    int i1 = key.charAt(1) - 'a';
    int i2 = key.charAt(2) - 'a';
    TRIE[i0][i1][i2] = month;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 5_000_000; i++) Main.calculateMonthNumber("January"); // Warmup
    long start = System.nanoTime();
    long count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      Main.calculateMonthNumber(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    double seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (MAIN)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");



    for (int i = 0; i < 5_000_000; i++) alternativeCalculateMonthNumber1("January"); // Warmup
    start = System.nanoTime();
    count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      alternativeCalculateMonthNumber1(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (MAP)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");




    for (int i = 0; i < 5_000_000; i++) alternativeCalculateMonthNumber2("January"); // Warmup
    start = System.nanoTime();
    count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      alternativeCalculateMonthNumber2(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (SWITCH)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");




    for (int i = 0; i < 5_000_000; i++) alternativeCalculateMonthNumber3("January"); // Warmup
    start = System.nanoTime();
    count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      alternativeCalculateMonthNumber3(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (SWITCH, verbose)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");








    for (int i = 0; i < 5_000_000; i++) alternativeCalculateMonthNumber4("January"); // Warmup
    start = System.nanoTime();
    count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      alternativeCalculateMonthNumber4(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (int[] ARR)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");






    for (int i = 0; i < 5_000_000; i++) alternativeCalculateMonthNumber5("January"); // Warmup
    start = System.nanoTime();
    count = 0;
    for (int i = 0; System.nanoTime() - start < ONE_SECOND_IN_NANOSECONDS * 10; count++, i = (i + 1) % Main.TEST_INPUTS.size()) {
      alternativeCalculateMonthNumber5(Main.TEST_INPUTS.get(i));
      if (count == Integer.MAX_VALUE) throw new RuntimeException("Overflow");
    }
    seconds = (System.nanoTime() - start) / 1_000_000_000.0;
    System.out.println("\n\u001B[35m========== PERFORMANCE TEST (TRIE)==========\u001B[0m");
    System.out.println("\u001B[36mElapsed time: \u001B[33m" + String.format("%.3f", seconds) + " s\u001B[0m");
    System.out.println("\u001B[36mTotal executions: \u001B[32m" + String.format("%,d", count) + "\u001B[0m");
    System.out.println("\u001B[35m======================================\u001B[0m\n");
  }

  public static int alternativeCalculateMonthNumber1(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    String key = month.substring(0, 3).toLowerCase();
    Integer result = MONTHS.get(key);
    if (result == null) throw new IllegalArgumentException("Unknown month");

    return result;
  }

  public static int alternativeCalculateMonthNumber2(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    switch (month.substring(0, 3).toLowerCase()) {
      case "jan": return 1;
      case "feb": return 2;
      case "mar": return 3;
      case "apr": return 4;
      case "may": return 5;
      case "jun": return 6;
      case "jul": return 7;
      case "aug": return 8;
      case "sep": return 9;
      case "oct": return 10;
      case "nov": return 11;
      case "dec": return 12;
      default: throw new IllegalArgumentException("Unknown month");
    }
  }

  public static int alternativeCalculateMonthNumber3(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    switch (Character.toLowerCase(month.charAt(0))) {
      case 'j':
        switch (Character.toLowerCase(month.charAt(1))) {
          case 'a': return 1; // jan
          case 'u':
            switch (Character.toLowerCase(month.charAt(2))) {
              case 'n': return 6; // jun
              case 'l': return 7; // jul
            }
            break;
        }
        break;
      case 'f': return 2; // feb
      case 'm':
        switch (Character.toLowerCase(month.charAt(2))) {
          case 'r': return 3; // mar
          case 'y': return 5; // may
        }
        break;
      case 'a':
        switch (Character.toLowerCase(month.charAt(1))) {
          case 'p': return 4; // apr
          case 'u': return 8; // aug
        }
        break;
      case 's': return 9; // sep
      case 'o': return 10; // oct
      case 'n': return 11; // nov
      case 'd': return 12; // dec
    }

    throw new IllegalArgumentException("Unknown month");
  }

  public static int alternativeCalculateMonthNumber4(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    char c0 = Character.toLowerCase(month.charAt(0));
    char c1 = Character.toLowerCase(month.charAt(1));
    char c2 = Character.toLowerCase(month.charAt(2));

    int index = (c0 + c1 + c2) - ('a' * 3);
    if (index < 0 || index >= MONTH_ARR.length || MONTH_ARR[index] == -1)
      throw new IllegalArgumentException("Unknown month");

    return MONTH_ARR[index];
  }

  public static int alternativeCalculateMonthNumber5(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    int i0 = Character.toLowerCase(month.charAt(0)) - 'a';
    int i1 = Character.toLowerCase(month.charAt(1)) - 'a';
    int i2 = Character.toLowerCase(month.charAt(2)) - 'a';

    if (i0 < 0 || i0 >= 26 || i1 < 0 || i1 >= 26 || i2 < 0 || i2 >= 26)
      throw new IllegalArgumentException("Unknown month");

    int result = TRIE[i0][i1][i2];
    if (result == 0) throw new IllegalArgumentException("Unknown month");

    return result;
  }
}