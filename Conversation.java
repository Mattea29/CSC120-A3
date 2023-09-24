import java.util.Scanner;
import java.util.*;
class Conversation {

  public static void main(String[] arguments) {
    System.out.println("Let's talk!");
    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int round = input.nextInt();
    if (round == 1) {
      System.out.println("Ok! Let's talk for " + round + " round.");
    } else {
      System.out.println("Ok! Let's talk for " + round + " rounds.");
    };
    input.nextLine();
    System.out.println("What's on your mind?");
    for (var i = 1; i <= round; i++) {
      String text = input.nextLine();
      String newtext = text
        .replaceAll("\\b(?i)i\\b", "you")
        .replaceAll("(?i)\\bam\\b", "are")
        .replaceAll("(?i)\\bme\\b", "you")
        .replaceAll("(?i)\\byou\\b", "i")
        .replaceAll("(?i)\\byour\\b", "my")
        .replaceAll("(?i)\\bmy\\b", "your");
      System.out.println(newtext);
    }
  }
}
