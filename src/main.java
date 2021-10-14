import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.CovidCase;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CovidCase> cases = new ArrayList<>();
        // read from csv
        String csvFile = "src/COVID19BE_CASES_TESTDATA.csv";
        makedataList(csvFile, cases);
        System.out.println(
                "Welcome to the COVID-19 Data Analysis Program. Make a selection from the menu below regarding the information you would like to see.");
        System.out.println("Please Select the Menu from Below!");
        System.out.println("1. Statistics of entire nation");
        System.out.println("2. Statistics of regions");
        System.out.println("3. Exit the Program");
        System.out.println("Your Choice: ");
        // get user input
        int firstSelection = scanner.nextInt();
        System.out.println(firstSelection);
        boolean exit   = false;
        do  
                switch (firstSelectio
                    cas
                        System.out.println("Statistics for the entire nation: select from the menu below
                        System.out.println("1. Display the total number of COVID-19 cases
                        System.out.println("2. Display the number of COVID-19 cases: Males
                        System.out.println("3. Display the number of COVID-19 cases: Females
                        System.out.println("4. Display the number of COVID-19 cases: 10-19 age group
                        System.out.println("5. Display the number of COVID-19 cases: 20-29 age group
                        System.out.println("6. Display the number of COVID-19 cases: 30-39 age group
                        System.out.println("7. Display the number of COVID-19 cases: 40-49 age group
                        System.out.println("8. Display the number of COVID-19 cases: 50-59 age group
                        System.out.println("9. Display the number of COVID-19 cases: 60-69 age group
                        System.out.println("10. Display the number of COVID-19 cases: 70-79 age group
                        System.out.println("11. Display the number of COVID-19 cases: 80-89 age group
                        System.out.println("12. Display the number of COVID-19 cases: 90+ age group
                        System.out.println("Your Choice
                        int secondSelection1 = scanner.nextIn
                        br
                    cas
                        System.out.prin
                                "Statistics by Region: select from the menu below:\nWhich region would you like statistics for
                        System.out.println("1. Flander
                        System.out.println("2. Brussel
                        System.out.println("3. Walloni
                        System.out.println("4. Unknow
                        System.out.println("Your Choice
                        int secondSelection2 = scanner.nextIn
                        br
                    cas
                        System.out.println("Thank you for using the COVID-19 Data Analysis Program
                        br
                    defa
                        System.out.println("Invalid Selection
                        br

            i
        } 
    
    public static void makedataList(String csvFile, List<CovidCase> dataList) {
        String line = "";
        String cvsSplitBy = ",";
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] ccase = line.split(cvsSplitBy);
                CovidCase caseobj = new CovidCase(Integer.parseInt(ccase[0]), Integer.parseInt(ccase[1]),
                        Integer.parseInt(ccase[2]), ccase[3], ccase[4], ccase[5], ccase[6], ccase[7],
                        Integer.parseInt(ccase[8]));
                // caseobj.printCase();
                dataList.add(caseobj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
