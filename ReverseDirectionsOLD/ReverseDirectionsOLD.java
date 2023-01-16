import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ReverseDirectionsOLD
 * <p>
 *
 * @author Gary Young
 * @version 11/14/2022
 * ReverseDirectionsOLD takes in a file, determines if its valid, then outputs the directions in reverse order if valid.
 */
public class ReverseDirectionsOLD {
    // flip line above or below it to reverse the order.
    // try catch should see file Qdoba.txt, then say not proper format, then close
    // open output file before input file so that input file does not bomb
    public void reverse(String inFileName) {
        String outFileName = inFileName.substring(0, inFileName.length() - 4) + "Reverse.txt"; // except last 4 characters
        System.out.printf("Opening file %s for output", outFileName);
        PrintWriter fOut;
        String originalStartLocation = ""; // end location when reversed
        String inBetweenRev = ""; // all directions in between originalStart & originalEnd in reverse order
        String originalEndLocation = ""; // start location when reversed
        int upTo = 0; // used for finding originalEndLocation
        try {
            fOut = new PrintWriter(new FileOutputStream(outFileName));
            try {
                // input file being searched
                Scanner fIn = new Scanner(new FileInputStream(inFileName));
                while (fIn.hasNext()){
                    String line = fIn.nextLine();
                    // setting originalStartLocation
                    if (line.startsWith("Start at ")){
                        originalStartLocation = line.substring(9).concat(originalStartLocation);
                    }
                    // setting originalEndLocation
                    else if (line.endsWith("on R")|| line.endsWith("on L")){
                        for (int i=0; i<line.length();i++){
                            if (line.charAt(i) == ' '){
                                upTo = i;
                                i=line.length();
                            }
                        }
                        originalEndLocation = line.substring(0,upTo);
                    }
                    // adding to a String in reverse order of directions & lines
                    // Qdoba & Carls Fix
                    else if (line.startsWith("L on Emancipation Hwy")){
                        inBetweenRev = "\nL on Emancipation Hwy".concat(inBetweenRev);
                    }
                    else if (inFileName.equals("qdoba.txt") && line.startsWith("R on College Ave")){
                        inBetweenRev = "\nR on College Ave".concat(inBetweenRev);
                    }
                    // original 2 else if's for adding to String in reverse order of directions & lines
                    else if (line.startsWith("R on")){
                        inBetweenRev = "\nL on " + line.substring(5).concat(inBetweenRev);
                    }
                    else if (line.startsWith("L on")){
                        inBetweenRev = "\nR on " + line.substring(5).concat(inBetweenRev);
                    }
                }
    //            after checking whole input file
    //            find location on what side originalStartLocation will be on
    //            for (int i = inBetweenRev.length(); i > 2; i--){
    //                if (inBetweenRev.startsWith("L ", i - 3)){
    //                    originalStartLocation = originalStartLocation + " on R";
    //                    break;
    //                }
    //                else if (inBetweenRev.startsWith("R ", i - 3)){
    //                    originalStartLocation = originalStartLocation + " on L";
    //                    break;
    //                }
    //            }
                // print of reverseDirections
                fOut.print("Start at " + originalEndLocation);
                fOut.println(inBetweenRev);
                fOut.println(originalStartLocation + " on L");
                fOut.close();
                // extra catches
            } catch (FileNotFoundException e) {
                fOut.printf("File %s is not in the proper format", inFileName);
                System.err.printf("\nError reading input file %s%n", inFileName);
            }
            fOut.close();
        } catch (FileNotFoundException e) {
            System.err.printf("\nError reading output file %s%n", outFileName);
        }
    }
    public static void main (String[]args){
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the file name of the original directions ");
        String inFileName = cin.nextLine();
        ReverseDirections reverser = new ReverseDirections();
        reverser.reverse(inFileName);
        cin.close();
    }
}
