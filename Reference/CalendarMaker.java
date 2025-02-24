import java.util.*;
 /**
 * This is the Calendar maker, here the logic from the other classes is called
 * and used to let the user create their calendar. They can list the months of any
 * year that is entered in the command line, and assign special dates to any month.
 * The events will be printed in a list under the months. This is continued until the
 * the user decides to exit the program.
 * @author Johnny O'Shea
 * @author Ethan Trout
 * @author Leigh Anne Poultney
 * @author Grant Fountain
 */
 
public class CalendarMaker {
    
    /** Constant that represents the month class */
    private Month months; 
    
    /** Constant that represents the year class */
    private Year year; 
    
    /** Int that represents the number of days in a year */
    public static final int MONTHS_IN_YEAR = 12;
    
/**
 * This is the main method for the calendar maker program. Here the user will enter 
 * a desired year in the command line and then they will be continually prompted
 * if they want to (L) list the months and events, (D) add events to particular
 * days or (Q) quit the program.
 * @param args command-line parameters the year that the user wants to see
 */
    public static void main(String[] args) {
        
        //returns an error if there is not one argument in the command line
        if (args.length != 1) {
            System.out.println("Usage: java CalendarMaker <year>");
            System.exit(1);
        }
        
        try {
            int number = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.out.println("Usage: java CalendarMaker (int) <year>");
            System.exit(1);
        }
        //returns an error if the command line argument is not an integer
        
        int number = Integer.parseInt(args[0]);
        Year year = new Year(number);
        Scanner scnr = new Scanner(System.in);
        String option = "";
        
        //continually prompts the user the main menu until q is pressed
        while (!option.equalsIgnoreCase("Q")) {
            
            //calls the main menu method to show the user the interface
            mainMenu();
            
            //Gets the users input for what option they want to choose
            option = scnr.nextLine();

            //if the user enters L a list of all the items will be printed
            if (option.equalsIgnoreCase("L")) {
                
                System.out.println();
                System.out.println(year.toString());
                
            }
            //if the user enters D they want to add an event
            else if (option.equalsIgnoreCase("D")) {
                int day = 0;
                int month = 0; 
                String event = "";
                String done = "";
                boolean end = false;
                boolean validDate = true;
                
                while (end == false) {
                    System.out.println();
                    System.out.print("What day would you like to add an event to "
                                    + "(e.g. MM DD : 12 25)? ");
                    
                    //Making a line scanner and counter
                    String dateLine = "";
                    dateLine = scnr.nextLine();
                    int spaceCount = 0;
                    Scanner linescan = new Scanner(dateLine);
                    
                    
                    try {
                        
                        // Testing if there are too many arguments 
                        for (int i = 0; i < dateLine.length(); i++) { 
                            if (dateLine.charAt(i) == ' '){
                                spaceCount++;
                            }
                        }
                    
                        if (spaceCount != 1) { 
                            throw new Exception("Input Formatted Incorrectly");
                        }
                        
                        month = linescan.nextInt();
                        day = linescan.nextInt();
                        validDate = true;
                        
                        
                    }
                    catch (Exception e) {
                        System.out.println("Invalid date");
                        validDate = false;
                        linescan.next();
                    }
                    if (validDate == true) {
                        try {
                            Month[] months = year.getMonth();
                            if ((day > months[month - 1].getNumDaysInMonth() || day < 1)
                                && validDate == true) { 
                                System.out.println("Invalid day");
                                validDate = false;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid month");
                            validDate = false;
                        }
                    }
                    
                    if (validDate == true) {
                        System.out.print("What is the name of the event? ");
                        event = scnr.nextLine();
                        try {
                            year.addEvent(day, month, event);
                        }
                        catch (Exception e) {
                            System.out.println("Invalid date");
                            validDate = false;
                        }
                        System.out.print("Would you like to add another event (y/n)? ");
                        done = scnr.nextLine();
                        if (done.equalsIgnoreCase("N")) {
                            end = true;
                        }
                    }
                }
                System.out.println();
                
            }
            //If the user enters something that is not a letter on the list
            else if (!option.equalsIgnoreCase("Q")) {
                
                //Error message
                System.out.println("Invalid option");
                System.out.println();
                
            }
        //q is pressed
        }
    }   
    
    /** This method creates a standard display menu that the user will see
     */
    public static void mainMenu() {
        
        //Creates the main display menu that will be continuously prompted
        System.out.println("Welcome to your personal calendar");
        System.out.println();
        System.out.println("D - Add note for a day");
        System.out.println("L - List calendar and events");
        System.out.println("Q - Quit program");
        System.out.println();
        System.out.print("Choose option: "); 
    }  
}








