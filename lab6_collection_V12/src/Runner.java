import by.pms.Product;
import by.pms.ShowInfo;
import by.pms.file.ReadData;
import by.pms.file.WriteData;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner extends ShowInfo {
    public static void main(String[] args) {
        List<Product> productList = ReadData.readData();
        ShowInfo.showInfo(Collections.singletonList(productList));
        Collections.sort(productList, Product::compareTo);
        exer(productList);
        WriteData.writeData(productList);
    }

    private static void exer(List<Product> productList){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter name ");
            Product.listByName(productList, sc.nextLine());
            System.out.println("enter name and prise ");
            Product.listByNameAndPrice(productList, sc.nextLine(), sc.nextLine());
            System.out.println("Enter shelf life");
            Product.listByShelfLife(productList, sc.nextLine());
        }

    }
}
