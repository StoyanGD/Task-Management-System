package com.group4.www.commands.creations;

import com.group4.www.commands.Command;
import com.group4.www.core.contacts.Repository;
import com.group4.www.models.contracts.Comment;
import com.group4.www.models.utils.ValidationHelpers;

import java.util.List;

public class AddCommentToTask implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private final Repository repository;

    private String author;
    private String message;
    private int taskId;

    public AddCommentToTask(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);

        author = parameters.get(0);
        message = parameters.get(1);
        taskId = Integer.parseInt(parameters.get(2));
        Comment comment = repository.createComment(author,message);

        return repository.addCommentToTask(comment,taskId);
    }
}
