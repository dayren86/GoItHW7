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

public class UpdateDevelopersCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Developers developers = new Developers();
        developers.setId(Integer.parseInt(req.getParameter("updateId")));
        developers.setName(req.getParameter("updateName"));
        developers.setAge(Integer.parseInt(req.getParameter("updateAge")));
        developers.setSex(Developers.Sex.valueOf(req.getParameter("updateSex")));
        developers.setSalary(Integer.parseInt(req.getParameter("updateSalary")));
        developers.setSkillsSet(Collections.singleton(new RequestsSkills().getById(Integer.parseInt(req.getParameter("updateSkills")))));
        developers.setProjectsSet(Collections.singleton(new RequestsProjects().getById(Integer.parseInt(req.getParameter("updateProjects")))));

        new RequestsDevelopers().update(developers);

        resp.sendRedirect("/developers");
    }
}
