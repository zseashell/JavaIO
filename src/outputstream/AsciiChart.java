package outputstream;

import java.io.IOException;

public class AsciiChart {

	public static void main(String[] args) {
		writeByte();
		System.out.write('\n');
		writeByteArray();
	}

	private static void writeByte() {
		for (int i = 32; i < 127; i++) {
			System.out.write(i);
			// break the line after 8 character
			if (i % 8 == 7) {
				System.out.write('\n');
			} else {
				System.out.write('\t');
			}
		}
		System.out.write('\n');
	}

	private static void writeByteArray() {
		byte[] b = new byte[(127 - 31) * 2];
		int index = 0;
		for (int i = 32; i < 127; i++) {
			b[index++] = (byte) i;
			if (i % 8 == 7) {
				b[index++] = (byte) '\n';
			} else {
				b[index++] = (byte) '\t';
			}
		}
		b[index++] = (byte) '\n';

		try {
			System.out.write(b);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
