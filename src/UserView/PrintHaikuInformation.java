package UserView;

import DataHandler.HaikuFileReader;

import java.util.ArrayList;


public class PrintHaikuInformation{

    HaikuFileReader haikuFileReader = new HaikuFileReader();

    /*
   * print a haiku
     */
    public void printHaiku(String haikuInformation){

        // make an array from given input dividing by ";"
        String[] haikuEntities = haikuInformation.split(";");

        // get the name
        String name = haikuEntities[0];
        // make first letter of the name upper case
        name = name.substring(0, 1).toLowerCase() + name.substring(1);

        // get it
        int id = Integer.parseInt(haikuEntities[1]);

        String firstLine = haikuEntities[2]; // get first line from Haiku
        firstLine = firstLine.substring(0, 1).toUpperCase() + firstLine.substring(1); // make first letter uppercase

        String middleLine = haikuEntities[3]; // get middle line from Haiku
        middleLine = middleLine.substring(0, 1).toUpperCase() + firstLine.substring(1); // make middle letter uppercase

        String lastLine = haikuEntities[4]; // get last line from Haiku
        lastLine = lastLine.substring(0, 1).toUpperCase() + firstLine.substring(1); // make last letter uppercase

        // finally print all information
        System.out.println("Writer Name: " + name);
        System.out.println("Haiku id: " + id);
        System.out.println("Haiku:");
        System.out.println("\t\t" + firstLine);
        System.out.println("\t\t" + middleLine);
        System.out.println("\t\t" + lastLine);

    }

    /*
    * print last added haiku
     */
    public void printLastAddedHaiku(){
        String lastAddedHaiku = haikuFileReader.getLatestHaikuEntries();
        printHaiku(lastAddedHaiku);
    }

    /*
    * methods to print all haikus those were saved
     */
    public void printHaikus(){

        // get all haiku entries
        ArrayList<String> haikus = haikuFileReader.getHaikuEntries();

        // print all haiku
        System.out.println("all saved Haiku:........................");
        for (int i = 0; i < haikus.size(); i++) {
            String haikuInformation = haikus.get(i);
            printHaiku(haikuInformation);
            System.out.println("..................................."); // print to make the output looking nice
        }

    }

}
