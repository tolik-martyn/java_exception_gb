package hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
         * Задание 1.
         * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
         * (типа float), и возвращает введенное значение. Ввод текста вместо числа не
         * должно приводить к падению приложения, вместо этого, необходимо повторно
         * запросить у пользователя ввод данных.
         */
        float number = getFloatInput();
        System.out.println("Введенное число: " + number);

        /*
         * Задание 2.
         * Если необходимо, исправьте данный код.
         */
        try {
            int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 }; // Объявление и инициализацию массива `intArray`, чтобы
                                                         // избежать ошибки массива.
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e); // Добавление `catch`блока для
                                                                   // `ArrayIndexOutOfBoundsException`, чтобы обработать
                                                                   // исключение, если индекс массива выходит за предел
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e); // Изменение текста вывода сообщения, чтобы указать
                                                              // конкретный тип исключения, которое было перехвачено.
        }

        /*
         * Задание 3.
         * Исправления:
         * а) Удалено объявление throws Exception в методе main, поскольку в коде нет
         * операций, которые могут вызвать исключение Exception.
         * б) Переупорядочены блоки catch в методе main таким образом, чтобы исключение
         * ArithmeticException (деление на ноль) обрабатывалось первым, затем
         * NullPointerException, затем ArrayIndexOutOfBoundsException, и в конце -
         * Throwable.
         * в) Удалено объявление throws FileNotFoundException в методе printSum, так как
         * в коде нет работы с файлами и, следовательно, нет необходимости в этом
         * исключении.
         */
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Индекс массива находится за пределами допустимого диапазона!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }

    private static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Введите дробное число: ");
            try {
                number = scanner.nextFloat();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введенное значение не является дробным числом. Попробуйте снова.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }

        return number;
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
