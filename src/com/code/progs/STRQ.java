package com.code.progs;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;

class STRQ {

	public static void main(String[] args) throws Exception {

		Input in = new Input(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String str = in.getString();
		char[] sarr = str.toCharArray();

		int query = in.getInt();
		while (query-- > 0) {

			char a = in.getChar();
			char b = in.getChar();

			int L = in.getInt();
			int R = in.getInt();
			int c = 0, ab = 0;
			System.out.println(L + " " + R);
			for (int i = L - 1; i <= R - 1; i++) {
				if (sarr[i] == a)
					c++;
				if (sarr[i] == b)
					ab += c;

			}

			out.write(ab + "");
			out.write("\n");
		}
		out.flush();
	}

}

class Input {
	private static final int BUFF_SIZE = 8192;
	private static final byte SPACE = ' ';
	private static final byte MINUS_SIGN = '-';
	private static final byte ZERO = '0';
	private static final byte NINE = '9';

	private byte[] buffer;
	private InputStream is;
	private int index;
	private int bytesRead;

	public Input(InputStream inputStream) {
		is = inputStream;
		buffer = new byte[BUFF_SIZE];
		index = bytesRead = 0;
	}

	public char getChar() throws Exception {
		return (char) getNextByte();
	}

	public long getLong() throws Exception {
		return (long) getInt();
	}

	public String getString() throws Exception {
		StringBuffer buf = new StringBuffer();

		// get the next character
		byte currentByte = getNextByte();

		// chew through whitespace
		while (currentByte <= SPACE) {
			currentByte = getNextByte();
		}

		// get the string
		do {
			buf.append((char) currentByte);
			currentByte = getNextByte();
		} while (currentByte > SPACE);

		return buf.toString();
	}

	// moves past whitespace and returns the next int
	public int getInt() throws Exception {
		int retVal = 0;

		// get the next character
		byte currentByte = getNextByte();

		// chew through whitespace
		while (currentByte <= SPACE) {
			currentByte = getNextByte();
		}

		// now we're at the number (maybe) - handle a negative sign
		boolean isNegative = (currentByte == MINUS_SIGN);
		if (isNegative) {
			// read past the negative sign
			currentByte = getNextByte();
		}

		// now we're really at the number - build it
		do {
			retVal = (retVal * 10) + currentByte - ZERO;
			currentByte = getNextByte();
		} while (isDigit(currentByte));

		// handle negative value
		if (isNegative) {
			return -retVal;
		}

		return retVal;
	}

	private boolean isDigit(byte theByte) {
		return ((theByte >= ZERO) && (theByte <= NINE));
	}

	// fills the buffer if necessary and returns the next byte
	private byte getNextByte() throws Exception {
		if (index == bytesRead) {
			// we need more data - reset the index and read
			bytesRead = is.read(buffer, index = 0, BUFF_SIZE);
		}

		// return the next byte in the buffer
		return buffer[index++];
	}
}
