package inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class StreamPrinter {

	public static void main(String[] args) {
		readFromFile();
		readFixedBytes(5);
		readByte();
		
	}

	private static void readFromFile() {
		InputStream inputStream = null;
		try {
			inputStream = StreamPrinter.class.getResourceAsStream("test.txt");
			int[] data = new int[100];
			for (int i = 0; i < data.length; i++) {
				int datum = inputStream.read();
				if (datum == -1) {
					break;
				}
				System.out.write(datum);
				data[i] = datum;
			}
			System.out.write('\n');
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void readByte() {
		try {
			while (true) {
				int datum = System.in.read();
				if (datum == -1) {
					break;
				}
				System.out.write(datum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFixedBytes(int max) {
		try {
			byte[] b = new byte[max];
			int offset = 0;
			while (offset < b.length) {
				int bytesRead = System.in.read(b, offset, (max - offset));
				if (bytesRead == -1) {
					break;
				}
				offset += bytesRead;
			}
			for (byte tmp : b) {
				System.out.write(tmp);
			}
			System.out.write('\n');
			System.out.println(Arrays.toString(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
