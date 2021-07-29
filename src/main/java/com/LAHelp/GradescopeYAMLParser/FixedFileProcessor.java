package com.LAHelp.GradescopeYAMLParser;

import java.io.IOException;
import java.util.Scanner;

import com.LAHelp.ParseHelpers.GradescopeParser;
import com.LAHelp.ParseHelpers.StudentSubmissions;

public class FixedFileProcessor 
{
//    public static void main(String[] args)
//    {    	
//    	System.out.println("Which yml file should be used during the conversion? (Put file in src/main/resources and enter just the name of the file. For example: submission_metadata.yml)");
//    	Scanner scanner = new Scanner(System.in);
//    	String resource = scanner.nextLine();
//    	System.out.println("What is the name of this assignment?");
//    	String assignmentName = scanner.nextLine();
//    	scanner.close();
//    	System.out.println("File will be parsed for use in conversion. If file has already been fixed and there are errors, keep running this again. File may be out of sync in Eclipse.");
//    	
//    	//Parsing the data in the YAML file into classes.
//    	GradescopeParser gradescopeParser = new GradescopeParser(resource);
//    	StudentSubmissions studentSubmissions = gradescopeParser.parse();
//    	
//    	//Using the parsed data to build a grades.csv file
//    	CSVConverter csvConverter = new CSVConverter();
//    	try {
//			csvConverter.createCSVFile(assignmentName, gradescopeParser.getDataForCSVConversion(studentSubmissions));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	//Converting the submissions in the Gradescope folder to Sakai submissions, using the data obtained from YAML parsing to help.
//    	SakaiConverter sakaiConverter = new SakaiConverter(assignmentName);
//    	try {
//    		/*
//    		 * For this to work, need to have directory structure like: 
//    		 * --> GradescopeYAMLParser (This is the current project folder)
//    		 * 	   --> Conversion
//    		 *         --> Gradescope
//    		 *             --> submission_12345678
//    		 *             --> submission_23456789
//    		 *             --> submission_34567890
//    		 *         --> Sakai
//    		 * */
//			sakaiConverter.createSakaiFolders(studentSubmissions);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    public static void main(String[] args)
    {    	
    	String anAssignmentName = null;
    	String aFixedYAMLFile = null;
    	String aCSVOutput = null;
    	String anOutputRoot = null;
    	String aGradescopeRoot = null;

    	if (args.length >= 4) {    		;
    		aFixedYAMLFile = args[0];
    		aGradescopeRoot = args[1];
    		anAssignmentName = args[2];
    		anOutputRoot = args[3];
    		aCSVOutput = args[4];    		
    		
    	} else {
    	System.out.println("Which yml file should be used during the conversion? (Put file in src/main/resources and enter just the name of the file. For example: submission_metadata.yml)");
    	Scanner scanner = new Scanner(System.in);
    	aFixedYAMLFile = scanner.nextLine();
    	System.out.println("What is the name of this assignment?");
    	 anAssignmentName = scanner.nextLine();
    	scanner.close();
    	}
    	System.out.println("File will be parsed for use in conversion. If file has already been fixed and there are errors, keep running this again. File may be out of sync in Eclipse.");
    	
    	//Parsing the data in the YAML file into classes.
    	GradescopeParser gradescopeParser = new GradescopeParser(aFixedYAMLFile);
    	StudentSubmissions studentSubmissions = gradescopeParser.parse();
    	
//    	//Using the parsed data to build a grades.csv file
//    	CSVConverter csvConverter = new CSVConverter();
//    	try {
//			csvConverter.createCSVFile(anOutputRoot, anAssignmentName, gradescopeParser.getDataForCSVConversion(studentSubmissions));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	//Converting the submissions in the Gradescope folder to Sakai submissions, using the data obtained from YAML parsing to help.
    	SakaiConverter sakaiConverter = new SakaiConverter(anAssignmentName);
    	try {
    		/*
    		 * For this to work, need to have directory structure like: 
    		 * --> GradescopeYAMLParser (This is the current project folder)
    		 * 	   --> Conversion
    		 *         --> Gradescope
    		 *             --> submission_12345678
    		 *             --> submission_23456789
    		 *             --> submission_34567890
    		 *         --> Sakai
    		 * */
			sakaiConverter.createSakaiFolders(aGradescopeRoot, anOutputRoot, studentSubmissions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Using the parsed data to build a grades.csv file
    	CSVConverter csvConverter = new CSVConverter();
    	try {
			csvConverter.createCSVFile(anOutputRoot, anAssignmentName, gradescopeParser.getDataForCSVConversion(studentSubmissions));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
