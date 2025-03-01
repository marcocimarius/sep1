package org.example.main;

import org.example.managers.ProjectsListManager;
import org.example.model.Customer;
import org.example.model.ProjectsList;
import org.example.model.Resources;
import org.example.model.project.IndustrialProject;
import org.example.model.project.Project;
import org.example.model.project.ResidentialProject;
import org.example.view.ProjectsTable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*Customer customer1 = new Customer("XYZ", "+66612345", "QWE@QWE.com", "XYZ - 7000 - XYZ");
        Resources resources1 = new Resources(2, 2, 2.1, 2.1);
        IndustrialProject industrialProject1 = new IndustrialProject(customer1, resources1, LocalDate.now().minusDays(3), java.time.LocalDate.now().minusDays(1),
                "Facility XYZ", "xD", 1200000, 1000, "chemical");
        System.out.println(industrialProject1);
        System.out.println(industrialProject1.prepareType(industrialProject1));

        ProjectsList projectsList = new ProjectsList();
        projectsList.addProject(industrialProject1);
//        List<CommercialProject> commercialProjects = projectsList.prepareCommercialProjects();
//        List<IndustrialProject> industrialProjects = projectsList.prepareIndustrialProjects();
        System.out.println("Line");

//        ProjectsListManager projectsListManager = new ProjectsListManager();
//        projectsListManager.sortAscendingByBudget();
//        ProjectsList projectsList1 = projectsListManager.getAllProjects();
//        for (int i = 0; i < projectsList1.getSize(); i++) {
//            System.out.println( projectsList1.getProject(i).getTimeline());
//        }

        ResidentialProject residentialProject = new ResidentialProject(new Customer("bob", "123", "asdas", "asdasd"), new Resources(1, 1, 2.0, 2.0), LocalDate.now(), LocalDate.now(), "name", "2 luni", 1.0, 1.0, 1, 1, 1, true);
        System.out.println(residentialProject);*/

        testUpdateMethod();

    }

    //update method check - unit test build based on DMA answer checker
    public static void testUpdateMethod() {
        String tagToAdd = "Testers";
        ProjectsListManager projectsListManager = new ProjectsListManager();
        ProjectsList allProjectsBefore = projectsListManager.getAllProjects();
        String output = "";
        String correctAnswer = "";
        if (allProjectsBefore.getSize() > 0) {
            Project projectBefore = getFirstProjectAfterSorting(allProjectsBefore);
            String editedProjectName = projectBefore.getName() + " " + tagToAdd;
            correctAnswer = editedProjectName;
            projectBefore.setName(editedProjectName);
            try {
                projectsListManager.updateProject(projectBefore, projectBefore.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ProjectsListManager afterProjectsListManager = new ProjectsListManager();
            ProjectsList allProjectsAfter = afterProjectsListManager.getAllProjects();
            if (allProjectsAfter.getSize() > 0) {
                Project projectAfter = getFirstProjectAfterSorting(allProjectsAfter);
                output = projectAfter.getName();
            } else {
                throw new IllegalArgumentException("Project list is empty after using update method");
            }

            if (!output.equals(correctAnswer)) {
                outputFail("test1",
                        "Expected output " + correctAnswer +
                                " but got " + output);
            } else {
                outputPass("test1");
            }
        } else {
            throw new IllegalArgumentException("Project list is empty");
        }
    }

    //this method is only for test and should not be considered as part of the project
    private static Project getFirstProjectAfterSorting(ProjectsList temp) {
        List<Project> list = new ArrayList<>();
        for (Project project : temp.getProjects()) {
            list.add(project);
        }
        list.sort(Comparator.comparing(Project::getBudget));
        return list.get(0); //sorting to make sure order is the same
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

}