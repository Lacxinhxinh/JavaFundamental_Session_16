package Session16.Ex01.Ex02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Event> events = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sự kiện");
            System.out.println("2. Hiển thị danh sách sự kiện");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập tên sự kiện: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
                        String startStr = sc.nextLine();
                        LocalDateTime start = LocalDateTime.parse(startStr, formatter);

                        System.out.print("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
                        String endStr = sc.nextLine();
                        LocalDateTime end = LocalDateTime.parse(endStr, formatter);

                        if (end.isBefore(start)) {
                            System.out.println("❌ Thời gian kết thúc phải sau thời gian bắt đầu!");
                        } else {
                            events.add(new Event(name, start, end));
                            System.out.println("✅ Thêm sự kiện thành công!");
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("❌ Lỗi định dạng ngày giờ! Vui lòng nhập đúng dd/MM/yyyy HH:mm");
                    }
                    break;

                case 2:
                    if (events.isEmpty()) {
                        System.out.println("⚠️ Danh sách sự kiện trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH SỰ KIỆN =====");
                        for (Event e : events) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }
}