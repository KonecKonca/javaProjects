package main.extension;

public class Operand {
	String name;
	boolean negation;
	boolean value;
	
	public Operand(String name, boolean negation) {
		this.name = name;
		this.negation = negation;
	}
	public String getName() {
		return name;
	}
	public void negation() {
		if(negation==false) negation=true;
		else negation=false;
	}
	public boolean getValue() {
		if(!negation) return value;
		if(value) return false;
		else return true;
	}
	public void setValue(boolean value) {
		this.value=value;
	}
	public String toString() {
		if(negation) return "!"+name;
		else return name;
	}
}
