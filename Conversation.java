import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 * Chatbot that takes in user input, provides either a mirrored response if it detects personal pronouns
 * or returns a random canned response from a set array 
 */

class Conversation {

  public static void main(String[] arguments) {
    System.out.println("Let's talk!");
    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int round = input.nextInt();
    String[] transcript = new String[2*round+1];
    transcript[0] = "What's on your mind?";
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
      transcript[i] = text;
      boolean mirrored = false; 
      String newtext = text;
      String [] responses = {"Oh, wow!", "Tell me more!", "Can you elaborate?", "I'm here to help!", "I'm here to listen", "What does that mean?", "Hmm...", "Mm-hmm", "That's interesting!"};

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
        transcript[i+1] = newtext;
      } else {
        Random rand = new Random();
        int max = responses.length;
        int random = rand.nextInt(max);
        String newresponse = responses[random];
        System.out.println(newresponse);
        transcript[i+1] = newresponse;
      }
        }
      System.out.println("\nGoodbye!\n\n");
      System.out.println("--------");
      System.out.println("TRANSCRIPT: ");
      System.out.println("--------");
      System.out.println(Arrays.toString(transcript));
      
    }
}



        
     

