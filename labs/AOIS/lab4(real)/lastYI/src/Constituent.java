public class Constituent {
	boolean x1;
	boolean x2;
	boolean x3;
	public Constituent(boolean x1, boolean x2, boolean x3) {
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
	}
	public boolean getX1() {
		return x1;
	}
	public boolean getX2() {
		return x2;
	}
	public boolean getX3() {
		return x3;
	}
	public  String getImplicant(boolean isdisjunction, String excess) {
		String result="";
		if(isdisjunction) {
			if(excess.equals("x1")) {
				if(x2) result+="(x2*";
				if(!x2) result+="(!x2*";
				if(x3) result+="x3)";
				if(!x3) result+="!x3)";
			}
			if(excess.equals("x2")) {
				if(x1) result+="(x1*";
				if(!x1) result+="(!x1*";
				if(x3) result+="x3)";
				if(!x3) result+="!x3)";
			}
			if(excess.equals("x3")) {
				if(x1) result+="(x1*";
				if(!x1) result+="(!x1*";
				if(x2) result+="x2)";
				if(!x2) result+="!x2)";
			}
		}
		if(!isdisjunction) {
			if(excess.equals("x1")) {
				if(x2) result+="(!x2+";
				if(!x2) result+="(x2+";
				if(x3) result+="!x3)";
				if(!x3) result+="x3)";
			}
			if(excess.equals("x2")) {
				if(x1) result+="(!x1+";
				if(!x1) result+="(x1+";
				if(x3) result+="!x3)";
				if(!x3) result+="x3)";
			}
			if(excess.equals("x3")) {
				if(x1) result+="(!x1+";
				if(!x1) result+="(x1+";
				if(x2) result+="!x2)";
				if(!x2) result+="x2)";
			}
		}
		return result;
	}
}
