package com.group4.www.commands.listings;

import com.group4.www.commands.contracts.Command;
import com.group4.www.models.tasks.contracts.Bug;
import com.group4.www.models.utils.FormattingHelpers;
import com.group4.www.models.utils.ListingHelper;
import com.group4.www.core.contacts.Repository;
import com.group4.www.models.enums.StatusBug;
import com.group4.www.models.utils.ParsingHelpers;
import com.group4.www.models.utils.ValidationHelpers;

import java.util.List;

public class FilterBugsByStatus implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String PARSING_BUG_STATUS_ERR = "Status of bug should be Active or Fixed!";
    public static final String BUGS_HEADER = "BUGS";
    private final Repository repository;
    private StatusBug status;
    public FilterBugsByStatus(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);

        List<Bug> bugs = ListingHelper.filterByCondition
                (repository.getBugs(),bug -> bug.getStatus().equals(status.toString()));
        return FormattingHelpers.listingFormatted(bugs,BUGS_HEADER);
    }
    private void parseParameters(List<String> parameters){
        status = ParsingHelpers.tryParseEnum(parameters.get(0), StatusBug.class, PARSING_BUG_STATUS_ERR);
    }
}
