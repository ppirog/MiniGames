package app.lotto;

import app.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Set;

public class LottoGameLauncher implements Game {

    @Override
    public void start() {
        UserNumberReceiver receiver = new UserNumberReceiver(new BufferedReader(new InputStreamReader(System.in)));
        Set<Integer> userSet = receiver.readUserNumber();

        LottoNumberGenerator generator = new LottoNumberGenerator();
        Set<Integer> randomSet = generator.generate6RandomNumbers(new Random());

        LottoGameVerficator verficator = new LottoGameVerficator(userSet,randomSet);
        System.out.println(verficator.verifyUserResult());

    }
}
