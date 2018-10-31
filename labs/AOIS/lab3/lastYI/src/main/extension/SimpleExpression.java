package main.extension;

public class SimpleExpression {
	private Operand operand1;
	private Operand operand2;
	Sign sign;
	boolean negation;
	public SimpleExpression(Sign sign, boolean negation) {
		this.sign = sign;
		this.negation=negation;
	}
	public SimpleExpression(String input) {
		int index = -1;
		if(input.indexOf("+")!=-1) index=input.indexOf("+");
		if(input.indexOf("*")!=-1) index=input.indexOf("*");
		if(input.charAt(0) == '!') operand1 = new Operand(input.substring(1, index), true);
		else operand1 = new Operand(input.substring(0, index), false);
		if(input.charAt(index+1) == '!') operand2 = new Operand(input.substring(index+2), true);
		else operand2 = new Operand(input.substring(index+1), false);
		sign = new Sign(input.substring(index, index+1));
		negation=false;
	}
	public final Operand getOperand1() {
		return operand1;
	}
	public final Operand getOperand2() {
		return operand2;
	}
	public void negation() {
		if(negation==true) {
			negation=false;
			return;
		}
		operand1.negation();
		operand2.negation();
		sign.negation();
	}
	public boolean getValue() {
		if(sign.getSign().equals("+")) if(operand1.getValue() || operand2.getValue()) return true;
		if(sign.getSign().equals("*")) if(operand1.getValue() && operand2.getValue()) return true;
		return false;
	}
	public String toString() {
		return operand1.toString()+sign.getSign()+operand2.toString();
	}
}
