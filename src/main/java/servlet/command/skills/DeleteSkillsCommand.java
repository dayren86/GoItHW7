package servlet.command.skills;

import data.queries.RequestsSkills;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteSkillsCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String deleteSkill = req.getParameter("deleteSkill");

        new RequestsSkills().deleteById(Integer.parseInt(deleteSkill));

        resp.sendRedirect("/skills");
    }
}
