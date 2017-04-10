package com.angelcraftonomy.solver.main;

public class DepthFirstSearch {

	private Cube cube;
	private int maxDepth;
	private String solution;

	public DepthFirstSearch(Cube cube, int depth) {
		this.cube = cube;
		this.maxDepth = depth;
		this.solution = "None";
	}

	public String getSolution() {
		return this.solution;
	}

	public void search() {
		search(0, "");
	}

	private void search(int currentDepth, String moves) {
		char possibleMoves[] = { 'L', 'l', 'R', 'r', 'U', 'u', 'D', 'd', 'F', 'f', 'B', 'b' };
		for (char c : possibleMoves) {
			if (currentDepth < maxDepth) {
				search(currentDepth + 1, moves.concat(Character.toString(c)));
			}
		}

		Cube temp = new Cube();
		temp.translateMoves(cube.getRandomMoves());
		temp.translateMoves(moves);
		if (temp.isSolved()) {
			solution = moves;
			System.out.println(solution);
			return;
		}

	}

}
