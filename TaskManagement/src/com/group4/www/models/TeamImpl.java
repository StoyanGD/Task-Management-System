package com.group4.www.models;

import com.group4.www.models.contracts.Board;
import com.group4.www.models.contracts.EventLog;
import com.group4.www.models.contracts.Member;
import com.group4.www.models.contracts.Team;
import com.group4.www.models.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Team {
    public static final int TEAM_NAME_MIN_LENGTH = 5;
    public static final int TEAM_NAME_MAX_LENGTH = 15;
    public static final String TEAM_NAME_LENGTH_ERROR =
            String.format("Team name must be between %d and %d symbols.", TEAM_NAME_MIN_LENGTH, TEAM_NAME_MAX_LENGTH);
    public static final String MEMBER_ALREADY_IN_TEAM_MSG = "Member %s, is already part of team %s.";
    public static final String BOARD_ALREADY_ASSIGNED_MSG = "Board %s is already assigned to team %s.";
    public static final String MEMBER_NOT_PART_OF_TEAM_ERROR = "Member %s is not a part of this team.";
    public static final String BOARD_NOT_ASSIGNED_IN_TEAM_ERROR = "There is no such board assigned to this team.";
    public static final String ADDED_BOARD_TO_TEAM_MESS = "Board with name %s, was added to team %s";
    public static final String BOARD_REMOVED_FROM_TEAM_MESS = "Board %s, was removed from team %s";
    public static final String MEMBER_REMOVED_FROM_TEAM_MESS = "Member %s was removed from team %s";
    public static final String MEMBER_ADDED_TO_TEAM_MESS = "Member %s was added to team %s.";

    private String name;
    private final List<Member> members;
    private final List<Board> boards;
    private final List<EventLog> teamActivity;


    public TeamImpl(String name) {
        setName(name);
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.teamActivity = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                TEAM_NAME_MIN_LENGTH,
                TEAM_NAME_MAX_LENGTH,
                TEAM_NAME_LENGTH_ERROR);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public void addMember(Member member){
        if(members.contains(member)){
            throw new IllegalArgumentException
                    (String.format(MEMBER_ALREADY_IN_TEAM_MSG, member, this.name));
        }
        members.add(member);
        addActivityHistory(String.format(MEMBER_ADDED_TO_TEAM_MESS,member.getName(),getName()));
    }

    @Override
    public void removeMember(Member member){
        if(!members.contains(member)){
            throw new IllegalArgumentException
                    (String.format(MEMBER_NOT_PART_OF_TEAM_ERROR, member));
        }
        members.remove(member);
        addActivityHistory(String.format(MEMBER_REMOVED_FROM_TEAM_MESS,member.getName(),getName()));
    }

    @Override
    public void addBoard(Board board){
        if(boards.contains(board)){
            throw new IllegalArgumentException
                    (String.format(BOARD_ALREADY_ASSIGNED_MSG,board,this.name));
        }
        boards.add(board);
        addActivityHistory(String.format(ADDED_BOARD_TO_TEAM_MESS,board.getName(),getName()));
    }

    @Override
    public void removeBoard(Board board){
        if(!boards.contains(board)){
            throw  new IllegalArgumentException(BOARD_NOT_ASSIGNED_IN_TEAM_ERROR);
        }
        boards.remove(board);
        addActivityHistory(String.format(BOARD_REMOVED_FROM_TEAM_MESS,board.getName(),getName()));
    }

    @Override
    public void addActivityHistory(String massage){
        EventLog eventLog = new EventLogImpl(massage);
        teamActivity.add(eventLog);
    }

    @Override
    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public List<EventLog> getTeamActivity() {
        return new ArrayList<>(teamActivity);
    }

    @Override
    public String getAsString() {
        return getName();
    }
}
