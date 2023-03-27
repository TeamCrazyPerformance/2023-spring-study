package org.example.controller.dto;

import org.example.domain.Person;

public class UpdateResultDto {

    private Person prevPerson;
    private Person updatePerson;

    public UpdateResultDto(Person prevPerson, Person updatePerson) {
        this.prevPerson = prevPerson;
        this.updatePerson = updatePerson;
    }

    public Person getPrevPerson() {
        return prevPerson;
    }

    public Person getUpdatePerson() {
        return updatePerson;
    }
}
