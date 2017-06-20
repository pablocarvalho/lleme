package uff.ic.biblioteca.controller.patterns.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    abstract public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
