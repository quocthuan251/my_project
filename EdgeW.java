package tuan_1;

public class EdgeW implements Comparable<EdgeW> {
	int s,d;
	double w;
	public EdgeW(int s, int d, double w) {
		this.s = s;
		this.d = d;
		this.w = w;
	}
	public int getS() {
		return s;
	}
	public int getD() {
		return d;
	}
	public double getW() {
		return w;
	}
	public void setS(int s) {
		this.s = s;
	}
	public void setD(int d) {
		this.d = d;
	}
	public void setW(double w) {
		this.w = w;
	}
	@Override
	public int compareTo(EdgeW arg0) {
		if(this.w<arg0.w) {
			return -1;
		}
		if(this.w==arg0.w) {
			return 0;
		}
		if(this.w>arg0.w) {
			return 1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return s+" " +d +" " + w + "\n" ;
	}
	
}
