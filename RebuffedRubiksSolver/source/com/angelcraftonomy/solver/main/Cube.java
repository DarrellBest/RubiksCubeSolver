package com.angelcraftonomy.solver.main;

import java.util.Random;

public class Cube {
	private String solution = "";
	private String randomMoves = "";
	private int stickers[];

	public Cube() {
		stickers = new int[54];
		// Setting Back side to Red (0)
		stickers[0] = stickers[1] = stickers[2] = stickers[3] = stickers[4] = stickers[5] = stickers[6] = stickers[7] = stickers[8] = 'R';
		// Setting Left side to Blue(1)
		stickers[9] = stickers[10] = stickers[11] = stickers[21] = stickers[22] = stickers[23] = stickers[33] = stickers[34] = stickers[35] = 'B';
		// Setting Top side to White(2)
		stickers[12] = stickers[13] = stickers[14] = stickers[24] = stickers[25] = stickers[26] = stickers[36] = stickers[37] = stickers[38] = 'W';
		// Setting Right side to Green(3)
		stickers[15] = stickers[16] = stickers[17] = stickers[27] = stickers[28] = stickers[29] = stickers[39] = stickers[40] = stickers[41] = 'G';
		// Setting Bottom side to Yellow(4)
		stickers[18] = stickers[19] = stickers[20] = stickers[30] = stickers[31] = stickers[32] = stickers[42] = stickers[43] = stickers[44] = 'Y';
		// Setting Front side to Orange(5)
		stickers[45] = stickers[46] = stickers[47] = stickers[48] = stickers[49] = stickers[50] = stickers[51] = stickers[52] = stickers[53] = 'O';
	}

	public Cube(int stickers[]) {
		this.stickers = stickers;
	}

	public String getSolution() {
		return this.solution;
	}

	public String getRandomMoves() {
		return this.randomMoves;
	}

	public void randomize(int val) {
		Random random = new Random();
		for (int i = 0; i < val; i++) {
			int move = random.nextInt(12);
			if (move == 0) {
				this.left();
				randomMoves = randomMoves.concat("L");
			}
			if (move == 1) {
				this.leftReverse();
				randomMoves = randomMoves.concat("l");
			}
			if (move == 2) {
				this.right();
				randomMoves = randomMoves.concat("R");
			}
			if (move == 3) {
				this.rightReverse();
				randomMoves = randomMoves.concat("r");
			}
			if (move == 4) {
				this.up();
				randomMoves = randomMoves.concat("U");
			}
			if (move == 5) {
				this.upReverse();
				randomMoves = randomMoves.concat("u");
			}
			if (move == 6) {
				this.down();
				randomMoves = randomMoves.concat("D");
			}
			if (move == 7) {
				this.downReverse();
				randomMoves = randomMoves.concat("d");
			}
			if (move == 8) {
				this.front();
				randomMoves = randomMoves.concat("F");
			}
			if (move == 9) {
				this.frontReverse();
				randomMoves = randomMoves.concat("f");
			}
			if (move == 10) {
				this.back();
				randomMoves = randomMoves.concat("B");
			}
			if (move == 11) {
				this.backReverse();
				randomMoves = randomMoves.concat("b");
			}
		}

	}

	public void translateMoves(String moves) {
		char moveArray[] = moves.toCharArray();

		for (char move : moveArray) {
			if (move == 'L') {
				this.left();
				continue;
			}
			if (move == 'l') {
				this.leftReverse();
				continue;
			}
			if (move == 'R') {
				this.right();
				continue;
			}
			if (move == 'r') {
				this.rightReverse();
				continue;
			}
			if (move == 'U') {
				this.up();
				continue;
			}
			if (move == 'u') {
				this.upReverse();
				continue;
			}
			if (move == 'D') {
				this.down();
				continue;
			}
			if (move == 'd') {
				this.downReverse();
				continue;
			}
			if (move == 'F') {
				this.front();
				continue;
			}
			if (move == 'f') {
				this.frontReverse();
				continue;
			}
			if (move == 'B') {
				this.back();
				continue;
			}
			if (move == 'b') {
				this.backReverse();
				continue;
			}

		}
	}

