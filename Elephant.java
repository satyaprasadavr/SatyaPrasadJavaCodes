public class Elephant extends ChessCoin {

	public Elephant(Position position,String color) {
		super(position,color);
	}
	public Elephant(){}

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

		return rowDiff == 0 || colDiff == 0;

	}
}
