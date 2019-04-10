/*
 * CustomerList.java
 * Quentin Magoon
 * April 4, 2019
 * This program recordes and stores names to be used for a company customer list
 */

package customerlist;

import java.io.*;
import javax.swing.*;
import java.util.Scanner;


public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
	    //asks user to enter in required informaation
         String customer = JOptionPane.showInputDialog("Enter name, address, and postal code of"
            +  " customer: ");
	    
    		//reads text file and detects errors
		File textFile = new File("customers");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		
		try {
                    in = new FileReader(textFile);
                    readFile = new BufferedReader(in);
                    while ((lineOfText = readFile.readLine()) != null ) {
                            System.out.println(lineOfText);
                    }
                    readFile.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File does not exist or could not be found.");
                    System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
                    System.out.println("Problem reading file.");
                    System.err.println("IOException: " + e.getMessage());
                }
	       
        //writes text and detects errors
        File dataFile = new File("customers");
        FileWriter out;
        BufferedWriter writeFile;
        Scanner input = new Scanner(System.in);
        double score;
        String name;

        try {
            out = new FileWriter(dataFile, true);
            writeFile = new BufferedWriter(out);
            for (int i = 0; i < 2; i++) {
                System.out.print("Enter student name: ");
                name = input.next();
                System.out.print("Enter test score: ");
                score = input.nextInt();
                writeFile.write(name);
                writeFile.newLine();
                writeFile.write(String.valueOf(score));
                writeFile.newLine();
            }
            writeFile.close();
            out.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
    
    
    
