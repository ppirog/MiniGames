package app.lotto;

import java.util.*;

public class LottoNumberGenerator {

    public Set<Integer> generate6RandomNumbers() {
        Random random = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        for (int i = 0; i < 6; ++i) {

            while (true) {
                int num = random.nextInt(99) + 1;
                if (!randomNumbers.contains(num)) {
                    randomNumbers.add(num);
                    break;
                }
            }
        }
        return randomNumbers;
    }
}