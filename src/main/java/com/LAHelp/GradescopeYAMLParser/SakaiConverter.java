package com.LAHelp.GradescopeYAMLParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

import com.LAHelp.ParseHelpers.StudentSubmissions;
import com.LAHelp.ZipHelper.Zip;

public class SakaiConverter {
	private static final DateTimeFormatter SOURCE_DATE_TIME_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS 'Z'");

    private static final DateTimeFormatter TARGET_DATE_TIME_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC"));

	private static final String SAKAI_FOLDER = "Sakai";
	private static final String GRADESCOPE_FOLDER = "Gradescope";
	private static final String CONVERSION_FOLDER = "Conversion";
	private static final String FEEDBACK_FOLDER = "Feedback Attachment(s)";
	private static final String SUBMISSIONS_FOLDER = "Submission attachment(s)";
	private static final String TIMESTAMP_FILE = "timestamp.txt";
	private String assignmentName = "Assignment1.zip";
	
	public SakaiConverter(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public void deleteFolder(File file){
		for (File subFile : file.listFiles()) {
			if(subFile.isDirectory()) {
				deleteFolder(subFile);
			} else {
				subFile.delete();
			}
		}
		file.delete();
	}
	
	public void createSakaiFolders(StudentSubmissions studentSubmissions) throws IOException {
		Path root = Paths.get(".");
		Path sakaiFolder = root.resolve(CONVERSION_FOLDER).resolve(SAKAI_FOLDER);
		Path gradescopeFolder = root.resolve(CONVERSION_FOLDER).resolve(GRADESCOPE_FOLDER);
		if (Files.exists(sakaiFolder)) {
			deleteFolder(new File(sakaiFolder.toAbsolutePath().toString()));
		}
		Files.list(gradescopeFolder).forEach(gradescopeSubmissionDirectory -> {
			//in sakai folder
			//create a user directory for each student
			//in user directory
			//create two folders: feedback attachment(s) and submission attachment(s)
			//zip up gradescope submission folder and put it inside submission attachment(s)
			//convert gradescope timestamp to sakai timestamp and put in user directory
			
			String submissionID = gradescopeSubmissionDirectory.getFileName().toString();
			String studentName = studentSubmissions.getMap().get(submissionID).getSubmitters().get(0).getName();
			String[] studentNameSplit = studentName.split(" ");
			String studentOnyen = studentSubmissions.getMap().get(submissionID).getSubmitters().get(0).getSid();
			System.err.println("Creating folder for " + studentOnyen + " " + Arrays.toString(studentNameSplit));

			String studentDirectoryPath = studentNameSplit[studentNameSplit.length-1] + ", " + studentNameSplit[0] + "(" + studentOnyen + ")";
			Path studentDirectory = sakaiFolder.resolve(studentDirectoryPath);
			int i = 1;
			while (Files.exists(studentDirectory)) {
				studentDirectory = sakaiFolder.resolve(studentDirectoryPath + "submission" + i);
				i++;
			}
			Path sakaiFeedbackFolder = studentDirectory.resolve(FEEDBACK_FOLDER);
			Path sakaiSubmissionsFolder = studentDirectory.resolve(SUBMISSIONS_FOLDER);
			try {
				if (!Files.exists(sakaiSubmissionsFolder)) {
					Files.createDirectories(sakaiFeedbackFolder);
					Files.createDirectories(sakaiSubmissionsFolder);
				}
				Zip.zipDir(gradescopeSubmissionDirectory.toAbsolutePath(), sakaiSubmissionsFolder.toAbsolutePath().resolve(assignmentName), assignmentName);
				String rawTimestamp = studentSubmissions.getMap().get(submissionID).getCreated_at();
		        TemporalAccessor gradescopeTimestamp = SOURCE_DATE_TIME_FORMATTER.parse(rawTimestamp);
				String sakaiTimestamp = TARGET_DATE_TIME_FORMATTER.format(gradescopeTimestamp);
				Files.write(studentDirectory.resolve(TIMESTAMP_FILE), sakaiTimestamp.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	public void createSakaiFolders(String aGradescopeRoot, String anOutputRoot, StudentSubmissions aStudentSubmissions) throws IOException {
		Path root = null;
		
		Path gradescopeFolder = null;
			Path sakaiFolder = Paths.get(anOutputRoot);
			gradescopeFolder = Paths.get(aGradescopeRoot);
		 
//		else {
//		
//		
//		 root = Paths.get(".");
//		 sakaiFolder = root.resolve(CONVERSION_FOLDER).resolve(SAKAI_FOLDER);
//		 gradescopeFolder = root.resolve(CONVERSION_FOLDER).resolve(GRADESCOPE_FOLDER);
//		}
		if (Files.exists(sakaiFolder)) {
			deleteFolder(new File(sakaiFolder.toAbsolutePath().toString()));
		}
		Files.list(gradescopeFolder).forEach(gradescopeSubmissionDirectory -> {
			//in sakai folder
			//create a user directory for each student
			//in user directory
			//create two folders: feedback attachment(s) and submission attachment(s)
			//zip up gradescope submission folder and put it inside submission attachment(s)
			//convert gradescope timestamp to sakai timestamp and put in user directory
			if (!gradescopeSubmissionDirectory.toFile().isFile()) {
				
			
			String submissionID = gradescopeSubmissionDirectory.getFileName().toString();
			String studentName = aStudentSubmissions.getMap().get(submissionID).getSubmitters().get(0).getName();
			String[] studentNameSplit = studentName.split(" ");
			String studentOnyen = aStudentSubmissions.getMap().get(submissionID).getSubmitters().get(0).getSid();
			String studentDirectoryPath = studentNameSplit[studentNameSplit.length-1] + ", " + studentNameSplit[0] + "(" + studentOnyen + ")";
			Path studentDirectory = sakaiFolder.resolve(studentDirectoryPath);
			int i = 1;
			while (Files.exists(studentDirectory)) {
				studentDirectory = sakaiFolder.resolve(studentDirectoryPath + "submission" + i);
				i++;
			}
			Path sakaiFeedbackFolder = studentDirectory.resolve(FEEDBACK_FOLDER);
			Path sakaiSubmissionsFolder = studentDirectory.resolve(SUBMISSIONS_FOLDER);
			try {
				if (!Files.exists(sakaiSubmissionsFolder)) {
					Files.createDirectories(sakaiFeedbackFolder);
					Files.createDirectories(sakaiSubmissionsFolder);
				}
				Zip.zipDir(gradescopeSubmissionDirectory.toAbsolutePath(), sakaiSubmissionsFolder.toAbsolutePath().resolve(assignmentName), assignmentName);
				String rawTimestamp = aStudentSubmissions.getMap().get(submissionID).getCreated_at();
		        TemporalAccessor gradescopeTimestamp = SOURCE_DATE_TIME_FORMATTER.parse(rawTimestamp);
				String sakaiTimestamp = TARGET_DATE_TIME_FORMATTER.format(gradescopeTimestamp);
				Files.write(studentDirectory.resolve(TIMESTAMP_FILE), sakaiTimestamp.getBytes());
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}});
	}

}
