package com.bsuir.web7lab.command;

import com.bsuir.web7lab.exception.IncorrectDataException;
import com.bsuir.web7lab.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException, ServletException, IOException;
}