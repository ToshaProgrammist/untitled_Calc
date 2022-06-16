package Exception;

import Enum.*;

public class Processing {
    public static void ProcessingString(String[] regex) {
        try {
            if (regex[0].matches("[a-z]{0,}") || regex[2].matches("[a-z]{0,}")) {
                throw new InvalidRomanFormat("Неверный формат введённых римских цифр");
            } else if (regex.length <= 2) {
                throw new InvalidOperationFormatException("Неверный формат операции");
            } else if (regex.length > 3) {
                throw new InvalidOperandFormatException("Превышено количество операндов");
            } else if ((regex[0].matches("\\d{0,}") && regex[2].matches("\\D{0,}")) || (regex[0].matches("\\D{0,}") && regex[2].matches("\\d{0,}"))) {
                throw new DifferentNumberSystemsException("Используются разные числовые системы");
            } else if (regex[0].matches("\\D{0,}") && regex[2].matches("\\D{0,}")) {
                Roman number1 = Roman.getCurrentString(regex[0]);
                Roman number2 = Roman.getCurrentString(regex[2]);
                if (number1.getNumber() < 1 || number1.getNumber() > 10 || number2.getNumber() < 1 || number2.getNumber() > 10) {
                    throw new NumberLimitException("Превышен лимит входящего числа");
                }
            } else if (Integer.parseInt(regex[0]) < 1 || Integer.parseInt(regex[0]) > 10 || Integer.parseInt(regex[2]) < 1 || Integer.parseInt(regex[2]) > 10) {
                throw new NumberLimitException("Превышен лимит входящего числа");
            }

        } catch (InvalidOperationFormatException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (InvalidOperandFormatException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (DifferentNumberSystemsException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (NumberLimitException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (InvalidRomanFormat e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
