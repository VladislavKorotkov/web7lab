package com.bsuir.web7lab.service;

import com.bsuir.web7lab.exception.RepositoryException;
import com.bsuir.web7lab.exception.ServiceException;
import com.bsuir.web7lab.model.Person;
import com.bsuir.web7lab.repository.PersonRepository;
import com.bsuir.web7lab.repository.RepositoryCreator;

import java.util.List;


public class PersonService {
    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
