import cxfservice.CxfServiceTest;
import service.ServiceTest;
import controller.ControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Wu.Kang on 2017/4/1.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ControllerTest.class, ServiceTest.class, CxfServiceTest.class})
public class ApplicationTest {
}
