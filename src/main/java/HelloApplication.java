import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class HelloApplication {
    private static final int PORT = 8085;

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(PORT);

        // то самое "приложение" или "контекст" с пустым путём
        Context tomcatContext = tomcat.addContext("", null);

        // класс Wrapper позволяет задать дополнительные настройки для сервлета
        Wrapper testServletWrapper =
                Tomcat.addServlet(tomcatContext, "helloServlet", new HelloServlet());

        // addMapping() сопоставляет URL-путь с сервлетом
        testServletWrapper.addMapping("/hello");

        tomcat.start();
    }
}