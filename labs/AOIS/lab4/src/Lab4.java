import java.util.ArrayList;

public class Lab4 {
	public static void main(String[] args) {
		ODS3();
		BCD(1);
	}
	public static void ODS3(){
		boolean[] x1 = {false,false,true,false,true,false,true,true};
		boolean[] x2 = {false,false,false,true,false,true,true,true};
		boolean[] x3 = {false,true,false,false,true,true,false,true};
		System.out.print("Таблица истинности для одноразрядного двоичного сумматора на 3 входа\nX1\t");
		for(int i=0; i< x1.length; i++)
			if(x1[i]) System.out.print("1\t");
			else System.out.print("0\t");
		System.out.print("\nX2\t");
		for(int i=0; i< x2.length; i++) 
			if(x2[i]) System.out.print("1\t");
			else System.out.print("0\t");
		System.out.print("\nX3\t");
		for(int i=0; i< x3.length; i++) 
			if(x3[i]) System.out.print("1\t");
			else System.out.print("0\t");
		boolean[] S = new boolean[8];
		boolean[] P = new boolean[8];
		ArrayList<Constituent> Sd = new ArrayList<>();
		ArrayList<Constituent> Sk = new ArrayList<>();
		ArrayList<Constituent> Pd = new ArrayList<>();
		ArrayList<Constituent> Pk = new ArrayList<>();
		for(int i=0; i<x1.length; i++) {
			if( (x1[i] && x2[i] && x3[i]) || (!x1[i] && !x2[i] && !x3[i]) ) {
				S[i]=x1[i];
				P[i]=x1[i];
				continue;
			}
			if( (x1[i]&&x3[i]) || (x2[i]&&x3[i]) || (x1[i]&&x2[i]) ) {
				S[i]=false;
				P[i]=true;
				continue;
			}
			if( !((x1[i]&&x3[i]) || (x2[i]&&x3[i]) || (x1[i]&&x2[i])) )  {
				S[i]=true;
				P[i]=false;
				continue;
			}
		}
		System.out.print("\nP\t");
		for(int i=0; i< P.length; i++) 
			if(P[i]) System.out.print("1\t");
			else System.out.print("0\t");
		System.out.print("\nS\t");
		for(int i=0; i< S.length; i++) 
			if(S[i]) System.out.print("1\t");
			else System.out.print("0\t");
		for(int i=0; i<x1.length; i++) {
			if(S[i]) Sd.add(new Constituent(x1[i], x2[i], x3[i]));
			if(!S[i]) Sk.add(new Constituent(x1[i], x2[i], x3[i]));
			if(P[i]) Pd.add(new Constituent(x1[i], x2[i], x3[i]));
			if(!P[i]) Pk.add(new Constituent(x1[i], x2[i], x3[i]));
		}
		String Ptd="";
		for(int i=0; i<Pd.size()-1; i++)
			for(int j=i+1; j<Pd.size(); j++) {
					if(Pd.get(i).getX1()==Pd.get(j).getX1() && Pd.get(i).getX2()==Pd.get(j).getX2() && Pd.get(i).getX3()!=Pd.get(j).getX3()) 
						Ptd+=Pd.get(i).getImplicant(true, "x3")+"+";
					if(Pd.get(i).getX1()==Pd.get(j).getX1() && Pd.get(i).getX2()!=Pd.get(j).getX2() && Pd.get(i).getX3()==Pd.get(j).getX3()) 
						Ptd+=Pd.get(i).getImplicant(true, "x2")+"+";
					if(Pd.get(i).getX1()!=Pd.get(j).getX1() && Pd.get(i).getX2()==Pd.get(j).getX2() && Pd.get(i).getX3()==Pd.get(j).getX3()) 
						Ptd+=Pd.get(i).getImplicant(true, "x1")+"+";
			}
		String Ptk="";
		for(int i=0; i<Pk.size()-1; i++)
			for(int j=i+1; j<Pk.size(); j++) {
					if(Pk.get(i).getX1()==Pk.get(j).getX1() && Pk.get(i).getX2()==Pk.get(j).getX2() && Pk.get(i).getX3()!=Pk.get(j).getX3()) 
						Ptk+=Pk.get(i).getImplicant(false, "x3")+"*";
					if(Pk.get(i).getX1()==Pk.get(j).getX1() && Pk.get(i).getX2()!=Pk.get(j).getX2() && Pk.get(i).getX3()==Pk.get(j).getX3()) 
						Ptk+=Pk.get(i).getImplicant(false, "x2")+"*";
					if(Pk.get(i).getX1()!=Pk.get(j).getX1() && Pk.get(i).getX2()==Pk.get(j).getX2() && Pk.get(i).getX3()==Pk.get(j).getX3()) 
						Ptk+=Pk.get(i).getImplicant(false, "x1")+"*";
			}
		Ptd=Ptd.substring(0, Ptd.length()-1);
		System.out.println("\nP в ТДНФ = "+Ptd);
		System.out.println("S в ТДНФ = !P*(x1+x2+x3)+(x1*x2*x3)");
		Ptk=Ptk.substring(0, Ptk.length()-1);
		System.out.println("P в ТКНФ = "+Ptk);
		System.out.println("S в ТКНФ = !P*(x1+x2+x3)+(x1*x2*x3)");
	}
	public static void BCD(int n) {
		System.out.print("Таблица истинности\n J 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15\nX4 0 0 0 0 0 0 0 0 1 1  1  1  1  1  1  1\nX3 0 0 0 0 1 1 1 1 0 0  0  0  1  1  1  1"
				+ "\nX2 0 0 1 1 0 0 1 1 0 0  1  1  0  0  1  1\nX1 0 1 0 1 0 1 0 1 0 1  0  1  0  1  0  1\n----------------------------------------");
		for(int i=4; i>0; i--) {
			System.out.print("\nY"+i+" ");
			for(int j=0; j<10; j++)
				System.out.print(toBinary(n+j)[4-i]+" ");
			for(int j=0; j<6; j++)
				System.out.print(" - ");
		}
		System.out.println("\nМинимизация функций:\nY4=(x4*!x3*!x2)+(!x4*x3*x2*x1)\nY3=(!x4*x3*x1)+(!x4*x3*x2)+(!x4*!x3*x1*x2)\nY2=(!x2*x1)+(x2*!x1)\nY1=!x1");
		
	}
	public static int[] toBinary(int number){
		int[] result = new int[4];
		for(int i=0; i<4; i++) result[i]=0;
		int count=3;
		while(number!=0 && count>=0) {
			result[count--]=number%2;
			number/=2;
		}
		return result;
	}
}
