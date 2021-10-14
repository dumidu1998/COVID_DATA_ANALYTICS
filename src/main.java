import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.CovidCase;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<CovidCase> cases = new ArrayList<>();
        // read from csv
        String csvFile = "src/COVID19BE_CASES_TESTDATA.csv";
        makedataList(csvFile, cases);
        boolean exite = false;
        System.out.println(
                "Welcome to the COVID-19 Data Analysis Program. Make a selection from the menu below regarding the information you would like to see.");
        do {
            System.out.println("Please Select the Menu from Below!");
            System.out.println("1. Statistics of entire nation");
            System.out.println("2. Statistics of regions");
            System.out.println("3. Exit the Program");
            System.out.println("Your Choice: ");
            // get user input
            int firstSelection = scanner.nextInt();
            System.out.println(firstSelection);
            switch (firstSelection) {
                case 1:
                    System.out.println("Statistics for the entire nation: select from the menu below:");
                    System.out.println("1. Display the total number of COVID-19 cases.");
                    System.out.println("2. Display the number of COVID-19 cases: Males.");
                    System.out.println("3. Display the number of COVID-19 cases: Females.");
                    System.out.println("4. Display the number of COVID-19 cases: 10-19 age group.");
                    System.out.println("5. Display the number of COVID-19 cases: 20-29 age group.");
                    System.out.println("6. Display the number of COVID-19 cases: 30-39 age group.");
                    System.out.println("7. Display the number of COVID-19 cases: 40-49 age group.");
                    System.out.println("8. Display the number of COVID-19 cases: 50-59 age group.");
                    System.out.println("9. Display the number of COVID-19 cases: 60-69 age group.");
                    System.out.println("10. Display the number of COVID-19 cases: 70-79 age group.");
                    System.out.println("11. Display the number of COVID-19 cases: 80-89 age group.");
                    System.out.println("12. Display the number of COVID-19 cases: 90+ age group.");
                    System.out.println("Your Choice:");
                    int secondSelection1 = scanner.nextInt();
                    exite = showEntrieNationData(secondSelection1);
                    break;
                case 2:
                    System.out.println(
                            "Statistics by Region: select from the menu below:\nWhich region would you like statistics for?");
                    System.out.println("1. Flanders");
                    System.out.println("2. Brussels");
                    System.out.println("3. Wallonia");
                    System.out.println("4. Unknown");
                    System.out.println("Your Choice:");
                    int secondSelection2 = scanner.nextInt();
                    exite = showRegionData(secondSelection2);
                    break;
                case 3:
                    System.out.println("Thank you for using the COVID-19 Data Analysis Program!");
                    exite = true;
                    break;
                default:
                    System.out.println("Invalid Selection!");
                    break;
            }
        } while (!exite);

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

    public static boolean showEntrieNationData(int selection) {
        switch (selection) {
            case 1:
                System.out.println("Total number of COVID-19 cases: ");
                break;
            case 2:
                System.out.println("Total number of COVID-19 cases of male: ");
                break;
            case 3:
                System.out.println("Total number of COVID-19 cases of female:");
            case 4:
                System.out.println("Total number of COVID-19 cases for 0-9: ");
                break;
            case 5:
                System.out.println("Total number of COVID-19 cases for 10-19: ");
                break;
            case 6:
                System.out.println("Total number of COVID-19 cases for 20-29: ");
                break;
            case 7:
                System.out.println("Total number of COVID-19 cases for 30-39: ");
                break;
            case 8:
                System.out.println("Total number of COVID-19 cases for 40-49: ");
                break;
            case 9:
                System.out.println("Total number of COVID-19 cases for 50-59: ");
                break;
            case 10:
                System.out.println("Total number of COVID-19 cases for 60-69: ");
                break;
            case 11:
                System.out.println("Total number of COVID-19 cases for 70-79: ");
                break;
            case 12:
                System.out.println("Total number of COVID-19 cases for 80-89: ");
                break;
            case 13:
                System.out.println("Total number of COVID-19 cases for 90+: ");
                break;

        }
        System.out.println("Would you like to make another selection?(Y or N)");
        if (scanner.next().equals("Y") || scanner.next().equals("y")) {
            return false;
        } else if (scanner.next().equals("N") || scanner.next().equals("n")) {
            return true;
        }
        return true;
    }

    public static boolean showRegionData(int selection) {
        switch (selection) {
            case 1:
                System.out.println("Total number of COVID-19 cases in Flanders: ");
                System.out.println("Total number of COVID-19 cases of male in Flanders: ");
                System.out.println("Total number of COVID-19 cases of female in Flanders:");
                System.out.println("Total number of COVID-19 cases for 0-9 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 10-19 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 20-29 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 30-39 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 40-49 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 50-59 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 60-69 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 70-79 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 80-89 in Flanders: ");
                System.out.println("Total number of COVID-19 cases for 90+ in Flanders: ");
                break;
            case 2:
                System.out.println("Total number of COVID-19 cases in Brussels: ");
                System.out.println("Total number of COVID-19 cases of male in Brussels: ");
                System.out.println("Total number of COVID-19 cases of female in Brussels:");
                System.out.println("Total number of COVID-19 cases for 0-9 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 10-19 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 20-29 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 30-39 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 40-49 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 50-59 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 60-69 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 70-79 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 80-89 in Brussels: ");
                System.out.println("Total number of COVID-19 cases for 90+ in Brussels: ");
                break;
            case 3:
                System.out.println("Total number of COVID-19 cases in Wallonia: ");
                System.out.println("Total number of COVID-19 cases of male in Wallonia: ");
                System.out.println("Total number of COVID-19 cases of female in Wallonia:");
                System.out.println("Total number of COVID-19 cases for 0-9 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 10-19 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 20-29 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 30-39 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 40-49 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 50-59 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 60-69 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 70-79 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 80-89 in Wallonia: ");
                System.out.println("Total number of COVID-19 cases for 90+ in Wallonia: ");
                break;
            case 4:
                System.out.println("Total number of COVID-19 cases in Unknown: ");
                System.out.println("Total number of COVID-19 cases in Unknown: ");
                System.out.println("Total number of COVID-19 cases of male in Unknown: ");
                System.out.println("Total number of COVID-19 cases of female in Unknown:");
                System.out.println("Total number of COVID-19 cases for 0-9 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 10-19 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 20-29 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 30-39 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 40-49 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 50-59 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 60-69 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 70-79 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 80-89 in Unknown: ");
                System.out.println("Total number of COVID-19 cases for 90+ in Unknown: ");
                break;
        }
        return false;
    }
}
