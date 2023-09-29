package app.lotto;

import app.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class LottoGameLauncher implements Game {

    @Override
    public void start() {
        UserNumberReceiver receiver = new UserNumberReceiver(new BufferedReader(new InputStreamReader(System.in)));
        Set<Integer> set = receiver.readUserNumber();
        LottoNumberGenerator generator = new LottoNumberGenerator();


        Set<Integer> randomSet = generator.generate6RandomNumbers();
        System.out.println(randomSet);
    }
}
