public class Queen extends ChessCoin {

	public Queen(Position position,String color) {
		super(position,color);
	}
	public Queen(){}

	@Override
	public boolean canAttackTo(Position position) {
		// TODO Auto-generated method stub
		if(position==null || this.position==null)
		{
			System.out.println("set Position of the coins please");
			return false;
		}
	
		int rowDiff = Position.getRowDifferece(this.position, position);
		int colDiff = Position.getColDifferece(this.position, position);

		return rowDiff == 0 || colDiff == 0
				|| Math.abs(rowDiff) == Math.abs(colDiff);

	}
}
