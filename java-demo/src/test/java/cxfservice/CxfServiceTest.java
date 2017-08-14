package cxfservice;

import com.hc.henghuirong.server.App;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertThat;

/**
 * Created by Wu.Kang on 2017/4/1.
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CxfServiceTest{
    //CHECKSTYLE:OFF
    @Rule
    public OutputCapture output = new OutputCapture(); // SUPPRESS CHECKSTYLE
    //CHECKSTYLE:ON

    private WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @LocalServerPort
    private String port;

    @Before
    public void setUp() {
        this.webServiceTemplate.setDefaultUri("http://localhost:" + this.port + "/soap/cxf");
    }

    @Test
    public void testGetInfo() {
        String request = "<q0:getInfo xmlns:q0=\"http://service.server.henghuirong.hc.com/\"><id>12</id></q0:getInfo>";

        StreamSource source = new StreamSource(new StringReader(request));
        StreamResult result = new StreamResult(System.out);

        this.webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        assertThat(this.output.toString(),
                equalToIgnoringWhiteSpace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + "<ns2:getInfoResponse xmlns:ns2=\"http://service.server.henghuirong.hc.com/\">"
                        + "<return>"
                        + "<data>"
                        + "<entry>"
                        + "<key xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">name</key>"
                        + "<value xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">caifu</value>"
                        + "</entry>"
                        + "<entry>"
                        + "<key xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">value</key>"
                        + "<value xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">fsdafas</value>"
                        +"</entry>"
                        + "</data>"
                        + "<sign>12</sign>"
                        + "</return>"
                        + "</ns2:getInfoResponse>"));
    }
}
