package com.LAHelp.GradescopeYAMLParser;

public class TestFixer {
	public static final String ORIGINAL_YAML_FILE = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\gradescope_a6_submissions (2)\\assignment_807844_export\\submission_metadata.yml";
	static final String[] MY_ARGS = {
			ORIGINAL_YAML_FILE,
	};
	public static void main (String[] args) {
		GradescopeYAMLFixer.main(MY_ARGS);
	}

}
