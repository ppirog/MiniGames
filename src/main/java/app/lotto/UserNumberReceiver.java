package app.lotto;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class UserNumberReceiver {
    private final BufferedReader reader;

    public List<Integer> readUserNumber() {
        List<Integer> userNumbers = new ArrayList<>();

        for (int i = 0; i < 6; ++i) {
            while (true) {
                try {
                    System.out.println("enter number: ");
                    int num = Integer.parseInt(reader.readLine());
                    if (!userNumbers.contains(num)) {
                        if (!(num >= 1 && num <= 99)) {
                            System.out.println("Number must be in range 1 - 99");
                            continue;
                        }
                        userNumbers.add(num);
                        break;
                    }
                    System.out.println("You entered this number previously!");

                } catch (NumberFormatException e) {
                    System.out.println("enter valid number!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        userNumbers.sort(Comparator.naturalOrder());
        return  userNumbers;

    }

}
