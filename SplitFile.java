package splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SplitFile {
	
	public static void main(String[] args) throws Exception {
		
		int size = 1024*1024*20;  //每次切割的大小为20M
		
		splict(size);
		merge(size);
		
		System.out.println("程序执行完成！");
	}
	/**
	 * 切割文件
	 * @param size
	 * @throws Exception
	 */
	public static void splict(int size) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:/Python视屏/爬音乐.wmv");
		byte[] b = new byte[size]; 
		int count = 1;
		int num = 0;
		FileOutputStream fileOutputStream = null;
		while((num=fileInputStream.read(b)) != -1) {
			fileOutputStream = new FileOutputStream(new File("D:/Python视屏/java/" + (count++) + ".wmv"), true);
			fileOutputStream.write(b, 0, num);
		}
		fileInputStream.close();
	}
	
	/**
	 * 合成文件
	 * @param size
	 * @throws Exception
	 */
	public static void merge(int size) throws Exception {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		File file = new File("D:/Python视屏/java");
		if (!file.exists()) {
			file.mkdir();
		}
		String[] list = file.list();
		byte[] b = new byte[size];
		int num = 0;
		
		for (int i = 1; i <= list.length; i++) {
			fileInputStream = new FileInputStream("D:/Python视屏/java/" + i + ".wmv");
			while((num=fileInputStream.read(b)) != -1) {
				fileOutputStream = new FileOutputStream("D:/Python视屏/shirui.wmv", true);
				fileOutputStream.write(b, 0, num);
			}
		}
		
	}
}
