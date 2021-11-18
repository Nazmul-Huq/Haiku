package DataHandler;

import java.io.*;
import java.util.ArrayList;

public class HaikuFileReader {


    // get all haiku entries from haiku.csv file and return as arraylist
    public ArrayList<String> getHaikuEntries(){

        // arraylist to store all haiku
        ArrayList<String> haikus = new ArrayList<>();

        // store individual entry
        String haiku = "";
        try {
            FileInputStream fileToRead = new FileInputStream("HaikuFiles/haiku.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileToRead));

            while ((haiku = br.readLine()) != null){
                haikus.add(haiku);
            }
            fileToRead.close();

        } catch (Exception e){
            System.out.println("Cant read");
        }
        return haikus;
    }


    // get the last added haiku as string and return it
    public String getLatestHaikuEntries(){
        String lastLine = "";
        try {
            FileInputStream fileToRead = new FileInputStream("HaikuFiles/haiku.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileToRead));

            String temporaryLine;

            while ((temporaryLine = br.readLine()) != null){
                lastLine = temporaryLine;
            }
            fileToRead.close();

        } catch (Exception e){
            System.out.println("Cant read");
        }
        return lastLine;
    }

    // get the total number of haiku saved in haiku.csv file and return it as int
    public int getNumberOfEntries(String fileLocation){
        int totalNumberOfEntries = 0;
        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(fileLocation));
            reader.skip(Integer.MAX_VALUE);
            totalNumberOfEntries = reader.getLineNumber();
            System.out.println(totalNumberOfEntries);
        } catch (Exception e){
            System.out.println("cant read the file");
        }
        return totalNumberOfEntries;
    }
} // class ends here



