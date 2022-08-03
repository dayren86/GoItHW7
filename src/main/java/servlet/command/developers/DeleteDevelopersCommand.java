package servlet.command.developers;


import data.queries.RequestsDevelopers;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDevelopersCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String id = req.getParameter("deleteDevelopers");

        new RequestsDevelopers().deleteById(Integer.parseInt(id));

        resp.sendRedirect("/developers");
    }
}
