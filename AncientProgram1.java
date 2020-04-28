import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//古诗处理主类
public class AncientProgram1 {

	// 控制台输入字符串控制流
	private static Scanner scanner = new Scanner(System.in);

	// 统计字符串出现个数
	private static int total = 0;

	// 输出记录的字符串
	private static String ancient = "";

	// 按要求显示字符串信息
	public static void screenPrint(String input) {
		try {
			// 字符串转数组
			char[] in = input.toCharArray();
			//输出所在行下标
			int line = 0;
			//字符串长度
			int length = in.length;
			//遍历字符串组集合
			for (int i = 0; i < length - length % 7; i++) {
				if (i % 7 == 0) {
					//截取到指定下标下的字符串信息
					String r = input.substring(line * 7, (line + 1) * 7);
					if (line % 2 == 1) {
						//控制输出
						System.out.println(r + "。");
						// 奇数时分割句号
						ancient += r + "。\n";
					} else {
						// 偶数时候分割的是逗号
						ancient += r + "，";
						System.out.print(r + "，");
					}
					line++;
				}
			}
			// 将结果字符串结果输出到文件
			FileWriter fileWritter = new FileWriter("file.txt", false);
			fileWritter.write(ancient);
			fileWritter.close();
		} catch (IOException e) {
			System.out.println("" + e.getMessage());
		}
	}

	// 判断对应字符串出现的次数
	public static int strTotalCount(String input) {
		System.out.print("请选输入统计关键词：");
		String key = scanner.next();
		int index = 0;
		// 如果key在对应字符串中存在
		while ((index = input.indexOf(key, index)) != -1) {
			// 下标索引往后移动一位
			index = index + key.length();
			// 计数器累加1，统计字符串出现次数
			total++;

		}
		return total;
	}

	// 主方法调用菜单
	public static void doMain() {
		System.out.print("请选输入古诗内容：");
		String input = scanner.nextLine();
		do {
			System.out.println("显示菜单选择");
			System.out.println("1.格式化古诗");
			System.out.println("2.统计字或词出现的次数");
			System.out.println("3.退出");
			System.out.print("请选择： ");
			int c = scanner.nextInt();
			switch (c) {
			case 1:
				screenPrint(input);
				break;
			case 2:
				System.out.println("出现次数：" + strTotalCount(input));
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (true);
	}

	// main方法调用菜单输出
	public static void main(String[] args) {
		doMain();
	}
}
