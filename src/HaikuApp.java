import UserView.GetUserInput;
import UserView.Menu;



public class HaikuApp {
    /*
    * rules to check to determine if a haiku is valid or not
    * Rule-1: A Haiku must have exactly 3 lines
    * Rule-1: In a Haiku line no word can't be repeated
    * Rule-1: In line 1 and 3 must have 5 syllables and in line 2 must have 7 syllables
    * Syllable rule:
                    * any (consonant + vowel + consonant) pattern will be considered as 1 syllable
                    * any (consonant + vowel + vowel) pattern will be considered as 1 syllable
     */

    /*
    * in this app once a haiku is submitted following is going to happen
    * fist going to check if haiku valid or not
    * if valid, will be saved both as a pdf file and in haiku.csv file
    * if not, will print what rules was violated
     */

    // instantiate necessary objects
    Menu menu;
    GetUserInput getUserInput;

    // make haiku app constructor
    public HaikuApp(){
        this.menu = new Menu();
        this.getUserInput = new GetUserInput();
    }

    public static void main(String[] args) {


        // create instance of haikuApp
        HaikuApp haikuApp = new HaikuApp();

        // greet the user
        haikuApp.menu.welcomeUser();


        /*
        * start activities
        * finish one activity, then ask for another activity, continue activities until user enter 9
        * if user enter 9 , then stop activities and stop the app
         */
        while (true){

            // get what user like to do (an activity fx, add haiku, see haiku....)
            int userChoiceOfActivity = haikuApp.getUserInput.getUserChoiceOfActivity();

            // start activities
            if (userChoiceOfActivity == 9 ) {
                // if user press 9, then close the app
                break;
            } else {
                haikuApp.menu.startActivity(userChoiceOfActivity);
            }
        }

    } // main() ends here

} // class ends here
