import UserView.GetUserInput;
import UserView.Menu;



public class HaikuApp {
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
