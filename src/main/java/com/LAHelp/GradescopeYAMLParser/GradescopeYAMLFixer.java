package com.LAHelp.GradescopeYAMLParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GradescopeYAMLFixer {
	//referenced from: https://stackoverflow.com/questions/20039980/java-replace-line-in-text-file
	
	public static void old_main(String[] args) {
		System.out.println("Which file would you like to fix? (Put file in src/main/resources and enter just the name of the file. For example: submission_metadata.yml)");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		scanner.close();
    	String absoluteResource = new File("").getAbsolutePath() + "\\src\\main\\resources\\" + fileName;
    	System.out.println("File will be fixed if there are no errors.");
    	fix(absoluteResource);
	}
	
	public static String toFixedFile (String resource) {
		int aDotIndex = resource.indexOf(".");
		
		return resource.substring(0, aDotIndex) + "_fixed" + resource.substring(aDotIndex);
		
	}
	public static void main(String[] args) {
		String absoluteResource = null;
		if (args.length !=0 ) {
			absoluteResource = args[0];
		} else {
		System.out.println("Which file would you like to fix? (Put file in src/main/resources and enter just the name of the file. For example: submission_metadata.yml)");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		scanner.close();
    	 absoluteResource = new File("").getAbsolutePath() + "\\src\\main\\resources\\" + fileName;
		}
    	 System.out.println("File " + absoluteResource + "  will be fixed if there are no errors.");
    	fix(absoluteResource);
	}
	
	public static void fix(String resource) {
		try {
			BufferedReader file = new BufferedReader(new FileReader(resource));
			StringBuffer inputBuffer = new StringBuffer();
			String currLine;
			inputBuffer.append("---");
			inputBuffer.append('\n');
			inputBuffer.append("studentSubmissions:");
			inputBuffer.append('\n');
			while ((currLine = file.readLine()) != null) {
				String copiedLine = String.copyValueOf(currLine.toCharArray());
				StringBuilder copiedLineBuilder = new StringBuilder();
				if (copiedLine.matches("submission_\\d*:")) {
					copiedLineBuilder.append("- name: ");
					copiedLineBuilder.append(copiedLine.substring(0, copiedLine.length()-1));
				} else if (copiedLine.equals("---")) {
					continue;
				} else if (copiedLine.equals("studentSubmissions:")) {
					continue;
				}
				else {
					boolean removed = false;
					for (int i = 0; i < copiedLine.length(); i++) {
						if (!removed && copiedLine.charAt(i) == ':') {
							removed = true;
						}
						else if (Character.isAlphabetic(copiedLine.charAt(i))) {
							removed = true;
							copiedLineBuilder.append(copiedLine.charAt(i));
						} else {
							copiedLineBuilder.append(copiedLine.charAt(i));
						}
					}
				}
				inputBuffer.append(copiedLineBuilder.toString());
				inputBuffer.append('\n');
			}
			
			file.close();
			
			String inputString = inputBuffer.toString();
//			System.out.println(inputString);
			int aDotIndex = resource.indexOf(".");
			
//			String anOutputResource = resource.substring(0, aDotIndex) + "_fixed" + resource.substring(aDotIndex);
			FileOutputStream output = new FileOutputStream(toFixedFile(resource));
			output.write(inputString.getBytes());
			output.close();
			
		} catch (IOException e) {
			System.out.println("Woops.");
			System.out.println(e);
		}
	}
}
