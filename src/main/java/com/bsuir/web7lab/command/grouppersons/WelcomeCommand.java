package com.bsuir.web7lab.command.grouppersons;

import com.bsuir.web7lab.command.Command;
import com.bsuir.web7lab.command.CommandResult;
import com.bsuir.web7lab.exception.IncorrectDataException;
import com.bsuir.web7lab.exception.ServiceException;
import com.bsuir.web7lab.model.Person;
import com.bsuir.web7lab.service.PersonService;
import com.bsuir.web7lab.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import static com.bsuir.web7lab.command.grouppersons.constants.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}