package com.group4.www.commands;

import com.group4.www.commands.contracts.Command;
import com.group4.www.core.contacts.Repository;
import com.group4.www.models.contracts.Member;
import com.group4.www.models.utils.ParsingHelpers;
import com.group4.www.models.utils.ValidationHelpers;

import java.util.List;

public class AssignTaskToMember implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private final Repository repository;
    private int id;

    public AssignTaskToMember(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);
        repository.findTaskByID(id);
       return repository.assignTaskToMember(id,parameters.get(1));
    }

    private void parseParameters(List<String> parameters){
        id = ParsingHelpers.tryParseInteger(parameters.get(0),"id for task");

    }
}
