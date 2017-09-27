package Test.Common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoundTest.class, TickerTest.class, TransformTest.class })
public class AllTests {

}
