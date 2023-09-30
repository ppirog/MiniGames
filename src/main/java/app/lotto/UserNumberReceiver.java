package app.lotto;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
class UserNumberReceiver {
    private final BufferedReader reader;

    public Set<Integer> readUserNumber() {
        Set<Integer> userNumbers = new TreeSet<>();

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
        return  userNumbers;
    }

}
