package HaikuDomain;

import DataHandler.HaikuFileReader;
import DataHandler.HaikuFileWriter;
import UserView.GetUserInput;

import java.util.ArrayList;

public class HaikuMethods {

    GetUserInput getUserInput = new GetUserInput();
    HaikuFileWriter haikuFileWriter = new HaikuFileWriter();
    HaikuFileReader haikuFileReader = new HaikuFileReader();
    HaikuAnalysis haikuAnalysis = new HaikuAnalysis();

    // analyze haiku to see if it is a valid haiku or not
    public void analyzeHaiku(){
        String[] haikuLines = getUserInput.getHaikuLines();
        // call haiku analysis and print any errors in haiku, if there is
        ArrayList<String> haikuErrors = haikuAnalysis.checkIfHaikuValid(haikuLines);
        if (haikuErrors.size() == 0) {
            System.out.println("no error found");
        } else {
            for (int i = 0; i < haikuErrors.size(); i++) {
                System.out.println(haikuErrors.get(i));
            }
        }
    }

    // method will add a new haiku
    public void addNewHaiku(){

        // get haiku lines
        //String[] haikuLines = getUserInput.getHaikuLines();

        // analyze the haiku to see if haiku is acceptable or not
        //HaikuAnalysis.checkIfHaikuValid(haikuLines);

        // make new haiku if it is acceptable
        Haiku newHaiku = makeNewHaikuFromUserInput();

        // save haiku to the haiku.csv file
        haikuFileWriter.addHaikuToFile(newHaiku);

        // save haiku as pdf file (file name as: authorName_haikuId.pdf)
        haikuFileWriter.saveAsPdf(newHaiku);

        // print the haiku
        System.out.println(newHaiku);
    }

   public Haiku makeNewHaikuFromUserInput(){
       String[] haikuLines = getUserInput.getHaikuLines();
       int id = (haikuFileReader.getNumberOfEntries("HaikuFiles/haiku.csv"))+1;
       String firstLine = haikuLines[0];
       String middleLine = haikuLines[1];
       String lastLine = haikuLines[2];
       Haiku newHaiku = new Haiku(id, getUserInput.name, firstLine, middleLine, lastLine);
       return newHaiku;
    }

    public Haiku getLastAddedHaiku(){
        String lastAddedEntries = haikuFileReader.getLatestHaikuEntries();
        String[] lastAddedHaikuEntities = lastAddedEntries.split(";");

        int id = Integer.parseInt(lastAddedHaikuEntities[0]);
        String name = lastAddedHaikuEntities[1];
        String firstLine = lastAddedHaikuEntities[2];
        String middleLine = lastAddedHaikuEntities[3];
        String lastLine = lastAddedHaikuEntities[4];
        Haiku newHaiku = new Haiku(id, name, firstLine, middleLine, lastLine);
        return newHaiku;

    }





}
