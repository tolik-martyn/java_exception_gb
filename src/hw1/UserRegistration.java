package hw1;

import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        boolean isRegistrationSuccessful = registerUser();
        System.out.println("Успешная регистрация: " + isRegistrationSuccessful);
    }

    public static boolean registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        System.out.print("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();

        // Проверка логина на символы
        if (!login.matches("[abcde01_]+")) {
            throw new RuntimeException(
                    "Неверный логин. Логин должен содержать только символы: a, b, c, d, e, 0, 1, _");
        }

        // Проверка длины логина
        if (login.length() < 4 || login.length() > 8) {
            throw new RuntimeException("Недопустимая длина логина. Длина логина должна составлять от 4 до 8 символов");
        }

        // Проверка пароля на символы и длину
        if (!password.matches("[0-9]+") || password.length() < 4 || password.length() > 8) {
            throw new RuntimeException("Неверный пароль. Длина пароля должна составлять от 4 до 8 цифр.");
        }

        // Проверка совпадения пароля и его подтверждения
        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Пароли не совпадают");
        }

        return true;
    }
}
