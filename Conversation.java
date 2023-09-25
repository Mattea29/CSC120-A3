import java.util.Scanner;
import java.util.Random;
class Conversation {

  public static void main(String[] arguments) {


    System.out.println("Let's talk!");
    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int round = input.nextInt();
    input.nextLine();
    if (round == 1) {
      System.out.println("Ok! Let's talk for " + round + " round.");
    } else {
      System.out.println("Ok! Let's talk for " + round + " rounds.");
    };
    input.nextLine();
    System.out.println("What's on your mind?");
    for (var i = 1; i <= round; i++) {
      String text = input.nextLine();
      boolean mirrored = false; 
      String newtext = text;
      String [] responses = {"Oh, wow!", "Tell me more!", "Can you elaborate?", "I'm here to help you", "I'm here to listen", "What does that mean?"};
      String [] transcript = {"TRANSCRIPT: "};

      if (text.contains("I ")) {
        newtext = newtext.replace("I ", "you "); 
        mirrored = true;
      }
      if (text.contains(" am ")) {
        newtext = newtext.replace("am ", "are ");
        mirrored = true;
      }
      if (text.contains("you ")){
        newtext = newtext.replace("you ", "i ");
        mirrored = true;
      }
      if (text.contains("my ")) {
        newtext = newtext.replace("my ", "your ");
        mirrored = true;
      }
      if (text.contains("your")){
        newtext = newtext.replace("your ", "my ");
        mirrored = true;
      } 

      if (mirrored == true) {
        System.out.println(newtext + "?");
      } else {
        Random rand = new Random();
        int max = responses.length;
        int random = rand.nextInt(max);
        System.out.println(responses[random]);
      }
      
        }
    }
}



        
     

