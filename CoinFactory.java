
public class CoinFactory {
	public static ChessCoin getChessCoin(String str){
		if(str.equalsIgnoreCase("king")){
			return new King();
		}
		if(str.equalsIgnoreCase("queen")){
			return new Queen();
		}
		if(str.equalsIgnoreCase("pawn")){
			return new Pawn();
		}
		if(str.equalsIgnoreCase("Bishop")){
			return new Bishop();
		}
		if(str.equalsIgnoreCase("elephant")){
			return new Elephant();
		}
		if(str.equalsIgnoreCase("knight")){
			return new Knight();
		}
		return null;
	}
}
