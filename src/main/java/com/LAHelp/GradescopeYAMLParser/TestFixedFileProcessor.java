package com.LAHelp.GradescopeYAMLParser;

public class TestFixedFileProcessor {
//	aFixedYAMLFile = args[0];
//	aGradescopeRoot = args[1];
//	anAssignmentName = args[2];
//	anOutputRoot = args[3];
//	aCSVOutput = args[4]; 
	public static final String FIXED_YAML_FILE = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\gradescope_a6_submissions (2)\\assignment_807844_export\\submission_metadata_fixed.yml";;
	public static final String GRADESCOPE_ROOT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\gradescope_a6_submissions (2)\\assignment_807844_export\\";
	public static final String ASSIGNMENT_NAME = "Assignment6";
	public static final String OUTPUT_ROOT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\Assignment6";;
	public static final String CSV_OUPUT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\Assignment6\\grades.csv";
	public static final String[] MY_ARGS = {
			FIXED_YAML_FILE,
			GRADESCOPE_ROOT,
			ASSIGNMENT_NAME,
			OUTPUT_ROOT,
			CSV_OUPUT
	};
	public static void main (String[] args) {
		FixedFileProcessor.main(MY_ARGS);
		
	}

}
