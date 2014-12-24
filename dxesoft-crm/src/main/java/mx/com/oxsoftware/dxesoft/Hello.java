package mx.com.oxsoftware.dxesoft;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ernesto on 12/23/14.
 */
@XmlRootElement
public class Hello {

    private String message;

    private TestClass testClass;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TestClass getTestClass() {
        return testClass;
    }

    public void setTestClass(TestClass testClass) {
        this.testClass = testClass;
    }
}
