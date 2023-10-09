package baitap3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_Advance_3 {
    static Scanner scanner = new Scanner(System.in);
    static Queue<String> parents = new LinkedList<>();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParent();
                    break;
                case 2:
                    getNextParent();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (choice != 3);
    }

    static void displayMenu() {
        System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
        System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
        System.out.println("2. Phụ huynh tiếp theo");
        System.out.println("3. Thoát");
        System.out.print("Nhập vào lựa chọn: ");
    }

    static void addParent() {
        System.out.print("Nhập tên phụ huynh: ");
        String parentName = scanner.nextLine();
        parents.offer(parentName);
    }

    static void getNextParent() {
        if (parents.isEmpty()) {
            System.out.println("Danh sách phụ huynh rỗng.");
        } else {
            String nextParent = parents.poll();
            System.out.println("Phụ huynh tiếp theo là: " + nextParent);
        }
    }
}
