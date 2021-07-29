package com.LAHelp.GradescopeYAMLParser;

public class GradescopeToSakaiSubmissions {
	
	public static void main (String[] args) {
		String aGradescopeFolder = args[0];
		String anAssignmentName = args[1];
		String aSakaiFolder = args[2];
		String anOriginalYMLFile = args[0] + "submission_metadata.yml";
		String aFixedYMLFile = GradescopeYAMLFixer.toFixedFile(anOriginalYMLFile);
		String aGradesCSVFile = aSakaiFolder + "grades.csv";
		String[] aFixerArgs = {
				anOriginalYMLFile,
		};
		GradescopeYAMLFixer.main(aFixerArgs);
//		public static final String[] MY_ARGS = {
//				FIXED_YAML_FILE,
//				GRADESCOPE_ROOT,
//				ASSIGNMENT_NAME,
//				OUTPUT_ROOT,
//				CSV_OUPUT
//		};
		String[] aFixedFileProcessorArgs = {
				aFixedYMLFile,
				aGradescopeFolder,
				anAssignmentName,
				aSakaiFolder,
				aGradesCSVFile
		};
		FixedFileProcessor.main(aFixedFileProcessorArgs);
		
	}

}
