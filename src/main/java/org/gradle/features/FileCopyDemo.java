package org.gradle.features;

import java.io.File;
import java.io.InputStreamReader;

public class FileCopyDemo {

	public static void main(String[] args) {
		File inputDirectory = new File("build.gradle");
		File outputDirectory = new File("temp");
		
		outputDirectory.mkdir();
		
		File[] inputFiles = inputDirectory.listFiles();
		
		for(File file : inputFiles){
			if(file.isFile()){
				
			}
		}

	}

}
