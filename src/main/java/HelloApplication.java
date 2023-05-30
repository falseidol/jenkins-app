import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class HelloApplication {
    private static final int PORT = 8085;

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.getConnector().setPort(PORT);
        Context tomcatContext = tomcat.addContext("", null);
        Wrapper testServletWrapper =
                Tomcat.addServlet(tomcatContext, "helloServlet", new HelloServlet());
        testServletWrapper.addMapping("/hello");

        tomcat.start();
    }
}