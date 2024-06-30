/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author luanq
 */
import model.SinhVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xoá sinh viên");
            System.out.println("3. In thông tin sinh viên");
            System.out.println("4. Sửa thông tin sinh viên theo mã số sinh viên");
            System.out.println("5. In ra thông tin toàn bộ sinh viên nam");
            System.out.println("6. In ra thông tin toàn bộ sinh viên nữ");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    deleteStudent(scanner);
                    break;
                case 3:
                    printStudentInfo(scanner);
                    break;
                case 4:
                    updateStudent(scanner);
                    break;
                case 5:
                    printMaleStudents();
                    break;
                case 6:
                    printFemaleStudents();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String gender = scanner.nextLine();
        System.out.print("Nhập chuyên ngành: ");
        String major = scanner.nextLine();

        SinhVien sv = new SinhVien(id, name, gender, major);
        listSinhVien.add(sv);
        System.out.println("Đã thêm sinh viên.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xoá: ");
        String id = scanner.nextLine();

        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getId().equals(id)) {
                listSinhVien.remove(i);
                System.out.println("Đã xoá sinh viên.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
    }

    private static void printStudentInfo(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                System.out.println(sv);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String id = scanner.nextLine();

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                sv.setName(scanner.nextLine());
                System.out.print("Nhập giới tính mới (Nam/Nữ): ");
                sv.setGender(scanner.nextLine());
                System.out.print("Nhập chuyên ngành mới: ");
                sv.setMajor(scanner.nextLine());
                System.out.println("Đã cập nhật thông tin sinh viên.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
    }

    private static void printMaleStudents() {
        System.out.println("Thông tin toàn bộ sinh viên nam:");
        for (SinhVien sv : listSinhVien) {
            if (sv.getGender().equalsIgnoreCase("Nam")) {
                System.out.println(sv);
            }
        }
    }

    private static void printFemaleStudents() {
        System.out.println("Thông tin toàn bộ sinh viên nữ:");
        for (SinhVien sv : listSinhVien) {
            if (sv.getGender().equalsIgnoreCase("Nữ")) {
                System.out.println(sv);
            }
        }
    }
}


