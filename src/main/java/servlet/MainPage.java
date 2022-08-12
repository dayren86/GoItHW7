package servlet;

import data.connection.DbInitService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import servlet.command.CommandService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainPage extends HttpServlet {

    private static TemplateEngine engine;

    private static CommandService commandService;

    public static TemplateEngine getEngine() {
        return engine;
    }

    public static CommandService getCommandService() {
        return commandService;
    }

    @Override
    public void init() {
        new DbInitService().dbInit();

        engine = new TemplateEngine();

        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix(getServletContext().getRealPath("templates/"));
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);

        commandService = new CommandService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        Context context = new Context();

        engine.process("/mainpage", context, resp.getWriter());

        resp.getWriter().close();
    }
}
