package org.collectionscsv;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var listLoader = new ListLoader();
        try {
            var list = listLoader.ReadFromFile("foreign_names.csv");
            for (var item: list) {
                System.out.println(item);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}