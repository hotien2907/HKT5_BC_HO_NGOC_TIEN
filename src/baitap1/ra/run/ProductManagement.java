
package baitap1.ra.run;
import baitap1.ra.bussinessImp.Catalog;
import baitap1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> catalogList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    inputCatalogs();
                    break;
                case 2:
                    inputProducts();
                    break;
                case 3:
                    sortProducts();
                    break;
                case 4:
                    searchProductByCatalogName();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

        } while (option != 5);
    }

    private static void inputCatalogs() {
        System.out.print("Nhập số lượng danh mục sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogList.add(catalog);
        }
    }

    private static void inputProducts() {
        System.out.print("Nhập số sản phẩm cần thêm mới: ");
        int numProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Sản Phẩm thứ " + (i + 1));
            Product product = new Product();
            product.inputData();
            productList.add(product);

        }
        displayProducts();
    }

    public static void sortProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống, không thể sắp xếp.");
        } else {
            productList.sort(new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return Double.compare(p1.getExportPrice(), p2.getExportPrice());
                }
            });

       ;
            System.out.println("Danh sách sản phẩm sau khi sắp xếp giá tăng dần:");
            for (Product product : productList) {
                System.out.println("Tên sản phẩm: " + product.getProductName() + ", Giá: " + product.getExportPrice());
            }
        }
    }

    public static void searchProductByCatalogName() {
        System.out.print("Nhập tên danh mục cần tìm kiếm: ");
        String categoryName = scanner.nextLine().toLowerCase();

        boolean check = false;
        for (Product product : productList) {
            if (product.getCatalog().getCatalogName().toLowerCase().contains(categoryName)) {
                product.displayData();
                check = true;
            }
        }

        if (!check) {
            System.out.println("\u001B[33mKhông tìm thấy sản phẩm trong danh mục này.\u001B[0m");
        }
    }


    public static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : productList) {
                product.displayData();
                System.out.println("------------");
            }
        }
    }
}
