package org.example.managers;

import org.example.model.ProjectsList;
import org.example.model.project.Project;
import org.example.utils.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is responsible for storing and managing a list of projects from the XML File.
 * @author Darja Jefremova, Marius Marcoci
 */
public class ProjectsListManager {
    private ProjectsList projectsList;

    /**
     * Constructs a new instance of the projectsList with the information from the XML File
     */
    public ProjectsListManager() {
        this.projectsList = XMLParser.getXMLArrayList();
    }

    /**
     * Returns all the projects
     * @return all the projects
     */
    public ProjectsList getAllProjects() {
        return this.projectsList;
    }

    /**
     * Returns all the industrial projects
     * @return all the industrial projects
     */
    public ArrayList<Project> getAllIndustrialProjects() {
        return this.projectsList.prepareIndustrialProjects();
    }

    /**
     * Returns all the commercial projects
     * @return all the commercial projects
     */
    public ArrayList<Project> getAllCommercialProjects() {
        return this.projectsList.prepareCommercialProjects();
    }

    /**
     * Returns all the road construction projects
     * @return all the road construction projects
     */
    public ArrayList<Project> getAllRoadConstructionProjects() {
        return this.projectsList.prepareRoadConstructionProjects();
    }

    /**
     * Returns all the residential projects
     * @return all the residential projects
     */
    public ArrayList<Project> getAllResidentialProjects() {
        return this.projectsList.prepareResidentialProjects();
    }

    /**
     * Returns multiple projects with the same name
     * @param name the name of the projects
     * @return the projects
     */
    public ProjectsList getProjectsByName(String name) {
        ProjectsList projectsListWithGivenName = this.projectsList.getProjectsByName(name);
        return projectsListWithGivenName;
    }

    /**
     * Returns a project based on its name
     * @param name the name of the project
     * @return the project
     */
    public Project getProjectByName(String name) {
        Project project = this.projectsList.getProjectByName(name);
        return project;
    }

    /**
     * Adds a project to the list and then to the XML File
     * @param project the project to be added
     * @throws ParserConfigurationException in case parser configuration exception occurs
     * @throws TransformerException in case transformer exception occurs
     */
    public void addProject(Project project) throws ParserConfigurationException, TransformerException {
        this.projectsList.addProject(project);
        XMLParser.writeProjectsToXML(this.projectsList);
    }

    /**
     * Updates a project from the list and then from the XML File
     * @param project the new project to be added
     * @param id the id of the project to be removed
     * @throws ParserConfigurationException in case parser configuration exception occurs
     * @throws TransformerException in case transformer exception occurs
     */
    public void updateProject(Project project, UUID id) throws ParserConfigurationException, TransformerException {
        removeProject(id, false);
        addProject(project);
    }

    /**
     * Removes a project from the list and then from the XML File
     * @param id the id of the project to be removed
     * @param isFinal the confirmation of writing the project to the XML file
     * @throws ParserConfigurationException in case parser configuration exception occurs
     * @throws TransformerException in case transformer exception occurs
     */
    public void removeProject(UUID id, boolean isFinal) throws ParserConfigurationException, TransformerException {
        Project temp = this.getProjectById(id);
        this.projectsList.removeProject(temp);
        if (isFinal) XMLParser.writeProjectsToXML(this.projectsList);
    }

    /**
     * Gets a project by its id
     * @param id the id of the project
     * @return the project
     */
    public Project getProjectById(UUID id) {
        Project project = this.projectsList.getProjectById(id);
        return project;
    }

    /**
     * Gets all the finished projects
     * @return all the finished projects
     */
    public ProjectsList getAllFinishedProjects() {
        ProjectsList temp = new ProjectsList();

        for (int i = 0; i < this.projectsList.getSize(); i++) {
            if (this.projectsList.getProject(i).getEndDate() != null) {
                temp.addProject(this.projectsList.getProject(i));
            }
        }

        return temp;
    }

    /**
     * Gets all the unfinished projects
     * @return all the unfinished projects
     */
    public ProjectsList getAllUnfinishedProjects() {
        ProjectsList temp = new ProjectsList();

        for (int i = 0; i < this.projectsList.getSize(); i++) {
            if (this.projectsList.getProject(i).getEndDate() == null) {
                temp.addProject(this.projectsList.getProject(i));
            }
        }

        return temp;
    }

    /**
     * Gets all the finished projects filtered by a type
     * @return all the finished projects
     */
    public ProjectsList getFinishedProjects(String type) {
        ProjectsList temp = new ProjectsList();

        if (type != null) {
            for (int i = 0; i < this.projectsList.getSize(); i++) {
                if (this.projectsList.getProject(i).getType().equals(type) && this.projectsList.getProject(i).getEndDate() != null) {
                    temp.addProject(this.projectsList.getProject(i));
                }
            }
        }

        return temp;
    }

    /**
     * Gets all the unfinished projects filtered by a type
     * @return all the unfinished projects
     */
    public ProjectsList getUnfinishedProjects(String type) {
        ProjectsList temp = new ProjectsList();

        if (type != null) {
            for (int i = 0; i < this.projectsList.getSize(); i++) {
                if (this.projectsList.getProject(i).getType().equals(type) && this.projectsList.getProject(i).getEndDate() == null) {
                    temp.addProject(this.projectsList.getProject(i));
                }
            }
        }

        return temp;
    }
}
