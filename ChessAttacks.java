public class ChessAttacks {
	final static String PLAYING = "BLACK"; // "WHITE"

	public static int isInLineOfPawn(int rowDiff, int colDiff) {
		if (PLAYING.equals("WHITE")) {
			return Math.abs(colDiff) == 1 && rowDiff == -1 ? 1 : 0;
		} else {
			return Math.abs(colDiff) == 1 && rowDiff == 1 ? 1 : 0;
		}
	}

	public static int isInLineOfElephant(int rowDiff, int colDiff) {
		return rowDiff == 0 || colDiff == 0 ? 1 : 0;
	}

	public static int isInLineOfBishop(int rowDiff, int colDiff) {
		return Math.abs(rowDiff) == Math.abs(colDiff) ? 1 : 0;
	}

	public static int isInLineOfKnight(int rowDiff, int colDiff) {
		return (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 2)
				|| (Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 1) ? 1 : 0;
	}

	public static int isInLineOfKing(int rowDiff, int colDiff) {
		return (Math.abs(rowDiff) <= 1 && Math.abs(colDiff) <= 1) ? 1 : 0;
	}

	public static int isInLineOfQueen(int rowDiff, int colDiff) {
		return (isInLineOfBishop(rowDiff, colDiff) == 1 || isInLineOfElephant(
				rowDiff, colDiff) == 1) ? 1 : 0;
	}

	public static int getColPosition(String position) {
		return position.toUpperCase().charAt(0) - 64;
	}

	public static int getRowPosition(String position) {
		return position.toUpperCase().charAt(1) - 48;
	}

	public static int checkAttack(String coinOne, String coinPosition,
			String coinOther, String otherPosition) {
		int colPosOne = getColPosition(coinPosition);
		int rowPosOne = getRowPosition(coinPosition);
		int colPosOther = getColPosition(otherPosition);
		int rowPosOther = getRowPosition(otherPosition);
		int colDiff = colPosOne - colPosOther;
		int rowDiff = rowPosOne - rowPosOther;
		int sum = 0;
		if (coinOne.toUpperCase().equals("PAWN")) {
			sum += isInLineOfPawn(rowDiff, colDiff);
		}
		if (coinOne.toUpperCase().equals("ELEPHANT")) {
			sum += isInLineOfElephant(rowDiff, colDiff);
		}
		if (coinOne.toUpperCase().equals("BISHOP")) {
			sum += isInLineOfBishop(rowDiff, colDiff);
		}
		if (coinOne.toUpperCase().equals("KNIGHT")) {
			sum += isInLineOfKnight(rowDiff, colDiff);
		}
		if (coinOne.toUpperCase().equals("KING")) {
			sum += isInLineOfKing(rowDiff, colDiff);
		}
		if (coinOne.toUpperCase().equals("QUEEN")) {
			sum += isInLineOfQueen(rowDiff, colDiff);
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(checkAttack("PAWN", "C5", "PAWN", "D4"));
		System.out.println(checkAttack("ELEPHANT", "C5", "PAWN", "D5"));
		System.out.println(checkAttack("BISHOP", "C5", "PAWN", "A3"));
		System.out.println(checkAttack("KNIGHT", "C3", "PAWN", "B5"));
		System.out.println(checkAttack("KING", "D3", "PAWN", "C2"));
		System.out.println(checkAttack("QUEEN", "I1", "PAWN", "J1"));

	}
}
