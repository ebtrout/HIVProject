/**
 * Constructor class for the Month objects used to create the calendar
 * @author Johnny O'Shea 
 * @author Grant Fountain 
 * @author Ethan Trout 
 * @author Leigh Ann Poultney
 */

public class Month { 

    /** Int for number of days in a month */
    public static final int DAYS_IN_MONTH  = 31;
    
    /** Int for the days in a week */
    public static final int DAYS_IN_WEEK = 7;
    
    /** Int for number of months in a year */
    public static final int MONTHS_IN_YEAR = 12;
    
    /** Int for number of years in a century */
    public static final int YEARS_IN_CENTURY = 100;
    
    /** Int for leap year frequency */
    public static final int LEAP_YEAR_FREQUENCY = 4;
    
    /** Int used for the number of weeks to use in the grid array */
    public static final int MAX_WEEKS_IN_MONTH = 6;
    
    /** Int used for the minimum number of weeks in a month */
    public static final int MIN_WEEKS_IN_MONTH = 4;
    
    /** Int for the number of days in February */
    public static final int DAYS_IN_FEB = 28;
    
    /** Int for the month of January */
    public static final int JAN = 1;
    
    /** Int for the month of February */
    public static final int FEB = 2;
    
    /** Int for the month of March */
    public static final int MAR = 3;
    
    /** Int for the month of April */
    public static final int APR = 4;
    
    /** Int for the month of May */
    public static final int MAY = 5;
    
    /** Int for the month of June */
    public static final int JUN = 6;
    
    /** Int for the month of July */
    public static final int JUL = 7;
    
    /** Int for the month of August */
    public static final int AUG = 8;
    
    /** Int for the month of September*/
    public static final int SEP = 9;
    
    /** Int for the month of October */
    public static final int OCT = 10;
    
    /** Int for the month of November */
    public static final int NOV = 11;
    
    /** Int for the month of December */
    public static final int DEC = 12;
    
    /** 2D array that stores the days of the month */
    private int[][] grid;
    
    /** String that stores the events */
    private String events;
    
    /** Int that represents the first day of the month */
    private int firstDay;
    
    /** Int that represents the number of the month */
    private int month;
    
    /** Int that represents the year */
    private int year;
    
    /** Int that represents the number of days in a month */
    private int numDaysInMonth;
    
    /** String that contains the name of the month */
    private String monthName;

    
   
    /** Constructor class for Month objects 
     * @param month int that represents the month 
     * @param year int that represents the year 
     * @throws IllegalArgumentException if months or year is less than 0 or if month is greater
     *         than 12
     */
     
    public Month(int month, int year) { 
    
        // Throwing Exceptions 
        if (month < 0 || month > MONTHS_IN_YEAR) {
            throw new IllegalArgumentException("Invalid month");
        }
        
        if (year < 0) { 
            throw new IllegalArgumentException("Invalid year");
        }
            
        this.month = month;
        this.year = year;
        this.events = "";
        this.firstDay = 0;
        this.grid = new int[MAX_WEEKS_IN_MONTH][DAYS_IN_WEEK];
        
        // Assigning the correct number of days in month and month name
        int temp = 0;
        String s = "";
        switch(month) { 
            case JAN: 
                s = "January";
                temp = DAYS_IN_MONTH;
                break;
            
            case MAR:
                s = "March";
                temp = DAYS_IN_MONTH;
                break;
            
            case MAY:
                s = "May";
                temp = DAYS_IN_MONTH;
                break;
            
            case JUL:
                s = "July";
                temp = DAYS_IN_MONTH;
                break;
            
            case AUG:
                s = "August";
                temp = DAYS_IN_MONTH;
                break;
            
            case OCT:
                s = "October";
                temp = DAYS_IN_MONTH;
                break;
            
            case DEC:
                s = "December";
                temp = DAYS_IN_MONTH;
                break;
                
            case APR:
                s = "April";
                temp = DAYS_IN_MONTH - 1;
                break;
            
            case JUN:
                s = "June";
                temp = DAYS_IN_MONTH - 1;
                break;
            
            case SEP:
                s = "September";
                temp = DAYS_IN_MONTH - 1;
                break;
            
            case NOV: 
                s = "November";
                temp = DAYS_IN_MONTH - 1;
                break;
                
            case FEB:
                if (year % LEAP_YEAR_FREQUENCY == 0) {
                    s = "February";
                    temp = DAYS_IN_FEB + 1;
                }
                else {
                    s = "February";
                    temp = DAYS_IN_FEB;
                }
            default:
                break;
        }
        
        // Assigning the instance variables after the switch statement
        this.monthName = s;
        this.numDaysInMonth = temp;
        
    }
    
    
    /** 
     * Getter method for the firstDay variable
     * @return firstDay as an int
     */
    
    public int getFirstDay() { 
        return this.firstDay;
    }
    
    /** 
     * Getter method for the year variable
     * @return year as an int
     */
    
