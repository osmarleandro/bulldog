package io.silverspoon.bulldog.core.testsuite;

import io.silverspoon.bulldog.core.TestSignal;
import io.silverspoon.bulldog.core.bus.TestBusConnection;
import io.silverspoon.bulldog.core.gpio.base.TestAbstractAnalogInput;
import io.silverspoon.bulldog.core.gpio.base.TestAbstractDigitalInput;
import io.silverspoon.bulldog.core.gpio.base.TestAbstractDigitalOutput;
import io.silverspoon.bulldog.core.gpio.base.TestAbstractPinFeature;
import io.silverspoon.bulldog.core.gpio.base.TestAbstractPwm;
import io.silverspoon.bulldog.core.gpio.base.TestDigitalIOFeature;
import io.silverspoon.bulldog.core.gpio.base.TestPin;
import io.silverspoon.bulldog.core.gpio.util.TestSoftPwm;
import io.silverspoon.bulldog.core.platform.TestAbstractBoard;
import io.silverspoon.bulldog.core.platform.TestAbstractPinProvider;
import io.silverspoon.bulldog.core.util.TestBitMagic;
import io.silverspoon.bulldog.core.util.TestBulldogUtil;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
				TestAbstractPinProvider.class,
				TestAbstractBoard.class, 
				TestPin.class,
				TestAbstractPinFeature.class,
				TestAbstractDigitalOutput.class,
				TestAbstractDigitalInput.class,
				TestDigitalIOFeature.class,
				TestAbstractAnalogInput.class,
				TestAbstractPwm.class,
				TestSignal.class,
				TestSoftPwm.class,
				TestBusConnection.class,
				TestBulldogUtil.class,
				TestBitMagic.class
			  })
public class CompleteTestSuite {

}