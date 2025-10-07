import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Collections
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * ArrayList, generics, operasi CRUD, dan iterasi collections.
         */

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        // Latihan 1: Demonstrasi keterbatasan array vs keunggulan ArrayList
        // - Buat array integer dengan ukuran tetap 3
        int[] fixedArray = new int[3];

        // - Buat ArrayList<Integer> kosong
        ArrayList<Integer> dynamicList = new ArrayList<>();

        // - Coba tambahkan 5 elemen ke array (akan error/terbatas)
        try{
            fixedArray[3] = 4;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Gagal menambahkan ke array tetap: " + e);
        }
        // - Tambahkan 5 elemen ke ArrayList (dinamis)
        for(int i = 1; i <= 5; i++){
            dynamicList.add(i);
        }

        // - Print ukuran keduanya dan jelaskan perbedaannya dalam komentar
        System.out.println("Ukuran array tetap (fixedArray.length) = " + fixedArray.length);
        System.out.println("Isi fixedArray = " + Arrays.toString(fixedArray));

        System.out.println("Ukuran ArrayList (dynamicList.size()) = " + dynamicList.size());
        System.out.println("Isi dynamicList = " + dynamicList);

        // ===== GENERICS DASAR =====
        System.out.println("\\n=== GENERICS DASAR ===");

        // Latihan 2: Memahami generics dan type safety
        // - Buat ArrayList tanpa generics (raw type) dan tambahkan berbagai tipe data
        ArrayList rawList = new ArrayList();
        rawList.add("Teks");
        rawList.add("123");
        rawList.add("4.56");
        System.out.println("Raw list: " + rawList);


        // - Buat ArrayList<String> dengan generics dan tambahkan hanya String
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("Satu");
        listStr.add("Dua");
        System.out.println("ArrayList<String>: " + listStr);

        // - Buat ArrayList<Double> untuk menyimpan nilai desimal

        // - Demonstrasikan type safety dengan mencoba menambahkan tipe yang salah

        // ===== OPERASI CRUD PADA ARRAYLIST =====
        System.out.println("\\n=== OPERASI CRUD PADA ARRAYLIST ===");

        // Latihan 3: Create - Menambah data
        ArrayList<String> daftarMahasiswa = new ArrayList<>();

        // - Tambahkan 5 nama mahasiswa menggunakan add()
        daftarMahasiswa.add("Andi");
        daftarMahasiswa.add("Siti");
        daftarMahasiswa.add("Rina");
        daftarMahasiswa.add("Tono");
        daftarMahasiswa.add("Lina");

        // - Tambahkan mahasiswa di posisi tertentu menggunakan add(index, element)
        daftarMahasiswa.add(2, "Budi");

        // - Print daftar mahasiswa
        System.out.println("Daftar mahasiswa (langsung): " + daftarMahasiswa);

        // Latihan 4: Read - Membaca data
        // - Baca mahasiswa pertama menggunakan get(0)
        if(!daftarMahasiswa.isEmpty()){
            String pertama = daftarMahasiswa.get(0);
        }else{
            System.out.println("Daftar mahasiswa kosong - tidak ada mahasiswa pertama.");
        }

        // - Baca mahasiswa terakhir
        if(!daftarMahasiswa.isEmpty()){
            String terakhir = daftarMahasiswa.get(daftarMahasiswa.size() - 1);
            System.out.println("Mahasiswa terakhir: " + terakhir);
        }else{
            System.out.println("Daftar mahasiswa kosong - tidak ada mahasiswa terakhir.");
        }

        // - Cek apakah ada mahasiswa dengan nama tertentu menggunakan contains()
        String namaDicari = "Budi";
        boolean ada = daftarMahasiswa.contains(namaDicari);
        System.out.println("Apakah ada \"" + namaDicari + "\"? " + (ada ? "Ya" : "Tidak"));

        // - Temukan index mahasiswa tertentu menggunakan indexOf()
        int indexNama = daftarMahasiswa.indexOf(namaDicari);
        if (indexNama >= 0) {
            System.out.println("Index \"" + namaDicari + "\": " + indexNama + " (0-based)");
        } else {
            System.out.println("\"" + namaDicari + "\" tidak ditemukan (index = -1).");
        }

        // - Print ukuran ArrayList menggunakan size()
        System.out.println("Jumlah mahasiswa: " + daftarMahasiswa.size());

        // Latihan 5: Update - Mengubah data
        // - Ubah nama mahasiswa di index tertentu menggunakan set()
        daftarMahasiswa.set(1, "Budianto");

        // - Print daftar setelah update
        System.out.println("Setelah update: " + daftarMahasiswa);

        // Latihan 6: Delete - Menghapus data
        // - Hapus mahasiswa berdasarkan index menggunakan remove(index)
        daftarMahasiswa.remove(0);

        // - Hapus mahasiswa berdasarkan nama menggunakan remove(object)
        daftarMahasiswa.remove("Eka");

        // - Hapus semua mahasiswa menggunakan clear()
        daftarMahasiswa.clear();

        // - Cek apakah ArrayList kosong menggunakan isEmpty()
        System.out.println("Setelah clear, kosong? " + daftarMahasiswa.isEmpty());

        // ===== ITERASI ARRAYLIST =====
        System.out.println("\\n=== ITERASI ARRAYLIST ===");

        // Latihan 7: Berbagai cara iterasi
        ArrayList<Integer> angka = new ArrayList<>();
        // Isi dengan angka 10, 20, 30, 40, 50
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        System.out.println("Isi ArrayList: " + angka + "\n");

        // - Iterasi menggunakan traditional for loop
        for (int i = 0; i < angka.size(); i++) {
            System.out.println("Index " + i + " -> " + angka.get(i));
        }

        // - Iterasi menggunakan enhanced for loop (for-each)
        System.out.println("\n2) Enhanced for loop (for-each):");
        for (Integer n : angka) {
            System.out.println(n);
        }

        // - Iterasi menggunakan while loop
        System.out.println("\n3) While loop:");
        int idx = 0;
        while (idx < angka.size()) {
            System.out.println("Index " + idx + " -> " + angka.get(idx));
            idx++;
        }

        // - Iterasi menggunakan Iterator
        System.out.println("\n4) Iterator:");
        Iterator<Integer> it = angka.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            System.out.println(value);
        }

        // ===== ARRAYLIST DENGAN TIPE DATA KOMPLEKS =====
        System.out.println("\\\\n=== ARRAYLIST DENGAN TIPE DATA KOMPLEKS ===");

        // Latihan 8: ArrayList of Arrays (simulasi objects)
        // - Buat ArrayList<String[]> untuk menyimpan data mahasiswa (nama, nim, jurusan)
        ArrayList<String[]> dataMahasiswa = new ArrayList<>();

        // - Tambahkan 3 data mahasiswa
        // TODO: Tambahkan data mahasiswa
        dataMahasiswa.add(new String[] { "Andi", "1001", "Teknik Informatika" });
        dataMahasiswa.add(new String[] { "Siti", "1002", "Sistem Informasi" });
        dataMahasiswa.add(new String[] { "Budi", "1003", "Teknik Komputer" });

        // - Print semua data dengan format tabel
        // TODO: Print dalam format tabel
        System.out.printf("%-4s %-20s %-8s %-20s%n", "No", "Nama", "NIM", "Jurusan");
        System.out.println("---------------------------------------------------------------");

        int no = 1;
        for (String[] m : dataMahasiswa) {
            // m[0] = nama, m[1] = nim, m[2] = jurusan
            System.out.printf("%-4d %-20s %-8s %-20s%n", no++, m[0], m[1], m[2]);
        }

        // ===== UTILITY METHODS COLLECTIONS =====
        System.out.println("\\\\n=== UTILITY METHODS COLLECTIONS ===");

        // Latihan 9: Eksplorasi Collections utility
        ArrayList<Integer> numbers = new ArrayList<>();
        // TODO: Isi dengan angka: 64, 34, 25, 12, 22, 11, 90
        numbers.add(64);
        numbers.add(34);
        numbers.add(25);
        numbers.add(12);
        numbers.add(22);
        numbers.add(11);
        numbers.add(90);

        System.out.println("Awal: " + numbers);

        // - Gunakan Collections.sort() untuk mengurutkan
        // TODO: Sort list
        Collections.sort(numbers);
        System.out.println("Setelah Collections.sort() (ascending): " + numbers);

        // - Gunakan Collections.reverse() untuk membalik urutan
        // TODO: Reverse list
        Collections.reverse(numbers);
        System.out.println("Setelah Collections.reverse() (sekarang descending): " + numbers);

        // - Gunakan Collections.shuffle() untuk mengacak
        // TODO: Shuffle list
        Collections.shuffle(numbers);
        System.out.println("Setelah Collections.shuffle() (acak): " + numbers);

        // - Gunakan Collections.max() dan Collections.min()
        // TODO: Find max dan min
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + " | Min: " + min);

        // - Gunakan Collections.frequency() untuk menghitung kemunculan elemen
        // TODO: Count frequency
        int nilaiDicari = 22;
        int freq = Collections.frequency(numbers, nilaiDicari);
        System.out.println("Frekuensi nilai " + nilaiDicari + ": " + freq);

        // ===== SEARCHING DAN SORTING =====
        System.out.println("\\\\n=== SEARCHING DAN SORTING ===");

        // Latihan 10: Implementasi search dan sort
        ArrayList<String> buah = new ArrayList<>();
        // TODO: Isi dengan: "Apel", "Jeruk", "Mangga", "Pisang", "Anggur"
        buah.add("Apel");
        buah.add("Jeruk");
        buah.add("Mangga");
        buah.add("Pisang");
        buah.add("Anggur");

        // - Sort secara alfabetis
        // TODO: Sort alphabetically
        Collections.sort(buah);
        System.out.println("Sorted buah: " + buah);

        // - Implementasikan binary search pada list yang sudah diurutkan
        // TODO: Binary search
        int id = Collections.binarySearch(buah, "Mangga");
        System.out.println("Binary search 'Mangga': index " + id);

        // - Implementasikan linear search untuk list yang tidak diurutkan
        // TODO: Linear search
        int linearIdx = linearSearch(buah, "Pisang");
        System.out.println("Linear search 'Pisang': index " + linearIdx);

        // ===== ARRAYLIST 2D =====
        System.out.println("\\\\n=== ARRAYLIST 2D ===");

        // Latihan 11: ArrayList of ArrayList (2D dynamic array)
        // - Buat ArrayList<ArrayList<Integer>> untuk merepresentasikan matriks dinamis
        ArrayList<ArrayList<Integer>> matrix2D = new ArrayList<>();

        // - Buat 3 baris dengan panjang yang berbeda-beda
        // TODO: Create jagged 2D ArrayList
        int[] colsPerRow = {3, 5, 2};

        int counter = 1;
        for (int r = 0; r < colsPerRow.length; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < colsPerRow[r]; c++) {
                row.add(counter++); // bisa diganti dengan pola nilai lain
            }
            matrix2D.add(row);
        }

        // - Isi dengan nilai dan print dalam format matriks
        // TODO: Fill dan print matrix
        System.out.println("Matrix (jagged) - setiap baris bisa punya panjang berbeda:");
        for (int r = 0; r < matrix2D.size(); r++) {
            ArrayList<Integer> row = matrix2D.get(r);
            System.out.print("Baris " + r + ": ");
            for (Integer val : row) {
                System.out.printf("%4d", val); // lebar 4 untuk rapi
            }
            System.out.println();
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\\\\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 12: Sistem manajemen perpustakaan sederhana
        ArrayList<String[]> daftarBuku = new ArrayList<>();
        // Format: [judul, pengarang, tahun, status] // status: "tersedia" atau "dipinjam"

        // - Tambahkan 5 buku
        // TODO: Tambahkan data buku
        daftarBuku.add(new String[] { "Laskar Pelangi", "Andrea Hirata", "2005", "tersedia" });
        daftarBuku.add(new String[] { "Bumi Manusia", "Pramoedya Ananta Toer", "1980", "tersedia" });
        daftarBuku.add(new String[] { "Negeri 5 Menara", "Ahmad Fuadi", "2009", "tersedia" });
        daftarBuku.add(new String[] { "Harry Potter", "J.K. Rowling", "1997", "tersedia" });
        daftarBuku.add(new String[] { "Dilan 1990", "Pidi Baiq", "2014", "tersedia" });

        // - Implementasikan fungsi pinjam buku (ubah status)
        // TODO: Implementasikan pinjam buku
        pinjamBuku(daftarBuku, "Negeri 5 Menara");

        // - Implementasikan fungsi kembalikan buku
        // TODO: Implementasikan kembalikan buku
        kembalikanBuku(daftarBuku, "Negeri 5 Menara");

        // - Implementasikan pencarian buku berdasarkan judul
        // TODO: Implementasikan search buku
        String[] hasilCari = cariBuku(daftarBuku, "Laskar Pelangi");
        if (hasilCari != null) System.out.println("Ditemukan: " + hasilCari[0] + " oleh " + hasilCari[1]);

        // - Print daftar buku yang tersedia
        // TODO: Print available books
        for (String[] b : daftarBuku) if (b[3].equals("tersedia")) System.out.println(b[0] + " - " + b[1]);

        // Latihan 13: Sistem nilai mahasiswa dinamis
        // TODO: Implementasikan sistem nilai yang bisa menambah mahasiswa dinamis
        ArrayList<Integer> nilai = new ArrayList<>();
        nilai.add(80); nilai.add(90); nilai.add(75);
        System.out.println("Rata-rata nilai: " + hitungRataRata(nilai));

        // ===== PERFORMANCE COMPARISON =====
        System.out.println("\\\\n=== PERFORMANCE COMPARISON ===");

        // Latihan 14: Bandingkan performa Array vs ArrayList
        // TODO: Implementasikan comparison waktu akses, insert, search
        int[] arrPerf = new int[100000];
        ArrayList<Integer> listPerf = new ArrayList<>();
        for (int j = 0; j < 100000; j++) { arrPerf[j] = j; listPerf.add(j); }
        long start = System.nanoTime(); int x = arrPerf[50000]; long end = System.nanoTime();
        System.out.println("Akses array: " + (end-start) + " ns");
        start = System.nanoTime(); int y = listPerf.get(50000); end = System.nanoTime();
        System.out.println("Akses ArrayList: " + (end-start) + " ns");
    }

    // ===== HELPER METHODS =====
    // TODO: Implementasikan method-method pembantu di sini

    public static void printArrayList(ArrayList<?> list, String title) {
        // TODO: Print ArrayList dengan title
        System.out.println(title + ": " + list);
    }

    public static int linearSearch(ArrayList<String> list, String target) {
        // TODO: Implementasi linear search
        for (int i = 0; i < list.size(); i++) if (list.get(i).equals(target)) return i;
        return -1;
    }

    public static void printMatrix2D(ArrayList<ArrayList<Integer>> matrix) {
        // TODO: Print 2D ArrayList matrix
        for (ArrayList<Integer> row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static boolean pinjamBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi pinjam buku
        for (String[] b : daftarBuku) {
            if (b[0].equals(judul) && b[3].equals("tersedia")) { b[3] = "dipinjam"; return true; }
        }
        return false;
    }

    public static boolean kembalikanBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi kembalikan buku
        for (String[] b : daftarBuku) {
            if (b[0].equals(judul) && b[3].equals("dipinjam")) { b[3] = "tersedia"; return true; }
        }
        return false;
    }

    public static String[] cariBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi cari buku
        for (String[] b : daftarBuku) if (b[0].equals(judul)) return b;
        return null;
    }

    public static double hitungRataRata(ArrayList<Integer> values) {
        // TODO: Hitung rata-rata
        if (values.isEmpty()) return 0.0;
        int sum = 0; for (int v : values) sum += v;
        return (double) sum / values.size();
    }
}
