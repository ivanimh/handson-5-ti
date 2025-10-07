import java.util.Arrays;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * array multidimensi, operasi lanjutan, parameter/return value, dan utility methods.
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        // Latihan 1: Membuat dan mengisi array 2D (matriks)
        // - Buat array 2D integer dengan ukuran 3x4 (3 baris, 4 kolom)
        int[][] matriks = new int[3][4];

        // - Isi array dengan nilai: baris 0: [1,2,3,4], baris 1: [5,6,7,8], baris 2: [9,10,11,12]
        int value = 1;
        for(int i = 0; i < matriks.length; i++){
            for(int j = 0; j < matriks[i].length; j++){
                matriks[i][j] = value++;
            }
        }

        // - Print seluruh matriks menggunakan nested loop dengan format yang rapi
        System.out.println("Matriks 3x4:");
        for(int i = 0; i < matriks.length; i++){
            for(int j = 0; j < matriks[i].length; j++){
                System.out.printf("%4d", matriks[i][j]);
            }
            System.out.println();
        }

        // Latihan 2: Array 2D dengan inisialisasi langsung
        // - Buat array 2D string yang merepresentasikan papan catur 3x3 dengan nilai awal "."
        String[][] papan = new String[3][3];
        for(int i = 0; i < papan.length; i++){
            for(int j = 0; j < papan[i].length; j++){
                papan[i][j] = ".";
            }
        }

        // - Tempatkan "X" di posisi [0][0], [1][1], dan [2][2] (diagonal)
        papan[0][0] = "X";
        papan[1][1] = "X";
        papan[2][2] = "X";
        // - Tempatkan "O" di posisi [0][2], [1][0], dan [2][1]
        papan[0][2] = "O";
        papan[1][0] = "O";
        papan[2][1] = "O";

        // - Print papan dengan format grid yang rapi
        System.out.println("Papan catur 3x3:");
        for(int i = 0; i < papan.length; i++){
            for(int j = 0; j < papan[i].length; j++){
                System.out.println(" " + papan[i][j] + " ");
                if(j < papan[i].length - 1){
                    System.out.println("|");
                }
            }
            System.out.println();
            if(i < papan.length - 1){
                System.out.println("---+---+---");
            }
        }

        // ===== ARRAY JAGGED (IRREGULAR) =====
        System.out.println("\\n=== ARRAY JAGGED (IRREGULAR) ===");

        // Latihan 3: Array dengan panjang baris yang berbeda
        // - Buat array 2D integer dengan 4 baris: baris 0 panjang 2, baris 1 panjang 4, baris 2 panjang 3, baris 3 panjang 5
        int[][] jagged = new int[4][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        jagged[3] = new int[5];

        // - Isi setiap baris dengan angka berurutan dimulai dari 1
        int nilai = 1;
        for(int i = 0; i < jagged.length; i++){
            for(int j = 0; j < jagged.length; j++){
                jagged[i][j] = nilai++;
            }
        }

        // - Print array jagged dengan menampilkan panjang setiap baris
        System.out.println("Array jagged:");
        for(int i = 0; i < jagged.length; i++){
            System.out.printf("Baris %d (panjang %d): ", i, jagged[i].length);
            for(int j = 0; j < jagged[i].length; j++){
                System.out.println(jagged[i][j]);
                if(j < jagged[i].length - 1) System.out.println(" ");
            }
            System.out.println();
        }

        // ===== OPERASI LANJUTAN PADA ARRAY =====
        System.out.println("\\n=== OPERASI LANJUTAN PADA ARRAY ===");

        // Latihan 4: Operasi matematika pada array 2D
        // - Buat dua matriks 2x3 dengan nilai bebas
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {6, 5, 4},
                {3, 2, 1}
        };

        // - Implementasikan penjumlahan matriks (buat method addMatrices)
        int[][] sum = addMatrices(A, B);

        // - Implementasikan perkalian setiap elemen dengan scalar 2 (buat method multiplyByScalar)
        int[][] scaled = multiplyByScalar(A, 2);

        // - Print hasil operasi
        System.out.println("Hasil Penjumlahan:");
        displayMatrix(sum);
        System.out.println("Hasil Perkalian Scalar:");
        displayMatrix(scaled);

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 5: Method yang menerima dan mengembalikan array
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        // - Panggil method sortArray untuk mengurutkan array
        // (implementasikan method sortArray yang menerima array dan mengembalikan array yang sudah diurutkan)
        System.out.println("Sorted: " + Arrays.toString(sortArray(numbers)));

        // - Panggil method reverseArray untuk membalik array
        // (implementasikan method reverseArray)
        System.out.println("Reversed: " + Arrays.toString(reverseArray(numbers)));

        // - Panggil method findMinMax untuk mencari nilai minimum dan maksimum
        // (implementasikan method yang mengembalikan array int dengan 2 elemen: [min, max])
        System.out.println("Min/Max: " + Arrays.toString(findMinMax(numbers)));

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");

        // Latihan 6: Eksplorasi utility methods Arrays
        int[] data = {5, 2, 8, 1, 9, 3};

        // - Gunakan Arrays.toString() untuk print array
        System.out.println("Awal: " + Arrays.toString(data));

        // - Gunakan Arrays.sort() untuk mengurutkan array
        Arrays.sort(data);
        System.out.println("Setelah sprt: " + Arrays.toString(data));

        // - Gunakan Arrays.binarySearch() untuk mencari elemen (array harus sudah diurutkan)
        int key1 = 8;
        int pos1 = Arrays.binarySearch(data, key1);
        System.out.println("binarySearch untuk " + key1 + " -> index = " + pos1);

        int key2 = 7;
        int pos2 = Arrays.binarySearch(data, key2);
        System.out.println("binarySearch untuk " + key2 + " -> = " + pos2 + " (negatif -> insertion point: " + (-pos2 - 1) + ")");

        // - Gunakan Arrays.fill() untuk mengisi array dengan nilai tertentu
        int[] filled = new int[6];
        Arrays.fill(filled, 42);
        System.out.println("Arrays.fill -> " + Arrays.toString(filled));

        // - Gunakan Arrays.equals() untuk membandingkan dua array
        int[] another = {1, 2, 3, 5, 8, 9};
        System.out.println("data.equals(another)? " + Arrays.equals(data, another));

        int[] copyOfData = Arrays.copyOf(data, data.length);
        System.out.println("copyofData: " + Arrays.toString(copyOfData));
        System.out.println("data.equals(copyOfData)? " + Arrays.equals(data, copyOfData));


        // - Gunakan Arrays.copyOf() untuk membuat copy array dengan ukuran berbeda
        int[] biggerCopy = Arrays.copyOf(data, 8);
        System.out.println("biggerCopy (length 8: " + Arrays.toString(biggerCopy));

        int[] smallerCopy = Arrays.copyOf(data, 3);
        System.out.println("smalledCopy (length 3): " + Arrays.toString(smallerCopy));


        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\\n=== ARRAY 3D DAN KOMPLEKS ===");

        // Latihan 7: Array 3 dimensi
        // - Buat array 3D integer ukuran 2x3x4 (seperti 2 buah matriks 3x4)
        int[][][] numbers3d = new int[2][3][4];

        // - Isi dengan nilai berurutan dari 1
        int c = 1;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 4; k++){
                    numbers3d[i][j][k] = c++;
                }
            }
        }

        // - Print menggunakan triple nested loop dengan format yang jelas
        for(int i = 0; i < 2; i++){
            System.out.println("=== Matriks ke-" + (i + 1) + " ===");
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 4; k++){
                    System.out.println(numbers3d[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 8: Sistem nilai mahasiswa
        // - Buat array 2D untuk menyimpan nilai 5 mahasiswa, 4 mata kuliah
        String[] namaMahasiswa = {"Tono", "Andi", "Toni", "Siti", "Cia"};
        String[] mataKuliah = {"Matematika", "Fisika", "Kimia", "Biologi"};

        // - Hitung rata-rata per mahasiswa
        int[][] grade = new int[namaMahasiswa.length][mataKuliah.length];
        fillRandomGrades(grade, 60, 100);

        // - Hitung rata-rata per mata kuliah

        // - Tentukan mahasiswa dengan nilai tertinggi
        double highestAvg = -1;
        String topStudent = "";

        // - Print dalam format tabel yang rapi
        System.out.println("Tabel Nilai:");
        System.out.print("Nama\t");
        System.out.println("Rata-rata");
        for (String m : mataKuliah) System.out.print(m+"\t");
        for (int i = 0; i < namaMahasiswa.length; i++) {
            System.out.println();
            System.out.print(namaMahasiswa[i] + "\t");
            double avg = calculateAverage(grade[i]);
            if (avg > highestAvg) { highestAvg = avg; topStudent = namaMahasiswa[i]; }
            for (int j = 0; j < mataKuliah.length; j++) {
                System.out.print(grade[i][j] + "\t");
            }
            System.out.println(avg);
        }
        System.out.println("Top Student: " + topStudent + " | Avg: " + highestAvg);

        // Latihan 9: Game Tic-Tac-Toe sederhana
        // - Buat array 2D char 3x3 untuk papan permainan
        char[][] board = new char[3][3];

        // - Implementasikan method untuk menampilkan papan
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }

        // - Implementasikan method untuk mengecek apakah ada pemenang
        char winner = checkWinner(board);
        if (winner != ' ') {
            System.out.println("Pemenang: " + winner);
        } else {
            System.out.println("Belum ada pemenang.");
        }

        // - Simulasikan beberapa langkah permainan
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[1][1] = 'X';
        board[1][2] = 'O';
        board[2][2] = 'X';

        displayBoard(board);
    }

    // ===== IMPLEMENTASI METHODS =====
    // TODO: Implementasikan method-method yang diperlukan di sini

    // Method untuk penjumlahan matriks
    public static int[][] addMatrices(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m1[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return res;
    }


    // Method untuk perkalian scalar
    // Method untuk perkalian scalar (sederhana, tanpa pengecekan null/ukuran)
    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = matrix[i][j] * scalar;
            }
        }
        return res;
    }


    // Method untuk sorting array
    public static int[] sortArray(int[] arr) {
        if (arr == null) return null;
        int[] res = arr.clone();
        Arrays.sort(res);
        return res;
    }


    // Method untuk reverse array
    // Mengembalikan array baru yang merupakan kebalikan dari arr.
// Jika arr == null -> mengembalikan null (safeguard).
    public static int[] reverseArray(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[n - 1 - i];
        }
        return res;
    }


    // Method untuk find min dan max
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) return null; // jika kosong/null

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        return new int[]{min, max};
    }

    // Method untuk display array 2D
    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix kosong/null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t"); // pakai tab agar rapi
            }
            System.out.println(); // pindah baris setelah satu row selesai
        }
    }

    // Method untuk mengisi array 2D dengan nilai random
    public static void fillRandomGrades(int[][] grades, int min, int max) {
        if (grades == null) return;
        Random rand = new Random();

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
    }

    // Method untuk menghitung rata-rata array
    public static double calculateAverage(int[] values) {
        if (values == null || values.length == 0) {
            return 0.0; // bisa juga lempar exception kalau mau lebih ketat
        }

        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }
}
