package org.example.view.modals;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.MainApplication;
import org.example.managers.ProjectsListManager;
import org.example.model.ProjectsList;
import org.example.model.project.Project;
import org.example.view.ProjectsTable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

/**
 * A modal window for deleting a project
 *
 * @author Dimitar Nizamov, Marius Marcoci, Alexander Cichon, Szymon Hajduk
 * @version 1.0
 */
public class DeleteProjectModal extends Stage {
    private Project project;
    private ProjectsListManager projectsListManager;
    private ProjectsTable table;

    /**
     * Constructor for the DeleteProjectModal
     * sets the table and project attribute
     * creates a new instance of projectsListManager
     * calls the method which creates the modal
     * @param project the project to be deleted
     * @param table where the project will be removed from
     */
    public DeleteProjectModal(Project project, ProjectsTable table) {
        super();
        this.project = project;
        this.projectsListManager = new ProjectsListManager();
        this.table = table;
        initDeleteProjectModal();
    }

    /**
     * method that creates the modal with all the necessary labels, text fields, buttons
     * deletes the project
     */
    public void initDeleteProjectModal() {
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Delete Confirmation");

        Label questionLabel = new Label("Are you sure you want to delete the project?");
        Label projectNameLabel = new Label("Project Name: " + project.getName());

        Separator separator = new Separator();

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(a -> {
            System.out.println("Deleting project: " + project.getName());
            try {
                projectsListManager.removeProject(project.getId(), true);
                System.out.println("Deleted project: " + project.getName());
                ProjectsTable.refreshProjectsAfterDeletion(table);
                close();
                modalStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.close();


        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> this.close());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(deleteButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        VBox modalLayout = new VBox(10);
        modalLayout.getChildren().addAll(questionLabel, projectNameLabel, separator, buttonBox);
        modalLayout.setAlignment(Pos.CENTER);
        modalLayout.setStyle("-fx-padding: 20; -fx-spacing: 10;");

        Scene modalScene = new Scene(modalLayout, 300, 150);

        this.setScene(modalScene);
        this.showAndWait();
    }
}
