package org.example.view.modals;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.managers.ProjectsListManager;
import org.example.model.project.*;
import org.example.view.FormFieldsBuilder;
import org.example.view.ProjectsTable;

/**
 * A modal window for editing a project from the projects table
 Change FormFieldsFactory to FormFieldsBuilder
 *
 * @author Dimitar Nizamov, Marius Marcoci
 * @version 1.0
 */
public class EditProjectModal extends Stage {
    private Project project;
    private Button saveButton;
    private Button cancelButton;
    private Button confirmButton;
    private TextField projectNameTextField;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private TextField hoursNeededTextField;
    private TextField materialExpensesNeededTextField;
    private TextField timelineTextField;
    private TextField budgetTextField;
    private TextField customerNameTextField;
    private TextField customerPhoneTextField;
    private TextField customerEmailTextField;
    private TextField customerAddressTextField;

    private FormFieldsBuilder formFieldsBuilder;
    private ProjectsListManager projectsListManager;
    private ProjectsTable table;

    /** Constructor for the EditProjectModal
     * sets the project and table attributes
     * initializes new instances of formFieldsBuilder and projectsListManager
     * calls the method which creates the modal
     * @param project The project to be edited
     * @param table The table where the project will be added after update
     */
    public EditProjectModal(Project project, ProjectsTable table) {
        super();
        this.project = project;
        this.formFieldsBuilder = new FormFieldsBuilder();
        this.projectsListManager = new ProjectsListManager();
        this.table = table;
        initEditProjectModal();
    }

    /** Sets the common project values
     * initializes to @param project the common attributes that every project has
     */
    private void setCommonProjectValues(Project project) {
        project.setName(projectNameTextField.getText());
        project.setStartDate(startDatePicker.getValue());
        project.setEndDate(endDatePicker.getValue());
        project.getResources().setHoursNeeded(Integer.parseInt(hoursNeededTextField.getText()));
        project.getResources().setMaterialExpensedNeeded(Double.parseDouble(materialExpensesNeededTextField.getText()));
        project.setTimeline(timelineTextField.getText());
        project.setBudget(Double.parseDouble(budgetTextField.getText()));
        project.getCustomer().setName(customerNameTextField.getText());
        project.getCustomer().setPhoneNumber(customerPhoneTextField.getText());
        project.getCustomer().setEmail(customerEmailTextField.getText());
        project.getCustomer().setAddress(customerAddressTextField.getText());
    }

