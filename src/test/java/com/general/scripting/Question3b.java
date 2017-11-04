
package com.general.scripting;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Question3b extends BeforeAfter {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
										
		File file = new File("/Users/kazialhasan/Documents/workspace/WeightWatchers/Lib/SampleData.txt");		
		ArrayList<WordList> roster = new ArrayList<WordList>();
		br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		StringTokenizer tokenizer;
		while (line != null) {

			WordList wl = new WordList();
			tokenizer = new StringTokenizer(line, ",");
			String token = tokenizer.nextToken();
			wl.setWord(token);
			token = tokenizer.nextToken();
			wl.setMeaning1(token);
			token = tokenizer.nextToken();
			wl.setMeaning2(token);
			roster.add(wl);

			// going to the next line
			line = br.readLine();
		}
				
		for (int i = 0; i < roster.size(); i++) {
			System.out.println(roster.get(i).getWord().toString());
			System.out.println(roster.get(i).getMeaning1().toString());
			System.out.println(roster.get(i).getMeaning2().toString());
			System.out.println();
		}		
	}	
}