package baseball;

public class Application {
    public static void main(String[] args) {
        boolean gameEndFlag = false;
        Game game = new Game();
        while (!gameEndFlag) {
            game.play();
            gameEndFlag = game.isGameEnd();
        }
    }
}
