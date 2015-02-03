package io.silverspoon.bulldog.devices.sensors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Dallas DS18B20 temperature sensor implementation.
 * 
 * @author sbunciak
 *
 */
public class DS18B20TemperatureSensor {

	private File deviceFile = null;

	public DS18B20TemperatureSensor(File deviceFile) {
		this.deviceFile = deviceFile;
	}

	// TODO: implement using UART?
	public float readTemperature() throws IOException {

		byte[] encoded = Files.readAllBytes(new File(deviceFile, "w1_slave").toPath());

		String tmp = new String(encoded);
		int tmpIndex = tmp.indexOf("t=");

		if (tmpIndex < 0) {
			throw new IOException("Could not read temperature!");
		}

		return Integer.parseInt(tmp.substring(tmpIndex + 2).trim()) / 1000f;
	}
}