	public void randomSolve() {
		Random random = new Random();
		int val;
		boolean solved = false;
		Cube temp;
		String moves = "";

		while (!solved) {

			temp = new Cube(this.stickers.clone());
			val = random.nextInt(20) + 1;
			moves = "";

			for (int i = 0; i < val; i++) {
				int move = random.nextInt(12);
				if (move == 0) {
					temp.left();
					moves = moves.concat("L");
				}
				if (move == 1) {
					temp.leftReverse();
					moves = moves.concat("l");
				}
				if (move == 2) {
					temp.right();
					moves = moves.concat("R");
				}
				if (move == 3) {
					temp.rightReverse();
					moves = moves.concat("r");
				}
				if (move == 4) {
					temp.up();
					moves = moves.concat("U");
				}
				if (move == 5) {
					temp.upReverse();
					moves = moves.concat("u");
				}
				if (move == 6) {
					temp.down();
					moves = moves.concat("D");
				}
				if (move == 7) {
					temp.downReverse();
					moves = moves.concat("d");
				}
				if (move == 8) {
					temp.front();
					moves = moves.concat("F");
				}
				if (move == 9) {
					temp.frontReverse();
					moves = moves.concat("f");
				}
				if (move == 10) {
					temp.back();
					moves = moves.concat("B");
				}
				if (move == 11) {
					temp.backReverse();
					moves = moves.concat("b");
				}
			}
			solved = temp.isSolved();
		}
		this.solution = moves;
	}

	public boolean isSolved() {

		boolean retVal = false;
		if ((stickers[0] == stickers[1]) && (stickers[0] == stickers[2]) && (stickers[0] == stickers[3])
				&& (stickers[0] == stickers[4]) && (stickers[0] == stickers[5]) && (stickers[0] == stickers[6])
				&& (stickers[0] == stickers[7]) && (stickers[0] == stickers[8]) && (stickers[9] == stickers[10])
				&& (stickers[9] == stickers[11]) && (stickers[9] == stickers[21]) && (stickers[9] == stickers[22])
				&& (stickers[9] == stickers[23]) && (stickers[9] == stickers[33]) && (stickers[9] == stickers[34])
				&& (stickers[9] == stickers[35]) && (stickers[12] == stickers[13]) && (stickers[12] == stickers[14])
				&& (stickers[12] == stickers[24]) && (stickers[12] == stickers[25]) && (stickers[12] == stickers[26])
				&& (stickers[12] == stickers[36]) && (stickers[12] == stickers[37]) && (stickers[12] == stickers[38])
				&& (stickers[15] == stickers[16]) && (stickers[15] == stickers[17]) && (stickers[15] == stickers[27])
				&& (stickers[15] == stickers[28]) && (stickers[15] == stickers[29]) && (stickers[15] == stickers[39])
				&& (stickers[15] == stickers[40]) && (stickers[15] == stickers[41]) && (stickers[18] == stickers[19])
				&& (stickers[18] == stickers[20]) && (stickers[18] == stickers[30]) && (stickers[18] == stickers[31])
				&& (stickers[18] == stickers[32]) && (stickers[18] == stickers[42]) && (stickers[18] == stickers[43])
				&& (stickers[18] == stickers[44]) && (stickers[45] == stickers[46]) && (stickers[45] == stickers[47])
				&& (stickers[45] == stickers[48]) && (stickers[45] == stickers[49]) && (stickers[45] == stickers[50])
				&& (stickers[45] == stickers[51]) && (stickers[45] == stickers[52]) && (stickers[45] == stickers[53]))
			retVal = true;

		return retVal;
	}

	public void test() {
		Cube temp = new Cube(this.stickers.clone());
		int i = 0;
		boolean solved = false;
		while (!solved) {
			temp.right();
			temp.up();
			temp.back();
			temp.down();
			temp.left();
			i++;
			solved = temp.isSolved();
		}
		temp.print();

	}

