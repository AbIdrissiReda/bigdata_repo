package com.reda.itemRecomander.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class converter {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new FileReader("data/u.data"));

		BufferedWriter bfw = new BufferedWriter(new FileWriter("data/u.csv"));
		
		String line = "";

		while ((line = bfr.readLine()) != null) {

			String[] results = line.split("\\t", -1);

			bfw.write(results[0] + "," + results[1] + "," + results[2] + "\n");

		}

		bfr.close();
		
		bfw.close();
		System.out.println("Converting DONE!");
	}

}
