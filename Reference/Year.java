/** 
 * Constructor class for the Year objects that contains an array that stores all 12 months 
 * of the year and the year number
 * @author Johnny O'Shea 
 * @author Grant Fountain 
 * @author Ethan Trout 
 * @author Leigh Ann Poultney
 */
public class Year { 
    
    /** Int that represents the number of days in a year */
    public static final int MONTHS_IN_YEAR = 12;
    
    /** Array that stores the months of the year */
    private Month[] months;
    
    /** Int that stores the year value */
    private int year;
    
    /** Int that stores the length of the line to go above each month used to center the header */
    public static final int MONTH_HEADER_LENGTH = 27;

    /**
     * Constructor class that creates the array of months in the year 
     * @param year int that contains the year number 
     */
     
    public Year(int year) {
        this.months = new Month[MONTHS_IN_YEAR];
        for (int i = 1; i <= MONTHS_IN_YEAR; i++) { 
            Month m = new Month(i, year);
            m.setFirstDay();
            m.setGrid();
            this.months[i - 1] = m;
        }
        this.year = year;
    }
            
    /** 
     * Mutator method that adds an event to a month
     * @param day int that stores what day will be displayed as an important day
     * @param month int that stores what month the important day will be stores in
     * @param event String that contains the user inputted event description
     * @throws IllegalArgumentException if the day is bigger than the number of days
     *         in the month, if month is greater than 12, or if event is null 
     */
    
    public void addEvent(int day, int month, String event) { 
        
        // Throwing exceptions
        if (day > this.months[month - 1].getNumDaysInMonth() || day < 1) { 
            throw new IllegalArgumentException("Invalid day");
        }
        if (month > MONTHS_IN_YEAR) { 
            throw new IllegalArgumentException("Invalid month");
        }
        if (event == null) { 
            throw new IllegalArgumentException("Null event");
        }
        
        // Creating the formatted string 
        String i = Integer.toString(day);
        String s = (this.months[month - 1].getMonthName() + " " + i + ": " + event);
        
        // Calling the setEvents method to add the method to the month
        this.months[month - 1].setEvents(s);
                                 
    }
    
    /** 
     * To string method that ouputs all of the months in a year as a formatted string 
     * @return returns all the arrays of all of the months in the year as a formatted string
     */
    
    public String toString() { 
    
        String s = "";
        for (int i = 0; i < MONTHS_IN_YEAR; i++) {
            
            String d = this.months[i].getMonthName() + " " + this.year;
            int center = MONTH_HEADER_LENGTH - d.length();
            
            for (int j = 0; j < ( (MONTH_HEADER_LENGTH - d.length()) / 2); j++){
                s += " ";
            }
            
            s += (this.months[i].getMonthName() + " " + this.year + 
                "\n" + this.months[i].toString() + "\n");
        }
        return s;
    }
    
    /** 
     * Getter method for the months object
     * @return month Month as an array
     */
    
    public Month[] getMonth() {
        return this.months;
    }
    
}



