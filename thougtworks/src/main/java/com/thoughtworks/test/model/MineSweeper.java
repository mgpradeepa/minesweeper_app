package com.thoughtworks.test.model;

public class MineSweeper implements Cloneable {

	private static MineSweeper INSTANCE = null;

	private MineSweeper() {
	}

	public synchronized static final MineSweeper getMineSweeperInstance() {
		if (INSTANCE == null) {

			INSTANCE = new MineSweeper();

		}
		return INSTANCE;
	}

	private int grid_size;
	private char inputMat[][];
	private char outputMat[][];

	/**
	 * @return the grid_size
	 */
	public int getGrid_size() {
		return grid_size;
	}

	/**
	 * @param grid_size
	 *            the grid_size to set
	 */
	public void setGrid_size(int grid_size) {
		this.grid_size = grid_size;
	}

	/**
	 * @return the inputMat
	 */
	public char[][] getInputMat() {
		return inputMat;
	}

	/**
	 * @param inputMat
	 *            the inputMat to set
	 */
	public void setInputMat(char[][] inputMat) {
		this.inputMat = inputMat;
	}

	/**
	 * @return the outputMat
	 */
	public char[][] getOutputMat() {

		return outputMat;
	}

	/**
	 * @param outputMat
	 *            the outputMat to set
	 */
	public void setOutputMat(char[][] outputMat) {
		this.outputMat = outputMat;
	}

}
