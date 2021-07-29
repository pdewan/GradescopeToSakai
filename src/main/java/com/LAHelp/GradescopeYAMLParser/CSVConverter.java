package com.LAHelp.GradescopeYAMLParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {
	public static String GRADES_CSV_FILE = "grades.csv";
	private static final String CONVERSION_FOLDER = "Conversion";
	
	public CSVConverter() {
		
	}
	
	public void createCSVFile(String assignmentName, List<String> dataLines) throws IOException {
		Path root = Paths.get(".").resolve(CONVERSION_FOLDER);
		Path csvFileLocation = root.resolve(GRADES_CSV_FILE);
		Files.deleteIfExists(csvFileLocation);
		Files.createFile(csvFileLocation);
		
		List<String> lines = new ArrayList<>();
		lines.add(assignmentName + ", SCORE_GRADE_TYPE,,,");
		lines.add(",,,,");
        lines.add("Display ID,ID,Last Name,First Name,Grade,Submission,Late Submission");
        if (dataLines != null)
        	lines.addAll(dataLines);
        Files.write(csvFileLocation, lines);
	}
	public void createCSVFile(String aRoot, String assignmentName, List<String> dataLines) throws IOException {
		Path aConversionFolder = null;
		Path aGradesCSVFilePath = null;
		if (aRoot != null) {
			aConversionFolder = Paths.get(aRoot + "/" + CONVERSION_FOLDER );
			aGradesCSVFilePath = Paths.get(aRoot + "/" + GRADES_CSV_FILE );
		} else {
		
	    aConversionFolder = Paths.get(".").resolve (CONVERSION_FOLDER);
	    aGradesCSVFilePath = aConversionFolder.resolve(GRADES_CSV_FILE);
		}
		Files.deleteIfExists(aGradesCSVFilePath);
		
		File aGradesCSVFile = new File (aGradesCSVFilePath.toString());
		aGradesCSVFile.getParentFile().mkdirs();
		Files.createFile(aGradesCSVFilePath);

		
		List<String> lines = new ArrayList<>();
		lines.add(assignmentName + ", SCORE_GRADE_TYPE,,,");
		lines.add(",,,,");
        lines.add("Display ID,ID,Last Name,First Name,Grade,Submission,Late Submission");
        if (dataLines != null)
        	lines.addAll(dataLines);
        Files.write(aGradesCSVFilePath, lines);
	}
	
}
