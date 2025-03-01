package org.example.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.managers.ProjectsListManager;
import org.example.model.ProjectsList;
import org.example.model.project.*;

import java.util.ArrayList;

/**
 * This class is responsible for displaying the projects in a table.
 * It handles filtering state, searching and selection of a project
 * @author Dimitar Nizamov, Marius Marcoci
 */
public class ProjectsTable extends TableView<Project> {
    private ArrayList<Project> projects;
    private TableFilterState filterState;
    private TableDateFilterState dateFilterState;
    private Project selectedProject;

    private TableColumn<Project, String> name = new TableColumn<Project, String>("Name");
    private TableColumn<Project, String> type = new TableColumn<Project, String>("Type");
    private TableColumn<Project, String> budget = new TableColumn<Project, String>("Budget");
    private TableColumn<Project, String> timeline = new TableColumn<Project, String>("Timeline");
    private TableColumn<Project, String> startDate = new TableColumn<>("Start Date");
    private TableColumn<Project, String> endDate = new TableColumn<>("End Date");
    private TableColumn<Project, String> customer = new TableColumn<>("Customer");
    private TableColumn<Project, String> customerName = new TableColumn<>("Name");
    private TableColumn<Project, String> customerPhone = new TableColumn<>("Phone Number");
    private TableColumn<Project, String> customerEmail = new TableColumn<>("Email");
    private TableColumn<Project, String> customerAddress = new TableColumn<>("Address");
    private TableColumn<Project, String> resources = new TableColumn<>("Resources");
    private TableColumn<Project, String> hoursUsed = new TableColumn<>("Hours Used");
    private TableColumn<Project, String> hoursNeeded = new TableColumn<>("Hours Needed");
    private TableColumn<Project, String> materialExpensesUsed = new TableColumn<>("Material Expenses Used");
    private TableColumn<Project, String> materialExpensesNeeded = new TableColumn<>("Material Expenses Needed");
    private TableColumn<Project, String> sizeResidential = new TableColumn<>("Size");
    private TableColumn<Project, String> numberOfKitchensResidential = new TableColumn<>("Number of Kitchens");
    private TableColumn<Project, String> numberOfBathroomsResidential = new TableColumn<>("Number of Bathrooms");
    private TableColumn<Project, String> numberOfOtherRoomsWithPlumbingResidential = new TableColumn<>("Other Rooms with Plumbing");
    private TableColumn<Project, String> isRenovatedResidential = new TableColumn<>("Renovated");
    private TableColumn<Project, String> sizeIndustrial = new TableColumn<>("Size");
    private TableColumn<Project, String> typeOfFacilityIndustrial = new TableColumn<>("Type of Facility");
    private TableColumn<Project, String> sizeCommercial = new TableColumn<>("Size");
    private TableColumn<Project, String> intendedUseCommercial = new TableColumn<>("Intended Use");
    private TableColumn<Project, String> numberOfFloorsCommercial = new TableColumn<>("Number of Floors");
    private TableColumn<Project, String> lengthRoad = new TableColumn<>("Length");
    private TableColumn<Project, String> widthRoad = new TableColumn<>("Width");
    private TableColumn<Project, String> numberOfBridgesRoad = new TableColumn<>("Bridges");
    private TableColumn<Project, String> numberOfTunnelsRoad = new TableColumn<>("Tunnels");
    private TableColumn<Project, String> envOrGeoChallengesRoad = new TableColumn<>("Environmental or Geographical Challenges");
    private Button editButton = new Button();
    private Button detailsButton = new Button();
    private Button deleteButton = new Button();
    private String searchText;
    private ToggleGroup toggleGroup;
    private ToggleGroup dateToggleGroup;

    /** Constructor for the table, initializes the table with the given projects
     * and sets default values and styles, sets the buttons to disabled
     * @param projects The projects to be displayed in the table
     */
    public ProjectsTable(ArrayList<Project> projects) {
        super();
        this.projects = projects;
        this.selectedProject = null;
        this.filterState = TableFilterState.ALL;
        this.dateFilterState = TableDateFilterState.ALL;
        this.editButton.setText("Edit");
        this.editButton.setStyle("-fx-padding: 5px 16px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-border-color: black;");
        this.setEditButtonDisable(true);
        this.detailsButton.setText("Details");
        this.detailsButton.setStyle("-fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-border-color: black;");
        this.setDetailsButtonDisable(true);
        this.deleteButton.setText("Delete");
        this.deleteButton.setStyle("-fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-border-color: black;");
        this.setDeleteButtonDisable(true);
        this.getItems().addAll(projects);
        this.setEditable(true);
        this.setAllColumns();
        this.setSelectionListener();
    }

