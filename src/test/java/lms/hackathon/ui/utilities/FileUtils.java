package lms.hackathon.ui.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import lms.hackathon.ui.configs.CommonConfigs;



public class FileUtils {
CommonConfigs configs = new CommonConfigs();
	
	/*===========File IO reusable methods to generate serial number 
	 * and attach it to required unique value's prefix==============================*/
	
	
	public  String numberFile = "./src/test/resources/testdata/serialNumberContainer.txt";
	 public  String namePrefix = "Team8LMSPhaseTwoProgram";

	    public  int readFromFile(String fname) {
	        int number = -1;
	        try {
	            File inputFile = new File(fname);
	            Scanner scanner = new Scanner(inputFile);

	            while (scanner.hasNextInt()) {
	                number = scanner.nextInt();
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        return number;
	    }
	    public  void writeToFile(int n, String fname) {
	        try {
	            File outputFile = new File(fname);
	            FileWriter writer = new FileWriter(outputFile);

	            writer.write(String.valueOf(n)); // Convert int to String and write
	            writer.close();
	            //System.out.println("Integer "+n+" written to file successfully! ...");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public  int getNextInteger() {
	        int num = 1;
	        try {
	            Path path = Paths.get(numberFile);
	            if (Files.exists(path)) {
	                num = readFromFile(numberFile);
	            } else {
	                File file = new File("filePath");
	                file.createNewFile();
	            }
	        } catch (IOException e) {
	            System.err.println("Error creating file: " + e.getMessage());
	        }
	        writeToFile(num+1, numberFile);
	        return num;
	    }
	    
	    public  String generateProgramName() {
	        int id = getNextInteger();
	        System.out.println("Program Name is : "+namePrefix+""+id);
	        return (namePrefix+""+id);
	    }
/*===========End of File IO reusable methods to generate serial number and attach it to program name==============================*/

}
