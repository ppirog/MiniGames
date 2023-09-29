package app.lotto;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserNumberReceiverTests {


    @Test
    public void has_receiver_exactly_6_numbers_test1() {
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        String givenNumbers =
                "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    @Test
    public void has_receiver_exactly_6_numbers_test2() {
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        String givenNumbers =
                "-1\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    @Test
    public void has_receiver_exactly_6_numbers_test3() {
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        String givenNumbers =
                "100\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    @Test
    public void has_receiver_exactly_6_numbers_test4() {
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        String givenNumbers =
                "6\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    @Test
    public void has_receiver_exactly_6_numbers_test5() {
        List<Integer> expectedNumbers = List.of( 1, 2, 3, 4, 5, 6);
        String givenNumbers =
                "6\n" +
                        "6\n" +
                        "6\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    @Test
    public void has_receiver_exactly_6_numbers_test6() {
        List<Integer> expectedNumbers = List.of(1, 22, 33, 44, 55, 99);
        String givenNumbers =
                "0\n" +
                        "1\n" +
                        "1\n" +
                        "22\n" +
                        "33\n" +
                        "33\n" +
                        "44\n" +
                        "55\n" +
                        "99\n" +
                        "99\n";

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        List<Integer> list = receiver.readUserNumber();
        assertThat(expectedNumbers).isEqualTo(list);
    }

    private BufferedReader mockReaderIn(String data) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
    }
}
