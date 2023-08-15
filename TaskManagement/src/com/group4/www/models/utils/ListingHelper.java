package com.group4.www.models.utils;

import com.group4.www.models.tasks.contracts.Bug;
import com.group4.www.models.tasks.contracts.Feedback;
import com.group4.www.models.tasks.contracts.Story;
import com.group4.www.models.tasks.contracts.Task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListingHelper {

    public static List<Task> mergeToTasks(List<Bug> bugs, List<Story> stories, List<Feedback> feedbacks) {
        List<Task> task = Stream.of(bugs, stories).flatMap(Collection::stream).collect(Collectors.toList());
        return Stream.of(task, feedbacks).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static List<Task> filterByTitle(List<Task> tasks, String title) {
        return tasks.stream().filter(task -> task.getTitle().equals(title)).collect(Collectors.toList());
    }

    public static <T extends Task> List<T> sortByTitle(List<T> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
    }

    public static List<Task> listOfTasksWithAssignee(List<Bug> bugs, List<Story> stories, List<Feedback> feedbacks) {
        List<Task> tasks = mergeToTasks(bugs, stories, feedbacks);
        List<Task> result = new ArrayList<>();
        int i = 0;
        try {
            for (; i < tasks.size(); i++) {
                if (tasks.get(i).getAssignee().getName() != null) {
                    result.add(tasks.get(i));
                }
            }
        } catch (NullPointerException ig) {}

        return result;
    }

    public static <T extends Task> List<T> filterByStatus(List<T> tasks, String status) {
        return tasks.stream().filter(e -> e.getStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
    }

    public static <T extends Task> List<T> filterByAssignee(List<T> tasks, String assignee) {
        List<T> result = listOfTasksWithAssignee(tasks);
        List<T> displayedResult = result.stream().filter(task -> task.getAssignee().getName().equals(assignee)).collect(Collectors.toList());
        return displayedResult;
    }

    public static <T extends Task> List<T> filterByStatusAndAssignee(List<T> tasks, String status, String assignee) {
        List<T> result = listOfTasksWithAssignee(tasks);
        List<T> displayedResult = result.stream().filter(t -> t.getStatus().equalsIgnoreCase(status) && t.getAssignee().getName().equals(assignee)).collect(Collectors.toList());
        return displayedResult;
    }

    public static <T extends Task> List<T> listOfTasksWithAssignee(List<T> tasks) {
        List<T> result = new ArrayList<>();
        int i = 0;
        try {
            for (; i < tasks.size(); i++) {
                if (tasks.get(i).getAssignee().getName() != null) {
                    result.add(tasks.get(i));
                }
            }
        } catch (NullPointerException ig) {}
        return result;
    }

    public static List<Bug> sortBugsByPriority(List<Bug> bugs){
        return bugs.stream().sorted(Comparator.comparing(Bug::getPriority)).collect(Collectors.toList());
    }

    public static List<Bug> sortBugsBySeverity(List<Bug> bugs){
        return bugs.stream().sorted(Comparator.comparing(Bug::getSeverity)).collect(Collectors.toList());
    }
}