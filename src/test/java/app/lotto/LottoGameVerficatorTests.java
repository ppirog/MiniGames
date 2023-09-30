package app.lotto;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameVerficatorTests {
    @Test
    public void should_result_text_be_correct_test1(){
        //given
        String givenNumbers =
                """
                        0
                        1
                        1
                        2
                        3
                        3
                        4
                        5
                        6
                        6
                        """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> userSet = receiver.readUserNumber();

        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(1);
        resultSet.add(2);
        resultSet.add(3);
        resultSet.add(4);
        resultSet.add(5);
        resultSet.add(6);

        LottoGameVerficator lottoGameVerficator = new LottoGameVerficator(userSet,resultSet);

        String givenResult = lottoGameVerficator.verifyUserResult();
        //when
        String expectedResult = """
                Result: 6
                User numbers: 1 2 3 4 5 6\s
                Lotto numbers: 1 2 3 4 5 6\s
                """;

        //then
        assertThat(givenResult).isEqualTo(expectedResult);

    }
    @Test
    public void should_result_text_be_correct_test2(){
        //given
        String givenNumbers =
                """
                        0
                        0
                        11
                        1
                        22
                        3
                        3
                        4
                        4
                        6
                        6
                        """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> userSet = receiver.readUserNumber();

        Set<Integer> resultSet = new TreeSet<>();
        resultSet.add(94);
        resultSet.add(95);
        resultSet.add(96);
        resultSet.add(97);
        resultSet.add(98);
        resultSet.add(99);


        LottoGameVerficator lottoGameVerficator = new LottoGameVerficator(userSet,resultSet);

        String givenResult = lottoGameVerficator.verifyUserResult();
        //when
        String expectedResult = """
                Result: 0
                User numbers: 1 3 4 6 11 22\s
                Lotto numbers: 94 95 96 97 98 99\s
                """;

        //then
        assertThat(givenResult).isEqualTo(expectedResult);

    }
    @Test
    public void should_result_text_be_correct_test3(){
        //given
        String givenNumbers =
                """
                        0
                        0
                        94
                        1
                        96
                        3
                        3
                        4
                        4
                        6
                        6
                        """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> userSet = receiver.readUserNumber();

        Set<Integer> resultSet = new TreeSet<>();
        resultSet.add(94);
        resultSet.add(95);
        resultSet.add(96);
        resultSet.add(97);
        resultSet.add(98);
        resultSet.add(99);


        LottoGameVerficator lottoGameVerficator = new LottoGameVerficator(userSet,resultSet);

        String givenResult = lottoGameVerficator.verifyUserResult();
        //when
        String expectedResult = """
                Result: 2
                User numbers: 1 3 4 6 94 96\s
                Lotto numbers: 94 95 96 97 98 99\s
                """;

        //then
        assertThat(givenResult).isEqualTo(expectedResult);
    }
    @Test
    public void should_result_text_be_correct_test4(){
        //given
        String givenNumbers =
                """
                        0
                        0
                        94
                        1
                        96
                        3
                        3
                        4
                        4
                        99
                        99
                        """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> userSet = receiver.readUserNumber();

        Set<Integer> resultSet = new TreeSet<>();
        resultSet.add(94);
        resultSet.add(95);
        resultSet.add(96);
        resultSet.add(97);
        resultSet.add(98);
        resultSet.add(99);


        LottoGameVerficator lottoGameVerficator = new LottoGameVerficator(userSet,resultSet);

        String givenResult = lottoGameVerficator.verifyUserResult();
        //when
        String expectedResult = """
                Result: 3
                User numbers: 1 3 4 94 96 99\s
                Lotto numbers: 94 95 96 97 98 99\s
                """;
        //then
        assertThat(givenResult).isEqualTo(expectedResult);
    }
    @Test
    public void should_result_text_be_correct_test5(){
        //given
        String givenNumbers =
                """
                        0
                        0
                        94
                        1
                        96
                        3
                        3
                        91
                        91
                        99
                        99
                        """;

        BufferedReader reader = mockReaderIn(givenNumbers);
        UserNumberReceiver receiver = new UserNumberReceiver(reader);
        Set<Integer> userSet = receiver.readUserNumber();

        Set<Integer> resultSet = new TreeSet<>();
        resultSet.add(94);
        resultSet.add(95);
        resultSet.add(96);
        resultSet.add(97);
        resultSet.add(91);
        resultSet.add(99);


        LottoGameVerficator lottoGameVerficator = new LottoGameVerficator(userSet,resultSet);

        String givenResult = lottoGameVerficator.verifyUserResult();
        //when
        String expectedResult = """
                Result: 4
                User numbers: 1 3 91 94 96 99\s
                Lotto numbers: 91 94 95 96 97 99\s
                """;
        //then
        assertThat(givenResult).isEqualTo(expectedResult);
    }

    private BufferedReader mockReaderIn(String data) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
    }
}
