package com.talent;

public class ChessAttacks {
	final static String PLAYING = "BLACK"; // "WHITE"

	public static int isInLineOfPawn(int rowDiff, int colDiff) {
		if (PLAYING.equals("WHITE")) {
			return Math.abs(colDiff) == 1 && rowDiff == -1 ? 1 : 0;
		} else {
			return Math.abs(colDiff) == 1 && rowDiff == 1 ? 1 : 0;
		}
	}

	public static int getColPosition(String position) {
		return position.toUpperCase().charAt(0) - 64;
	}

	public static int getRowPosition(String position) {
		return position.toUpperCase().charAt(1) - 48;
	}

	public static int checkAttack(String coinOne, String coinPosition,
			String coinOther,String otherPosition) {
		int colPosPawn = getColPosition(coinPosition);
		int rowPosPawn = getRowPosition(coinPosition);
		int colPosOther = getColPosition(otherPosition);
		int rowPosOther = getRowPosition(otherPosition);
		int colDiff = colPosOther - colPosPawn;
		int rowDiff = rowPosPawn - rowPosOther;
		int sum = 0;
		if (coinOne.toUpperCase().equals("PAWN")) {
			sum += isInLineOfPawn(rowDiff, colDiff);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(checkAttack("PAWN","A3","PAWN","A4"));
	}
}
