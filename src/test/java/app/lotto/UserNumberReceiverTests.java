package app.lotto;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserNumberReceiverTests {


    @Test
    public void has_receiver_exactly_6_numbers_correct_user_input_test() {
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String givenNumbers = """
                1
                2
                3
                4
                5
                6
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }

    @Test
    public void has_receiver_exactly_6_numbers_in_correct_range_test1() {
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);

        String givenNumbers = """
                -1
                1
                2
                3
                4
                5
                6
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }

    @Test
    public void has_receiver_exactly_6_numbers_in_correct_range_test2() {
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String givenNumbers = """
                100
                1
                2
                3
                4
                5
                6
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }

    @Test
    public void has_receiver_exactly_6_numbers_one_value_is_two_times_test() {
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String givenNumbers = """
                6
                1
                2
                3
                4
                5
                6
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }

    @Test
    public void has_receiver_exactly_6_numbers_one_value_is_four_times_test() {
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String givenNumbers = """
                6
                6
                6
                1
                2
                3
                4
                5
                6
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);

    }

    @Test
    public void has_receiver_exactly_6_numbers_three_values_are_two_times_test() {
        Set<Integer> expectedNumbers = Set.of(1, 22, 33, 44, 55, 99);
        String givenNumbers = """
                0
                1
                1
                22
                33
                33
                44
                55
                99
                99
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }
    @Test
    public void has_receiver_exactly_6_numbers_letters_agains_integers_test() {
        Set<Integer> expectedNumbers = Set.of(1, 22, 33, 44, 55, 99);
        String givenNumbers = """
                0
                1
                1
                d
                g
                aw
                22
                33
                33
                44
                55
                99
                99
                """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> set = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(set);
    }

    private BufferedReader mockReaderIn(String data) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
    }
}
