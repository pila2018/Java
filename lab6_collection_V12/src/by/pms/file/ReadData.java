package by.pms.file;

import by.pms.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadData {
    public static List<Product> readData() {
        final String FILE_NAME = "src\\by\\pms\\file\\File.txt";
        List<String> lines = new ArrayList<>();
        List<Product> schedules = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        for (String oneData : lines) {
            String[] oneDataSplit = oneData.split(" ");
            Product schedule = new Product(oneDataSplit);
            schedules.add(schedule);
        }

        return schedules;
    }
}
