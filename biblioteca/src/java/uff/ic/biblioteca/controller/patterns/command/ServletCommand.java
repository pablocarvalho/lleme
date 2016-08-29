package uff.ic.biblioteca.controller.patterns.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletCommand implements Command {

    @Override
    public abstract void execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException;
}
