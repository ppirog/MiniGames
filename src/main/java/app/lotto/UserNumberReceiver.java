package app.lotto;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
class UserNumberReceiver {
    public static final String NUMBER_MUST_BE_IN_RANGE_1_99 = "Number must be in range 1 - 99";
    public static final String ENTER_NUMBER = "enter number: ";
    public static final String YOU_ENTERED_THIS_NUMBER_PREVIOUSLY = "You entered this number previously!";
    public static final String ENTER_VALID_NUMBER = "enter valid number!";
    private final BufferedReader reader;

    public Set<Integer> readUserNumber() {
        Set<Integer> userNumbers = new TreeSet<>();

        for (int i = 0; i < 6; ++i) {
            while (true) {
                try {
                    System.out.println(ENTER_NUMBER);
                    int num = Integer.parseInt(reader.readLine());
                    if (!userNumbers.contains(num)) {
                        if (!(num >= 1 && num <= 99)) {
                            System.out.println(NUMBER_MUST_BE_IN_RANGE_1_99);
                            continue;
                        }
                        userNumbers.add(num);
                        break;
                    }
                    System.out.println(YOU_ENTERED_THIS_NUMBER_PREVIOUSLY);

                } catch (NumberFormatException e) {
                    System.out.println(ENTER_VALID_NUMBER);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userNumbers;

    }

}