    /** Saves the project with the new values from the form fields
     * @see IndustrialProject
     * @see ResidentialProject
     * @see CommercialProject
     * @see RoadConstructionProject
     */
    private void saveProject() {
        //validate fields and show error messages if invalid
        if (this.project.getType().equals("Industrial")) {
            IndustrialProject industrialProject = (IndustrialProject) this.project;
            setCommonProjectValues(industrialProject);
            industrialProject.setTypeOfIndustrialFacility(formFieldsBuilder.getIndustrialTypeOfFacilityTextField().getText());
            industrialProject.setSize(Double.parseDouble(formFieldsBuilder.getIndustrialSizeTextField().getText()));
            try {
                projectsListManager.updateProject(industrialProject, industrialProject.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.project.getType().equals("Residential")) {
            ResidentialProject residentialProject = (ResidentialProject) this.project;
            setCommonProjectValues(residentialProject);
            residentialProject.setNumberOfBathrooms(Integer.parseInt(formFieldsBuilder.getResidentialBathroomsTextField().getText()));
            residentialProject.setNumberOfKitchen(Integer.parseInt(formFieldsBuilder.getResidentialKitchensTextField().getText()));
            residentialProject.setNumberOfRoomsWithPlumbing(Integer.parseInt(formFieldsBuilder.getResidentialPlumbingRoomsTextField().getText()));
            try {
                projectsListManager.updateProject(residentialProject, residentialProject.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.project.getType().equals("Commercial")) {
            CommercialProject commercialProject = (CommercialProject) this.project;
            setCommonProjectValues(commercialProject);
            commercialProject.setIntendedUseOfBuilding(formFieldsBuilder.getCommercialUseTextField().getText());
            commercialProject.setNumberOfFloors(Integer.parseInt(formFieldsBuilder.getCommercialFloorsTextField().getText()));
            try {
                projectsListManager.updateProject(commercialProject, commercialProject.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            RoadConstructionProject roadConstructionProject = (RoadConstructionProject) this.project;
            setCommonProjectValues(roadConstructionProject);
            roadConstructionProject.setWidth(Double.parseDouble(formFieldsBuilder.getRoadWidthTextField().getText()));
            roadConstructionProject.setLength(Double.parseDouble(formFieldsBuilder.getRoadLengthTextField().getText()));
            roadConstructionProject.setNumberOfBridge(Integer.parseInt(formFieldsBuilder.getRoadBridgesTextField().getText()));
            roadConstructionProject.setNumberOfTunnels(Integer.parseInt(formFieldsBuilder.getRoadTunnelsTextField().getText()));
            roadConstructionProject.setEnvOrGeoChallenges(formFieldsBuilder.getRoadChallengesTextField().getText());
            try {
                projectsListManager.updateProject(roadConstructionProject, roadConstructionProject.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Displays a confirmation modal window when the user clicks the save button
     * if the user clicks confirm, the project is saved and the modal window is closed
     * if the user clicks cancel, the modal window is closed and the project is not saved
     *
     * @version 1.0
     */
    private void editConfirmation() {
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Edit Confirmation");

        Label questionLabel = new Label("Are you sure you want to proceed with this action?");

        Separator separator = new Separator();

        this.confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            this.saveProject();
            this.table.refreshProjects(this.table);
            this.close();
            modalStage.close();
        });

        Button cancelConfirmButton = new Button("Cancel");
        cancelConfirmButton.setOnAction(e -> modalStage.close());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(confirmButton, cancelConfirmButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        VBox modalLayout = new VBox(10);
        modalLayout.getChildren().addAll(questionLabel, separator, buttonBox);
        modalLayout.setAlignment(Pos.CENTER);
        modalLayout.setStyle("-fx-padding: 20; -fx-spacing: 10;");

        Scene modalScene = new Scene(modalLayout, 300, 150);

        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    /**
     * Initializes the modal window for editing a project, and displays it
     * prepopulates the fields with the project's current values
     *
     * @version 1.0
     */
    private void initEditProjectModal() {
        this.setTitle("Edit Project");

        this.initModality(Modality.APPLICATION_MODAL);

        StackPane modalLayout = new StackPane();

        //project name
        Label projectNameLabel = new Label("Project name: ");
        HBox projectNameLabelBox = new HBox(projectNameLabel);
        projectNameLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(projectNameLabelBox, new Insets(5, 0, 0, 10));

        this.projectNameTextField = new TextField();
        projectNameTextField.setText(this.project.getName());
        projectNameTextField.setPrefWidth(175);
        HBox projectNameTextFieldBox = new HBox(projectNameTextField);
        projectNameTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(projectNameTextFieldBox, new Insets(5, 10, 0, 0));

        HBox projectNameBox = new HBox(projectNameLabelBox, projectNameTextFieldBox);
        HBox.setHgrow(projectNameTextFieldBox, Priority.ALWAYS);
        HBox.setHgrow(projectNameLabelBox, Priority.ALWAYS);

        //project start date
        Label startDateLabel = new Label("Start date: ");
        HBox startDateLabelBox = new HBox(startDateLabel);
        startDateLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(startDateLabelBox, new Insets(5, 0, 0, 10));

        this.startDatePicker = new DatePicker();
        startDatePicker.setValue(this.project.getStartDate());
        HBox startDatePickerBox = new HBox(startDatePicker);
        startDatePickerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(startDatePickerBox, new Insets(5, 10, 0, 0));

        //project start date
        Label endDateLabel = new Label("End date: ");
        HBox endDateLabelBox = new HBox(endDateLabel);
        endDateLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(endDateLabelBox, new Insets(5, 0, 0, 10));

        this.endDatePicker = new DatePicker();
        endDatePicker.setValue(this.project.getEndDate());
        HBox endDatePickerBox = new HBox(endDatePicker);
        endDatePickerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(endDatePickerBox, new Insets(5, 10, 0, 0));

        HBox endDateBox = new HBox(endDateLabelBox, endDatePickerBox);
        HBox.setHgrow(endDateLabelBox, Priority.ALWAYS);
        HBox.setHgrow(endDateBox, Priority.ALWAYS);

        HBox startDateBox = new HBox(startDateLabelBox, startDatePickerBox);
        HBox.setHgrow(startDateLabelBox, Priority.ALWAYS);
        HBox.setHgrow(startDatePickerBox, Priority.ALWAYS);

        //project hours needed
        Label hoursNeededLabel = new Label("Hours Needed: ");
        HBox hoursNeededLabelBox = new HBox(hoursNeededLabel);
        hoursNeededLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(hoursNeededLabelBox, new Insets(5, 0, 0, 10));

        this.hoursNeededTextField = new TextField();
        hoursNeededTextField.setPrefWidth(175);
        hoursNeededTextField.setText(String.valueOf(this.project.getResources().getHoursNeeded()));
        HBox hoursNeededTextFieldBox = new HBox(hoursNeededTextField);
        hoursNeededTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(hoursNeededTextFieldBox, new Insets(5, 10, 0, 0));

        HBox hoursNeededBox = new HBox(hoursNeededLabelBox, hoursNeededTextFieldBox);
        HBox.setHgrow(hoursNeededLabelBox, Priority.ALWAYS);
        HBox.setHgrow(hoursNeededTextFieldBox, Priority.ALWAYS);

        //material expenses needed
        Label materialExpensesNeededLabel = new Label("Material Expenses Needed ($): ");
        HBox materialExpensesNeededLabelBox = new HBox(materialExpensesNeededLabel);
        materialExpensesNeededLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(materialExpensesNeededLabelBox, new Insets(5, 0, 0, 10));

        this.materialExpensesNeededTextField = new TextField();
        materialExpensesNeededTextField.setText(String.valueOf(this.project.getResources().getMaterialExpensedNeeded()));
        materialExpensesNeededTextField.setPrefWidth(175);
        HBox materialExpensesNeededTextFieldBox = new HBox(materialExpensesNeededTextField);
        materialExpensesNeededTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(materialExpensesNeededTextFieldBox, new Insets(5, 10, 0, 0));

        HBox materialExpensesNeededBox = new HBox(materialExpensesNeededLabelBox, materialExpensesNeededTextFieldBox);
        HBox.setHgrow(materialExpensesNeededLabelBox, Priority.ALWAYS);
        HBox.setHgrow(materialExpensesNeededTextFieldBox, Priority.ALWAYS);

        //timeline
        Label timelineLabel = new Label("Timeline (months): ");
        HBox timelineLabelBox = new HBox(timelineLabel);
        timelineLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(timelineLabelBox, new Insets(5, 0, 0, 10));

        this.timelineTextField = new TextField();
        timelineTextField.setText(this.project.getTimeline());
        timelineTextField.setPrefWidth(175);
        HBox timelineTextFieldBox = new HBox(timelineTextField);
        timelineTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(timelineTextFieldBox, new Insets(5, 10, 0, 0));

        HBox timelineBox = new HBox(timelineLabelBox, timelineTextFieldBox);
        HBox.setHgrow(timelineLabelBox, Priority.ALWAYS);
        HBox.setHgrow(timelineTextFieldBox, Priority.ALWAYS);

        //budget
        Label budgetLabel = new Label("Budget ($): ");
        HBox budgetLabelBox = new HBox(budgetLabel);
        budgetLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(budgetLabelBox, new Insets(5, 0, 0, 10));

        this.budgetTextField = new TextField();
        budgetTextField.setText(String.valueOf(this.project.getBudget()));
        budgetTextField.setPrefWidth(175);
        HBox budgetTextFieldBox = new HBox(budgetTextField);
        budgetTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(budgetTextFieldBox, new Insets(5, 10, 0, 0));

        HBox budgetBox = new HBox(budgetLabelBox, budgetTextFieldBox);
        HBox.setHgrow(budgetLabelBox, Priority.ALWAYS);
        HBox.setHgrow(budgetTextFieldBox, Priority.ALWAYS);

        //customer name
        Label customerNameLabel = new Label("Customer Name: ");
        HBox customerNameLabelBox = new HBox(customerNameLabel);
        customerNameLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerNameLabelBox, new Insets(5, 0, 0, 10));

        this.customerNameTextField = new TextField();
        customerNameTextField.setText(this.project.getCustomer().getName());
        customerNameTextField.setPrefWidth(175);
        HBox customerNameTextFieldBox = new HBox(customerNameTextField);
        customerNameTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerNameTextFieldBox, new Insets(5, 10, 0, 0));

        HBox customerNameBox = new HBox(customerNameLabelBox, customerNameTextFieldBox);
        HBox.setHgrow(customerNameLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerNameTextFieldBox, Priority.ALWAYS);

        //customer phone
        Label customerPhoneLabel = new Label("Customer Phone Number: ");
        HBox customerPhoneLabelBox = new HBox(customerPhoneLabel);
        customerPhoneLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerPhoneLabelBox, new Insets(5, 0, 0, 10));

        this.customerPhoneTextField = new TextField();
        customerPhoneTextField.setText(this.project.getCustomer().getPhoneNumber());
        customerPhoneTextField.setPrefWidth(175);
        HBox customerPhoneTextFieldBox = new HBox(customerPhoneTextField);
        customerPhoneTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerPhoneTextFieldBox, new Insets(5, 10, 0, 0));

        HBox customerPhoneBox = new HBox(customerPhoneLabelBox, customerPhoneTextFieldBox);
        HBox.setHgrow(customerPhoneLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerPhoneTextFieldBox, Priority.ALWAYS);

        //customer email
        Label customerEmailLabel = new Label("Customer Email: ");
        HBox customerEmailLabelBox = new HBox(customerEmailLabel);
        customerEmailLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerEmailLabelBox, new Insets(5, 0, 0, 10));

        this.customerEmailTextField = new TextField();
        customerEmailTextField.setText(this.project.getCustomer().getEmail());
        customerEmailTextField.setPrefWidth(175);
        HBox customerEmailTextFieldBox = new HBox(customerEmailTextField);
        customerEmailTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerEmailTextFieldBox, new Insets(5, 10, 0, 0));

        HBox customerEmailBox = new HBox(customerEmailLabelBox, customerEmailTextFieldBox);
        HBox.setHgrow(customerEmailLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerEmailTextFieldBox, Priority.ALWAYS);

        //customer address
        Label customerAddressLabel = new Label("Customer Address: ");
        HBox customerAddressLabelBox = new HBox(customerAddressLabel);
        customerAddressLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerAddressLabelBox, new Insets(5, 0, 0, 10));

        this.customerAddressTextField = new TextField();
        customerAddressTextField.setText(this.project.getCustomer().getAddress());
        customerAddressTextField.setPrefWidth(175);
        HBox customerAddressTextFieldBox = new HBox(customerAddressTextField);
        customerAddressTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerAddressTextFieldBox, new Insets(5, 10, 0, 0));

        HBox customerAddressBox = new HBox(customerAddressLabelBox, customerAddressTextFieldBox);
        HBox.setHgrow(customerAddressLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerAddressTextFieldBox, Priority.ALWAYS);

        //save and cancel buttons
        this.saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            boolean isValid = validateForm();
            if (isValid) {
                editConfirmation();
            }
        });
        this.cancelButton = new Button("Cancel");
        HBox handleAddProjectButtonsBox = new HBox(saveButton, cancelButton);
        handleAddProjectButtonsBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(cancelButton, new Insets(10, 10, 10, 5));
        HBox.setMargin(saveButton, new Insets(10, 0, 10, 0));

        VBox form = new VBox();
        form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox, handleAddProjectButtonsBox);


