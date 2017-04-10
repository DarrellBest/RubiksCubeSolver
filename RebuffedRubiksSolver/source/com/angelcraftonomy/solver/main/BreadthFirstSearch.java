package com.angelcraftonomy.solver.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	// private Thread t;
	private Queue<String> queue;
	private Cube cube;
	private ArrayList<String> solutions;
	private String threadName;
	private int queueSize;

	public BreadthFirstSearch(Cube cube, String threadName) {
		solutions = new ArrayList<>();
		this.cube = cube;
		this.threadName = threadName;

		if (!threadName.equals(""))
			queue = new LinkedList<>(Arrays.asList(threadName));
	}

	public BreadthFirstSearch(Cube cube) {
		solutions = new ArrayList<>();
		this.cube = cube;
		queue = new LinkedList<>(Arrays.asList("F", "f", "B", "b", "L", "l", "R", "r", "U", "u", "D", "d"));
	}

	public void search() {
		String retVal = "";
		String moves = "";

		ArrayList<String> nextMoves = new ArrayList<>();

		if (cube.isSolved()) {
			// already in a solved state
			System.out.println("Already in a solved state");
			System.exit(2);
		}

		while (!queue.isEmpty() && solutions.isEmpty()) {
			nextMoves.clear();
			nextMoves.addAll(Arrays.asList("F", "f", "B", "b", "L", "l", "R", "r", "U", "u", "D", "d"));
			// Get next moves
			moves = queue.remove();
			int maxSteps = 20;

			if (moves.length() > maxSteps)
				continue;

			// Add all children to the queue
			if (moves.length() < maxSteps - 1)
				for (String move : nextMoves)
					queue.add(moves.concat(move));

			// Test possible solution
			Cube temp = new Cube();
			temp.translateMoves(cube.getRandomMoves());
			temp.translateMoves(moves);

			if (temp.isSolved()) {
				retVal = moves;
				solutions.add(retVal);
				queueSize = queue.size();
			}
		}

		// print solutions on thread exit
		for (String solution : solutions)
			System.out.println("Solution: " + solution);
	}

	public ArrayList<String> getSolutions() {
		return this.solutions;
	}

}
