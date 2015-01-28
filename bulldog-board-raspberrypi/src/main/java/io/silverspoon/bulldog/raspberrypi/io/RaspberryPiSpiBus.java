package io.silverspoon.bulldog.raspberrypi.io;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.linux.io.LinuxSpiBus;

public class RaspberryPiSpiBus extends LinuxSpiBus {

	public RaspberryPiSpiBus(String name, String deviceFilePath, Board board) {
		super(name, deviceFilePath, board);
	}

}
