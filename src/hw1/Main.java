package hw1;

public class Main {

    public static void main(String[] args) {

        /*
         * Задание 1. Реализуйте 3 метода, чтобы в каждом из них получить разные
         * исключения:
         */
        generateNullPointerException(); // Метод, генерирующий NullPointerException
        generateArrayIndexOutOfBoundsException(); // Метод, генерирующий ArrayIndexOutOfBoundsException
        generateNumberFormatException(); // Метод, генерирующий NumberFormatException

        /*
         * Задание 2. Посмотрите на код, и подумайте сколько разных типов исключений вы
         * тут сможете получить?
         * 
         * Примечание:
         * В предложенном коде можно получить два разных типа исключений:
         * a) NumberFormatException: Это исключение возникает при попытке преобразовать
         * некорректное строковое представление числа в целочисленное значение с помощью
         * метода `Integer.parseInt()`. Если элемент массива `arr` не может быть
         * корректно преобразован в целое число, возникнет исключение
         * NumberFormatException.
         * b) ArrayIndexOutOfBoundsException: Это исключение возникает, если индекс
         * элемента выходит за пределы допустимого диапазона массива. В данном случае,
         * если значение `i` превышает количество строк в массиве `arr`, или значение
         * `j` превышает 4 (так как внутренний цикл ограничен до `j < 5`), возникнет
         * исключение ArrayIndexOutOfBoundsException.
         */
        String[][] exampleArray = {
                { "1", "2", "3", "4", "5" },
                { "6", "7", "8", "9", "10" },
                { "11", "12", "13", "14", "15" } };
        sum2d(exampleArray); // Метод из описания задания
        sum2dExceptions(exampleArray); // Метод с обработкой исключений

        /*
         * Задание 3 и Задание 4.
         */
        int[] array1 = { 4, 8, 12, 16 };
        int[] array2 = { 1, 2, 3, 4 };

        subtractArrays(array1, array2); // разность
        divideArrays(array1, array2); // деление
    }

    public static void generateNullPointerException() {
        String str = null;
        int length = str.length();
    }

    public static void generateArrayIndexOutOfBoundsException() {
        int[] arr = new int[5];
        int element = arr[10];
    }

    public static void generateNumberFormatException() {
        String str = "abc";
        int number = Integer.parseInt(str);
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static int sum2dExceptions(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    System.err.println("Некорректное число: " + arr[i][j]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Неверные индексы: i=" + i + ", j=" + j);
                }
            }
        }
        return sum;
    }

    public static int[] subtractArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }

        return result;
    }

    public static double[] divideArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }

        double[] result = new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0) {
                throw new RuntimeException("Деление на 0");
            }
            result[i] = (double) array1[i] / array2[i];
        }

        return result;
    }

}
