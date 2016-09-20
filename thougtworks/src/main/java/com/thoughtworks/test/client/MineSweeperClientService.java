package com.thoughtworks.test.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.thoughtworks.test.helper.consts.GridInfoConst;
import com.thoughtworks.test.model.MineSweeper;
import com.thoughtworks.test.service.IOPerateMineSweeper;
import com.thoughtworks.test.service.msimpl.MineSweeperServiceImpl;

public class MineSweeperClientService implements IMineSweeperClient {

	private static final char INPUT = 'I';
	private static final char FLAG = 'f';
	private static final char OUTPUT = 'O';
	private static final char OPEN = 'o';
	public static final String INPUT_FILE = Messages.getString("MineSweeperClientService.FILE_PATH"); //$NON-NLS-1$

	public static void main(String... args) {
		Scanner sc = null;
		MineSweeper mineSweeper;
		int game_status = -1;// game in progress
		IOPerateMineSweeper service;
		try {
			sc = new Scanner(new FileInputStream(INPUT_FILE));

			int grid_size = Integer.parseInt(sc.nextLine());
			mineSweeper = MineSweeper.getMineSweeperInstance();
			mineSweeper.setGrid_size(grid_size);

			System.out.println("value of grod" + grid_size);
			String initBoard = sc.nextLine();
			String eachRows[] = initBoard.split(",");
			char inputMat[][] = new char[grid_size][grid_size];
			char outputMat[][] = new char[grid_size][grid_size];
			
			service = new MineSweeperServiceImpl();
			service.populateInputMat(mineSweeper, eachRows, inputMat);
			service.populateOutputMat(mineSweeper, outputMat);

			displayMatrix(mineSweeper, INPUT);

			// String operation = null;
			char type;
			int row, col;
			String[] oper;

			// char[] eachOperation = new char[3];
			
			do {
				// operation = sc.nextLine();
				// eachOperation = operation.toCharArray();
				// type = eachOperation[0];
				// row = eachOperation[2];
				// col = eachOperation[4];

				oper = sc.nextLine().split(",");
				type = oper[0].charAt(0);
				row = Integer.parseInt(oper[1]);
				col = Integer.parseInt(oper[2]);

				if (type == OPEN) {
					mineSweeper = service.open(row, col);
					displayMatrix(mineSweeper, OUTPUT);

				} else if (type == FLAG) {
					mineSweeper = service.flag(row, col);
					displayMatrix(mineSweeper, OUTPUT);

				}

			} while (MineSweeperServiceImpl.GAME_STATUS == -1 || MineSweeperServiceImpl.GAME_STATUS == 0);// game_status
																											// can
																											// also
																											// be
																											// a
																											// attribute
																											// of
																											// the
																											// MineSweeper
																											// class
																											// --
																											// easy
																											// to
																											// track

		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
			System.err.println("File not found");
		} finally

		{
			if (sc != null)
				sc.close();
		}

	}

	private static void displayMatrix(MineSweeper mineSweeper, char type) {
		for (int i = 0; i < mineSweeper.getGrid_size(); i++) {
			if (type == INPUT) {

				for (int j = 0; j < mineSweeper.getGrid_size(); j++) {

					System.out.print(mineSweeper.getInputMat()[i][j]);

				}
				System.out.println(" ");
			} else if (type == OUTPUT) {
				for (int j = 0; j < mineSweeper.getGrid_size(); j++) {

					System.out.print(mineSweeper.getOutputMat()[i][j]);

				}
				System.out.println(" ");
			}

		}
	}


	/**
	 * This method is to get the input during the game and do the open / flag
	 * task
	 * 
	 */
	// public static
}
