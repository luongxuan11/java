import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien {
    public static void main(String[] args) {
        ArrayList<String> danhSachSinhVien = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Chèn sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Sắp xếp danh sách sinh viên");
            System.out.println("5. Hiển thị danh sách sinh viên");
            System.out.println("0. Thoát");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập tên sinh viên:");
                    String tenSinhVien = scanner.nextLine();
                    themSinhVien(danhSachSinhVien, tenSinhVien);
                    break;
                case 2:
                    System.out.println("Nhập vị trí cần sửa (từ 1 đến " + danhSachSinhVien.size() + "):");
                    int viTriSua = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập tên sinh viên mới:");
                    String tenMoi = scanner.nextLine();
                    suaSinhVien(danhSachSinhVien, viTriSua, tenMoi);
                    break;
                case 3:
                    System.out.println("Nhập vị trí cần xóa (từ 1 đến " + danhSachSinhVien.size() + "):");
                    int viTriXoa = scanner.nextInt();
                    xoaSinhVien(danhSachSinhVien, viTriXoa);
                    break;
                case 4:
                    sapXepDanhSachSinhVien(danhSachSinhVien);
                    break;
                case 5:
                    hienThiDanhSachSinhVien(danhSachSinhVien);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    public static void themSinhVien(ArrayList<String> danhSachSinhVien, String tenSinhVien) {
        danhSachSinhVien.add(tenSinhVien);
        System.out.println("Thêm sinh viên thành công.");
    }

    public static void suaSinhVien(ArrayList<String> danhSachSinhVien, int viTri, String tenMoi) {
        if (viTri >= 1 && viTri <= danhSachSinhVien.size()) {
            danhSachSinhVien.set(viTri - 1, tenMoi);
            System.out.println("Sửa thông tin sinh viên thành công.");
        } else {
            System.out.println("Vị trí không hợp lệ.");
        }
    }

    public static void xoaSinhVien(ArrayList<String> danhSachSinhVien, int viTri) {
        if (viTri >= 1 && viTri <= danhSachSinhVien.size()) {
            danhSachSinhVien.remove(viTri - 1);
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Vị trí không hợp lệ.");
        }
    }

    public static void sapXepDanhSachSinhVien(ArrayList<String> danhSachSinhVien) {
        Collections.sort(danhSachSinhVien);
        System.out.println("Sắp xếp danh sách sinh viên thành công.");
    }

    public static void hienThiDanhSachSinhVien(ArrayList<String> danhSachSinhVien) {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng.");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (int i = 0; i < danhSachSinhVien.size(); i++) {
                System.out.println((i + 1) + ". " + danhSachSinhVien.get(i));
            }
        }
    }
}
