package io.silverspoon.bulldog.linux.io;

import io.silverspoon.bulldog.linux.jni.NativePollResult;

public interface LinuxEpollListener {

	void processEpollResults(NativePollResult[] results);
	
}
