package UserView;

import java.util.Scanner;

public class GetUserInput {

    private Scanner scanner = new Scanner(System.in);

    // name of the author is static so that once it set, no need to initiate again and all class have access to
    public static String name;



    /*
     * ask user to enter a name and return the name
     */
    public void getUserName(){
        System.out.println("Enter your full name");
        this.name = scanner.nextLine();
    }

    /*
     * ask user to choose an activity and return the activity as integer
     */
    public int getUserChoiceOfActivity(){
        System.out.println("1 - add a new Haiku, 2- see last added haiku, 3- See all saved Haiku, 9 -  exit");
        int userChoice = Integer.parseInt(scanner.nextLine());
        return userChoice;
    }

    /*
     * get the Haiku lines from user
     */
    public String[] getHaikuLines(){
        String[] haikuLines = new String[3];
        for (int i = 0; i < 3; i++) {
            int lineNumber = i+1;
            System.out.println("Enter First line - "+ lineNumber);
            haikuLines[i] = scanner.nextLine();
        }
        return haikuLines;
    }


} // class ends here
