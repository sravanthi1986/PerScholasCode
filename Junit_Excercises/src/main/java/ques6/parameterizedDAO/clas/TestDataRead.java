package ques6.parameterizedDAO.clas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDataRead {

	public static void main(String[] args) throws Exception{
		String csvFile = "testdata.csv";
        String line = "";
        String cvsSplitBy = ",";
        //List<TestData> records = new ArrayList<TestData>();
        Scanner sc = new Scanner(System.in);
        try {
       
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        TestDataDAO dao = new TestDataDAO();
            while ((line = br.readLine()) != null) {
             //System.out.println(line);
            	String[] data = line.split(",");
            	TestData testData = new TestData();
            	testData.setTestName(data[1]);
            	dao.createTestData(testData);

               
            }
           

           
            

        } catch (IOException e) {
            e.printStackTrace();
        }


	}

}
