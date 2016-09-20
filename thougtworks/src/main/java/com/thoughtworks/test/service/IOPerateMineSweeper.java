package com.thoughtworks.test.service;

import com.thoughtworks.test.model.MineSweeper;

public interface IOPerateMineSweeper {

	/**
	 * method which will operate when the input is 'o' and it opens up the
	 * square in the mine by putting the value as 0
	 */
	public MineSweeper open(int row, int col);

	/**
	 * method which will operate when the input is 'f' and it flags up the
	 * square in the mine by putting the value as f
	 * 
	 */
	public MineSweeper flag(int row, int col);

	public void populateInputMat(MineSweeper mineSweeper, String[] eachRows, char[][] inputMat);

	public void populateOutputMat(MineSweeper mineSweeper, char[][] outputMat);

}
