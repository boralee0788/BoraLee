import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// 로또 1~45까지 45 배열 
		//6개의 값을 ltto2배열에 넣어주세요.
	
		int[] lotto = new int[45]; 
		int[] lotto2 = new int[6];
		Scanner scan = new Scanner(System.in);
		int num1=0;
		int result = 0;
		
		shuffle(lotto);
		
		while(true) {
			System.out.println("-------------------------");
			System.out.println("1. 배열출력하기");
			System.out.println("2. 배열섞기");
			System.out.println("3. 6개 배열 합 구하기");
			System.out.println("4. 6개 배열 정렬하기");
			System.out.println("원하는 번호를 입력하세요.>>");
			num1 = scan.nextInt();
			switch (num1) {
			case 1:
				System.out.println("6개의 배열을 출력합니다.");
				printArr(lotto2, lotto);
				System.out.println();
				break;
				
			case 2:
				System.out.println("1~45 숫자를 다시 섞습니다.");
				shuffle(lotto);
				break;
				
			case 3:
				System.out.println("6개의 숫자의 합을 구합니다.");
				result = sumArr(lotto2);
				printArr(lotto2, lotto);
				System.out.println();
				System.out.println("합: "+result);
				break;
				
			case 4:
				System.out.println("배열정렬");
				sortArr(lotto2);
				System.out.println();
				break;

			default:
				break;
			}
		}
		
	}
	
	static void shuffle(int[] lotto) {
	
		for(int i=0;i<45;i++) {
			lotto[i] = i+1;
		}
		
		int temp=0;
		int index=0;
		
		for(int i=0;i<200;i++) {
			index = (int)(Math.random()*45);
			temp = lotto[0];
			lotto[0] = lotto[index];
			lotto[index] = temp;
		}
	}
	
	static void printArr(int[] lotto2, int[] lotto) {
		System.out.print("로또 번호: ");	
		for(int i=0;i<lotto2.length;i++) {
			lotto2[i] = lotto[i];
			System.out.print(lotto2[i]+" ");
		}
		
	}
	
	static int sumArr(int[] lotto2) {
		int result = 0;
		for(int i=0;i<lotto2.length;i++) {
			result +=lotto2[i];
		}
		return result;
	}
	
	static void sortArr(int[] lotto2) {
		int temp = 0;
		for(int i=0;i<lotto2.length;i++) {
			boolean change = false;
			for(int j=0;j<i;j++) {
				if(lotto2[i]<lotto2[j]) {
					temp = lotto2[i];
					lotto2[i] = lotto2[j];
					lotto2[j] = temp;
					change = true;
				}
				if(change==false) {
					break;
				}
			}
		}
		//정렬 
//		for(int i=0; i<lotto2.length-1;i++) {
//			boolean change = false;
//			for(int j=0; j<lotto2.length-1-i;j++) {
//				if(lotto2[j]>lotto2[j+1]) {
//					temp = lotto2[j];
//					lotto2[j]=lotto2[j+1];
//					lotto2[j+1] = temp;  
//					change=true;
//				}
//				if(change==false) {
//					break;
//				}
//			}
//		}
		
		for(int i=0;i<lotto2.length;i++) {
			System.out.print(lotto2[i]+" ");
		}
	}
	

}
