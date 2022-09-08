
public class Robot extends GameObject implements Movable {
	
	
	
	
	
	
	public Robot(int posX, int posY) {
		super(posX, posY);
	}


	@Override
	public void move(int x, int y) {
		
		super.setPosX(x);
		super.setPosY(y);
		
		
	}


	@Override
	public String toString() {
		return "Robot";
	}
	
	


}
