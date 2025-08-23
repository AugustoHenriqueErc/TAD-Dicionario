package controller;

public class testDataValidator {
    public static void main(String[] args) {
        String data1 = "01_01_2000";
        String data2 = "01-01-2000";
        String data3 = "01/01/2000";

        //Test DatasTypes
        System.out.println("DATA 1");
        System.out.println(DataValidator.validateDate(data1));
        System.out.println("DATA 2");
        System.out.println(DataValidator.validateDate(data2));
        System.out.println("DATA 3");
        System.out.println(DataValidator.validateDate(data3));
    }
}

