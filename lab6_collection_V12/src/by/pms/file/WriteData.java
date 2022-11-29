package by.pms.file;

import by.pms.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteData {
    public static void writeData(List<Product> productList) {

        try (FileWriter wr = new FileWriter("src\\by\\pms\\file\\Out.txt", false)) {
            for (var s : productList) {
                wr.write(s.toStringClear() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}