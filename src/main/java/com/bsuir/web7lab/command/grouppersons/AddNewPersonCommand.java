package com.bsuir.web7lab.command.grouppersons;

import static com.bsuir.web7lab.command.authorithation.constants.AuthConstants.ERROR_MESSAGE;
import static com.bsuir.web7lab.command.authorithation.constants.AuthConstants.ERROR_MESSAGE_TEXT;
import static com.bsuir.web7lab.command.grouppersons.constants.GroupConstant.LISTGROUP;
import static com.bsuir.web7lab.command.grouppersons.constants.GroupConstant.NEWEMAIL;
import static com.bsuir.web7lab.command.grouppersons.constants.GroupConstant.NEWNAME;
import static com.bsuir.web7lab.command.grouppersons.constants.GroupConstant.NEWPHONE;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import com.bsuir.web7lab.command.Command;
import com.bsuir.web7lab.command.CommandResult;
import com.bsuir.web7lab.exception.IncorrectDataException;
import com.bsuir.web7lab.exception.ServiceException;
import com.bsuir.web7lab.model.Person;
import com.bsuir.web7lab.service.PersonService;
import com.bsuir.web7lab.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class AddNewPersonCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddNewPersonCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        Optional<String> newName = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWNAME));
        Optional<String> newPhone = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWPHONE));
        Optional<String> newEmail = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWEMAIL));
        if (isEmpty(newName.get()) || isEmpty(newPhone.get()) || isEmpty(newEmail.get())) {
            logger.info("missing parameter for new person in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {
            Person newperson = new Person(newName.get(), newPhone.get(), newEmail.get());
            personService.save(newperson);
        }
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}