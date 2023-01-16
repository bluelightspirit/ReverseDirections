import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ReverseDirections
 * <p>
 *
 * @author Gary Young
 *
 * Original version: 11/14/2022
 * Original version: Printed locations in reverse, but didn't always print directions in reverse properly by switching any direction read from the original file over to the opposite & assuming that's good enough (not 100% accurate).
 * New version: Adjusted to print directions in reverse for any .txt file by using a recorder reading all the directions themselves from the original file & reversing them at the end of the file.
 *
 * @version 01/16/2022
 * ReverseDirections2 takes in a file, determines if its valid, then outputs the directions in reverse order if valid.
 */
public class ReverseDirections {
    // flip line above or below it to reverse the order.
    // try catch should see file Qdoba.txt or carls.txt, then say not proper format, then close
    // open output file before input file so that input file does not bomb
    public void reverse(String inFileName) {
        String outFileName = inFileName.substring(0, inFileName.length() - 4) + "Reverse.txt";
        System.out.printf("Opening file %s for output", outFileName);
        PrintWriter fOut;
        String originalStartLocation = ""; // end location when reversed
        StringBuilder inBetweenRev = new StringBuilder(); // all normal directions in between originalStart & originalEnd, but reversed road names
        String originalEndLocation = ""; // start location when reversed
        StringBuilder recorder = new StringBuilder(); // will record directions in reverse, checking from all directions from originalEndLocation to right after "Start at"
        try {
            fOut = new PrintWriter(new FileOutputStream(outFileName));
            try {
                // input file being searched
                Scanner fIn = new Scanner(new FileInputStream(inFileName));
                while (fIn.hasNext()) {
                    String line = fIn.nextLine();
                    String endofLineSubstring = line.substring(0, line.length()-5);
                    // setting originalStartLocation
                    if (line.startsWith("Start at")) {
                        originalStartLocation = line.substring(9).concat(originalStartLocation);
                    }
                    // original 2 else if's for adding to String in reverse order of directions & lines
                    else if (line.startsWith("L on")) {
                        recorder.append("R");
                        inBetweenRev.insert(0, "\n on ");
                        inBetweenRev.insert(5, line.substring(5));
                    }
                    else if (line.startsWith("R on")) {
                        recorder.append("L");
                        inBetweenRev.insert(0, "\n on ");
                        inBetweenRev.insert(5, line.substring(5));
                    }
                    else if (line.endsWith("on L")) {
                        recorder.append("R");
                        originalEndLocation = endofLineSubstring;
                    }
                    else if (line.endsWith("on R")) {
                        recorder.append("L");
                        originalEndLocation = endofLineSubstring;
                    }
                }
                int lenBeforeAdding = inBetweenRev.length();
                // reverse the directions
                recorder.reverse();
                int y = 0;
                int indexLocation;
                // for loop to loop through how many times inBetweenRev should insert a letter
                for (int x = 0; x < recorder.length()-1; x++) {
                    // while loop for where to put in the letters from recorder
                    while (y < lenBeforeAdding) {
                        indexLocation = (inBetweenRev.indexOf("\n on ", y));
                        if (indexLocation != -1) {
                            inBetweenRev.insert(indexLocation + 1, recorder.substring(x, x + 1));
                            break;
                        }
                        y++;
                    }
                }
                // give user directions in reverse by:
                // print where the user will start
                fOut.print("Start at " + originalEndLocation);
                // print directions in reverse
                fOut.println(inBetweenRev);
                // find the last reversed direction from recorder & print where the end location in reverse is to the user
                fOut.println(originalStartLocation + " on " + recorder.charAt(recorder.length()-1));
                fOut.close();
            // extra catches
            } catch (FileNotFoundException e) {
                fOut.printf("File %s is not in the proper format", inFileName);
                System.err.printf("\nError reading input file %s%n", inFileName);
            }
            // close scanner
            fOut.close();
        } catch (FileNotFoundException e) {
            System.err.printf("\nError reading output file %s%n", outFileName);
        }
    }
    public static void main (String[]args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the file name of the original directions ");
        String inFileName = cin.nextLine();
        ReverseDirections reverser = new ReverseDirections();
        reverser.reverse(inFileName);
        cin.close();
    }
}
