package servlet.command.developers;

import data.entity.Developers;
import data.queries.RequestsDevelopers;
import data.queries.RequestsProjects;
import data.queries.RequestsSkills;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

public class AddDevelopersCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Developers developers = new Developers();
        developers.setName(req.getParameter("name"));
        developers.setAge(Integer.parseInt(req.getParameter("age")));
        developers.setSex(Developers.Sex.valueOf(req.getParameter("sex")));
        developers.setSalary(Integer.parseInt(req.getParameter("salary")));

        developers.setSkillsSet(Collections.singleton(new RequestsSkills().getById(Integer.parseInt(req.getParameter("skills")))));
        developers.setProjectsSet(Collections.singleton(new RequestsProjects().getById(Integer.parseInt(req.getParameter("projects")))));

        new RequestsDevelopers().create(developers);

        resp.sendRedirect("/developers");
    }
}
