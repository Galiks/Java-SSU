package com.turchenkov.servlets.refactoring;

import com.turchenkov.dao.impl.TextDaoImpl;
import com.turchenkov.model.BankClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateClientServlet extends HttpServlet {

    private TextDaoImpl textDao;

    @Override
    public void init() throws ServletException {
        textDao = new TextDaoImpl("E:\\Загрузки\\turchenkov\\turchenkov\\Java-SSU\\AddClients.txt");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("createClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int account = Integer.parseInt(req.getParameter("account"));
        int money = Integer.parseInt(req.getParameter("money"));

        BankClient bankClient = new BankClient(username, password, account, money);

        textDao.write(bankClient);

        resp.sendRedirect("clients");
    }
}
