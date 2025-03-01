package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.managers.ProjectsListManager;
import org.example.model.project.Project;
import org.example.view.OptionsMenu;
import org.example.view.ProjectsTable;
import org.example.view.TableDateFilterState;
import org.example.view.TableFilterState;
import org.example.view.modals.CreateProjectModal;
import org.example.view.modals.DeleteProjectModal;
import org.example.view.modals.EditProjectModal;
import org.example.view.modals.ProjectDetailsModal;

import java.util.ArrayList;

/**
 * A user interface that allows adding, displaying, modifying, deleting, searching, filtering, sorting of projects.
 * @version 1.0
 * @author Dimitar Nizamov, Marius Marcoci, Darja Jefremova, Szymon Hajduk, Aleksander Cichon
 */
public class MainApplication extends Application {

    ProjectsListManager projectsListManager = new ProjectsListManager();
    ArrayList<Project> projects = projectsListManager.getAllProjects().getProjects();
    ProjectsTable projectsTable = new ProjectsTable(projects);

    /**
     * Start method that initializes the GUI components
     * @param window The Stage object that will be displayed
     */
    public void start(Stage window) {
        window.setTitle("BobCoPro");

        ProjectsListManager projectsListManager = new ProjectsListManager();
        ArrayList<Project> projects = projectsListManager.getAllProjects().getProjects();
        ProjectsTable projectsTable = new ProjectsTable(projects);

        //menu
        OptionsMenu menuBar = new OptionsMenu();

        menuBar.getAddNewMenuItem().setOnAction(event -> {
            new CreateProjectModal(projectsTable);
        });

        menuBar.getExitMenuItem().setOnAction(event -> {
            window.close();
        });

        menuBar.getRefreshMenuItem().setOnAction(event -> {
            projectsTable.setFilterState(TableFilterState.REFRESH);
        });

        BorderPane mainBorderPane = new BorderPane();
        mainBorderPane.setTop(menuBar);

        //radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleGroup dateToggleGroup = new ToggleGroup();

        //search bar
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search:");
        searchBar.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-padding: 5px; -fx-border-color: black;");
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            toggleGroup.selectToggle(null);
            dateToggleGroup.selectToggle(null);
            projectsTable.setDateFilterState(TableDateFilterState.ALL);
            projectsTable.setFilterState(TableFilterState.ALL);

            if (!newValue.isEmpty()) {
                projectsTable.setSearchText(newValue);
                projectsTable.setFilterState(TableFilterState.SEARCH);

            } else {
                projectsTable.setSearchText("");
                projectsTable.setFilterState(TableFilterState.ALL);
            }
        });

        RadioButton industrial = new RadioButton("Industrial");
        industrial.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        industrial.setToggleGroup(toggleGroup);
        projectsTable.setToggleGroup(toggleGroup);
        HBox.setMargin(industrial, new Insets(10, 0, 10, 5));
        industrial.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (industrial.isSelected()) {
                toggleGroup.selectToggle(null);
                projectsTable.setFilterState(TableFilterState.ALL);
            } else {
                toggleGroup.selectToggle(industrial);
                projectsTable.setFilterState(TableFilterState.INDUSTRIAL);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        RadioButton commercial = new RadioButton("Commercial");
        commercial.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        commercial.setToggleGroup(toggleGroup);
        projectsTable.setToggleGroup(toggleGroup);
        HBox.setMargin(commercial, new Insets(10, 0, 10, 5));
        commercial.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (commercial.isSelected()) {
                toggleGroup.selectToggle(null);
                projectsTable.setFilterState(TableFilterState.ALL);
            } else {
                toggleGroup.selectToggle(commercial);
                projectsTable.setFilterState(TableFilterState.COMMERCIAL);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        RadioButton residential = new RadioButton("Residential");
        residential.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        residential.setToggleGroup(toggleGroup);
        projectsTable.setToggleGroup(toggleGroup);
        HBox.setMargin(residential, new Insets(10, 0, 10, 5));
        residential.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (residential.isSelected()) {
                toggleGroup.selectToggle(null);
                projectsTable.setFilterState(TableFilterState.ALL);
            } else {
                toggleGroup.selectToggle(residential);
                projectsTable.setFilterState(TableFilterState.RESIDENTIAL);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        RadioButton road = new RadioButton("Road");
        road.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        road.setToggleGroup(toggleGroup);
        projectsTable.setToggleGroup(toggleGroup);
        HBox.setMargin(road, new Insets(10, 80, 10, 5));
        road.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (road.isSelected()) {
                toggleGroup.selectToggle(null);
                projectsTable.setFilterState(TableFilterState.ALL);
            } else {
                toggleGroup.selectToggle(road);
                projectsTable.setFilterState(TableFilterState.ROAD);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        RadioButton unfinished = new RadioButton("Unfinished");
        unfinished.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        unfinished.setToggleGroup(dateToggleGroup);
        projectsTable.setDateToggleGroup(dateToggleGroup);
        HBox.setMargin(unfinished, new Insets(10, 0, 10, 5));
        unfinished.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (unfinished.isSelected()) {
                dateToggleGroup.selectToggle(null);
                projectsTable.setDateFilterState(TableDateFilterState.ALL);
            } else {
                dateToggleGroup.selectToggle(unfinished);
                projectsTable.setDateFilterState(TableDateFilterState.UNFINISHED);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        RadioButton finished = new RadioButton("Finished");
        finished.setStyle("-fx-padding: 5px 10px; -fx-border-color: black; -fx-border-radius: 5px;");
        finished.setToggleGroup(dateToggleGroup);
        projectsTable.setDateToggleGroup(dateToggleGroup);
        HBox.setMargin(finished, new Insets(10, 0, 10, 5));
        finished.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (finished.isSelected()) {
                dateToggleGroup.selectToggle(null);
                projectsTable.setDateFilterState(TableDateFilterState.ALL);
            } else {
                dateToggleGroup.selectToggle(finished);
                projectsTable.setDateFilterState(TableDateFilterState.FINISHED);
            }
            projectsTable.setDetailsButtonDisable(true);
            projectsTable.setEditButtonDisable(true);
            projectsTable.setDeleteButtonDisable(true);
            e.consume();
        });

        HBox filtersHorizontally = new HBox(5);
        filtersHorizontally.getChildren().addAll( industrial, commercial, residential, road);
        filtersHorizontally.setAlignment(Pos.CENTER_RIGHT);

        HBox dateFilters = new HBox(5);
        dateFilters.getChildren().addAll(unfinished, finished);

        HBox searchBox = new HBox(5);
        searchBox.getChildren().addAll(searchBar);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(searchBar, new Insets(10, 0, 10, 40));

        HBox secondRow = new HBox();
        secondRow.getChildren().addAll(searchBox, dateFilters, filtersHorizontally);

        HBox.setHgrow(searchBox, Priority.ALWAYS);
        HBox.setHgrow(filtersHorizontally, Priority.ALWAYS);

        BorderPane filtersGrid = new BorderPane();
        filtersGrid.setTop(secondRow);

        mainBorderPane.setCenter(filtersGrid);

        BorderPane tableGrid = new BorderPane();
        filtersGrid.setCenter(tableGrid);

        //tableview
        tableGrid.setCenter(projectsTable);

        Region leftMargin = new Region();
        BorderPane.setMargin(leftMargin, new Insets(20)); // Set left margin
        tableGrid.setLeft(leftMargin);

        //action buttons
        VBox actionBox = new VBox();
        VBox actionButtonsBox = new VBox();

        Button editButton = projectsTable.getEditButton();
        editButton.setOnAction(e -> new EditProjectModal(projectsTable.getSelectedProject(), projectsTable));

        Button deleteButton = projectsTable.getDeleteButton();
        deleteButton.setOnAction(e -> new DeleteProjectModal(projectsTable.getSelectedProject(), projectsTable));

        Button detailsButton = projectsTable.getDetailsButton();
        detailsButton.setOnAction(e -> new ProjectDetailsModal(projectsTable.getSelectedProject()));

        VBox.setMargin(editButton, new Insets(0, 10, 5, 10));
        VBox.setMargin(deleteButton, new Insets(0, 10, 5, 10));
        VBox.setMargin(detailsButton, new Insets(0, 10, 0, 10));

        actionButtonsBox.getChildren().addAll(editButton, deleteButton, detailsButton);
        actionButtonsBox.setAlignment(Pos.CENTER);

        actionBox.getChildren().addAll(actionButtonsBox);

        tableGrid.setRight(actionBox);

        //add new project button
        HBox addNewBox = new HBox(5);

        Button addNewButton = new Button("Add New Project");
        addNewButton.setStyle("-fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-border-color: black;");
        HBox.setMargin(addNewButton, new Insets(10, 75, 10, 0));

        addNewButton.setOnAction(e -> new CreateProjectModal(projectsTable));

        addNewBox.getChildren().addAll(addNewButton);
        addNewBox.setAlignment(Pos.CENTER_RIGHT);

        tableGrid.setBottom(addNewBox);

        Scene scene = new Scene(mainBorderPane, 1024, 720);
        scene.getRoot().requestFocus(); //removes the focus of the searchbar on app start
        window.setScene(scene);
        window.setResizable(false);

        window.show();
    }


}
