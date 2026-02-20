
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> inputs = List.of(
        "January", "january", "JAN", "Jan",
        "February", "february", "FEB", "Feb",
        "March", "march", "MAR", "Mar",
        "April", "april", "APR", "Apr",
        "May", "may", "MAY",
        "June", "june", "JUN", "Jun",
        "July", "july", "JUL", "Jul",
        "August", "august", "AUG", "Aug",
        "September", "september", "SEP", "Sep",
        "October", "october", "OCT", "Oct",
        "November", "november", "NOV", "Nov",
        "December", "december", "DEC", "Dec"
    );

    for (String input : inputs) {
      int result = calculateMonthNumber(input);
      System.out.println("\u001B[36mInput: \u001B[33m" + input + "\u001B[36m  ->  Month #: \u001B[32m" + result + "\u001B[0m");
    }
  }

  public static int calculateMonthNumber(String month) {
    if (month == null || month.length() < 3) throw new IllegalArgumentException("Invalid month");

    String m = month.toLowerCase();
    long x = (m.charAt(0) + 5423L) * (m.charAt(1) + 28042L) * (m.charAt(2) + 12655L);
    x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
    x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
    x = x ^ (x >>> 31);

    return (int) (Math.abs(x % 12) + 1);
  }
}