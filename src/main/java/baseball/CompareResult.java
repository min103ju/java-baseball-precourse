package baseball;

/**
 * author : citizen103
 */
public class CompareResult {

    private int strike = 0;
    private int ball = 0;

    public boolean isThreeStrike() {
        if (strike == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
            return true;
        }
        return false;
    }

    public void checkBallStatus(BallStatus compareBallStatus) {
        if (BallStatus.STRIKE == compareBallStatus) {
            strike++;
        }

        if (BallStatus.BALL == compareBallStatus) {
            ball++;
        }
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        setBallMessage(sb);
        setStrikeMessage(sb);
        setNothingMessage(sb);
        System.out.println(sb.toString());
    }

    private StringBuilder setBallMessage(StringBuilder sb) {
        if (ball != 0) {
            sb.append(String.format("%d볼 ", ball));
        }
        return sb;
    }

    private StringBuilder setStrikeMessage(StringBuilder sb) {
        if (strike != 0) {
            sb.append(String.format("%d스트라이크", strike));
        }
        return sb;
    }

    private StringBuilder setNothingMessage(StringBuilder sb) {
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        return sb;
    }
}
