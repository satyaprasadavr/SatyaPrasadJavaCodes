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

		int sumA = 0;
		int sumB = 0;
		if (coinOne.toUpperCase().equals("PAWN")) {
			sumA = isInLineOfPawn(rowDiff, colDiff);
		}
		if (coinOther.toUpperCase().equals("PAWN")) {
			sumB = isInLineOfPawn(rowDiff * -1, colDiff * -1);
		}

		if (coinOne.toUpperCase().equals("ELEPHANT")) {
			sumA = isInLineOfElephant(rowDiff, colDiff);
		}

		if (coinOther.toUpperCase().equals("ELEPHANT")) {
			sumB = isInLineOfElephant(rowDiff * -1, colDiff * -1);
		}

		if (coinOne.toUpperCase().equals("BISHOP")) {
			sumA = isInLineOfBishop(rowDiff, colDiff);
		}

		if (coinOther.toUpperCase().equals("BISHOP")) {
			sumB = isInLineOfBishop(rowDiff * -1, colDiff * -1);
		}

		if (coinOne.toUpperCase().equals("KNIGHT")) {
			sumA = isInLineOfKnight(rowDiff, colDiff);
		}
		if (coinOther.toUpperCase().equals("KNIGHT")) {
			sumB = isInLineOfKnight(rowDiff * -1, colDiff * -1);
		}

		if (coinOne.toUpperCase().equals("KING")) {
			sumA += isInLineOfKing(rowDiff, colDiff);
		}
		if (coinOther.toUpperCase().equals("KING")) {
			sumB += isInLineOfKing(rowDiff * -1, colDiff * -1);
		}

		if (coinOne.toUpperCase().equals("QUEEN")) {
			sumA += isInLineOfQueen(rowDiff, colDiff);
		}

		if (coinOther.toUpperCase().equals("QUEEN")) {
			sumB += isInLineOfQueen(rowDiff * -1, colDiff * -1);
		}
		return (sumA+sumB==2)?4:(sumA==1)?1:(sumB==1)?2:0;
		
	}

	public static void main(String[] args) {
		System.out.println(checkAttack("PAWN", "C5", "PAWN", "D4"));
		System.out.println(checkAttack("ELEPHANT", "C5", "PAWN", "D5"));
		System.out.println(checkAttack("BISHOP", "C5", "PAWN", "A3"));
		System.out.println(checkAttack("KNIGHT", "C3", "PAWN", "B5"));
		System.out.println(checkAttack("KING", "D3", "PAWN", "C2"));
		System.out.println(checkAttack("QUEEN", "I1", "PAWN", "J1"));
		System.out.println(checkAttack("QUEEN", "I1", "QUEEN", "J1"));
		System.out.println(checkAttack("BISHOP", "A3", "KNIGHT", "A4"));
		System.out.println(checkAttack("BISHOP", "A3", "KNIGHT", "B4"));
		System.out.println(checkAttack("BISHOP", "A3", "KING", "B3"));

	}
}
