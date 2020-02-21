import java.util.Scanner;

public class Ex0221_01 {

	public static void main(String[] args) {
		
		// �������� 10���� 1���� �迭�� ����
		// 1~45�� �迭�� ���� ���� �־����. ����
		// 10���� �迭�� ������ �ǰڽ��ϴ�.
		// �� �ߺ��� ������� ����
		
		int[] list = new int[45];
		int[] select = new int[10];
		Scanner scan = new Scanner(System.in);
		int sum =0;
		int s_num = 0;
		
		while(true) {
			s_num = mainprint();
			
			switch (s_num) {
			case 1:
				input(list);
				System.out.println("45�� �� �ֱ� �Ϸ�");
				break;

			case 2:
				shuffle(list);
				System.out.println("�������� �Ϸ�");
				break;

			case 3:
				array(list, select);
				System.out.println("10�� �� �ֱ� �Ϸ�");
				break;

			case 4:
				printArr(select);
				break;

			case 5:
				sum = sumArr(select);
				System.out.println();
				System.out.println("10�� ��: "+sum);
				break;

			case 6:
				int[] change = new int[10];
				array(select, change); // ������ �ϳ� �����صδ� ���
				ascending(change);
				printArr(select);
				printArr(change);
				
//				printArr(select);
//				ascending(select);
//				printArr(select);
				break;

				
			default:
				break;
			}
			
		}
		
		
		
	} //main
	
	static int mainprint() {
		int s_num = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------------------");
		System.out.println("1. 45���� �� �ֱ�");
		System.out.println("2. ��������");
		System.out.println("3. 10�� �� �ֱ�");
		System.out.println("4. 10�� ���");
		System.out.println("5. 10�� �� ���ϱ�");
		System.out.println("6. 10�� �����ϱ�");
		System.out.println("------------------------");
		System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
		s_num = scan.nextInt();
		scan.hasNextLine();
		return s_num;
	}
	
	static void input(int[] list) {
		for(int i=0;i<list.length;i++) {  // �迭�� ��쿡�� for(int i:lotto){} ó�� �� �� ����
			list[i] = i+1;
		}
	}
	
	static void shuffle(int[] list) {
		int temp=0;
		int index=0;
		for(int i=0;i<300;i++) {
			index = (int)(Math.random()*45);
			temp = list[0];
			list[0] = list[index];
			list[index] = temp;
		}
	}
	
	
	static void array(int[] list, int[] select) {
		for(int i=0;i<select.length;i++) {
			select[i] = list[i];
		}
	}
	
	static void printArr(int[] select) {
		for(int i=0;i<select.length;i++) {
			System.out.print(select[i]+" ");
		}
		System.out.println();
	}
	
	static int sumArr(int[] select) {
		int sum = 0;
		for(int i=0;i<select.length;i++) {
			sum +=select[i];
		}
		return sum;
	}
	
	static void ascending(int[]select) {
		int temp=0;
		for(int i=0;i<select.length-1;i++) {
			boolean check = false;
			for(int j=0;j<select.length-1-i;j++) {
				if(select[j]>select[j+1]) {
					temp = select[j];
					select[j] = select[j+1];
					select[j+1] = temp;
					check = true;
				}
			}
			if(check==false) {
				break;
			}
		}
	}

} //class
