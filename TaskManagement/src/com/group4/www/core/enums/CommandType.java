package com.group4.www.core.enums;

import com.group4.www.commands.listings.FilterFeedbacksByStatus;

public enum CommandType {

    CREATEPERSON,
    CREATETEAM,
    CREATEBUGINBOARD,
    CREATESTORYINBOARD,
    CREATEFEEDBACKINBOARD,
    CREATEBOARD,
    CREATEBOARDINTEAM,
    SHOWALLMEMBERS,
    SHOWPERSONACTIVITY,
    SHOWALLTEAMS,
    SHOWTEAMACTIVITY,
    ADDMEMBERTOTEAM,
    SHOWALLTEAMMEMBERS,
    SHOWALLTEAMBOARDS,
    SHOWBOARDACTIVITY,
    CHANGEFEEDBACKRATING,
    ASSIGNTASKTOMEMBER,
    UNASSIGNTASKTOMEMBER,
    ADDCOMMENTTOTASK,
    CHANGEBUGSTATUS,
    CHANGEBUGPRIORITY,
    CHANGEBUGSEVERITY,
    CHANGESTORYSTATUS,
    CHANGESTORYPRIORITY,
    CHANGESTORYSIZE,
    CHANGEFEEDBACKSTATUS,
    FILTERTASKSBYTITLE,
    SORTTASKSBYTITLE,
    FILTERTASKSBYSTATUS,
    FILTERTASKSBYASSIGNEE,
    FILTERTASKSBYSTATUSANDASSIGNEE,
    SORTASSIGNEDTASKSBYTITLE,
    FILTERBUGSBYSTATUS,
    FILTERBUGSBYASSIGNEE,
    FILTERBUGSBYSTATUSANDASSIGNEE,
    SORTBUGSBYTITLE,
    SORTBUGSBYPRIORITY,
    SORTBUGSBYSEVERITY,
    SHOWTASKACTIVITY,
    FILTERSTORIESBYSTATUS,
    FILTERSTORIESBYASSIGNEE,
    FILTERSTORIESBYSTATUSANDASSIGNEE,
    SORTSTORIESBYTITLE,
    SORTSTORIESBYPRIORITY,
    SORTSTORIESBYSIZE,
    FILTERFEEDBACKBYSTATUS,
    SORTFEEDBACKBYRATING,
    SORTFEEDBACKBYTITLE,

    CHANGESTATUS;

}
