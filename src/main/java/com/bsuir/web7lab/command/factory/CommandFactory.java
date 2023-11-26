package com.bsuir.web7lab.command.factory;

import com.bsuir.web7lab.command.Command;
import com.bsuir.web7lab.command.LoginPageCommand;
import com.bsuir.web7lab.command.RegisterPageCommand;
import com.bsuir.web7lab.command.authorithation.LoginCommand;
import com.bsuir.web7lab.command.authorithation.RegisterNewUserCommand;
import com.bsuir.web7lab.command.authorithation.SignOutCommand;
import com.bsuir.web7lab.command.grouppersons.AddNewPersonCommand;
import com.bsuir.web7lab.command.grouppersons.WelcomeCommand;

//Создает команды
public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
            case LOGIN: {
                resultCommand = new LoginCommand();
                break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand();
                break;
            }
            case SIGN_OUT: {
                resultCommand = new SignOutCommand();
                break;
            }
            case ADD_NEW_PERSON: {
                resultCommand = new AddNewPersonCommand();
                break;
            }
            case LOGIN_PAGE: {
                resultCommand = new LoginPageCommand();
                break;
            }
            case WELCOME: {
                resultCommand = new WelcomeCommand();
                break;
            }
            case REGISTRATION_PAGE: {
                resultCommand = new RegisterPageCommand();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid command" + commandEnum);
            }
        }
        return resultCommand;
    }
}