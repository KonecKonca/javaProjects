import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lab8 {
	
	public static void main(String[] args) {
		int m = 16;
		int[][] table = createTable(m,m);
		System.out.println("Исходный массив размером " + m + "*" + m);
		out(table);
		
		int[][] diagonalTable = toDiagonal(table);
		System.out.println("Массив с диагональной адресацией:");
		out(diagonalTable);
		
		int indexColumn = 1;
		int[] column = readColumn(diagonalTable, indexColumn);
		System.out.println("\nЧтение "+ indexColumn +  " столбца");
		out(column);
		
		writeColumn(diagonalTable, --indexColumn, column);
		System.out.println("\n\nЗапись вo "+ indexColumn +  " столбец нового столбца: ( " + toString(column) + ")");
		out(diagonalTable);
		
		int indexWord = 3;
		int[] word = readWord(diagonalTable, indexWord);
		System.out.println("\n\nЧтение "+ indexWord +  " слова");
		out(word);
		
		writeWord(diagonalTable, ++indexWord, word);
		System.out.println("\n\nПерезапись "+ indexWord +  " слова новым словом: ( " + toString(word) + ")");
		out(diagonalTable);
		
		
		int[] operand1 = readColumn(diagonalTable, 1);
		int[] operand2 = readColumn(diagonalTable, 2);
		int[] f2 = f2(operand1, operand2);
		int[] f7 = f7(operand1, operand2);
		int[] f8 = f8(operand1, operand2);
		int[] f13 = f13(operand1, operand2);
		writeColumn(diagonalTable, 3, f2);
		writeColumn(diagonalTable, 4, f7);
		writeColumn(diagonalTable, 5, f8);
		writeColumn(diagonalTable, 6, f13);
		
		System.out.println("\n1 столбец = " + toString(operand1));
		System.out.println("2 столбец = " + toString(operand2));
		System.out.println("Результат f2 = " + toString(f2));
		System.out.println("Результат f7 = " + toString(f7));
		System.out.println("Результат f8 = " + toString(f8));
		System.out.println("Результат f13 = " + toString(f13));
		System.out.println("Массив после проведения логических операций");
		out(diagonalTable);
		
		int min = 100;
		int max = 1000;
		int[][] search = interval(diagonalTable, min, max);
		System.out.println("\nУсловия поиска:\nнижняя граница = "+min+"\nверхняя граница = "+max);
		System.out.println("\nРезультат поиска: ");
		out(search);
		System.out.println("Количество подходящих элементов: к="+ search.length);
		
		int[] V = {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0};
		List<Integer> result = sumWord(diagonalTable, V);
		System.out.println("\nМассив после сложения полей слова");
		out(diagonalTable);
		System.out.println("Индексы замененных слов");
		for(Integer i: result){
			System.out.println(i+" ");
		}
		
	}
	
	public static int[][] createTable(int m, int n) {
		int[][] array = new int[m][n];
		System.out.print("Сгенерированные числа: ");
		for(int i = 0; i < m; i++) {
			Random random = new Random();
			int randomNumber = random.nextInt((int) Math.pow(2, n)-1);
			System.out.print(randomNumber+"  ");
			int[] binaryNumber = toBinary(randomNumber, n);
			for(int j = 0; j < n; j++) {
				array[i][j] = binaryNumber[j];
			}
		}
		System.out.println();
		return array;
	}
	
	public static int[] toBinary(int number, int n){
		int[] result = new int[n];
		if(number < 0) {
			result[0]=1;
			number*=-1;
		}
		int count=n - 1;
		while(count > 0) {
			result[count--]=number%2;
			number/=2;
		}
		return result;
	}
	
	public static void out(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void out(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

	public static int[][] toDiagonal(int[][] array){
		int m = array.length;
		transpose(array);
		int[][] diagonalArray = new int[m][m];
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(j + i < m) {
					diagonalArray[j+i][j] = array[i][j];
				}
				if(j + i >= m) {
					diagonalArray[j+i-m][j] = array[i][j];
				}
			}
		}
		return diagonalArray;
	}
	
	public static void transpose(int[][] array){
		int m = array.length;
		int[][] transposeArray = new int[m][m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				transposeArray[i][j] = array[i][j];
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				array[i][j] = transposeArray[j][i];
			}
		}
	}
	
	public static int[] readColumn(int[][] array, int index) {
		int m = array.length;
		int[] column = new int[m];
		for(int j = 0; j < m; j++) {
			if(j + index < m) {
				column[j] = array[j+index][j];
			}
			if(j + index >= m) {
				column[j] = array[j+index-m][j];
			}
		}
		return column;
	}
	
	public static void writeColumn(int[][] array, int index, int[] column) {
		int m = array.length;
		for(int j = 0; j < m; j++) {
			if(j + index < m) {
				array[j+index][j] = column[j];
			}
			if(j + index >= m) {
				array[j+index-m][j] = column[j];
			}
		}
	}
	
	public static String toString(int[] array) {
		String result = "";
		for(int i = 0; i < array.length; i++) {
			result += array[i]+" ";
		}
		return result;
	}
	
	public static int[] readWord(int[][] array, int index) {
		int m = array.length;
		int[] word = new int[m];
		for(int i = index; i < m; i++) {
			word[i-index] = array[i][index];
		}
		for(int i = 0; i < index; i++) {
			word[m-index+i] = array[i][index];
		}
		return word;
	}
	
	public static void writeWord(int[][] array, int index, int[] word) {
		int m = array.length;
		for(int i = index; i < m; i++) {
			array[i][index] = word[i-index];
		}
		for(int i = 0; i < index; i++) {
			array[i][index] = word[m-index+i];
		}
	}
	
	public static int[] inversion(int[] array) {
		int[] inversionArray = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 1) {
				inversionArray[i] = 0;
				continue;
			}
			if(array[i] == 0) {
				inversionArray[i] = 1;
				continue;
			}
		}
		return inversionArray;
	}

	public static int[] f2(int[] operand1, int[] operand2) {
		int n = operand1.length;
		int[] result = new int[n];
		operand2 = inversion(operand2);
		for(int i = 0; i < n; i++) {
			if(operand1[i] == 1 && operand2[i] == 1) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
		}
		return result;
	}

	public static int[] f7(int[] operand1, int[] operand2) {
		int n = operand1.length;
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			if(operand1[i] == 1 || operand2[i] == 1) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
		}
		return result;
	}
	
	public static int[] f8(int[] operand1, int[] operand2) {
		int n = operand1.length;
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			if(operand1[i] == 1 || operand2[i] == 1) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
		}
		result = inversion(result);
		return result;
	}
	
	public static int[] f13(int[] operand1, int[] operand2) {
		int n = operand1.length;
		int[] result = new int[n];
		operand1 = inversion(operand1);
		for(int i = 0; i < n; i++) {
			if(operand1[i] == 1 || operand2[i] == 1) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
		}
		return result;
	}

	public static int[][] interval(int[][] array, int min, int max){
		int m = array.length;
		int n = array[0].length;
		int[][] result = new int[m][n];
		int[] binaryMin = toBinary(min, n);
		int[] binaryMax = toBinary(max, n);
		int size = 0;
		array = recovery(array);
		for(int j = 0; j < m; j++) {
			boolean g1 = false, l1 = false;
			boolean g2 = false, l2 = false;
			for(int i = 0; i < n; i++) {
				g1 = g1 || (!toBoolean(binaryMin[i]) && toBoolean(array[j][i])  && !l1);
				g2 = g2 || (!toBoolean(binaryMax[i]) && toBoolean(array[j][i])  && !l2);
				l1 = l1 || (toBoolean(binaryMin[i])  && !toBoolean(array[j][i]) && !g1);
				l2 = l2 || (toBoolean(binaryMax[i])  && !toBoolean(array[j][i]) && !g2);
			}
			if( ( (g1 == false && l1 == false) || (g2 == false && l1 == false)) || 
				( (g1 == true  && l1 == false) && (g2 == false && l1 == true)) ) {
				save(result, size, array, j);
				size++;
			}
		}
		result = cut(result, size);
		return result;
	}
	
	public static boolean toBoolean(int number) {
		return number == 0 ? false : true;
	}
	
	public static void save(int[][] result, int size, int[][] array, int index) {
		for(int i = 0; i < result[0].length; i++) {
			result[size][i] = array[index][i];
		}
	}

	public static int[][] cut(int[][] array, int index) {
		int length = array[0].length;
		int[][] result = new int[index][length];
		for(int i = 0; i < index; i++) {
			for(int j = 0; j < length; j++) {
				result[i][j] = array[i][j];
			}
		}
		return result;
	}

	public static int[][] recovery(int[][] array){
		int m = array.length;
		int[][] recoveryArray = new int[m][m];
		for(int i = 0; i < m; i++) {
			int[] column = readColumn(array, i);
			for(int j = 0; j < m; j++) {
				recoveryArray[i][j] = column[j];
			}
		}
		return recoveryArray;
	}
	
	public static List<Integer> sumWord(int[][] array, int[] V) {
		int m = array.length;
		List<Integer> index = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			int[] word = readWord(array, i);
			if(equals(word, V)) {
				word = sum(word);
				writeWord(array, i, word);
				index.add(i);
			}
		}
		return index;
	}
	
	public static boolean equals(int[] word, int[] arg) {
		int length = 3;
		for(int i = 0; i < length; i++) {
			if(word[i] != arg[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] sum(int[] word) {
		int size = 5;
		int[] result = new int[size];
		for(int i = 0; i < size; i++) {
			result[i] = 0;
		}
		int[] op1 = new int[size-1];
		int[] op2 = new int[size-1];
		System.arraycopy(word, 3, op1, 0, 4);
		System.arraycopy(word, 7, op2, 0, 4);
		int excess = 0;
		for(int i=3; i>0; i--) {
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
		if(excess == 1) {
			result[0] = 1;
		}
		System.arraycopy(result, 0, word, 11, 5);
		return word;
	}
}
