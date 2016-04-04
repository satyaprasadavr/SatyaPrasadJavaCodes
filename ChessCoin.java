public abstract class ChessCoin {
	Position position;
	String color;

	public ChessCoin(){}
	public ChessCoin(Position position, String color) {
		this.position = position;
		this.color = color;
	}

	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position){
		this.position=position;
	}

	public abstract boolean canAttackTo(Position position);

	public boolean canAttackTo(ChessCoin chessCoin) {
		// TODO Auto-generated method stub
		return canAttackTo(chessCoin.getPosition());
	}
}
