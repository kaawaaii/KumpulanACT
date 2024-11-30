import org.example.controller.MahasiswaController;
import org.example.model.MahasiswaDAO;

import java.util.Scanner;

public class MahasiswaView {
    public static void main(String[] args) {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi Database");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;

                case 2:
                    // Tambah mahasiswa
                    System.out.print("Masukkan NPM: ");
                    String npm = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Semester: ");
                    int semester = scanner.nextInt();
                    System.out.print("Masukkan IPK: ");
                    float ipk = scanner.nextFloat();

                    mahasiswaController.addMahasiswa(npm, nama, semester, ipk);
                    break;

                case 3:
                    System.out.print("Masukkan ID mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan NPM Baru: ");
                    String npmBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Semester Baru: ");
                    int semesterBaru = scanner.nextInt();
                    System.out.print("Masukkan IPK Baru: ");
                    float ipkBaru = scanner.nextFloat();

                    mahasiswaController.updateMahasiswa(id, npmBaru, namaBaru, semesterBaru, ipkBaru);
                    break;

                case 4:

                    System.out.print("Masukkan ID Mahasiswa: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idHapus);
                    break;

                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;

                case 6:
                    // Keluar
                    mahasiswaController.closeConnection();
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Input tidak valid. Silakan pilih opsi yang tersedia.");
            }
        }
    }
}
