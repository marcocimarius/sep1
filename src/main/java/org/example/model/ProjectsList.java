package org.example.model;

import org.example.managers.ProjectsListManager;
import org.example.model.project.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import static org.example.model.project.Project.*;

/**
 * This class is responsible for storing a list of projects.
 * @author Darja Jefremova, Marius Marcoci, Szymon Hajduk
 */
public class ProjectsList {

    private ArrayList<Project> projects;

    /**
     * Constructs a new instance of the projects ArrayList
     */
    public ProjectsList() {
        this.projects = new ArrayList<>();
    }

    /**
     * Getter for projects
     * @return projects
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }

    /**
     * Adds a project to the list
     * @param project the project to be added
     */
    public void addProject(Project project) {
        this.projects.add(project);
    }

    /**
     * Gets a project from the list based on its index
     * @param index the index of the project
     * @return the project
     */
    public Project getProject(int index) {
        return this.projects.get(index);
    }

    /**
     * gets a project based on its name
     * @param name the name of the project
     * @return the project
     */
    public Project getProjectByName(String name) {
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }

    /**
     * gets the project based on its id
     * @param id the id of the project
     * @return the project
     */
    public Project getProjectById(UUID id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        return null;
    }

    /**
     * Returns a list of projects which contain a specific value in their name
     * @param value the value to be searched for
     * @return the list of projects
     */
    public ProjectsList getProjectsWhereNameContainsSpecifiedValue(String value) {
        ProjectsList temp = new ProjectsList();
        for (int i = 0; i < this.projects.size(); i++) {
            String tempLowerCase = this.projects.get(i).getName().toLowerCase();
            String valueLowerCase = value.toLowerCase();
            if (tempLowerCase.contains(valueLowerCase)) {
                temp.addProject(this.projects.get(i));
            }
        }
        return temp;
    }

    /**
     * Returns a list of projects which have the same name
     * @param name the name of the projects
     * @return the projects
     */
    public ProjectsList getProjectsByName(String name) {
        ProjectsList temp = new ProjectsList();
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                temp.addProject(project);
            }
        }
        return temp;
    }

    /**
     * Returns all the finished projects
     * @return the projects
     */
    public ArrayList<Project> getAllFinishedProjects() {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList temp = all.getAllFinishedProjects();

        return temp.getProjects();
    }

    /**
     * Returns all the unfinished projects
     * @return the projects
     */
    public ArrayList<Project> getAllUnfinishedProjects() {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList temp = all.getAllUnfinishedProjects();

        return temp.getProjects();
    }

    /**
     * Returns all the finished projects filtered by a project type
     * @return the projects
     */
    public ArrayList<Project> getFinishedProjects(String type) {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList temp = all.getFinishedProjects(type);

        return temp.getProjects();
    }

    /**
     * Returns all the unfinished projects filtered by a project type
     * @return the projects
     */
    public ArrayList<Project> getUnfinishedProjects(String type) {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList temp = all.getUnfinishedProjects(type);

        return temp.getProjects();
    }

    /**
     * Removes a project from the list based on its index
     * @param index the index of the project
     * @return the removed project
     */
    public Project removeProject(int index) {
        return this.projects.remove(index);
    }

    /**
     * Removes a project from the list
     * @param project the project to be removed
     * @return the removed project
     */
    public Project removeProject(Project project) {
        int indexOfProject = projects.indexOf(project);
        return removeProject(indexOfProject);
    }

    /**
     * Returns the size of the ArrayList
     * @return the size of the ArrayList
     */
    public int getSize() {
        return this.projects.size();
    }

    /**
     * Returns the commercial projects
     * @return the commercial projects
     */
    public ArrayList<Project> prepareCommercialProjects() {
        ArrayList<Project> commercialProjects = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (isCommercial(project)) {
                commercialProjects.add(project);
            }
        }
        return commercialProjects;
    }

    /**
     * Returns the residential projects
     * @return the residential projects
     */
    public ArrayList<Project> prepareResidentialProjects() {
        ArrayList<Project> residentialProjects = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (isResidential(project)) {
                residentialProjects.add(project);
            }
        }
        return residentialProjects;
    }

    /**
     * Returns the road construction projects
     * @return the road construction projects
     */
    public ArrayList<Project> prepareRoadConstructionProjects() {
        ArrayList<Project> roadConstructionProjects = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (isRoadConstruction(project)) {
                roadConstructionProjects.add(project);
            }
        }
        return roadConstructionProjects;
    }

    /**
     * Returns the industrial projects
     * @return the industrial projects
     */
    public ArrayList<Project> prepareIndustrialProjects() {
        ArrayList<Project> industrialProjects = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (isIndustrial(project)) {
                industrialProjects.add(project);
            }
        }
        return industrialProjects;
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return "ProjectsList{" +
                "projects=" + projects +
                '}';
    }
}
