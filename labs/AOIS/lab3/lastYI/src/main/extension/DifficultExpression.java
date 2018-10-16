package main.extension;

public class DifficultExpression {
	SimpleExpression operand1;
	SimpleExpression operand2;
	Sign sign;
	boolean negation;
	public DifficultExpression(SimpleExpression operand1, SimpleExpression operand2, Sign sign, boolean negation) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.sign = sign;
		this.negation=negation;
	}
	public SimpleExpression getOperand1() {
		return operand1;
	}
	public SimpleExpression getOperand2() {
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
		return "("+operand1.toString()+")"+sign.getSign()+"("+operand2.toString()+")";
	}
}
