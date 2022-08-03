package servlet.command.companies;

import data.entity.Companies;
import data.queries.RequestsCompanies;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddCommands implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String name = req.getParameter("name");
        String companyDescription = req.getParameter("companyDescription");

        new RequestsCompanies().create(new Companies(name, companyDescription));

        resp.sendRedirect("/companies");
    }
}