    private void setSelectionListener() {
        this.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                this.selectedProject = newSelection;
                setEditButtonDisable(false);
                setDetailsButtonDisable(false);
                setDeleteButtonDisable(false);
            }
        });
    }

    /**
     * Getter for the edit button
     * @return The edit button
     */
    public Button getEditButton() {
        return this.editButton;
    }

    /**
     * Getter for the details button
     * @return The details button
     */
    public Button getDetailsButton() {
        return detailsButton;
    }

    /**
     * Getter for the delete button
     * @return The delete button
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * Setter for searchText
     * @param searchText sets the searchText attribute
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * Disables the edit button
     * @param value disables or enables the edit button
     */
    public void setEditButtonDisable(boolean value) {
        this.editButton.setDisable(value);
    }

    /**
     * Sets the details button to disabled or enabled
     * @param value The value to set the button to
     */
    public void setDetailsButtonDisable(boolean value) {
        this.detailsButton.setDisable(value);
    }

    /**
     * Sets the delete button to disabled or enabled
     * @param value The value to set the button to
     */
    public void setDeleteButtonDisable(boolean value) {
        this.deleteButton.setDisable(value);
    }

    /**
     * Sets the columns of the table to display all the information about the projects
     */
    private void setAllColumns() {
        name.setMinWidth(200);
        name.setCellValueFactory(
                new PropertyValueFactory<Project, String>("name"));

        type.setMinWidth(120);
        type.setCellValueFactory(
                new PropertyValueFactory<Project, String>("type"));

        budget.setMinWidth(100);
        budget.setCellValueFactory(cellValue -> {
            return new SimpleStringProperty(("$" + cellValue.getValue().getBudget()));
        });

        timeline.setMinWidth(80);
        timeline.setCellValueFactory(
                new PropertyValueFactory<Project, String>("timeline"));

        startDate.setMinWidth(100);
        startDate.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getStartDate().toString());
        });

        endDate.setMinWidth(100);
        endDate.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getEndDate() == null ? "Not Finished" : cellData.getValue().getEndDate().toString());
        });

        customerName.setMinWidth(100);
        customerName.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getCustomer().getName());
        });

        customerPhone.setMinWidth(100);
        customerPhone.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getCustomer().getPhoneNumber());
        });

        customerEmail.setMinWidth(100);
        customerEmail.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getCustomer().getEmail());
        });

        customerAddress.setMinWidth(200);
        customerAddress.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getCustomer().getAddress());
        });

        customer.setMinWidth(500);
        customer.getColumns().addAll(customerName, customerPhone, customerEmail, customerAddress);

        hoursUsed.setMinWidth(50);
        hoursUsed.setCellValueFactory(cellValue -> {
            return new SimpleStringProperty(Integer.toString(cellValue.getValue().getResources().getHoursUsed()));
        });

        hoursNeeded.setMinWidth(50);
        hoursNeeded.setCellValueFactory(cellValue -> {
            return new SimpleStringProperty(Integer.toString(cellValue.getValue().getResources().getHoursNeeded()));
        });

        materialExpensesUsed.setMinWidth(75);
        materialExpensesUsed.setCellValueFactory(cellValue -> {
            return new SimpleStringProperty(("$" + cellValue.getValue().getResources().getMaterialExpensedUsed()));
        });

        materialExpensesNeeded.setMinWidth(75);
        materialExpensesNeeded.setCellValueFactory(cellValue -> {
            return new SimpleStringProperty(("$" + cellValue.getValue().getResources().getMaterialExpensedNeeded()));
        });

        resources.setMinWidth(250);
        resources.getColumns().addAll(hoursUsed, hoursNeeded, materialExpensesUsed, materialExpensesNeeded);

        sizeResidential.setMinWidth(100);
        sizeResidential.setCellValueFactory(cellValue -> {
            ResidentialProject temp = (ResidentialProject) cellValue.getValue();
            return new SimpleStringProperty((temp.getSize() + " m^2"));
        });

        numberOfKitchensResidential.setMinWidth(100);
        numberOfKitchensResidential.setCellValueFactory(cellValue -> {
            ResidentialProject temp = (ResidentialProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfKitchen()));
        });

        numberOfBathroomsResidential.setMinWidth(100);
        numberOfBathroomsResidential.setCellValueFactory(cellValue -> {
            ResidentialProject temp = (ResidentialProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfBathrooms()));
        });

        numberOfOtherRoomsWithPlumbingResidential.setMinWidth(100);
        numberOfOtherRoomsWithPlumbingResidential.setCellValueFactory(cellValue -> {
            ResidentialProject temp = (ResidentialProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfRoomsWithPlumbing()));
        });

        isRenovatedResidential.setMinWidth(100);
        isRenovatedResidential.setCellValueFactory(cellValue -> {
            ResidentialProject temp = (ResidentialProject) cellValue.getValue();
            return new SimpleStringProperty(temp.isRenovated() ? "Yes" : "No");
        });

        sizeIndustrial.setMinWidth(100);
        sizeIndustrial.setCellValueFactory(cellValue -> {
            IndustrialProject temp = (IndustrialProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getSize() + " m^2");
        });

        typeOfFacilityIndustrial.setMinWidth(100);
        typeOfFacilityIndustrial.setCellValueFactory(cellValue -> {
            IndustrialProject temp = (IndustrialProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getTypeOfIndustrialFacility());
        });

        sizeCommercial.setMinWidth(100);
        sizeCommercial.setCellValueFactory(cellValue -> {
            CommercialProject temp = (CommercialProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getSize() + " m^2");
        });

        numberOfFloorsCommercial.setMinWidth(100);
        numberOfFloorsCommercial.setCellValueFactory(cellValue -> {
            CommercialProject temp = (CommercialProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfFloors()));
        });

        intendedUseCommercial.setMinWidth(100);
        intendedUseCommercial.setCellValueFactory(cellValue -> {
            CommercialProject temp = (CommercialProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getIntendedUseOfBuilding());
        });

        lengthRoad.setMinWidth(100);
        lengthRoad.setCellValueFactory(cellValue -> {
            RoadConstructionProject temp = (RoadConstructionProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getLength() + " m");
        });

        widthRoad.setMinWidth(100);
        widthRoad.setCellValueFactory(cellValue -> {
            RoadConstructionProject temp = (RoadConstructionProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getWidth() + " m");
        });

        numberOfBridgesRoad.setMinWidth(100);
        numberOfBridgesRoad.setCellValueFactory(cellValue -> {
            RoadConstructionProject temp = (RoadConstructionProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfBridge()));
        });

        numberOfTunnelsRoad.setMinWidth(100);
        numberOfTunnelsRoad.setCellValueFactory(cellValue -> {
            RoadConstructionProject temp = (RoadConstructionProject) cellValue.getValue();
            return new SimpleStringProperty(Integer.toString(temp.getNumberOfTunnels()));
        });

        envOrGeoChallengesRoad.setMinWidth(100);
        envOrGeoChallengesRoad.setCellValueFactory(cellValue -> {
            RoadConstructionProject temp = (RoadConstructionProject) cellValue.getValue();
            return new SimpleStringProperty(temp.getEnvOrGeoChallenges());
        });

        this.getColumns().add(name);
        this.getColumns().add(type);
        this.getColumns().add(budget);
        this.getColumns().add(timeline);
        this.getColumns().add(startDate);
        this.getColumns().add(endDate);
        this.getColumns().add(customer);
        this.getColumns().add(resources);
    }

    /**
     * Sets the columns of the table to display only the information about the residential projects
     */
    public void setResidentialColumns() {
        ProjectsListManager all = new ProjectsListManager();
        ArrayList<Project> temp = all.getAllResidentialProjects();

        removeCommercialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getColumns().add(sizeResidential);
        this.getColumns().add(numberOfKitchensResidential);
        this.getColumns().add(numberOfBathroomsResidential);
        this.getColumns().add(numberOfOtherRoomsWithPlumbingResidential);
        this.getColumns().add(isRenovatedResidential);

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the columns of the table to display only the information about the commercial projects
     */
    public void setCommercialColumns() {
        ProjectsListManager all = new ProjectsListManager();
        ArrayList<Project> temp = all.getAllCommercialProjects();

        removeResidentialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getColumns().add(sizeCommercial);
        this.getColumns().add(numberOfFloorsCommercial);
        this.getColumns().add(intendedUseCommercial);

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the columns of the table to display only the information about the industrial projects
     */
    public void setIndustrialColumns() {
        ProjectsListManager all = new ProjectsListManager();
        ArrayList<Project> temp = all.getAllIndustrialProjects();

        removeResidentialColumns();
        removeCommercialColumns();
        removeRoadColumns();

        this.getColumns().add(sizeIndustrial);
        this.getColumns().add(typeOfFacilityIndustrial);

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the columns of the table to display only the information about the road construction projects
     */
    public void setRoadColumns() {
        ProjectsListManager all = new ProjectsListManager();
        ArrayList<Project> temp = all.getAllRoadConstructionProjects();

        removeResidentialColumns();
        removeCommercialColumns();
        removeIndustrialColumns();

        this.getColumns().add(lengthRoad);
        this.getColumns().add(widthRoad);
        this.getColumns().add(numberOfBridgesRoad);
        this.getColumns().add(numberOfTunnelsRoad);
        this.getColumns().add(envOrGeoChallengesRoad);

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Getter for projects
     * @return
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }

    /**
     * Setter for the filter state
     * @param projects The filter state
     */
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    /**
     * Sets the table with the information of finished projects
     */
    public void setFinishedProjects() {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList finished = all.getAllFinishedProjects();
        ArrayList<Project> temp = finished.getAllFinishedProjects();

        removeResidentialColumns();
        removeCommercialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the table with the information of unfinished projects
     */
    public void setUnfinishedProjects() {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList finished = all.getAllUnfinishedProjects();
        ArrayList<Project> temp = finished.getAllUnfinishedProjects();

        removeResidentialColumns();
        removeCommercialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the columns of the table to display only the information about the road construction projects
     */
    public void setAllColumnsInfo() {
        removeResidentialColumns();
        removeCommercialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getItems().clear();
        this.getItems().addAll(this.projects);
    }

    /**
     * Removes from the table the columns related to Residential projects
     */
    public void removeResidentialColumns() {
        if (this.getColumns().contains(sizeResidential)) {
            this.getColumns().remove(sizeResidential);
            this.getColumns().remove(numberOfKitchensResidential);
            this.getColumns().remove(numberOfBathroomsResidential);
            this.getColumns().remove(numberOfOtherRoomsWithPlumbingResidential);
            this.getColumns().remove(isRenovatedResidential);
        }
    }

    /**
     * Removes from the table the columns related to Industrial projects
     */
    public void removeIndustrialColumns() {
        if (this.getColumns().contains(sizeIndustrial)) {
            this.getColumns().remove(sizeIndustrial);
            this.getColumns().remove(typeOfFacilityIndustrial);
        }
    }

    /**
     * Removes from the table the columns related to Commercial projects
     */
    public void removeCommercialColumns() {
        if (this.getColumns().contains(sizeCommercial)) {
            this.getColumns().remove(sizeCommercial);
            this.getColumns().remove(numberOfFloorsCommercial);
            this.getColumns().remove(intendedUseCommercial);
        }
    }

    /**
     * Removes from the table the columns related to Road Construction projects
     */
    public void removeRoadColumns() {
        if (this.getColumns().contains(lengthRoad)) {
            this.getColumns().remove(lengthRoad);
            this.getColumns().remove(widthRoad);
            this.getColumns().remove(numberOfBridgesRoad);
            this.getColumns().remove(numberOfTunnelsRoad);
            this.getColumns().remove(envOrGeoChallengesRoad);
        }
    }

    /**
     * Sets dynamically the table columns with the information of the searched project
     */
    public void setSearchColumns() {
        ProjectsListManager allProjectsManager = new ProjectsListManager();
        ProjectsList allProjects = allProjectsManager.getAllProjects();
        ProjectsList searchedProjects = new ProjectsList();
        ArrayList<Project> temp = new ArrayList<>();

        if (!this.searchText.isEmpty()) {
            searchedProjects = allProjects.getProjectsWhereNameContainsSpecifiedValue(this.searchText);
        } else {
            setDateFilterState(TableDateFilterState.ALL);
            setFilterState(TableFilterState.ALL);
        }

        for (int i = 0; i < searchedProjects.getSize(); i++) {
            temp.add(searchedProjects.getProject(i));
        }

        removeResidentialColumns();
        removeCommercialColumns();
        removeIndustrialColumns();
        removeRoadColumns();

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Refreshes the table after editing a project
     * @param table
     */
    public void refreshProjects(ProjectsTable table) {
        ProjectsListManager all = new ProjectsListManager();
        ProjectsList newProjects = all.getAllProjects();

        table.projects.clear();
        table.projects = newProjects.getProjects();

        this.projects = table.projects;
        this.setFilterState(TableFilterState.REFRESH);
        this.setDateFilterState(TableDateFilterState.ALL);
    }

    /**
     * Refreshes the table after deleting a project
     * @param table
     */
    public static void refreshProjectsAfterDeletion(ProjectsTable table) {
        ProjectsList newProjects = new ProjectsListManager().getAllProjects();
        table.setProjects(newProjects.getProjects());
        table.setFilterState(TableFilterState.REFRESH);
        table.setDateFilterState(TableDateFilterState.ALL);
    }

    /**
     * Sets the filter state of the table,
     * sets the columns of the table to display the information about the projects, based on which
     * type of project is currently being filtered
     * @param filterState The filter state to set
     */
    public void setFilterState(TableFilterState filterState) {
        this.filterState = filterState;
        this.getItems().clear();
        if (this.dateFilterState == TableDateFilterState.ALL) {
            if (this.filterState == TableFilterState.ALL) {
                setAllColumnsInfo();
            } else if (this.filterState == TableFilterState.RESIDENTIAL) {
                setResidentialColumns();
            } else if (this.filterState == TableFilterState.COMMERCIAL) {
                setCommercialColumns();
            } else if (this.filterState == TableFilterState.INDUSTRIAL) {
                setIndustrialColumns();
            } else if (this.filterState == TableFilterState.ROAD) {
                setRoadColumns();
            } else if (this.filterState == TableFilterState.SEARCH) {
                setSearchColumns();
            } else if (this.filterState == TableFilterState.REFRESH) {
                setAllColumnsInfo();
                unclickRadioButtons();
                this.filterState = TableFilterState.ALL;
            }
        } else {
            if (this.filterState == TableFilterState.REFRESH) {
                setAllColumnsInfo();
                unclickRadioButtons();
                this.filterState = TableFilterState.ALL;
            } else {
                setDateFilterState(this.dateFilterState);
            }
        }
    }

    /**
     * Sets the table with finished projects
     */
    public void setFinishedColumns() {
        ProjectsList finished = new ProjectsList();
        ArrayList<Project> temp = finished.getFinishedProjects(getFilterState());

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Sets the table with unfinished projects
     */
    public void setUnfinishedColumns() {
        ProjectsList finished = new ProjectsList();
        ArrayList<Project> temp = finished.getUnfinishedProjects(getFilterState());

        this.getItems().clear();
        this.getItems().addAll(temp);
    }

    /**
     * Setter for dateFilterState and column generator
     * based on the dateFilterState, the respective columns will be added or removed
     * @param dateFilterState The dateFilterState to be used as setter
     */
    public void setDateFilterState(TableDateFilterState dateFilterState) {
        this.dateFilterState = dateFilterState;
        this.getItems().clear();
        if (this.filterState != TableFilterState.ALL) {
            if (this.dateFilterState == TableDateFilterState.ALL) {
                removeRoadColumns();
                removeResidentialColumns();
                removeIndustrialColumns();
                removeCommercialColumns();
                setFilterState(this.filterState);
            } else if (this.dateFilterState == TableDateFilterState.FINISHED) {
                setFinishedColumns();
            } else if (this.dateFilterState == TableDateFilterState.UNFINISHED) {
                setUnfinishedColumns();
            }
        } else {
            if (this.dateFilterState == TableDateFilterState.ALL) {
                setAllColumnsInfo();
            } else if (this.dateFilterState == TableDateFilterState.FINISHED) {
                setFinishedProjects();
            } else if (this.dateFilterState == TableDateFilterState.UNFINISHED) {
                setUnfinishedProjects();
            }
        }
    }

    /**
     * Getter for the filterState
     * @return the String version of the filterState
     */
    public String getFilterState() {
        String temp = "";
        if (this.filterState == TableFilterState.ALL) {
            temp = "";
        } else if (this.filterState == TableFilterState.COMMERCIAL) {
            temp = "Commercial";
        } else if (this.filterState == TableFilterState.RESIDENTIAL) {
            temp = "Residential";
        } else if (this.filterState == TableFilterState.INDUSTRIAL) {
            temp = "Industrial";
        } else if (this.filterState == TableFilterState.ROAD) {
            temp = "Road Construction";
        }

        return temp;
    }

    /**
     * Getter for the selectedProject
     * @return The selected project
     */
    public Project getSelectedProject() {
        return selectedProject;
    }

    /**
     * Setter for the project-type-filters toggle group
     * @param toggleGroup
     */
    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    /**
     * Setter for the finished/unfinished-filters toggle group
     * @param dateToggleGroup
     */
    public void setDateToggleGroup(ToggleGroup dateToggleGroup) {
        this.dateToggleGroup = dateToggleGroup;
    }

    /**
     * deselects whichever radio buttons are currently toggled
     */
    public void unclickRadioButtons() {
        this.toggleGroup.selectToggle(null);
        this.dateToggleGroup.selectToggle(null);
    }
}
