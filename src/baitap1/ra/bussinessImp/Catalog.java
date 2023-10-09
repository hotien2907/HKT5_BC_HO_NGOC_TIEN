
package baitap1.ra.bussinessImp;

import baitap1.ra.bussiness.IShop;

import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private Boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }


    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã danh mục: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên danh mục: ");
        this.catalogName = scanner.nextLine();
        System.out.print("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Nhập trạng thái danh mục (true/false): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + this.catalogId);
        System.out.println("Tên danh mục: " + this.catalogName);
    }
}
