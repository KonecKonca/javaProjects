package main.extension;

import java.util.Set;

public class Lab3 extends Lab2{
	public static void main(String[] args){

		String input = "!((x1+!x2)*!(!x2*!x3))";
		System.out.println("Исходная функция = "+input+"\nЗапись функции после снятия отрицаний = "+parse(input));
		transform(parse(input));

		System.out.println();

		System.out.println("Расчетный метод: ТДНФ = " + calculatedMethod(getConstituents(FSDNF), new Sign("*")));
		System.out.println("Расчетный метод: ТКНФ = "+calculatedMethod(getConstituents(FSKNF), new Sign("+")));

		System.out.println();

		System.out.println("Расчетно-табличный метод: ТДНФ = "+settlement_tabularMethod(getConstituents(FSDNF), new Sign("*")));
		System.out.println("Расчетно-табличный метод: ТКНФ = "+settlement_tabularMethod(getConstituents(FSKNF), new Sign("+")));

		System.out.println();

		System.out.println("Табличный метод: ТДНФ = "+tabularMethod(getConstituents(FSDNF), new Sign("*")));
		System.out.println("Табличный метод: ТКНФ = "+tabularMethod(getConstituents(FSKNF), new Sign("+")));

	}
	public static String calculatedMethod(String[][] constituents, Sign sign) {
		boolean difference = false;
		String temp="";
		String result="";
		boolean record=true;
		for(int i=0; i<constituents.length-1; i++)
			for(int j=i+1; j<constituents.length; j++) {
				for(int k=0; k<constituents[0].length; k++) {
					if(constituents[i][k].equals(constituents[j][k])) temp+=constituents[i][k]+sign.getSign();
					if(!constituents[i][k].equals(constituents[j][k]) && difference) record=false;
					if(!constituents[i][k].equals(constituents[j][k]) && !difference)  difference=true;
				}
				if(record) result+="("+temp.substring(0,temp.length()-1)+")"+sign.getNegationSign();
				else record=true;
				difference=false;
				temp="";
			}
		result=result.substring(0,result.length()-1);
		String[] split = result.split("["+sign.getNegationSign()+"]");
		if(sign.getSign().equals("*")) return split[0]+sign.getNegationSign()+split[2];
		else return split[1]+sign.getNegationSign()+split[2];
	}
	public static String settlement_tabularMethod(String[][] constituents, Sign sign){
		int x=constituents.length;
		int y=constituents[0].length;
		String[][] table = new String[x][y];
		int sum=0;
		for(int i=0; i <x; i++) {
			for(int j=0; j<y; j++) {
				try {
					if(table[x][y]!=null && sum==1) {
						sum+=1;
						try {
							if(table[x][y]!=null) {
								table[x][y]=constituents[x][y];
							}
						}catch(ArrayIndexOutOfBoundsException e) {};
					}
				}catch(ArrayIndexOutOfBoundsException e) {};
				sum=0;
			}
		}
		for(int i=0; i <x-1; i++) {
			for(int j=0; j<y-1; j++) {
				try {
					if(table[x][y].equals(table[x+1][y+1]) && table[x][y]!=null) {
						table[x][y]=null;
					}
				}catch(ArrayIndexOutOfBoundsException e) {};
			}
		}
		return calculatedMethod(constituents, sign);
	}
	public static String tabularMethod(String[][] constituents, Sign sign){
		int x=constituents.length;
		int y=constituents[0].length;
		String[][] table = new String[x][y];
		for(int i=0; i <x; i++) {
			int coordinate1 = x ^ x>>1;
			int coordinate2 = y ^ y>>1;
			for(int j=0; j<y; j++) {
				try {
					if(table[x][y]!=null && coordinate1<coordinate2) {
						table[x][y]=constituents[x][y];
					}
				}catch(ArrayIndexOutOfBoundsException e) {};
			}
		}
		for(int i=0; i <x-1; i++) {
			for(int j=0; j<y-1; j++) {
				try {
					if(table[x][y].equals(table[x+1][y+1]) && table[x][y]!=null) {
						table[x][y]=null;
					}
				}catch(ArrayIndexOutOfBoundsException e) {};
			}
		}
		return calculatedMethod(constituents, sign);
	}
	public static String[] parseArguments(String function) {
		return ((String) function.subSequence(1, function.length()-1)).split("[+*]");
	}
	public static String[][] getConstituents(Set<String> function){
		String[][] constituents = new String[4][3];
		int count=0;
		for(String i: function) constituents[count++]=parseArguments(i);
		return constituents;
	}

}
