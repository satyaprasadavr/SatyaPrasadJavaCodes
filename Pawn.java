public class Pawn extends ChessCoin {

	public Pawn(Position position, String color) {
		super(position, color);
	}

	public Pawn() {
	}

	public void setColor(String color) {
		if (color.equalsIgnoreCase("white")) {
			color = "White";
		} else if (color.equalsIgnoreCase("black")) {
			color = "Black";
		} else {
			System.out
					.println("white or black color required...set to white by default");
			color = "white";
		}

	}

	@Override
	public boolean canAttackTo(Position position) {
		// TODO Auto-generated method stub
		if (position == null || this.position == null) {
			System.out.println("set Position of the coins please");
			return false;
		}
		if (color == null) {
			System.out.println("Kindly set the color of pawn please");
			return false;
		}

		int rowDiff = Position.getRowDifferece(this.position, position);
		int colDiff = Position.getColDifferece(this.position, position);
		if (color.equalsIgnoreCase("white")) {
			return Math.abs(colDiff) == 1 && rowDiff == -1;
		} else {
			return Math.abs(colDiff) == 1 && rowDiff == 1;
		}
	}
}
