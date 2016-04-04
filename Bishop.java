public class Bishop extends ChessCoin {

	public Bishop(Position position, String color) {
		super(position, color);
	}
	public Bishop(){}

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
		return Math.abs(rowDiff) == Math.abs(colDiff);
	}

	
}
