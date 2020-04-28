import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//��ʫ��������
public class AncientProgram1 {

	// ����̨�����ַ���������
	private static Scanner scanner = new Scanner(System.in);

	// ͳ���ַ������ָ���
	private static int total = 0;

	// �����¼���ַ���
	private static String ancient = "";

	// ��Ҫ����ʾ�ַ�����Ϣ
	public static void screenPrint(String input) {
		try {
			// �ַ���ת����
			char[] in = input.toCharArray();
			//����������±�
			int line = 0;
			//�ַ�������
			int length = in.length;
			//�����ַ����鼯��
			for (int i = 0; i < length - length % 7; i++) {
				if (i % 7 == 0) {
					//��ȡ��ָ���±��µ��ַ�����Ϣ
					String r = input.substring(line * 7, (line + 1) * 7);
					if (line % 2 == 1) {
						//�������
						System.out.println(r + "��");
						// ����ʱ�ָ���
						ancient += r + "��\n";
					} else {
						// ż��ʱ��ָ���Ƕ���
						ancient += r + "��";
						System.out.print(r + "��");
					}
					line++;
				}
			}
			// ������ַ������������ļ�
			FileWriter fileWritter = new FileWriter("file.txt", false);
			fileWritter.write(ancient);
			fileWritter.close();
		} catch (IOException e) {
			System.out.println("" + e.getMessage());
		}
	}

	// �ж϶�Ӧ�ַ������ֵĴ���
	public static int strTotalCount(String input) {
		System.out.print("��ѡ����ͳ�ƹؼ��ʣ�");
		String key = scanner.next();
		int index = 0;
		// ���key�ڶ�Ӧ�ַ����д���
		while ((index = input.indexOf(key, index)) != -1) {
			// �±����������ƶ�һλ
			index = index + key.length();
			// �������ۼ�1��ͳ���ַ������ִ���
			total++;

		}
		return total;
	}

	// ���������ò˵�
	public static void doMain() {
		System.out.print("��ѡ�����ʫ���ݣ�");
		String input = scanner.nextLine();
		do {
			System.out.println("��ʾ�˵�ѡ��");
			System.out.println("1.��ʽ����ʫ");
			System.out.println("2.ͳ���ֻ�ʳ��ֵĴ���");
			System.out.println("3.�˳�");
			System.out.print("��ѡ�� ");
			int c = scanner.nextInt();
			switch (c) {
			case 1:
				screenPrint(input);
				break;
			case 2:
				System.out.println("���ִ�����" + strTotalCount(input));
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (true);
	}

	// main�������ò˵����
	public static void main(String[] args) {
		doMain();
	}
}
