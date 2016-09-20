package com.thoughtworks.test.client;

public class MineSweeperClientFactory {

	public IMineSweeperClient getMyClient(String clientType) {
		IMineSweeperClient clientObj = null;
		switch (clientType) {
		case "File":
			// do something
			break;
		case "Console":
			// do something
			break;
		// case default break;

		}
		return clientObj;

	}
}
