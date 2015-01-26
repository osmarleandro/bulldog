package org.bulldog.core.platform;

import java.util.ServiceLoader;

public class Platform {

	public static Board createBoard() throws IncompatiblePlatformException {
				
		for (BoardFactory detector : ServiceLoader.load(BoardFactory.class)) {
			if(detector.isCompatibleWithPlatform()) {
				return detector.createBoard();
			}
		}
		
		throw new IncompatiblePlatformException();
	}
}
