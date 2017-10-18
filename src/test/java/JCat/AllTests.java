package JCat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import JCat.Display.BoundTest;

@RunWith(Suite.class)
@SuiteClasses({ BoundTest.class, TickerTest.class, TransformTest.class })
public class AllTests {

}
