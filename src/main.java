import models.CovidCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<CovidCase> cases = new ArrayList<>();

    public static void main(String[] args) {
        // read from csv
        String csvFile = "COVID19BE_CASES_TESTDATA.csv";
        makedataList(csvFile, cases);
        boolean exite = false;
        System.out.println(
                "Welcome to the COVID-19 Data Analysis Program. Make a selection from the menu below regarding the information you would like to see.");
        // List<CovidCase> filteredcasesbyCountry = cases.stream().filter(c ->
        // c.getCountry().equals("Belgium"))
        // .collect(Collectors.toList());
        // List<CovidCase> filteredcasesbydate = cases.stream().filter(c -> c.getDay()
        // == 1).collect(Collectors.toList());
        // // System.out.println(filteredcasesbyCountry);
        // System.out.println(filteredcasesbydate.size());
        // int total = cases.stream().filter(c ->
        // c.getCountry().equals("Belgium")).mapToInt(c -> c.getCases()).sum();
        // System.out.println(total);

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
                System.out.print("Total number of COVID-19 cases: ");
                System.out.println(cases.stream().mapToInt(c -> c.getCases()).sum());
                break;
            case 2:
                System.out.print("Total number of COVID-19 cases of male: ");
                System.out
                        .println(cases.stream().filter(c -> c.getSex().equals("M")).mapToInt(c -> c.getCases()).sum());
                break;
            case 3:
                System.out.print("Total number of COVID-19 cases of female: ");
                System.out
                        .println(cases.stream().filter(c -> c.getSex().equals("F")).mapToInt(c -> c.getCases()).sum());
                break;

            case 4:
                System.out.print("Total number of COVID-19 cases for 0-9: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("0-9")).mapToInt(c -> c.getCases()).sum());
                break;
            case 5:
                System.out.print("Total number of COVID-19 cases for 10-19: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("10-19")).mapToInt(c -> c.getCases()).sum());
                break;
            case 6:
                System.out.print("Total number of COVID-19 cases for 20-29: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("20-29")).mapToInt(c -> c.getCases()).sum());
                break;
            case 7:
                System.out.println("Total number of COVID-19 cases for 30-39: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("30-39")).mapToInt(c -> c.getCases()).sum());
                break;
            case 8:
                System.out.print("Total number of COVID-19 cases for 40-49: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("40-49")).mapToInt(c -> c.getCases()).sum());
                break;
            case 9:
                System.out.print("Total number of COVID-19 cases for 50-59: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("50-59")).mapToInt(c -> c.getCases()).sum());
                break;
            case 10:
                System.out.print("Total number of COVID-19 cases for 60-69: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("60-69")).mapToInt(c -> c.getCases()).sum());
                break;
            case 11:
                System.out.print("Total number of COVID-19 cases for 70-79: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("70-79")).mapToInt(c -> c.getCases()).sum());
                break;
            case 12:
                System.out.print("Total number of COVID-19 cases for 80-89: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("80-89")).mapToInt(c -> c.getCases()).sum());
                break;
            case 13:
                System.out.print("Total number of COVID-19 cases for 90+: ");
                System.out.println(
                        cases.stream().filter(c -> c.getAgeGroup().equals("90+")).mapToInt(c -> c.getCases()).sum());
                break;

        }
        System.out.println("Would you like to make another selection?(Y or N)");
        if (scanner.nextLine().equals("Y") || scanner.nextLine().equals("y")) {
            return false;
        } else if (scanner.nextLine().equals("N") || scanner.nextLine().equals("n")) {
            return true;
        }
        return true;
    }

    public static boolean showRegionData(int selection) {
        switch (selection) {
            case 1:
                System.out.print("Total number of COVID-19 cases in Flanders: ");
                System.out
                        .println(cases.stream().filter(c -> c.getSex().equals("M")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of male in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getSex().equals("F")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of female in Flanders:");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 0-9 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("0-9")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 10-19 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("10-19")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 20-29 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("20-29")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 30-39 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("30-39")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 40-49 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("40-49")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 50-59 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("50-59")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 60-69 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("60-69")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 70-79 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("70-79")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 80-89 in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("80-89")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 90+ in Flanders: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Flanders"))
                        .filter(c -> c.getAgeGroup().equals("90+")).mapToInt(c -> c.getCases()).sum());
                break;
            case 2:
                System.out.print("Total number of COVID-19 cases in Brussels: ");
                System.out
                        .println(cases.stream().filter(c -> c.getSex().equals("M")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of male in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getSex().equals("F")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of female in Brussels:");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 0-9 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("0-9")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 10-19 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("10-19")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 20-29 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("20-29")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 30-39 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("30-39")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 40-49 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("40-49")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 50-59 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("50-59")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 60-69 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("60-69")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 70-79 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("70-79")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 80-89 in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("80-89")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 90+ in Brussels: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Brussels"))
                        .filter(c -> c.getAgeGroup().equals("90+")).mapToInt(c -> c.getCases()).sum());
                break;
            case 3:
                System.out.print("Total number of COVID-19 cases in Wallonia: ");
                System.out
                        .println(cases.stream().filter(c -> c.getSex().equals("M")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of male in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getSex().equals("F")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of female in Wallonia:");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 0-9 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("0-9")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 10-19 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("10-19")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 20-29 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("20-29")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 30-39 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("30-39")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 40-49 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("40-49")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 50-59 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("50-59")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 60-69 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("60-69")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 70-79 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("70-79")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 80-89 in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("80-89")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 90+ in Wallonia: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Wallonia"))
                        .filter(c -> c.getAgeGroup().equals("90+")).mapToInt(c -> c.getCases()).sum());
                break;
            case 4:
                System.out.print("Total number of COVID-19 cases in Unknown: ");
                System.out.println(
                        cases.stream().filter(c -> c.getRegion().equals("Unknown")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of male in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getSex().equals("M")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases of female in Unknown:");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getSex().equals("F")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 0-9 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("0-9")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 10-19 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("10-19")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 20-29 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("20-29")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 30-39 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("30-39")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 40-49 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("40-49")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 50-59 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("50-59")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 60-69 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("60-69")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 70-79 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("70-79")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 80-89 in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("80-89")).mapToInt(c -> c.getCases()).sum());
                System.out.print("Total number of COVID-19 cases for 90+ in Unknown: ");
                System.out.println(cases.stream().filter(c -> c.getRegion().equals("Unknown"))
                        .filter(c -> c.getAgeGroup().equals("90+")).mapToInt(c -> c.getCases()).sum());
                break;
        }
        return false;
    }
}
