import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable untuk demonstrasi
    private static int counter = 0;

    // Instance variable untuk demonstrasi
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Methods Advanced
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * method signature, overloading, pass by value/reference, static vs instance methods.
         */

        // ===== METHOD SIGNATURE DAN DECLARATION =====
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");

        // Latihan 1: Memahami komponen method signature
        // - Panggil method dengan signature berbeda untuk melihat perbedaannya
        // - Gunakan method overloading untuk mendemonstrasikan signature

        // Contoh pemanggilan method calculate dengan signature berbeda
        System.out.println("calculate(int, int) = " + calculate(3, 4));
        System.out.println("calculate(double, double) = " + calculate(2.5, 3.5));
        System.out.println("calculate(int, int, int) = " + calculate(1, 2, 3));
        System.out.println("calculate(String, String) = " + calculate("Hello ", "World"));

        // ===== METHOD OVERLOADING =====
        System.out.println("\\n=== METHOD OVERLOADING ===");

        // Latihan 2: Implementasi dan penggunaan method overloading
        // - Panggil semua variasi method calculate yang di-overload
        System.out.println("calculate(int,int)      -> " + calculate(10, 20));
        System.out.println("calculate(double,double)-> " + calculate(3.14, 2.86));
        System.out.println("calculate(int,int,int)  -> " + calculate(1, 2, 3));
        System.out.println("calculate(String,String)-> " + calculate("Java ", "Rocks"));

        // - Panggil semua variasi method print yang di-overload
        print(42);
        print(3.14159);
        print("Halo Dunia!");
        print(new int[]{1,2,3,4});

        // - Demonstrasikan bagaimana compiler memilih method yang tepat
        print(5);
        print(5.0);

        // ===== STATIC VS INSTANCE METHODS =====
        System.out.println("\\n=== STATIC VS INSTANCE METHODS ===");

        // Latihan 3: Perbedaan static dan instance methods
        // - Panggil static method tanpa membuat object
        incrementCounter();
        System.out.println("Counter (static) = " + getCounter());

        // - Buat instance object dan panggil instance method
        MethodsAdvancedPractice obj1 = new MethodsAdvancedPractice("Objek Satu");
        MethodsAdvancedPractice obj2 = new MethodsAdvancedPractice("Objek Dua");

        // - Demonstrasikan akses ke static vs instance variables
        System.out.println("Static counter diakses via class   = " + MethodsAdvancedPractice.getCounter());
        System.out.println("Instance name diakses via objek    = " + obj1.getInstanceName());

        // - Coba akses instance method dari static context (akan error)

        // ===== PASS BY VALUE - PRIMITIVES =====
        System.out.println("\\n=== PASS BY VALUE - PRIMITIVES ===");

        // Latihan 4: Demonstrasi pass by value untuk primitive types
        int originalNumber = 10;

        // - Panggil method modifyPrimitive dengan originalNumber
        System.out.println("Sebelum method call: " + originalNumber);

        // - Print originalNumber sebelum dan sesudah method call
        modifyPrimitive(originalNumber);
        System.out.println("Sesudah method call: " + originalNumber);

        // - Jelaskan mengapa nilai tidak berubah

        // ===== PASS BY VALUE OF REFERENCE - OBJECTS =====
        System.out.println("\\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");

        // Latihan 5: Demonstrasi pass by value of reference untuk objects
        int[] originalArray = {1, 2, 3, 4, 5};

        // - Print array sebelum modification
        print(originalArray);

        // - Panggil method modifyArray dengan originalArray
        modifyArray(originalArray);

        // - Print array setelah modification
        print(originalArray);

        // - Jelaskan mengapa isi array berubah tetapi reference tidak

        // Latihan 6: Reference reassignment dalam method
        int[] anotherArray = {10, 20, 30};

        // - Print array sebelum reassignment
        print(anotherArray);

        // - Panggil method reassignArray dengan anotherArray
        reassignArray(anotherArray);

        // - Print array setelah method call
        print(anotherArray);

        // - Jelaskan mengapa reference asli tidak berubah
        // Saat masuk ke method, arr adalah salinan dari referensi anotherArray.
        // Ketika arr diarahkan ke new int[]{99, 88, 77}, hanya salinan referensi di dalam method yang berubah.
        // Referensi anotherArray di luar tetap menunjuk ke array lama, jadi tidak terpengaruh.

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 7: Method yang menerima dan mengembalikan array
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        // - Panggil method yang mengembalikan copy array yang diurutkan
        print(sortArrayCopy(numbers));

        // - Panggil method yang mengembalikan statistik array (min, max, avg)
        double[] stats = getArrayStats(numbers);
        print("Min: " + stats[0] + ", Max; " + stats[1] + ", Avg: " + stats[2]);

        // - Panggil method yang merge dua array
        print(mergeArrays(new int[]{1, 2}, new int[]{3, 4, 5}));

        // ===== VARIABLE ARGUMENTS (VARARGS) =====
        System.out.println("\\n=== VARIABLE ARGUMENTS (VARARGS) ===");

        // Latihan 8: Implementasi dan penggunaan varargs
        // - Panggil method sum dengan jumlah parameter berbeda-beda
        System.out.println("Sum(1, 2) = " + sum(1, 2));
        System.out.println("Sum(5, 10, 15) = " + sum(5, 10, 15));
        System.out.println("Sum(7, 14, 21, 28, 35) = " + sum(7, 14, 21, 28, 35));

        // - Panggil method printInfo dengan berbagai kombinasi parameter
        printInfo("Nilai Ujian", 80, 90, 100);
        printInfo("Bilangan Ganjil", 1, 3, 5, 7, 9);
        printInfo("Tidak ada angka");

        // ===== METHOD CHAINING =====
        System.out.println("\\n=== METHOD CHAINING ===");

        // Latihan 9: Implementasi method chaining
        // - Gunakan Calculator dengan method chaining untuk operasi berurutan
        Calculator calc = new Calculator(10);
        double result = calc.add(5).multiply(2).subtract(4).getResult();
        print("Calculator result: " + result);

        // ===== RECURSIVE METHODS =====
        System.out.println("\\n=== RECURSIVE METHODS ===");

        // Latihan 10: Implementasi dan penggunaan recursive methods
        // - Hitung faktorial menggunakan recursion
        int num = 5;
        System.out.println("Faktorial dari " + num + " = " + factorial(num));

        // - Hitung fibonacci menggunakan recursion
        int n = 7;
        System.out.println("Fibonacci ke-" + n + " = " + fibonacci(n));

        // - Implementasikan binary search recursive
        int[] sortedArr = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int index = binarySearchRecursive(sortedArr, target, 0, sortedArr.length - 1);

        System.out.println("Binary Search: target " + target + " ada di index " + index);

        // ===== UTILITY STATIC METHODS =====
        System.out.println("\\n=== UTILITY STATIC METHODS ===");

        // Latihan 11: Membuat utility class dengan static methods
        // - Gunakan MathUtils untuk berbagai operasi matematika
        System.out.println("Power(2, 5) = " + MathUtils.power(2, 5));
        System.out.println("Is 17 prime? " + MathUtils.isPrime(17));
        System.out.println("GCD(56, 98) = " + MathUtils.gcd(56, 98));

        // - Gunakan StringUtils untuk manipulasi string
        String text = "Kasur ini rusak";
        System.out.println("Reverse: " + StringUtils.reverse(text));
        System.out.println("Is palindrome? " + StringUtils.isPalindrome(text));
        System.out.println("Word count: " + StringUtils.countWords("Belajar Java itu menyenangkan"));

        // - Gunakan ArrayUtils untuk operasi array
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Print Matrix:");
        ArrayUtils.printMatrix(matrix);

        int[] arrWithDup = {1, 2, 3, 2, 4, 5, 1, 6};
        System.out.println("Duplicates: " + Arrays.toString(ArrayUtils.findDuplicates(arrWithDup)));

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("Array equal? " + ArrayUtils.areEqual(arr1, arr2));

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 12: Sistem kalkulator dengan method overloading
        // - Implementasikan calculator yang bisa handle berbagai tipe data dan operasi
        System.out.println("Penjumlahan int: " + calculate(10, 20));
        System.out.println("Penjumlahan double: " + calculate(2.5, 3.7));
        System.out.println("Penjumlahan tiga int: " + calculate(1, 2, 3));
        System.out.println("Konkatenasi String: " + calculate("Hello, ", "World!"));
        // Latihan 13: Sistem processing data dengan static utilities
        // - Implementasikan data processor dengan berbagai method utility
        int[] data = {4, 2, 7, 2, 9, 4, 7};
        System.out.println("Data asli:");
        print(data);

        System.out.println("\nStatistik array (min, max, avg): " + Arrays.toString(getArrayStats(data)));

        System.out.println("Apakah 17 bilangan prima? " + MathUtils.isPrime(17));
        System.out.println("GCD dari 36 dan 60: " + MathUtils.gcd(36, 60));

        System.out.println("Reverse string 'level': " + StringUtils.reverse("level"));
        System.out.println("Apakah 'level' palindrome? " + StringUtils.isPalindrome("level"));
        System.out.println("Jumlah kata dalam 'Hello world Java!': " + StringUtils.countWords("Hello world Java!"));

        System.out.println("\nMencari duplikat dalam array:");
        int[] duplicates = ArrayUtils.findDuplicates(data);
        print(duplicates);

        System.out.println("\nMatrix demo:");
        int[][] matrixs = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayUtils.printMatrix(matrixs);
    }

    // ===== METHOD OVERLOADING EXAMPLES =====

    // TODO: Implementasikan method calculate yang di-overload
    public static int calculate(int a, int b) {
        // Penjumlahan dua integer
        return a + b; // Ganti dengan implementasi
    }

    public static double calculate(double a, double b) {
        // Penjumlahan dua double
        return a + b; // Ganti dengan implementasi
    }

    public static int calculate(int a, int b, int c) {
        // Penjumlahan tiga integer
        return a + b + c; // Ganti dengan implementasi
    }

    public static String calculate(String a, String b) {
        // Concatenation dua string
        return a + b; // Ganti dengan implementasi
    }

    // TODO: Implementasikan method print yang di-overload
    public static void print(int value) {
        // Print integer dengan format khusus
        System.out.println("Integer value: " + value);
    }

    public static void print(double value) {
        // Print double dengan format khusus
        System.out.println("Double value: " + value);
    }

    public static void print(String value) {
        // Print string dengan format khusus
        System.out.println("String value: \"" + value + "\"");
    }

    public static void print(int[] array) {
        // Print array dengan format khusus
        System.out.println("Array: " + Arrays.toString(array));
    }

    // ===== STATIC VS INSTANCE METHODS =====

    public static int getCounter() {
        // TODO: Return nilai counter static
        return counter;
    }

    public static void incrementCounter() {
        // TODO: Increment counter static
        counter++;
    }

    public String getInstanceName() {
        // TODO: Return instance name
        return instanceName;
    }

    public void setInstanceName(String name) {
        // TODO: Set instance name
        this.instanceName = name;
    }

    public void displayInfo() {
        // TODO: Display instance dan static information
        System.out.println("Instance: " + instanceName + ", Counter: " + counter);
    }

    // ===== PASS BY VALUE DEMONSTRATIONS =====

    public static void modifyPrimitive(int number) {
        // TODO: Modify parameter dan print perubahan
        number = number + 5;
        System.out.println("Inside modifyPrimitive: " + number);
    }

    public static void modifyArray(int[] array) {
        // TODO: Modify isi array
    }

    public static void reassignArray(int[] array) {
        // TODO: Reassign reference array
        if (array.length > 0) {
            array[0] = 99;
        }
    }

    // ===== ARRAY METHODS =====

    public static int[] sortArrayCopy(int[] original) {
        // TODO: Return sorted copy tanpa mengubah original
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        return copy; // Ganti dengan implementasi
    }

    public static double[] getArrayStats(int[] array) {
        // TODO: Return array [min, max, average]
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        double avg = Arrays.stream(array).average().getAsDouble();
        return new double[]{min, max, avg}; // Ganti dengan implementasi
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        // TODO: Merge dua array dan return hasil
        int[] merged = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        return merged; // Ganti dengan implementasi
    }

    // ===== VARIABLE ARGUMENTS (VARARGS) =====

    public static int sum(int... numbers) {
        // TODO: Hitung sum dari varargs
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total; // Ganti dengan implementasi
    }

    public static void printInfo(String title, int... values) {
        // TODO: Print title dan semua values
        System.out.println(title + ": " + Arrays.toString(values));
    }

    // ===== RECURSIVE METHODS =====

    public static long factorial(int n) {
        // TODO: Implementasi factorial recursive
        if (n <= 1) return 1;
        return n * factorial(n - 1); // Ganti dengan implementasi
    }

    public static int fibonacci(int n) {
        // TODO: Implementasi fibonacci recursive
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2); // Ganti dengan implementasi
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        // TODO: Implementasi binary search recursive
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        if (target < array[mid]) return binarySearchRecursive(array, target, left, mid - 1);
        else return binarySearchRecursive(array, target, mid + 1, right); // Ganti dengan implementasi
    }

    // ===== UTILITY CLASSES (INNER STATIC CLASSES) =====

    public static class MathUtils {
        public static double power(double base, int exponent) {
            // TODO: Implementasi power function
            if (exponent == 0) return 1;
            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }

        public static boolean isPrime(int number) {
            // TODO: Check apakah number adalah prime
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }

        public static int gcd(int a, int b) {
            // TODO: Greatest Common Divisor
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    public static class StringUtils {
        public static String reverse(String str) {
            // TODO: Reverse string
            return new StringBuilder(str).reverse().toString();
        }

        public static boolean isPalindrome(String str) {
            // TODO: Check palindrome
            return str.equals(reverse(str));
        }

        public static int countWords(String str) {
            // TODO: Count words in string
            if (str == null || str.trim().isEmpty()) return 0;
            return str.trim().split("\\s+").length;
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            // TODO: Print 2D array dengan format rapi
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        public static int[] findDuplicates(int[] array) {
            // TODO: Find duplicate elements
            java.util.Set<Integer> seen = new java.util.HashSet<>();
            java.util.Set<Integer> dupes = new java.util.HashSet<>();
            for (int n : array) {
                if (!seen.add(n)) dupes.add(n);
            }
            return dupes.stream().mapToInt(Integer::intValue).toArray();
        }

        public static boolean areEqual(int[] array1, int[] array2) {
            // TODO: Compare dua array
            return Arrays.equals(array1, array2);
        }
    }

    // ===== METHOD CHAINING EXAMPLE =====

    public static class Calculator {
        private double value;

        public Calculator(double initial) {
            this.value = initial;
        }

        public Calculator add(double n) {
            // TODO: Add dan return this untuk chaining
            this.value += n;
            return this;
        }

        public Calculator multiply(double n) {
            // TODO: Multiply dan return this untuk chaining
            this.value *= n;
            return this;
        }

        public Calculator subtract(double n) {
            // TODO: Subtract dan return this untuk chaining
            this.value -= n;
            return this;
        }

        public double getResult() {
            return value;
        }
    }
}