        if (this.project.getType().equals("Industrial")) {
            IndustrialProject industrialProject = (IndustrialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateIndustrialDetails(false, industrialProject), handleAddProjectButtonsBox);
        } else if (this.project.getType().equals("Residential")) {
            ResidentialProject residentialProject = (ResidentialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateResidentialDetails(false, residentialProject), handleAddProjectButtonsBox);
        } else if (this.project.getType().equals("Commercial")) {
            CommercialProject commercialProject = (CommercialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateCommercialDetails(false, commercialProject), handleAddProjectButtonsBox);
        } else {
            RoadConstructionProject roadConstructionProject = (RoadConstructionProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateRoadDetails(false, roadConstructionProject), handleAddProjectButtonsBox);
        }

        modalLayout.getChildren().addAll(form);

        Scene modalScene = new Scene(modalLayout, 400, 550);
        this.setScene(modalScene);
        this.setResizable(false);

        this.showAndWait();
    }

    /**
     * checks every text field if it is empty and displays an alert with an error message
     * @return {@code false} if there is at least an empty field and {@code true} if there are no empty fields
     */
    private boolean validateForm() {
        boolean isShowingAlert = false;
        if (projectNameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Project name is required");
            alert.setContentText("Please enter a project name");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (startDatePicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Start date is required");
            alert.setContentText("Please enter a start date");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (endDatePicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("End date is required");
            alert.setContentText("Please enter an end date");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (hoursNeededTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hours needed is required");
            alert.setContentText("Please enter hours needed");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (materialExpensesNeededTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Material expenses needed is required");
            alert.setContentText("Please enter material expenses needed");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (timelineTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Timeline is required");
            alert.setContentText("Please enter a timeline");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (budgetTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Budget is required");
            alert.setContentText("Please enter a budget");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (customerNameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Customer name is required");
            alert.setContentText("Please enter a customer name");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (customerPhoneTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Customer phone number is required");
            alert.setContentText("Please enter a customer phone number");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (customerEmailTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Customer email is required");
            alert.setContentText("Please enter a customer email");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (customerAddressTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Customer address is required");
            alert.setContentText("Please enter a customer address");
            alert.showAndWait();
            isShowingAlert = alert.isShowing();
        }
        if (this.project.getType().equals("Industrial")) {
            if (formFieldsBuilder.getIndustrialTypeOfFacilityTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Type of industrial facility is required");
                alert.setContentText("Please enter a type of industrial facility");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            IndustrialProject industrialProject = (IndustrialProject) this.project;
            setCommonProjectValues(industrialProject);
            industrialProject.setTypeOfIndustrialFacility(formFieldsBuilder.getIndustrialTypeOfFacilityTextField().getText());
            industrialProject.setSize(Double.parseDouble(formFieldsBuilder.getIndustrialSizeTextField().getText()));
        } else if (this.project.getType().equals("Residential")) {
            if (formFieldsBuilder.getResidentialBathroomsTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of bathrooms is required");
                alert.setContentText("Please enter a number of bathrooms");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getResidentialKitchensTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of kitchens is required");
                alert.setContentText("Please enter a number of kitchens");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getResidentialPlumbingRoomsTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of rooms with plumbing is required");
                alert.setContentText("Please enter a number of rooms with plumbing");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
        } else if (this.project.getType().equals("Commercial")) {
            if (formFieldsBuilder.getCommercialUseTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Intended use of building is required");
                alert.setContentText("Please enter an intended use of building");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getCommercialFloorsTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of floors is required");
                alert.setContentText("Please enter a number of floors");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
        } else {
            if (formFieldsBuilder.getRoadWidthTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Road width is required");
                alert.setContentText("Please enter a road width");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getRoadLengthTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Road length is required");
                alert.setContentText("Please enter a road length");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getRoadBridgesTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of bridges is required");
                alert.setContentText("Please enter a number of bridges");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getRoadTunnelsTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Number of tunnels is required");
                alert.setContentText("Please enter a number of tunnels");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
            if (formFieldsBuilder.getRoadChallengesTextField().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Environmental or geological challenges is required");
                alert.setContentText("Please enter environmental or geological challenges");
                alert.showAndWait();
                isShowingAlert = alert.isShowing();
            }
        }
        return !isShowingAlert;
    }
}
