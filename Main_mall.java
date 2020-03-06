import java.util.ArrayList;
import java.util.Scanner;

public class Main_mall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Mall_execute execute = new Mall_execute();
		execute.manager();
	
		
		while(true) {
			System.out.println("---------------------");
			System.out.println("    [���θ� ���α׷�]	");
			System.out.println("---------------------");
			System.out.println("1) ȸ������");
			System.out.println("2) �α��� ");
			System.out.println("3) �α׾ƿ� ");
			System.out.println("4) ��ǰ���� ");
			System.out.println("5) ��ǰ���� ��Ϻ��� ");
			System.out.println("8) ȸ�������˻� ");
			System.out.println("9) ȸ��������� ");
			System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
			int select = scan.nextInt();
						
			switch (select) {
			case 1:
				execute.input();
				break;
				
			case 2:
				execute.login();
				break;
				
			case 3:
				execute.logout();
				break;
				
			case 4:
				boolean check;
				check = execute.login_check();
				if(check==false) {
					System.out.println("�α����� �Ǿ����� �ʽ��ϴ�. ��ǰ�� �����Ͻ÷��� �α����� ���ּ���.");
					break;
				}
				
				String[] p_list = {"", "LCD TV", "LED TV", "OLED TV", "�Ϲ� �����", "�繮�� �����", "�뵹�̼�Ź�� ", "�巳��Ź��", "�巳������Ź��"};
			
				while(true) {
									
					System.out.println("---------------------------");
					System.out.println("	[��ǰ���]	");
					System.out.println("---------------------------");
					System.out.println("1)LCD TV	2)LED TV	3)OLED TV");
					System.out.println("4)�Ϲ� �����	5)�繮�� �����");
					System.out.println("6)�뵹�̼�Ź�� 	7)�巳��Ź��	8)�巳������Ź��");
					System.out.println("�����ϰ� ���� ��ǰ ��ȣ�� �Է��ϼ���.>> (����ȭ��:99)");
					int p_num = scan.nextInt();
					scan.nextLine();
					
					if (p_num==99) {
						System.out.println("���� ȭ������ ���ư��ϴ�.");
						break;
					}
					
					System.out.println(p_list[p_num]+"�� �����Ͻðڽ��ϱ�? (y/n)");
					String yn = scan.nextLine();
					
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("�����Ͻ� ��ǰ�� �ٽ� �������ּ���.");
						continue;
					}else if(yn.equalsIgnoreCase("y")) {
					
						switch (p_num) {
						case 1:
							execute.buy_tv(new LCD());
							
							break;
							
						case 2:
							execute.buy_tv(new LED());
							break;
							
						case 3:
							execute.buy_tv(new OLED());
							break;
				
						case 4:
							execute.buy_ref(new Ref1());
							break;
							
						case 5:
							execute.buy_ref(new Ref2());
							break;
							
						case 6:
							execute.buy_wm(new WM1());
							break;

						case 7:
							execute.buy_wm(new WM2());
							break;
							
						case 8:
							execute.buy_wm(new WM3());
							break;
							
						default:
							break;
						}
					}
					break;
				}
						
				break;
//				
			case 5:
				execute.print_buy();
				break;
				
			case 8:
				execute.search();
				break;
				
			case 9:
				execute.prit_member();
				break;

			default:
				break;
			}
			
		}
		
		
		
		
		
		
		
		
	}

}
