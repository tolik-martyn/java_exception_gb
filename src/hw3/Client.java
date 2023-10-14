package hw3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();

            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();

            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();

            System.out.println("Введите дату рождения в формате dd.mm.yyyy:");
            String dateOfBirth = scanner.nextLine();

            long phoneNumber = 0;
            boolean validPhoneNumber = false;
            while (!validPhoneNumber) {
                try {
                    System.out.println("Введите номер телефона:");
                    phoneNumber = Long.parseLong(scanner.nextLine());
                    if (phoneNumber > 0)
                        validPhoneNumber = true;
                    else
                        throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Некорректный номер телефона. Попробуйте еще раз.");
                }
            }

            char gender = '\0';
            boolean validGender = false;
            while (!validGender) {
                System.out.println("Введите пол (f - женский, m - мужской):");
                String genderStr = scanner.nextLine();
                if (genderStr.length() == 1) {
                    gender = genderStr.charAt(0);
                    if (gender == 'f' || gender == 'm') {
                        validGender = true;
                    } else {
                        System.out.println("Ошибка: Некорректное значение пола. Попробуйте еще раз.");
                    }
                } else {
                    System.out.println("Ошибка: Некорректное значение пола. Попробуйте еще раз.");
                }
            }

            try {
                Human human = new Human(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
                saveToFile(human);
            } catch (InvalidDataException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (DataFormatException e) {
                System.out.println("Ошибка формата данных: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(Human human) throws InvalidDataException, DataFormatException {
        validateData(human);

        String fileName = human.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(human.toString() + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static void validateData(Human human) throws InvalidDataException, DataFormatException {
        if (human.getLastName().isEmpty()) {
            throw new InvalidDataException("Не указана фамилия.");
        }

        if (human.getFirstName().isEmpty()) {
            throw new InvalidDataException("Не указано имя.");
        }

        if (human.getDateOfBirth().isEmpty()) {
            throw new InvalidDataException("Не указана дата рождения.");
        }

        String[] parts = human.getDateOfBirth().split("\\.");
        if (parts.length != 3) {
            throw new DataFormatException("Неправильный формат даты рождения.");
        }
        int day, month, year;
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Некорректные значения дня, месяца или года.");
        }

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2023) {
            throw new DataFormatException("Некорректная дата рождения.");
        }
    }
}
