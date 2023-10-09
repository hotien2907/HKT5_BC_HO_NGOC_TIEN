package baitap2;



import java.util.Scanner;
import java.util.Stack;

public class Exam_Advance_2 {
    static Scanner scanner = new Scanner(System.in);
    static String sentence = "";
    static Stack<String> textStack = new Stack<>();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputSentence();
                    break;
                case 2:
                    reverseSentence();
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

    public static void displayMenu() {
        System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
        System.out.println("1. Nhập câu");
        System.out.println("2. Đảo ngược câu");
        System.out.println("3. Thoát");
        System.out.print("Nhập vào lựa chọn : ");
    }

    public static void inputSentence() {
        System.out.print("Nhập câu: ");
        sentence = scanner.nextLine();
    }

    public static void reverseSentence() {
        if (sentence.isEmpty()) {
            System.out.println("Chưa có câu để đảo ngược.");
        } else {
            String[] texts = sentence.split(" ");
            for (String word : texts) {
                textStack.push(word);
            }

            System.out.print("Câu đảo ngược là : ");
            while (!textStack.isEmpty()) {
                System.out.print(textStack.pop() + " ");
            }
            System.out.println();
        }
    }
}
