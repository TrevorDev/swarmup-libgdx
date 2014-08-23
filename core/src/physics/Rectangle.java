package physics;

import com.badlogic.gdx.math.Vector2;

public abstract class Rectangle {
	public Vector2 pos = new Vector2(0,0);
	public Vector2 dim = new Vector2(100,100);
	
	public Vector2 adjustMoveCollision(Rectangle a, Vector2 move){
		Vector2 nextPos = pos.cpy();
		nextPos.x+=move.x;
		if(checkCollision(nextPos, this.dim, a.pos, a.dim)){
			if(move.x>0){
				nextPos.x = a.pos.x - this.pos.x;
			}else{
				nextPos.x = a.pos.x + a.dim.x;
			}
		}
		
		nextPos.y+=move.y;
		if(checkCollision(nextPos, this.dim, a.pos, a.dim)){
			if(move.x>0){
				nextPos.y = a.pos.y - this.pos.y;
			}else{
				nextPos.y = a.pos.y + a.dim.y;
			}
		}
		
		return nextPos.sub(this.pos);
	}
	
	private boolean checkCollision(Vector2 aPos, Vector2 aDim, Vector2 bPos, Vector2 bDim){
		if(aPos.x > bPos.x + bDim.x || aPos.x + aDim.x < bPos.x){
			return false;
		}
		
		if(aPos.y > bPos.y + bDim.y || aPos.y + aDim.y < bPos.y){
			return false;
		}
		
		return true;
	}
}
