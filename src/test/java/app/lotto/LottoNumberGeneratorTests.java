package app.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTests {
    LottoNumberGenerator generator = new LottoNumberGenerator();

    @Test
    public void check_if_in_random_contains_are_exacly_6_numbers() {
        //given
        int givenSize = generator.generate6RandomNumbers().size();
        //when
        int expectedSize = 6;
        //when
        assertThat(givenSize).isEqualTo(expectedSize);
    }

    @Test
    public void check_if_in_random_contains_are_exacly_6_unique_numbers() {
        //given
        boolean givenUniqueNumbers = true;
        Set<Integer> randomSet = generator.generate6RandomNumbers();
        for(var num : randomSet){
            Set<Integer> counter = randomSet
                    .stream()
                    .filter(integer -> integer.equals(num))
                    .collect(Collectors.toSet());

            if(counter.size() != 1){
                givenUniqueNumbers = false;
            }
        }
        //when
        boolean expectedUniqueNumbers = true;
        //when
        assertThat(givenUniqueNumbers).isEqualTo(expectedUniqueNumbers);
    }

    @Test
    public void check_if_in_random_contains_are_numbers_from_1_do_99_numbers_test1() {
        //given
        boolean givenInRangeNumbers = true;
        for(int i = 0;i < 1000;++i){
            Set<Integer> randomSet = generator.generate6RandomNumbers();
            Set<Integer> counter = randomSet
                    .stream()
                    .filter(integer -> integer >= 1)
                    .filter(integer -> integer <= 99)
                    .collect(Collectors.toSet());
            if(counter.size() != 6){
                givenInRangeNumbers = false;
            }
        }
        //when
        boolean expectedInRangeNumbers = true;
        //when
        assertThat(givenInRangeNumbers).isEqualTo(expectedInRangeNumbers);
    }
    @Test
    public void check_if_in_random_contains_are_numbers_from_1_do_99_numbers_test2() {
        //given
        boolean givenInRangeNumbers = true;
        int numberOfSamples = 10000;
        for(int i = 0;i < numberOfSamples;++i){
            Set<Integer> randomSet = generator.generate6RandomNumbers();
            Set<Integer> counter = randomSet
                    .stream()
                    .filter(integer -> integer >= 1)
                    .filter(integer -> integer <= 99)
                    .collect(Collectors.toSet());
            if(counter.size() != 6){
                givenInRangeNumbers = false;
            }

        }
        //when
        boolean expectedInRangeNumbers = true;
        //when
        assertThat(givenInRangeNumbers).isEqualTo(expectedInRangeNumbers);
    }

}
