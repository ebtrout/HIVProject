import java.util.*;
import java.io.*; 
import java.nio.file.*;

public class Volleyball {

		
    public static boolean isNumeric(char e) {
		boolean result = true;
		switch(e) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
			break;
			default: 
			result = false;
		}
		return result;
	}
	
	
	public static boolean isChar(char e) {
		boolean result = true;
		switch(e) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case '\'':
			case ',':
			case '.':break;
			default: 
			result = false;
		}
		return result;
	}
			
		
    public static void main(String[] args) {
      
        
        Scanner userInput = new Scanner(System.in);
        Scanner inputFile = null;
        Scanner outputFile = null;
		String infile = "D:/DeskingTop/VolleyballStats/f01.txt";
        Path path = null;
        Scanner inputFile2 = null;
		
        try { 
            inputFile = new Scanner(new FileInputStream(infile));
            inputFile2 = new Scanner(new FileInputStream(infile));

        }
        catch (FileNotFoundException e) {
            System.out.print("Unable to access input file: " + infile);
            System.exit(1);
        }
		
		
		int count = 0;
		String[] cols = new String[100];
		String[] colNames = new String[100];

			
			String line = inputFile.nextLine();
			Scanner lineScan = new Scanner(line);			
			int length = line.length();
			int n = 42;
			
			cols[0] = lineScan.next();
			colNames[0] = "A1";
			
			cols[1] = lineScan.next();
			colNames[1] = "A2";
			
			String temp1 = lineScan.next();
			cols[2] = temp1.substring(0,8);
			colNames[2] = "A3";

			cols[3] = temp1.substring(8,12);
			colNames[3] = "A4";
			
			cols[4] = lineScan.next();
			colNames[4] = "A6";

			
			cols[5] = lineScan.next();
			colNames[5] = "A7";
			
			String CSV = "";
			
			while(n < length -10){
				char c = line.charAt(n);
				char c2 = line.charAt(n+1);
				if (isNumeric(c)){
					CSV += c + ",";
				}
				
				else if (c == '-' && c2 == '1') {
					
					CSV += c + "" + c2 + ",";
					n++;
				}
				
				
				else if (isChar(c)) {
					int j = 0;
					for (int i = 1; i < 100; i++){
						
						char s = line.charAt(n + 1);
						
						if(isChar(s)){
							j++;
						}
						
						else if(isNumeric(s)){
							break;
						}
						else if(s == ' ') {
							if (line.char
							break;
						}
					}
					System.out.println("BROKEN");
				}
										n++;
							System.out.println(CSV);

			}
	}
	
	
}
