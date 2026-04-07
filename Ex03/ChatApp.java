package Session16.Ex01.Ex03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ChatApp {
    private static List<Message> messages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử chat");
            System.out.println("3. Lọc theo người gửi");
            System.out.println("4. Lọc theo ngày");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    sendMessage();
                    break;
                case 2:
                    showMessages();
                    break;
                case 3:
                    filterBySender();
                    break;
                case 4:
                    filterByDate();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }


    private static void sendMessage() {
        System.out.print("Nhập tên người gửi: ");
        String sender = scanner.nextLine();

        System.out.print("Nhập nội dung: ");
        String content = scanner.nextLine();

        Message message = new Message(sender, content, LocalDateTime.now());
        messages.add(message);

        System.out.println("Gửi tin nhắn thành công!");
    }


    private static void showMessages() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn.");
            return;
        }
        messages.forEach(System.out::println);
    }

    private static void filterBySender() {
        System.out.print("Nhập tên người gửi: ");
        String sender = scanner.nextLine();

        List<Message> result = messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(sender))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn.");
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void filterByDate() {
        System.out.print("Nhập ngày (dd/MM/yyyy): ");
        String input = scanner.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(input, formatter);

            List<Message> result = messages.stream()
                    .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                System.out.println("Không có tin nhắn trong ngày này.");
            } else {
                result.forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Sai định dạng ngày! Vui lòng nhập dd/MM/yyyy");
        }
    }
}