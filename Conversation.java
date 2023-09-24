import java.util.Scanner;
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
    System.out.println("What's on your mind?");

  }
}
