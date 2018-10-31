package main.extension;

import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class Lab2 {

	public static Set<String> FSDNF = new HashSet<String>();
	public static Set<String> FSKNF = new HashSet<String>();
	public static void main(String[] args) {
		String input = "!((x1+!x2)*!(!x2*!x3))";
		System.out.println("Исходная функция = "+input+"\nЗапись функции после снятия отрицаний = "+parse(input));
		transform(parse(input));
	}
	public static DifficultExpression parse(String input) {
		DifficultExpression expression;
		SimpleExpression operand1 = null;
		SimpleExpression operand2 = null;
		int indexSign=-1;
		for(int i=1; i<input.length()-1; i++) {
			if(input.charAt(i)=='(' && input.charAt(i+1)!='(')
				for(int j=i; j<input.length(); j++)
					if(input.charAt(j)==')')
						if(j-i<=8)
							if(operand1 == null) {
								operand1 = new SimpleExpression(input.substring(i+1, j));
								if(input.charAt(i-1)=='!') operand1.negation();
							}
			if(input.charAt(i)=='(' && (input.charAt(i-1)!='!' || input.charAt(i-1)!='+'|| input.charAt(i-1)!='*') && i>5 )
				for(int j=i; j<input.length(); j++)
					if(input.charAt(j)==')') 
						if(j-i<=8) 
							if(operand2 == null) {	
								operand2 = new SimpleExpression(input.substring(i+1, j));
								if(input.charAt(i-1)=='!') operand2.negation();
							}	
			if((input.charAt(i)=='+' || input.charAt(i)=='*') && input.charAt(i-1)==')') indexSign=i;
		}
		expression = new DifficultExpression(operand1, operand2, new Sign(input.substring(indexSign,indexSign+1)), false);
		if(input.charAt(0)=='!') expression.negation();
		return expression;
	}
	public static void transform(DifficultExpression expression) {
		int result=0;
		String SDNF="V(";
		String SKNF="Λ(";
		boolean[] x1= {false,false,false,false,true,true,true,true};
		boolean[] x2= {false,false,true,true,false,false,true,true};
		boolean[] x3= {false,true,false,true,false,true,false,true};
		for(int i=0; i<x1.length; i++) {
			if(expression.getOperand1().getOperand1().getName().equals("x1")) expression.getOperand1().getOperand1().setValue(x1[i]);
			if(expression.getOperand1().getOperand2().getName().equals("x1")) expression.getOperand1().getOperand2().setValue(x1[i]);
			if(expression.getOperand1().getOperand1().getName().equals("x2")) expression.getOperand1().getOperand1().setValue(x2[i]);
			if(expression.getOperand1().getOperand2().getName().equals("x2")) expression.getOperand1().getOperand2().setValue(x2[i]);
			if(expression.getOperand1().getOperand1().getName().equals("x3")) expression.getOperand1().getOperand1().setValue(x3[i]);
			if(expression.getOperand1().getOperand2().getName().equals("x3")) expression.getOperand1().getOperand2().setValue(x3[i]);
			if(expression.getOperand2().getOperand1().getName().equals("x1")) expression.getOperand2().getOperand1().setValue(x1[i]);
			if(expression.getOperand2().getOperand2().getName().equals("x1")) expression.getOperand2().getOperand2().setValue(x1[i]);
			if(expression.getOperand2().getOperand1().getName().equals("x2")) expression.getOperand2().getOperand1().setValue(x2[i]);
			if(expression.getOperand2().getOperand2().getName().equals("x2")) expression.getOperand2().getOperand2().setValue(x2[i]);
			if(expression.getOperand2().getOperand1().getName().equals("x3")) expression.getOperand2().getOperand1().setValue(x3[i]);
			if(expression.getOperand2().getOperand2().getName().equals("x3")) expression.getOperand2().getOperand2().setValue(x3[i]);
			if(expression.getValue()) {
				SDNF+=i+",";
				FSDNF.add(getSDNF(x1[i], x2[i], x3[i]));
				result+=Math.pow(2,7-i);
			}else {
				FSKNF.add(getSKNF(x1[i], x2[i], x3[i]));
				SKNF+=i+",";	
			}
		}
		System.out.println("CДНФ="+getString(FSDNF, "+")+"\nCKНФ="+getString(FSKNF, "*"));
	}
	public static String getSDNF(boolean a, boolean b, boolean c) {
		String result="(";
		if(a) result+="x1*"; else result+="!x1*";
		if(b) result+="x2*"; else result+="!x2*";
		if(c) result+="x3"; else result+="!x3";
		return result+")";
	}
	public static String getSKNF(boolean a, boolean b, boolean c) {
		String result="(";
		if(a) result+="!x1+"; else result+="x1+";
		if(b) result+="!x2+"; else result+="x2+";
		if(c) result+="!x3"; else result+="x3";
		return result+")";
	}
	public static String getString(Set<String> input, String sign) {
		String result="";
		for(String i: input) result+=i+sign;
		return result.substring(0, result.length()-1);	
	}

}
