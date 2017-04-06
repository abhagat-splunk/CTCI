import java.util.*;
public class TowerOfHanoi{
	public static void main(String args[]){
		int n=3;
		Tower[] towers = new Tower[n];
		for(int i=0;i<3;i++){
			towers[i] = new Tower(i);
		}
		for(int i=n-1;i>=0;i--){
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}
class Tower{
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		index = i;
		disks = new Stack<Integer>();
	}
	public int index(){
		return index;
	}

	public void add(int d){
		if(!disks.isEmpty() && disks.peek() <= d){
			System.out.println("Can't place");
		}
		else{
			disks.push(d);
		}
	}
	public void moveTop(Tower destination){
		int top = disks.pop();
		destination.add(top);
	}
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			//System.out.println(n);
			moveDisks(n-1,buffer,destination);
			moveTop(destination);
			buffer.moveDisks(n-1,destination,this);	
		}
	}
}