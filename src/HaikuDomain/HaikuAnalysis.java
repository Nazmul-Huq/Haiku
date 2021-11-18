package HaikuDomain;

import UserView.GetUserInput;

import java.util.ArrayList;

public class HaikuAnalysis {

    // this method will check if a submitted haiku is valid or not
    // to read rules for a haiku to be valid, please read comment section at the beginning of the HaikuApp
    public ArrayList<String> checkIfHaikuValid(String[] haikuLines){
        ArrayList<String> haikuErrors = new ArrayList<>(); // initialize an arraylist to store errors if any occurred
        int lineNumber = 1;

        for (int i = 0; i < haikuLines.length; i++) {

            // get individual haiku line
            String individualHaikuLine = haikuLines[i].toLowerCase();

            // check for syllables in each line, and add error message to haikuErrors, if any error
            if (getSyllableInLine(individualHaikuLine, lineNumber) == false) {
                haikuErrors.add("you have more or less syllable than accepted in line - " + lineNumber);
            }

            // check for repeated words in each line, and add error message to haikuErrors, if any error found
            if (checkRepeatedWordInLine(individualHaikuLine)) { haikuErrors.add("you have repeated word in line - " + lineNumber);}

            lineNumber++;
        }

        return haikuErrors;
    }

    // method to check for number of syllable in a line
    public boolean getSyllableInLine(String haikuLine, int lineNumber){

        // to count the total number of syllable in a line
        int totalNoSyllableInLine = 0;

        // make word array form line and make them lower case
        String[] words =  haikuLine.toLowerCase().split(" ");
        for (int i = 0; i < words.length ; i++) {

            // get a word from the given line
            String individualWordInLine = words[i];

            // get number of syllable in the word
            int nosSyllableInWord = getNoSyllableInWord(individualWordInLine);

            // add the number of syllable in the total line count
            totalNoSyllableInLine += nosSyllableInWord;
        }

        if ( (lineNumber == 1 || lineNumber == 3 ) && ( totalNoSyllableInLine == 5 ) ) {
            return true;
        } else if (lineNumber == 2 && totalNoSyllableInLine == 7) {
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
        word = getWordRemovingTrailingSymbol(word);

        // check word length and based on word length perform different action
        int wordLength = word.length();
        if (wordLength > 0 && wordLength < 4) {
            // if word length is less than 3 so there is only one syllable
            nosSyllableInWord += 1;
        } else {
            // if word length more than three check for repeating vowel consonant pattern
            nosSyllableInWord += getNosSyllableInLongWord(word);
        }

        return nosSyllableInWord;
    }

    // this method will check for number of syllables in word which has more than 3 letters
    private int getNosSyllableInLongWord(String word){
        int syllable = 0;

        // make a char array from given word
        char[] charsFromWord = word.toCharArray();

        // iterate over char array and compare chars
        for (int i = 0; i < charsFromWord.length-2; i++) {

            // get 3 consecutive chars from char array and check if char is vowel or not
            char firstChar = charsFromWord[i];
            boolean isChar1Vowel = isCharVowel(firstChar);
            char secondChar =charsFromWord[i+1];
            boolean isChar2Vowel = isCharVowel(secondChar);
            char thirdChar = charsFromWord[i+2];
            boolean isChar3Vowel = isCharVowel(thirdChar);

            // if char 1 is consonant, char 2 is vowel and char 3 is consonant, so this is one syllable
            // if char 1 is consonant, char 2 is vowel and char 3 is vowel, so this is one syllable
            // there is no syllable
            if (!isChar1Vowel && isChar2Vowel && !isChar3Vowel) {
                syllable += 1;
            } else if (!isChar1Vowel && isChar2Vowel && isChar3Vowel) {
                syllable += 1;
            }
        }
        return syllable;
    }

    // check if a given char is vowel or not
    private boolean isCharVowel(char givenChar){
        if(givenChar == 'a' || givenChar == 'e' || givenChar == 'i' || givenChar == 'o' || givenChar == 'u' ){
            return true;
        }
        return false;
    }

    // methods to remove any trailing symbol (",", "!" etc) from the end of the given word
    private String getWordRemovingTrailingSymbol(String word){

        //get size of word
        int lengthOfWord = word.length();

        // fist get the last letter as a string
        String lastLetter = word.substring((lengthOfWord-1), lengthOfWord);
        // then convert the string to a char
        char lastChar = lastLetter.charAt(0);

        // compare the char with char value
        // if the char is not an alphabetic character then reset the word by trimming the last letter
        if (lastChar < 97 || lastChar > 122) {
            word = word.substring(0, (lengthOfWord-1));
        }

        return word;
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
