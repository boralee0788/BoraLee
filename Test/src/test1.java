import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// �ζ� 1~45���� 45 �迭 
		//6���� ���� ltto2�迭�� �־��ּ���.
	
		int[] lotto = new int[45]; 
		int[] lotto2 = new int[6];
		Scanner scan = new Scanner(System.in);
		int num1=0;
		int result = 0;
		
		shuffle(lotto);
		
		while(true) {
			System.out.println("-------------------------");
			System.out.println("1. �迭����ϱ�");
			System.out.println("2. �迭����");
			System.out.println("3. 6�� �迭 �� ���ϱ�");
			System.out.println("4. 6�� �迭 �����ϱ�");
			System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
			num1 = scan.nextInt();
			switch (num1) {
			case 1:
				System.out.println("6���� �迭�� ����մϴ�.");
				printArr(lotto2, lotto);
				System.out.println();
				break;
				
			case 2:
				System.out.println("1~45 ���ڸ� �ٽ� �����ϴ�.");
				shuffle(lotto);
				break;
				
			case 3:
				System.out.println("6���� ������ ���� ���մϴ�.");
				result = sumArr(lotto2);
				printArr(lotto2, lotto);
				System.out.println();
				System.out.println("��: "+result);
				break;
				
			case 4:
				System.out.println("�迭����");
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
		System.out.print("�ζ� ��ȣ: ");	
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
		//���� 
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
