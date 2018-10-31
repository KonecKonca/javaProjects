import java.lang.Math;

public class Lab {
	private static final int VALUE1 = 14;
	private static final int VALUE2 = 25;

	private final static int[] ONE = new int[32];
	private final static int[] MINUSONE = new int[32];
	private static int[] EXPONENT1;

	static {
		toZero(ONE);
		toZero(MINUSONE);
		ONE[31]=1;
		MINUSONE[31]=1;
		MINUSONE[0]=1;
		EXPONENT1=toBinary(5);
		EXPONENT1[0]=1;
	}

	public static void main(String[] args) {
		int[] X1 = {VALUE1, -VALUE1};
		int[] X2 = {VALUE2, -VALUE2};
		System.out.println("Число\t\tПрямой код\t\t\t\t\t\t\tОбратный код\t\t\t\t\t\tДополнительный код");
		for(int i=0; i<2; i++) {
			System.out.println(X1[i]+"\t"+toString(toBinary(X1[i]))+"\t"+toString(toInversion(toBinary(X1[i])))+"\t"+toString(toAdditional(toBinary(X1[i]))) );
			System.out.println(X2[i]+"\t"+toString(toBinary(X2[i]))+"\t"+toString(toInversion(toBinary(X2[i])))+"\t"+toString(toAdditional(toBinary(X2[i]))) );
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("\n\nСложение:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X1[i]+"+("+X2[j]+")="+toDecimal(sum(toBinary(X1[i]),toBinary(X2[j]))));
			}
		}
		System.out.println("Разность Х1-Х2:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X1[i]+"-("+X2[j]+")="+toDecimal(difference(toBinary(X1[i]),toBinary(X2[j])))+"\t\t");
			}
		}
		System.out.println("Разность Х2-Х1:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X2[j]+"-("+X1[i]+")="+toDecimal(difference(toBinary(X2[j]),toBinary(X1[i])))+"\t\t");
			}
		}
		System.out.println("Умножение X1*X2:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X1[i]+"*("+X2[j]+")="+toDecimal(multiply(toBinary(X1[i]),toBinary(X2[j])))+"\t\t");
			}
		}
		System.out.println("Умножение X2*X1:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X2[j]+"*("+X1[i]+")="+toDecimal(multiply(toBinary(X2[j]),toBinary(X1[i])))+"\t\t");
			}
		}
		System.out.println("Деление X1/X2:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X1[i]+"/("+X2[j]+")="+String.format("%.5f", toDecimal(divide(toBinary(X1[i]),toBinary(X2[j]))))+"\t\t");
			}
		}
		System.out.println("Деление X2/X1:");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println("\t" + X2[j]+"/("+X1[i]+")="+toDecimal(divide(toBinary(X2[j]),toBinary(X1[i]))[0])+","+toDecimal(divide(toBinary(X2[j]),toBinary(X1[i]))[1])+"\t");
			}
		}

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("\n\nСложение двух чисел Х1 и Х2, представленных в форме с плавающей точкой");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.print("X1+(X2)="+sumFloat(toBinary(X1[i]),toBinary(X2[j])));
				System.out.println();
			}
		}
	}

	public static int[] toBinary(int number){
		int[] result = new int[32];
		toZero(result);
		if(number<0) {
			result[0]=1;
			number*=-1;
		}
		int count=31;
		while(number!=0) {
			result[count--]=number%2;
			number/=2;
		}
		return result;
	}
	public static int toDecimal(int[] number) {
		int result=0;
		for(int i=31; i>0; i--) {
			result+=number[i]*Math.pow(2, 31-i);
		}
		if(number[0]==1) result*=-1;
		return result;
	}
	public static double toDecimal(int[][] number) {
		int result1=0;
		double result2=0;
		for(int i=31; i>0; i--) {
			result1+=number[0][i]*Math.pow(2, 31-i);
			result2+=number[1][i]*Math.pow(2, 31-i);
		}
		while(result2>1) {
			result2/=10;
		}
		double result=result1+result2;
		if(number[0][0]==1) result*=-1;
		return result;
	}
	public static int[] sum(int[] operand1, int[] operand2) {
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		int[] result = new int[32];
		toZero(result);
		if(op1[0]==op2[0]) {
			result[0]=op1[0];
			int excess=0;
			for(int i=31; i>0; i--) {
				if(op1[i]==0 && op2[i]==0 && excess==0) {
					result[i]=0;
					continue;
				}
				if(op1[i]==0 && op2[i]==0 && excess==1) {
					result[i]=1;
					excess=0;
					continue;
				}
				if(op1[i]==1 && op2[i]==1 && excess==0) {
					result[i]=0;
					excess=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==1 && excess==1) {
					result[i]=1;
					excess=1;
					continue;
				}
				if(op1[i]==0 && op2[i]==1 && excess==0) {
					result[i]=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==0 && excess==0) {
					result[i]=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==0 && excess==1) {
					result[i]=0;
					excess=1;
					continue;
				}
				if(op1[i]==0 && op2[i]==1 && excess==1) {
					result[i]=0;
					excess=1;
					continue;
				}
			}
			return result;
		}
		return additionalSum(op1,op2);
	}
	public static int[] additionalSum(int[] operand1, int[] operand2) {
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		op1=toAdditional(op1);
		op2=toAdditional(op2);
		int[] result = new int[32];
		toZero(result);
			int excess=0;
			for(int i=31; i>=0; i--) {
				if(op1[i]==0 && op2[i]==0 && excess==0) {
					result[i]=0;
					continue;
				}
				if(op1[i]==0 && op2[i]==0 && excess==1) {
					result[i]=1;
					excess=0;
					continue;
				}
				if(op1[i]==1 && op2[i]==1 && excess==0) {
					result[i]=0;
					excess=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==1 && excess==1) {
					result[i]=1;
					excess=1;
					continue;
				}
				if(op1[i]==0 && op2[i]==1 && excess==0) {
					result[i]=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==0 && excess==0) {
					result[i]=1;
					continue;
				}
				if(op1[i]==1 && op2[i]==0 && excess==1) {
					result[i]=0;
					excess=1;
					continue;
				}
				if(op1[i]==0 && op2[i]==1 && excess==1) {
					result[i]=0;
					excess=1;
					continue;
				}
			}
			return toAdditional(result);
	}
	public static int[] difference(int[] operand1, int[] operand2) {
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		if(op2[0]==1) op2[0]=0;
		else op2[0]=1;
		if(op1[0]==op2[0]) {
			return sum(op1,op2);
		}
		return additionalSum(op1,op2);
	}
	public static boolean compare(int[] op1, int[] op2) {
		if(op1[0]<op2[0]) return true;
		if(op1[0]>op2[0]) return false;
		for(int i=1; i<32; i++) {
			if(op1[i]>op2[i]) return true;
			if(op1[i]<op2[i]) return false;
		}
		return false;
	}
	public static int[] multiply(int[] operand1, int[] operand2) {
		int[] result = new int[32];
		int[] i = new int[32];
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		op1[0]=op2[0]=0;
		toZero(result);
		toZero(i);
		while(compare(op2,i)) {
			result=sum(result,op1);
			i=sum(i,ONE);
		}
		if(operand1[0]==operand2[0]) result[0]=0;
		else result[0]=1;
		return result;
	}
	public static void toZero(int[] array) {
		for(int i=0; i<32; i++) array[i]=0;
	}
	public static boolean isZero(int[] number) {
		for(int i=1; i<32; i++) if(number[i]==1) return false;
		return true;
	}
	public static int[][] divide(int[] operand1, int[] operand2) {
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		int[][] result = new int[2][32];
		toZero(result[0]);
		toZero(result[1]);
		op1[0]=op2[0]=0;
			while(compare(op1,op2) || !equals(op1,op2)) {
				if(op1[0]==1) break;
				if(!compare(op1,op2)) break;
				op1=difference(op1,op2);
				result[0]=sum(result[0], ONE);
			}
		if(!isZero(op1)) {
			op1=multiply(op1,toBinary(100000));
			while(compare(op1,op2) || !equals(op1,op2)) {
				if(op1[0]==1) break;
				op1=difference(op1,op2);
				result[1]=sum(result[1], ONE);
			}
		}
		if(operand1[0]!=operand2[0]) result[0][0]=1;
		else  result[0][0]=0;
		return result;
	}
	public static int[] toInversion(int[] number) {
		if(number[0]==0) return number;
		int[] result = new int[32];
		System.arraycopy(number, 0, result, 0, 32);
		for(int i=1; i<32; i++) {
			if(result[i]==1) {
				result[i]=0;
				continue;
			}else result[i]=1;
		}
		return result;
	}
	public static int[] toAdditional(int[] number) {
		if(number[0]==0) return number;
		return sum(toInversion(number), MINUSONE);
	}
	public static boolean equals(int[] op1, int[] op2) {
		for(int i=1; i<32; i++) if(op1[i]!=op2[0]) return false;
		return true;
	}
	public static String toString(int[] number) {
		String toString="";
		for(int i=0; i<32; i++) {
			toString+=number[i];
		}
		return toString;
	}
	public static String sumFloat(int[] operand1, int[] operand2) {
		int[] op1 = new int[32];
		int[] op2 = new int[32];
		System.arraycopy(operand1, 0, op1, 0, 32);
		System.arraycopy(operand2, 0, op2, 0, 32);
		int[] result;
		for(int i=31; i>1; i--) {
			op1[i]=op1[i-1];
		}
		result = sum(op1,op2);
		return Double.toString(toDecimal(result)*Math.pow(10,toDecimal(EXPONENT1)));
	}

}