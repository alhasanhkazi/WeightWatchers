package com.general.scripting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question3a extends BeforeAfter{
	public static void main(String[] args) {
		
		String validFilePath = sysPath+"/Lib/SampleData.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(validFilePath))) {
			doesFileExist(validFilePath);
			System.out.println("File exists in the valid path");			
		}

		catch (FileNotFoundException e) {
			System.out.println("The path is not valid");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		
		}
	}
	
	static boolean doesFileExist(String path) {

		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}
}
