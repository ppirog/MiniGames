package app.lotto;

import lombok.Data;

import java.util.*;
@Data
class LottoNumberGenerator {

    public Set<Integer> generate6RandomNumbers(Random random) {

        Set<Integer> randomNumbers = new TreeSet<>();

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