	private void left() {
		int temp = stickers[51];
		stickers[51] = stickers[36];
		stickers[36] = stickers[6];
		stickers[6] = stickers[44];
		stickers[44] = temp;
		temp = stickers[48];
		stickers[48] = stickers[24];
		stickers[24] = stickers[3];
		stickers[3] = stickers[32];
		stickers[32] = temp;
		temp = stickers[45];
		stickers[45] = stickers[12];
		stickers[12] = stickers[0];
		stickers[0] = stickers[20];
		stickers[20] = temp;
		temp = stickers[33];
		stickers[33] = stickers[35];
		stickers[35] = stickers[11];
		stickers[11] = stickers[9];
		stickers[9] = temp;
		temp = stickers[34];
		stickers[34] = stickers[23];
		stickers[23] = stickers[10];
		stickers[10] = stickers[21];
		stickers[21] = temp;
	}

	private void leftReverse() {
		for (int i = 0; i < 3; i++) {
			this.left();
		}
	}

	private void right() {
		int temp = stickers[2];
		stickers[2] = stickers[14];
		stickers[14] = stickers[47];
		stickers[47] = stickers[42];
		stickers[42] = temp;
		temp = stickers[5];
		stickers[5] = stickers[26];
		stickers[26] = stickers[50];
		stickers[50] = stickers[30];
		stickers[30] = temp;
		temp = stickers[8];
		stickers[8] = stickers[38];
		stickers[38] = stickers[53];
		stickers[53] = stickers[18];
		stickers[18] = temp;
		temp = stickers[17];
		stickers[17] = stickers[15];
		stickers[15] = stickers[39];
		stickers[39] = stickers[41];
		stickers[41] = temp;
		temp = stickers[16];
		stickers[16] = stickers[27];
		stickers[27] = stickers[40];
		stickers[40] = stickers[29];
		stickers[29] = temp;
	}

	private void rightReverse() {
		for (int i = 0; i < 3; i++) {
			this.right();
		}
	}

	private void up() {
		int temp = stickers[36];
		stickers[36] = stickers[38];
		stickers[38] = stickers[14];
		stickers[14] = stickers[12];
		stickers[12] = temp;
		temp = stickers[37];
		stickers[37] = stickers[26];
		stickers[26] = stickers[13];
		stickers[13] = stickers[24];
		stickers[24] = temp;
		temp = stickers[45];
		stickers[45] = stickers[39];
		stickers[39] = stickers[8];
		stickers[8] = stickers[11];
		stickers[11] = temp;
		temp = stickers[46];
		stickers[46] = stickers[27];
		stickers[27] = stickers[7];
		stickers[7] = stickers[23];
		stickers[23] = temp;
		temp = stickers[47];
		stickers[47] = stickers[15];
		stickers[15] = stickers[6];
		stickers[6] = stickers[35];
		stickers[35] = temp;
	}

	private void upReverse() {
		for (int i = 0; i < 3; i++) {
			this.up();
		}
	}

	private void down() {
		int temp = stickers[51];
		stickers[51] = stickers[9];
		stickers[9] = stickers[2];
		stickers[2] = stickers[41];
		stickers[41] = temp;
		temp = stickers[52];
		stickers[52] = stickers[21];
		stickers[21] = stickers[1];
		stickers[1] = stickers[29];
		stickers[29] = temp;
		temp = stickers[53];
		stickers[53] = stickers[33];
		stickers[33] = stickers[0];
		stickers[0] = stickers[17];
		stickers[17] = temp;
		temp = stickers[18];
		stickers[18] = stickers[42];
		stickers[42] = stickers[44];
		stickers[44] = stickers[20];
		stickers[20] = temp;
		temp = stickers[30];
		stickers[30] = stickers[43];
		stickers[43] = stickers[32];
		stickers[32] = stickers[19];
		stickers[19] = temp;
	}

	private void downReverse() {
		for (int i = 0; i < 3; i++) {
			this.down();
		}
	}

