package app;

import app.lotto.LottoGameLauncher;

public class GameLauncher {

    public static void main(String[] args) {
        Game game = new LottoGameLauncher();
        game.start();

    }
}
