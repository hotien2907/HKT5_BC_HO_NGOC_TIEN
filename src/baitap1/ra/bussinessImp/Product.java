
package baitap1.ra.bussinessImp;

import baitap1.ra.bussiness.IShop;

import java.util.Scanner;

import static baitap1.ra.run.ProductManagement.catalogList;


public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private Boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, Boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        this.productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.print("Nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();

        //Phần chọn danh mục
        boolean validCatalog = false;
        if (!catalogList.isEmpty()) {
            System.out.println("\u001B[33mDanh sách danh mục sản phẩm:\u001B[0m");
            for (Catalog catalog : catalogList) {
                System.out.println("\u001B[33mMã danh mục: " + catalog.getCatalogId() + ", Tên danh mục: " + catalog.getCatalogName() + "\u001B[0m");
            }
            do {
                System.out.print("Chọn mã danh mục sản phẩm: ");
                int selectedCatalogId = Integer.parseInt(scanner.nextLine());

                for (Catalog catalog : catalogList) {
                    if (catalog.getCatalogId() == selectedCatalogId) {
                        this.catalog = catalog;
                        validCatalog = true;
                        break;
                    }
                }

                if (!validCatalog) {
                    System.out.println("Mã danh mục không hợp lệ. Vui lòng chọn lại.");
                }
            } while (!validCatalog);
        } else {
            System.out.println("Danh mục sản phẩm đang trống. Thêm mới danh mục.");

            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogList.add(newCatalog);
            this.catalog = newCatalog;
        }


        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Nhập giá nhập sản phẩm: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        this.exportPrice = this.importPrice * RATE;
        System.out.print("Nhập trạng thái sản phẩm (true/false): ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Tên danh mục: " + this.catalog.getCatalogName());
        System.out.println("Giá bán sản phẩm: " + this.exportPrice);
        System.out.println("Trạng thái sản phẩm: " + (this.productStatus ? "Hoạt động" : "Ngừng hoạt động"));
    }
}
