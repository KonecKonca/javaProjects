package main.extension;

public class Sign {
	String sign;
	public Sign(String sign) {
		this.sign=sign;
	}
	public String getSign() {
		return sign;
	}
	public String getNegationSign() {
		if(sign.equals("+")) return "*";
		else return "+";
	}
	public void negation() {
		if(sign.equals("+")) sign="*";
		else sign="+";
	}
}
