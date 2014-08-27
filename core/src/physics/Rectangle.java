package physics;

import com.badlogic.gdx.math.Vector2;

public abstract class Rectangle {
	public Vector2 pos = new Vector2(0,0);
	public Vector2 dim = new Vector2(0,0);
	
	public Vector2 adjustMoveCollision(Rectangle a, Vector2 nxtPos){
		Vector2 move = nxtPos.sub(this.pos);
		Vector2 adjPos = pos.cpy();
		adjPos.x+=move.x;
		if(checkCollision(adjPos, this.dim, a.pos, a.dim)){
			if(move.x>0){
				adjPos.x = a.pos.x - this.dim.x;
			}else{
				adjPos.x = a.pos.x + a.dim.x;
			}
		}
		
		adjPos.y+=move.y;
		if(checkCollision(adjPos, this.dim, a.pos, a.dim)){
			if(move.y>0){
				adjPos.y = a.pos.y - this.dim.y;
			}else{
				adjPos.y = a.pos.y + a.dim.y;
			}
		}
		
		return adjPos;
	}
	
	public boolean collidesWith(Rectangle a){
		return checkCollision(a.pos, a.dim, this.pos, this.dim);
	}
	
	private boolean checkCollision(Vector2 aPos, Vector2 aDim, Vector2 bPos, Vector2 bDim){
		if(aPos.x >= bPos.x + bDim.x || aPos.x + aDim.x <= bPos.x){
			return false;
		}
		
		if(aPos.y >= bPos.y + bDim.y || aPos.y + aDim.y <= bPos.y){
			return false;
		}
		
		return true;
	}
}
