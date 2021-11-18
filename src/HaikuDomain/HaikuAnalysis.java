package HaikuDomain;

import org.apache.pdfbox.contentstream.operator.text.SetTextRise;

import java.util.ArrayList;
import java.util.Locale;

public class HaikuAnalysis {

    public ArrayList<String> checkIfHaikuValid(String[] haikuLines){
        ArrayList<String> haikuErrors = new ArrayList<>(); // initialize an arraylist to store errors if any occurred
        int lineNumber = 1;

        for (int i = 0; i < haikuLines.length; i++) {

            // get individual haiku line
            String individualHaikuLine = haikuLines[i].toLowerCase();

            // check for syllables in each line, and add error message to haikuErrors, if any error
            if (checkSyllableInLine(individualHaikuLine, lineNumber) == true) { haikuErrors.add("you have more or less syllable than accepted in line - " + lineNumber);  }

            // check for repeated words in each line, and add error message to haikuErrors, if any error found
            if (checkRepeatedWordInLine(individualHaikuLine) == true) { haikuErrors.add("you have repeated word in line - " + lineNumber);}

            lineNumber++;
        }

        return haikuErrors;
    }

    // method to check for number of syllable in a line
    public boolean checkSyllableInLine(String haikuLine, int lineNumber){
        /*
        a non repeating vowel
        steen has 1 sylllable
        Langeland has 3 syllables
         */

        int totalNoSyllableInLine = 0;
        String[] words =  haikuLine.toLowerCase().split(" ");
        for (int i = 0; i < words.length ; i++) {

            // get a word from the given line
            String individualWordInLine = words[i];

            // get number of syllable in the word
            int nosSyllableInWord = getNoSyllableInWord(individualWordInLine);

            // add the number of syllable in the total line count
            totalNoSyllableInLine += nosSyllableInWord;
        }

        if (lineNumber == 1 || lineNumber == 3 && totalNoSyllableInLine != 5 ) {
            return true;
        } else if (lineNumber == 1 && totalNoSyllableInLine != 7) {
            return true;
        }
        return false;
    }

    /*
    * methods to get the number of syllable in a word
     * first trim the word to get rid of any symbol (",", "!", "." etc) at the end of the word
     * then check the size of the word
     * if word is composed of 3 or less letter so there is only one syllable
     *  if word is composed of more than 3 letters, need to check for repeating vowels and consonants
     */
    private int getNoSyllableInWord(String word){
        int nosSyllableInWord = 0;

        // first remove any trailing symbol at end from the word
        String wordAfterTrailingSymbolRemoved = getWordRemovingTrailingSymbol(word);

        // check word length and based on word length perform different action
        int wordLength = wordAfterTrailingSymbolRemoved.length();
        if (wordLength > 0 && wordLength < 4) {
            // if word length is less than 3 so there is only one syllable
            nosSyllableInWord += 1;
        } else {
            // if word length more than three check for repeating vowel consonant pattern

        }
        char[] charsFromWord = word.toCharArray();
        for (int i = 0; i < charsFromWord.length; i++) {

        }
        return nosSyllableInWord;
    }



    public String getWordRemovingTrailingSymbol(String word){
        String pureWord = word;

        return pureWord;
    }

    // method to check for repeated word in a line
    private boolean checkRepeatedWordInLine(String haikuLine){
        String[] words =  haikuLine.split(" ");
        for (int i = 0; i < words.length-1 ; i++) {
            int j = i+1;
            for (int k = j ; k < words.length; k++) {

                if (words[i].equals(words[(k)])) {
                    return true;
                }
            }

        }
        return false;
    }

} // class ends here
