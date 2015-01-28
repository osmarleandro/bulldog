package io.silverspoon.bulldog.cubieboard;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.BoardFactory;


public class CubieboardBoardFactory implements BoardFactory {

	@Override
	public boolean isCompatibleWithPlatform() {
		return true;
	}

	@Override
	public Board createBoard() {
		return Cubieboard.getInstance();
	}
}