    public int getYear() { 
        return this.year;
    }
    
    /** 
     * Getter method for the month variable
     * @return month as an int
     */
    
    public int getMonth() { 
        return this.month;
    }
    
    /** 
     * Getter method for the event variable
     * @return event as a String
     */
    
    public String getEvents() { 
        return this.events;
    }
    
    /** 
     * Getter method for the numDaysInMonth variable
     * @return numDaysInMonth as an int
     */
    
    public int getNumDaysInMonth() {
        return this.numDaysInMonth;
    }
    
    /** 
     * Getter method for the monthName variable
     * @return monthName as a String
     */
    
    public String getMonthName() {
        return this.monthName;
    }
    
    /** 
     * Setter method sets the first day of the month to proper day of the week
     */

    public void setFirstDay(){ 
        
        int x;
        int w;
        int z;
        int d = 1;
        
        // Using Zeller's Algorithm to find the first day
        w = this.year - ( (DAYS_IN_WEEK + DAYS_IN_WEEK) - this.month) 
            / MONTHS_IN_YEAR;

        x = w + w / LEAP_YEAR_FREQUENCY - w / YEARS_IN_CENTURY + w / (YEARS_IN_CENTURY * 
            LEAP_YEAR_FREQUENCY);

        z = this.month + MONTHS_IN_YEAR * (( (DAYS_IN_WEEK + DAYS_IN_WEEK) - 
            this.month) / MONTHS_IN_YEAR) - FEB;

        this.firstDay = (d + x + (DAYS_IN_MONTH * z) / 
            MONTHS_IN_YEAR) % DAYS_IN_WEEK;
    }
    
    /** 
     * Setter method sets the grid that will hold each day of the month
     */

    public void setGrid() {
        
        //Counter variable for the day
        int dayCount = 1;   

        
        // For loop for assigning values to the 2D array
        for(int i = 0; i < MAX_WEEKS_IN_MONTH; i ++) { 
            
            // If in the first row starts on the first day
            if (i == 0) { 
                for( int j = this.firstDay; j < DAYS_IN_WEEK; j++) {
                    this.grid[i][j] = dayCount;
                    dayCount++;
                }
            }
            // If in rows 1 - 3 assigns values 
            else if (i < MIN_WEEKS_IN_MONTH) { 
                for (int j = 0; j < DAYS_IN_WEEK; j++){ 
                    this.grid[i][j] = dayCount;
                    dayCount++;
                }
            }
            
            // If in row 4 and still has days to count, assigns values
            else if (i == MIN_WEEKS_IN_MONTH && dayCount <= this.numDaysInMonth) { 
                for (int j = 0; j < DAYS_IN_WEEK; j++) { 
                    if (dayCount <= numDaysInMonth) {
                        this.grid[i][j] = dayCount;
                        dayCount++;
                    }
                }
            }
            
            // If in row 5 and still has days to count, assigns values
            else if (i == MIN_WEEKS_IN_MONTH + 1 && dayCount <= this.numDaysInMonth) { 
                for (int j = 0; j < DAYS_IN_WEEK; j++) { 
                    if (dayCount <= numDaysInMonth) { 
                        this.grid[i][j] = dayCount;
                        dayCount++;
                    }
                }
            }
        }
        
    }
    
    /** 
     * Setter method for the events variable
     * @param event String that contains the event 
     */
     
    public void setEvents(String event) { 
        this.events += event + "\n";
            
    }
    
    /**
     * To string method for the month objects
     * @return a formatted string that contains the month array and month name
     */
     
    public String toString(){
        // Formatting the array into a string
        String s = "";
        for (int i = 0; i < MAX_WEEKS_IN_MONTH; i++){
            String line = "";
            String line2 = "";
            
            for (int j = 0; j < DAYS_IN_WEEK; j++) {
                int day = this.grid[i][j];
                String d = Integer.toString(day);
                
                // If the value is empty 
                if (d.equals("0")) {
                    line2 += ("    ");
                }
                
                else {
                    // If the value is a single digit number
                    if (d.length() == 1) { 
                        line += (d + "   ");
                        line2 += (d + "   ");
                    }
                    
                    // If the value is a double digit number
                    if (d.length() == 2) { 
                        line += (d + "  ");
                        line2 += (d + "  ");
                    }
                    
                }
            }
            
            // Testing if a week had no values 
            if (line.equals("")){
                s += "";
            }
            else { 
                s += line2 + "\n";
            }
            
        } 
        
        
        String temp = "";
        
        // Testing if there are events in the month and adds them if there is
        if(this.events.length() > 1) { 
            temp = ("SUN MON TUE WED THU FRI SAT\n" + s + "\nImportant dates: \n" + this.events); 
        }
        else { 
            temp = ("SUN MON TUE WED THU FRI SAT\n" + s);
        }
        return temp;

            
    }   
        
    
}
            
            
            






