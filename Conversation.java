import java.util.Scanner;
import java.util.Random;

/**
 * Chatbot that takes in user input, provides either a mirrored response if it detects personal pronouns
 * or returns a random canned response from a set array.
 * Everything is executed in the main function, which deals with user input, determining the appropriate responses,
 * storing each call and response properly in a transcript, and printing said transcript when done.
 * 
 * <round> - number of rounds the conversation will go on for; also used for determining the length of the transcript array
 * <transcriptIndex> - counter used to keep track of the current position in the array to avoid overwriting 
 * <mirrored> - boolean value that is either true if the user input contains mirror words, or false if not and used to determine
 * appropriate response
 */

class Conversation {

  public static void main(String[] arguments) {
    System.out.println("Let's talk!");
    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    //take in user inputted number of rounds and use value for specifying transcript array length
    int round = input.nextInt();
    String[] transcript = new String[2*round+2];
    transcript[0] = "What's on your mind?";
    input.nextLine();
    if (round == 1) {
      System.out.println("Ok! Let's talk for " + round + " round.");
    } else {
      System.out.println("Ok! Let's talk for " + round + " rounds.");
    };
    System.out.println("What's on your mind?");
    //keeping track of the position in the index of the transcript to avoid overwriting
    int transcriptIndex = 1;

    for (var i = 1; i <= round; i++) {
      String text = input.nextLine();
      // storing the user input in the transript array
      transcript[transcriptIndex++] = text;
      boolean mirrored = false; 
      // newtext is copy of text to avoid issue of mirror word search/replace writing back over each changed sentence and returning nonsense
      String newText = text;
      String [] responses = {"Oh, wow!", "Tell me more!", "Can you elaborate?", "I'm here to help!", "I'm here to listen", "What does that mean?", "Hmm...", "Mm-hmm", "That's interesting!"};

      // replacing mirror words
      if (text.contains("I ")) {
        newText = newText.replace("I ", "you "); 
        mirrored = true;
      }
      if (text.contains(" am ")) {
        newText = newText.replace("am ", "are ");
        mirrored = true;
      }
      if (text.contains("you ")){
        newText = newText.replace("you ", "i ");
        mirrored = true;
      }
      if (text.contains("my ")) {
        newText = newText.replace("my ", "your ");
        mirrored = true;
      }
      if (text.contains("your")){
        newText = newText.replace("your ", "my ");
        mirrored = true;
      } 

      // detecting if a sentence has mirror words and returning the proper response based on boolean value
      // also storing responses properly in transcript array
      if (mirrored == true) {
        System.out.println(newText + "?");
        transcript[transcriptIndex++] = newText + "?";
      } else {
        Random rand = new Random();
        int max = responses.length;
        int random = rand.nextInt(max);
        String newresponse = responses[random];
        System.out.println(newresponse);
        transcript[transcriptIndex++] = newresponse;
      }
        }

      System.out.println("\nGoodbye!\n\n");
      transcript[transcriptIndex++] = "Goodbye!";
      System.out.println("--------");
      System.out.println("TRANSCRIPT: ");
      System.out.println("--------");
      // printing the transcript but ignoring the null values
      for (int i = 0; i < transcriptIndex; i++) {
        System.out.println(transcript[i]);
      }
      
    // Closing Scanner to stop resource leak message
    input.close();
    }
}



        
     

