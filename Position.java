public class Position {
	private char colName;
	private char rowName;

	public Position(String position)
	{
		setPosition(position);
	}
	
	public void setPosition(String position) {
		colName = position.toUpperCase().charAt(0);
		rowName = position.charAt(1);
		if (!"ABCDEFGH".contains("" + colName)) {
			System.out.println("Invalid Column Position..Default set to A");
			colName = 'A';
		}
		if (!"12345678".contains("" + rowName)) {
			System.out.println("Invalid Row Position..Default set to 1");
			rowName = '1';
		}
	}

	public int getRowNumber() {
		return rowName - 48;
	}

	public int getColNumber() {
		return colName - 64;
	}
	
	public static int getRowDifferece(Position one,Position two)
	{
		return one.getRowNumber()-two.getRowNumber();
	}
	public static int getColDifferece(Position one,Position two)
	{
		return one.getColNumber()-two.getColNumber();
	}

}
