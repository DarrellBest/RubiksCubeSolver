package com.angelcraftonomy.solver.main;

public class IterativeDepthFirstSearch implements Runnable {

	private Cube cube;
	private int maxDepth;
	private String solution;
	private Thread t;
	private String threadName;

	public IterativeDepthFirstSearch(Cube cube, String threadName) {
		this.cube = cube;
		this.maxDepth = 20;
		this.solution = "None";
		this.threadName = threadName;
	}

	public String getSolution() {
		return this.solution;
	}

	// Single thread
	public void search(String branch) {
		for (int i = maxDepth; i > 0; i--) {
			System.out.println("Searching Depth " + (maxDepth - i) + " on branch " + threadName);
			search(i, branch);
			if (!solution.equals("None"))
				return;
		}
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
			System.out.println("Solution: " + solution);
			return;
		}
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		this.search(threadName);
		printRuntime(startTime);
		System.exit(0);
	}

	private void printRuntime(long startTime) {
		long endTime = System.currentTimeMillis();
		long runtime = (endTime - startTime);
		long minutes = (runtime / 1000) / 60;
		long seconds = (runtime / 1000) % 60;
		if (minutes != 0 || seconds != 0)
			System.out
					.println("Thread " + threadName + " Total execution time: " + minutes + " min " + seconds + " sec");
		else
			System.out.println("Thread " + threadName + " Total execution time: " + runtime + " milliseconds");
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			// System.out.println("Starting Thread " + threadName);
			t.start();
		}
	}

}
