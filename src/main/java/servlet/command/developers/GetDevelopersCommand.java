package servlet.command.developers;

import data.entity.Developers;
import data.queries.RequestsDevelopers;
import data.queries.RequestsProjects;
import data.queries.RequestsSkills;
import org.thymeleaf.context.Context;
import servlet.MainPage;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class GetDevelopersCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        resp.setContentType("text/html");
        Context context = new Context(
                req.getLocale(),
                Map.of("requestsForDevelopers", new RequestsDevelopers().listAll(),
                        "sexValues", Developers.Sex.values(),
                        "requestsForSkills", new RequestsSkills().listAll(),
                        "requestsForProjects", new RequestsProjects().listAll()
                )

        );

        MainPage.getEngine().process("developers", context, resp.getWriter());
        resp.getWriter().close();
    }
}
