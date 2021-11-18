package HaikuDomain;

import DataHandler.HaikuFileReader;
import DataHandler.HaikuFileWriter;
import UserView.GetUserInput;
import UserView.PrintHaikuInformation;

import java.util.ArrayList;

public class HaikuMethods {

    GetUserInput getUserInput = new GetUserInput();
    HaikuFileWriter haikuFileWriter = new HaikuFileWriter();
    HaikuFileReader haikuFileReader = new HaikuFileReader();
    HaikuAnalysis haikuAnalysis = new HaikuAnalysis();
    PrintHaikuInformation printHaikuInformation = new PrintHaikuInformation();

    // method will add a new haiku
    public void addNewHaiku(){

        // get haiku lines
        String[] haikuLines = getUserInput.getHaikuLines();

        //analyze the haiku to see if haiku is acceptable or not, and ger if any errors
        ArrayList<String> haikuErrors = haikuAnalysis.checkIfHaikuValid(haikuLines);

        if (haikuErrors.size() == 0) {
            // make new haiku if it is acceptable
            Haiku newHaiku = makeNewHaikuFromUserInput(haikuLines);

            // save haiku to the haiku.csv file
            haikuFileWriter.addHaikuToFile(newHaiku);

            // save haiku as pdf file (file name as: authorName_haikuId.pdf)
            haikuFileWriter.saveAsPdf(newHaiku);

            System.out.println("The following Haiku was added");
            printHaikuInformation.printLastAddedHaiku();
        }  else {
            // print which rules were violated
            printHaikuInformation.printHaikuRulesViolation(haikuErrors);
        }
    }

    // make a new haiku from user input
   public Haiku makeNewHaikuFromUserInput(String[] haikuLines){
        // first get generate haiku id automatic by reading number of entries in the csv file
       int id = (haikuFileReader.getNumberOfEntries("HaikuFiles/haiku.csv"))+1;
       String firstLine = haikuLines[0];
       String middleLine = haikuLines[1];
       String lastLine = haikuLines[2];
       Haiku newHaiku = new Haiku(id, getUserInput.name, firstLine, middleLine, lastLine);
       return newHaiku;
    }
}