	private void front() {
		int temp = stickers[41];
		stickers[41] = stickers[38];
		stickers[38] = stickers[35];
		stickers[35] = stickers[44];
		stickers[44] = temp;
		temp = stickers[40];
		stickers[40] = stickers[37];
		stickers[37] = stickers[34];
		stickers[34] = stickers[43];
		stickers[43] = temp;
		temp = stickers[39];
		stickers[39] = stickers[36];
		stickers[36] = stickers[33];
		stickers[33] = stickers[42];
		stickers[42] = temp;
		temp = stickers[47];
		stickers[47] = stickers[45];
		stickers[45] = stickers[51];
		stickers[51] = stickers[53];
		stickers[53] = temp;
		temp = stickers[46];
		stickers[46] = stickers[48];
		stickers[48] = stickers[52];
		stickers[52] = stickers[50];
		stickers[50] = temp;
	}

	private void frontReverse() {
		for (int i = 0; i < 3; i++) {
			this.front();
		}
	}

	private void back() {
		int temp = stickers[9];
		stickers[9] = stickers[12];
		stickers[12] = stickers[15];
		stickers[15] = stickers[18];
		stickers[18] = temp;
		temp = stickers[10];
		stickers[10] = stickers[13];
		stickers[13] = stickers[16];
		stickers[16] = stickers[19];
		stickers[19] = temp;
		temp = stickers[11];
		stickers[11] = stickers[14];
		stickers[14] = stickers[17];
		stickers[17] = stickers[20];
		stickers[20] = temp;
		temp = stickers[0];
		stickers[0] = stickers[6];
		stickers[6] = stickers[8];
		stickers[8] = stickers[2];
		stickers[2] = temp;
		temp = stickers[3];
		stickers[3] = stickers[7];
		stickers[7] = stickers[5];
		stickers[5] = stickers[1];
		stickers[1] = temp;
	}

	private void backReverse() {
		for (int i = 0; i < 3; i++) {
			this.back();
		}
	}

	public void print() {
		System.out.println("         |" + "-------|");
		System.out.println(
				"         | " + (char) stickers[0] + " " + (char) stickers[1] + " " + (char) stickers[2] + " |");
		System.out.println(
				"         | " + (char) stickers[3] + " " + (char) stickers[4] + " " + (char) stickers[5] + " |");
		System.out.println(
				"         | " + (char) stickers[6] + " " + (char) stickers[7] + " " + (char) stickers[8] + " |");
		System.out.println(" |-------|" + "-------|" + "-------|" + "-------|");
		System.out.println(" | " + (char) stickers[9] + " " + (char) stickers[10] + " " + (char) stickers[11] + " | "
				+ (char) stickers[12] + " " + (char) stickers[13] + " " + (char) stickers[14] + " | "
				+ (char) stickers[15] + " " + (char) stickers[16] + " " + (char) stickers[17] + " | "
				+ (char) stickers[18] + " " + (char) stickers[19] + " " + (char) stickers[20] + " | ");
		System.out.println(" | " + (char) stickers[21] + " " + (char) stickers[22] + " " + (char) stickers[23] + " | "
				+ (char) stickers[24] + " " + (char) stickers[25] + " " + (char) stickers[26] + " | "
				+ (char) stickers[27] + " " + (char) stickers[28] + " " + (char) stickers[29] + " | "
				+ (char) stickers[30] + " " + (char) stickers[31] + " " + (char) stickers[32] + " | ");
		System.out.println(" | " + (char) stickers[33] + " " + (char) stickers[34] + " " + (char) stickers[35] + " | "
				+ (char) stickers[36] + " " + (char) stickers[37] + " " + (char) stickers[38] + " | "
				+ (char) stickers[39] + " " + (char) stickers[40] + " " + (char) stickers[41] + " | "
				+ (char) stickers[42] + " " + (char) stickers[43] + " " + (char) stickers[44] + " | ");
		System.out.println(" |-------|" + "-------|" + "-------|" + "-------|");
		System.out.println(
				"         | " + (char) stickers[45] + " " + (char) stickers[46] + " " + (char) stickers[47] + " |");
		System.out.println(
				"         | " + (char) stickers[48] + " " + (char) stickers[49] + " " + (char) stickers[50] + " |");
		System.out.println(
				"         | " + (char) stickers[51] + " " + (char) stickers[52] + " " + (char) stickers[53] + " |");
		System.out.println("         |" + "-------|\n");
	}

}
