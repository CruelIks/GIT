package acmp;

import acmp.MyException;

import java.io.*;
import java.util.ArrayList;

public class TaskOne {

	public TaskOne() {
		// TODO Auto-generated constructor stub
	}

	private static String loadFromFile(String filename) throws MyException {
		String result = "";
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			throw (new MyException("Error reading file"));
		}

		try {

			result = br.readLine();

		} catch (IOException e) {
			throw (new MyException("Error reading file"));

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw (new MyException("Error reading file"));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		
		//вычисление суммы чисел, заданных в файле Input.txt
		//результат выводится в файл Output.txt
		
		String line = "";
		int resultCalculation = 0;
		
		try {
			line = loadFromFile("Input.txt");
		} catch (MyException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		if (line.length() == 0) {
			System.out.println("Empty file!");
			System.exit(0);
		}

		resultCalculation = getSum(line);
		System.out.println("result calculation is " + resultCalculation);

		try {
			saveToFile(resultCalculation, "Output.txt");
		} catch (IOException e) {
			System.out.println("error!!! " + e.getMessage());
		}

	}

	private static void saveToFile(int resultCalculation, String filename) throws IOException {

		BufferedWriter br = new BufferedWriter(new FileWriter(filename));
		br.write(String.valueOf(resultCalculation));
		br.close();

	}

	private static int getSum(String line) {

		int resultCalculation = 0;
		String tmp = "";

		for (int i = 0; i < line.length(); i++) {

			char ch = line.charAt(i);

			if (Character.isWhitespace(ch)) {

				try {
					resultCalculation = resultCalculation + Integer.parseInt(tmp);
				} catch (NumberFormatException e) {
					tmp = "";
					continue;

				}
				tmp = "";

			} else {
				// System.out.println("" + Character.getNumericValue(ch) + " " +
				// Character.getName(ch));
				tmp = tmp + ch;
			}

		}

		try {
			resultCalculation = resultCalculation + Integer.parseInt(tmp);
		} catch (NumberFormatException e) {

		}

		return resultCalculation;
	}

}
