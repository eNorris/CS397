package util;

import java.util.ArrayList;

public class SpaceTimeInt {
	int cx = 0, cy = 0;
	int lx = 0, ly = 0;
	int dx = 0, dy = 0;
	float vx = 0.0f, vy = 0.0f;
	long ct = 0, lt = 0, dt = 0;
	
	public SpaceTimeInt(){}
	
	public SpaceTimeInt(int cx, int cy, int lx, int ly, int dx, int dy, float vx, float vy, long ct, long lt, long dt){
		this.cx = cx; this.cy = cy;
		this.lx = lx; this.ly = ly;
		this.dx = dx; this.dy = dy;
		this.vx = vx; this.vy = vy;
		this.ct = ct; this.lt = lt; this.dt = dt;
	}
	
	public ArrayList<SpaceTimeInt> history = new ArrayList<SpaceTimeInt>();
	
	public SpaceTimeInt bigBang(){
		temporalCollapse();
		spacialCollapse();
		history.clear();
		ct = System.currentTimeMillis();
		return this;
	}
	
	public SpaceTimeInt wormHole(int x, int y){
		bigBang();
		cx = x; cy = y;
		return this;
	}
	
 	public SpaceTimeInt temporalCollapse(){
		ct = lt = dt = 0;
		return this;
	}
	
	public SpaceTimeInt spacialCollapse(){
		cx = cy = lx = ly = dx = dy = 0;
		vx = vy = 0.0f;
		return this;
	}
	
	public SpaceTimeInt temporalUpdate(){
		lt = ct;
		ct = System.currentTimeMillis();
		dt = ct - lt;
		return this;
	}
	
	public SpaceTimeInt spacialUpdate(int x, int y){
		lx = cx;
		ly = cy;
		cx = x;
		cy = y;
		dx = cx - lx;
		dy = cy - ly;
		if(dt != 0){
			vx = dx / (float)dt;
			vy = dy / (float)dt;
		}else{
			System.out.print("WARNING: SpaceTimeInt::spacialUpdate(): Divide by zero!\n\n");
			vx = vy = Float.POSITIVE_INFINITY;
		}
		return this;
	}
	
	public SpaceTimeInt universalUpdate(int x, int y){
		temporalUpdate();
		return spacialUpdate(x, y);
	}
	
	public void chronicle(){
		history.add(instantiate());
	}
	
	public SpaceTimeInt instantiate(){
		return new SpaceTimeInt(cx, cy, lx, ly, dx, dy, vx, vy, ct, lt, dt);
	}
	
	public SpaceTimeInt reflect(int index){
		return history.get(index);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.ensureCapacity(100);
		
		builder.append("[(" + cx + ", " + cy + ") <- (" + lx + ", " + ly + ") ~ (");
		builder.append(dx + ", " + dy + ") @ (" + vx + ", " + vy + ") : <" + ct + " <- " + lt + " ~ " + dt + ">]");
		
		return builder.toString();
	}
	
}
























