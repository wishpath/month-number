public class ComeUpWithFormula {
  public static char[][] months = new char[][]{
      {'j', 'a', 'n'}, {'f', 'e', 'b'}, {'m', 'a', 'r'}, {'a', 'p', 'r'},
      {'m', 'a', 'y'}, {'j', 'u', 'n'}, {'j', 'u', 'l'}, {'a', 'u', 'g'},
      {'s', 'e', 'p'}, {'o', 'c', 't'}, {'n', 'o', 'v'}, {'d', 'e', 'c'}
  };

  public static void main(String[] args) {
    long max = 0;
    long bestA = -1;
    long bestB = -1;
    long bestC = -1;

    for (long a = 0; a <= 28_561; a++) {
      if (a % 250 == 0) System.out.println("a: " + a);
      for (long b = 0; b <= 28_561; b++) {
        nextC:
        for (long c = 0; c <= 28_561; c++) {
          for (int monthIndex = 1; monthIndex <= 12; monthIndex++) {
            char[] m = months[monthIndex - 1];
            long result = Math.abs(hash((m[0] + a) * (m[1] + b) * (m[2] + c)) % 12) + 1;
            if (result != monthIndex) {
              if ((monthIndex - 1) > max) {
                max = monthIndex - 1;
                System.out.println("Best result: " + max + " months; with a, b, c: " + a + ", " + b + ", " + c);
              }
              continue nextC;
            }
          }
          System.out.println("Solved a, b, c: " + a + ", " + b + ", " + c);
        }
      }
    }
  }

  public static long hash(long x) {
    x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
    x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
    x = x ^ (x >>> 31);
    return x;
  }
}

//There was one solution up to "a: 9000"
//This 9000 of "a" took around 24 hours to loop

//Console results:
//a: 0
//Best result: 1 months; with a, b, c: 0, 0, 15
//Best result: 2 months; with a, b, c: 0, 0, 204
//Best result: 3 months; with a, b, c: 0, 0, 689
//Best result: 5 months; with a, b, c: 0, 0, 7153
//Best result: 6 months; with a, b, c: 0, 13, 6456
//Best result: 7 months; with a, b, c: 0, 1100, 8729
//Best result: 8 months; with a, b, c: 0, 12467, 25795
//Best result: 9 months; with a, b, c: 6, 14647, 119
//Best result: 10 months; with a, b, c: 44, 7667, 9359
//a: 250
//a: 500
//a: 750
//a: 1000
//a: 1250
//a: 1500
//a: 1750
//a: 2000
//a: 2250
//a: 2500
//Best result: 11 months; with a, b, c: 2504, 26561, 26615
//a: 2750
//a: 3000
//a: 3250
//a: 3500
//a: 3750
//a: 4000
//a: 4250
//a: 4500
//a: 4750
//a: 5000
//a: 5250
//    Solved a, b, c: 5423, 28042, 12655
//a: 5500
//a: 5750
//a: 6000
//a: 6250
//a: 6500
//a: 6750
//a: 7000
//a: 7250
//a: 7500
//a: 7750
//a: 8000
//a: 8250
//a: 8500
//a: 8750
//a: 9000



//additional solution
//a: 9250
//Solved a, b, c: 9464, 11489, 2922
//a: 9500
//a: 9750
