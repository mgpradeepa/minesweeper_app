package com.thoughtworks.test.service.msimpl;

import com.thoughtworks.test.helper.consts.GridInfoConst;
import com.thoughtworks.test.model.MineSweeper;
import com.thoughtworks.test.service.IOPerateMineSweeper;

public class MineSweeperServiceImpl implements IOPerateMineSweeper {
	MineSweeper ms = MineSweeper.getMineSweeperInstance();
	public static int GAME_STATUS = -1;

	public MineSweeper open(int row, int col) {
		char[][] inp = ms.getInputMat();
		char[][] out = ms.getOutputMat();
		int r = row;
		int c = col;
		System.out.println(r + " " + c);
		if (inp[r][c] == 'x') {
			out[r][c] = GridInfoConst.SELECTED_CELL_VALUE;
			ms.setOutputMat(out);
			GAME_STATUS = 0;
		} else if (inp[row][col] == 'm') {
			out[row][col] = 'm';
			
			ms.setOutputMat(out);

		}
		return ms;

	}

	public MineSweeper flag(int row, int col) {
		char[][] out = ms.getOutputMat();
		int r = row;
		int c = col;
		System.out.println(r + " " + c);

		out[r][c] = GridInfoConst.FLAGGED_CELL_VALUE;
		ms.setOutputMat(out);

		return ms;

	}

	public void populateInputMat(MineSweeper mineSweeper, String[] eachRows, char[][] inputMat) {
		char[] eachChars;
		for (int i = 0; i < mineSweeper.getGrid_size(); i++) {
			eachChars = eachRows[i].toCharArray();
			int k = 0;

			for (int j = 0; j < mineSweeper.getGrid_size() && k < mineSweeper.getGrid_size(); j++, k++) {
				inputMat[i][j] = eachChars[k];

			}

		}

		mineSweeper.setInputMat(inputMat);
	}

	public void populateOutputMat(MineSweeper mineSweeper, char[][] outputMat) {

		for (int i = 0; i < mineSweeper.getGrid_size(); i++) {

			for (int j = 0; j < mineSweeper.getGrid_size(); j++) {
				outputMat[i][j] = GridInfoConst.EMPTY_CELL_VALUE;

			}

		}

		mineSweeper.setOutputMat(outputMat);
	}
}
