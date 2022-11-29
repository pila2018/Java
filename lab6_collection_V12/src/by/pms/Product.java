package by.pms;

import java.util.List;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private int UPC;
    private String monafacturer;
    private double cost;
    private double shelfLife;
    private String count;

    public Product(String[] str){
        this.id = Integer.parseInt(str[0]);
        this.name = str[1];
        this.UPC = Integer.parseInt(str[2]);
        this.monafacturer = str[3];
        this.cost = Double.parseDouble(str[4]);
        this.shelfLife = Double.parseDouble(str[5]);
        this.count = str[6];
    }

    public static void listByName(List<Product> prodList, String name){
        System.out.println("List by name{" + name + "}");
        for(var s : prodList){
            if(s.name.equals(name)){
                System.out.println(s.toString());
            }
        }
    }

    public static void listByNameAndPrice(List<Product> prodList, String name, String price){
        double lPrice;
        try{
            lPrice = Double.parseDouble(price);
            for(var s : prodList){
                if(s.name.equals(name) && (s.cost < lPrice)){
                    System.out.println(s.toString());
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void listByShelfLife(List<Product> prodList, String shTime){
        System.out.println("");
        double lShTime;
        try{
            lShTime = Double.parseDouble(shTime);
            for(var s : prodList){
                if(s.shelfLife > lShTime){
                    System.out.println(s.toString());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Product o) {
        if (this.name.length() < o.name.length()) return 1;
        if(this.name.length() > o.name.length()) return -1;
        return this.name.toUpperCase().compareTo(o.name.toUpperCase());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", UPC=" + UPC +
                ", monafacturer='" + monafacturer + '\'' +
                ", cost=" + cost +
                ", shelfLife=" + shelfLife +
                ", count='" + count + '\'' +
                '}';
    }

    public String toStringClear(){
        return id + " " +
                name + " " +
                UPC + " " +
                monafacturer + " " +
                cost + " " +
                shelfLife + " " +
                count;
    }
}
