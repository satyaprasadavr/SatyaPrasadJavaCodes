public class Main {

	public static int checkCoinAttacks(ChessCoin x, ChessCoin y) {
		if (x == null || y == null) {
			System.out.println("Not a proper chess coin");
			return 0;
		}

		if (x.getPosition() == null || y.getPosition() == null) {
			System.out.println("Set positions of coins please ");
			return 0;
		}
		int sum = 0;
		if (x.canAttackTo(y)) {
			sum = sum + 1;
		}
		if (y.canAttackTo(x)) {
			sum = sum + 2;
		}

		if (sum == 3)
			sum = 4;
		return sum;

	}

	public static void main(String[] args) {
		ChessCoin king = CoinFactory.getChessCoin("king");
		king.setPosition(new Position("A6"));

		ChessCoin pawn = CoinFactory.getChessCoin("pawn");
		
		pawn.setPosition(new Position("A4"));

		System.out.println(checkCoinAttacks(king, pawn));

	}
}
