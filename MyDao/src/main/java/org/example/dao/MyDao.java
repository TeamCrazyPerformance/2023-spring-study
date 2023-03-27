package org.example.dao;

import org.example.controller.dto.PersonCreateDto;
import org.example.controller.dto.PersonUpdateDto;
import org.example.domain.Person;

public interface MyDao {
    Person save(PersonCreateDto dto);
    Person find(String name);
    Person update(String name, PersonUpdateDto dto);
    void delete(String name);
}
