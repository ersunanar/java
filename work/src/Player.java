
public class Player extends GameObject implements Movable {
	
	private int previousDistance;
	
	
	
	
	public Player(int posX, int posY, int previousDistance) {
		super(posX, posY);
		this.previousDistance = previousDistance;
	}

	
	@Override
	public void move(int x, int y) {
		
		
		super.setPosX(x);
		super.setPosY(y);
		
	}
	
	
	@Override
	public String toString() {
		
		
		return "Player";
		
	}



	public int getPreviousDistance() {
		return previousDistance;
	}



	public void setPreviousDistance(int previousDistance) {
		this.previousDistance = previousDistance;
	}
	
	
	
	
	
	
	

}
