package com.LAHelp.GradescopeYAMLParser;

public class TestGradescopeToSakaiSubmissions {
//	aFixedYAMLFile = args[0];
//	aGradescopeRoot = args[1];
//	anAssignmentName = args[2];
//	anOutputRoot = args[3];
//	aCSVOutput = args[4]; 
	public static final String GRADESCOPE_ROOT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\gradescope_a6_submissions (2)\\assignment_807844_export\\";
	public static final String ASSIGNMENT_NAME = "Assignment6";
	public static final String OUTPUT_ROOT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\Assignment6\\";;
	public static final String[] MY_ARGS = {
			GRADESCOPE_ROOT,
			ASSIGNMENT_NAME,
			OUTPUT_ROOT,
	};
//	String aGradescopeFolder = args[0];
//	String anAssignmentName = args[1];
//	String aSakaiFolder = args[2];
	public static void main (String[] args) {
		GradescopeToSakaiSubmissions.main(MY_ARGS);
		
	}

}
