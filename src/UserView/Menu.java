package UserView;

import HaikuDomain.HaikuMethods;

import java.util.Scanner;

public class Menu {

    // instantiate necessary objects
    private Scanner scanner = new Scanner(System.in);
    PrintHaikuInformation printHaikuInformation = new PrintHaikuInformation();
    HaikuMethods haikuMethods = new HaikuMethods();
    GetUserInput getUserInput = new GetUserInput();


    /*
     * greet the user
     */
    public void welcomeUser(){
        getUserInput.getUserName();
        System.out.println("Hi " + getUserInput.name + ", welcome to the Haiku world");
    }

    /*
    * start an activity that user has chosen to do
     */
    public void startActivity(int userChoiceOfActivity){
        switch (userChoiceOfActivity){
            case 1:  // add a new Haiku to the haiku.csv file
                haikuMethods.addNewHaiku();
                break;
            case 2: // see last entries of haiku
                printHaikuInformation.printLastAddedHaiku();
                break;
            case 3: // print all saved haiku
                printHaikuInformation.printHaikus();
            default: break;
        }
    }

} // class ends here
