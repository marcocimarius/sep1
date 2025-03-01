package org.example.view.modals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import org.example.model.Customer;
import org.example.model.Resources;
import org.example.model.project.*;
import org.example.view.DefaultFieldValues;
import org.example.view.ProjectsTable;
import org.example.view.FormFieldsBuilder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * A modal window for creating a project
 *
 * @author Dimitar Nizamov, Marius Marcoci, Alexander Cichon
 * @version 1.0
 */
public class CreateProjectModal extends Stage {
    ProjectsListManager projectsListManager = new ProjectsListManager();
    private ProjectsTable table;
    private HBox dropDownBox;
    private HBox projectNameBox;
    private HBox startDateBox;
    private HBox hoursNeededBox;
    private HBox materialExpensesNeededBox;
    private HBox timelineBox;
    private HBox budgetBox;
    private HBox customerNameBox;
    private HBox customerPhoneBox;
    private HBox customerEmailBox;
    private HBox customerAddressBox;
    private HBox handleAddProjectButtonsBox;
    private FormFieldsBuilder formFieldsBuilder;

    /**
     * Constructor for the CreateProjectModal
     * sets the table attribute
     * creates a new instance of formFieldsBuilder
     * calls the method which creates the modal
     * @param table Where the project will be added
     */
    public CreateProjectModal(ProjectsTable table) {
        super();
        this.table = table;
        this.formFieldsBuilder = new FormFieldsBuilder();
        initCreateModal();
    }

    /**
     * method that creates the modal with all the necessary labels, text fields, dropdowns, buttons, date pickers
     * inserts the default values for every type of project
     * validates the project's fields
     * shows an alert with an error message in case of finding an empty field
     * saves the project
     */
    public void initCreateModal() {
        this.setTitle("Create Project");

        this.initModality(Modality.APPLICATION_MODAL);

        StackPane modalLayout = new StackPane();

        //dropDown
        ComboBox<String> dropdown = new ComboBox<>();
        dropdown.setPromptText("Choose a project type");
        ObservableList<String> options = FXCollections.observableArrayList("Industrial", "Residential", "Commercial", "Road Construction");
        dropdown.setItems(options);
        this.dropDownBox = new HBox(dropdown);
        HBox.setMargin(dropdown, new Insets(10, 0, 0, 10));

        //project name
        Label projectNameLabel = new Label("Project name: ");
        HBox projectNameLabelBox = new HBox(projectNameLabel);
        projectNameLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(projectNameLabelBox, new Insets(5, 0, 0, 10));

        TextField projectNameTextField = new TextField();
        projectNameTextField.setPromptText("ex: My Great Project");
        projectNameTextField.setPrefWidth(175);
        HBox projectNameTextFieldBox = new HBox(projectNameTextField);
        projectNameTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(projectNameTextFieldBox, new Insets(5, 10, 0, 0));

        this.projectNameBox = new HBox(projectNameLabelBox, projectNameTextFieldBox);
        HBox.setHgrow(projectNameTextFieldBox, Priority.ALWAYS);
        HBox.setHgrow(projectNameLabelBox, Priority.ALWAYS);

        //project start date
        Label startDateLabel = new Label("Start date: ");
        HBox startDateLabelBox = new HBox(startDateLabel);
        startDateLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(startDateLabelBox, new Insets(5, 0, 0, 10));

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setValue(LocalDate.now());
        HBox startDatePickerBox = new HBox(startDatePicker);
        startDatePickerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(startDatePickerBox, new Insets(5, 10, 0, 0));

        this.startDateBox = new HBox(startDateLabelBox, startDatePickerBox);
        HBox.setHgrow(startDateLabelBox, Priority.ALWAYS);
        HBox.setHgrow(startDatePickerBox, Priority.ALWAYS);

        //project hours needed
        Label hoursNeededLabel = new Label("Hours Needed: ");
        HBox hoursNeededLabelBox = new HBox(hoursNeededLabel);
        hoursNeededLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(hoursNeededLabelBox, new Insets(5, 0, 0, 10));

        TextField hoursNeededTextField = new TextField();
        hoursNeededTextField.setPromptText("ex: 1500");
        hoursNeededTextField.setPrefWidth(175);
        HBox hoursNeededTextFieldBox = new HBox(hoursNeededTextField);
        hoursNeededTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(hoursNeededTextFieldBox, new Insets(5, 10, 0, 0));

        this.hoursNeededBox = new HBox(hoursNeededLabelBox, hoursNeededTextFieldBox);
        HBox.setHgrow(hoursNeededLabelBox, Priority.ALWAYS);
        HBox.setHgrow(hoursNeededTextFieldBox, Priority.ALWAYS);

        //material expenses needed
        Label materialExpensesNeededLabel = new Label("Material Expenses Needed ($): ");
        HBox materialExpensesNeededLabelBox = new HBox(materialExpensesNeededLabel);
        materialExpensesNeededLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(materialExpensesNeededLabelBox, new Insets(5, 0, 0, 10));

        TextField materialExpensesNeededTextField = new TextField();
        materialExpensesNeededTextField.setPromptText("ex: 11500.0");
        materialExpensesNeededTextField.setPrefWidth(175);
        HBox materialExpensesNeededTextFieldBox = new HBox(materialExpensesNeededTextField);
        materialExpensesNeededTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(materialExpensesNeededTextFieldBox, new Insets(5, 10, 0, 0));

        this.materialExpensesNeededBox = new HBox(materialExpensesNeededLabelBox, materialExpensesNeededTextFieldBox);
        HBox.setHgrow(materialExpensesNeededLabelBox, Priority.ALWAYS);
        HBox.setHgrow(materialExpensesNeededTextFieldBox, Priority.ALWAYS);

        //timeline
        Label timelineLabel = new Label("Timeline (months): ");
        HBox timelineLabelBox = new HBox(timelineLabel);
        timelineLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(timelineLabelBox, new Insets(5, 0, 0, 10));

        TextField timelineTextField = new TextField();
        timelineTextField.setPromptText("ex: 6");
        timelineTextField.setPrefWidth(175);
        HBox timelineTextFieldBox = new HBox(timelineTextField);
        timelineTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(timelineTextFieldBox, new Insets(5, 10, 0, 0));

        this.timelineBox = new HBox(timelineLabelBox, timelineTextFieldBox);
        HBox.setHgrow(timelineLabelBox, Priority.ALWAYS);
        HBox.setHgrow(timelineTextFieldBox, Priority.ALWAYS);

        //budget
        Label budgetLabel = new Label("Budget ($): ");
        HBox budgetLabelBox = new HBox(budgetLabel);
        budgetLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(budgetLabelBox, new Insets(5, 0, 0, 10));

        TextField budgetTextField = new TextField();
        budgetTextField.setPromptText("ex: 1000000.0");
        budgetTextField.setPrefWidth(175);
        HBox budgetTextFieldBox = new HBox(budgetTextField);
        budgetTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(budgetTextFieldBox, new Insets(5, 10, 0, 0));

        this.budgetBox = new HBox(budgetLabelBox, budgetTextFieldBox);
        HBox.setHgrow(budgetLabelBox, Priority.ALWAYS);
        HBox.setHgrow(budgetTextFieldBox, Priority.ALWAYS);

        //customer name
        Label customerNameLabel = new Label("Customer Name: ");
        HBox customerNameLabelBox = new HBox(customerNameLabel);
        customerNameLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerNameLabelBox, new Insets(5, 0, 0, 10));

        TextField customerNameTextField = new TextField();
        customerNameTextField.setPromptText("ex: Bob Smith");
        customerNameTextField.setPrefWidth(175);
        HBox customerNameTextFieldBox = new HBox(customerNameTextField);
        customerNameTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerNameTextFieldBox, new Insets(5, 10, 0, 0));

        this.customerNameBox = new HBox(customerNameLabelBox, customerNameTextFieldBox);
        HBox.setHgrow(customerNameLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerNameTextFieldBox, Priority.ALWAYS);

        //customer phone
        Label customerPhoneLabel = new Label("Customer Phone Number: ");
        HBox customerPhoneLabelBox = new HBox(customerPhoneLabel);
        customerPhoneLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerPhoneLabelBox, new Insets(5, 0, 0, 10));

        TextField customerPhoneTextField = new TextField();
        customerPhoneTextField.setText(DefaultFieldValues.PHONE_CODE);
        customerPhoneTextField.setPrefWidth(175);
        HBox customerPhoneTextFieldBox = new HBox(customerPhoneTextField);
        customerPhoneTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerPhoneTextFieldBox, new Insets(5, 10, 0, 0));

        this.customerPhoneBox = new HBox(customerPhoneLabelBox, customerPhoneTextFieldBox);
        HBox.setHgrow(customerPhoneLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerPhoneTextFieldBox, Priority.ALWAYS);

        //customer email
        Label customerEmailLabel = new Label("Customer Email: ");
        HBox customerEmailLabelBox = new HBox(customerEmailLabel);
        customerEmailLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerEmailLabelBox, new Insets(5, 0, 0, 10));

        TextField customerEmailTextField = new TextField();
        customerEmailTextField.setPromptText("ex: bobsmith@gmail.com");
        customerEmailTextField.setPrefWidth(175);
        HBox customerEmailTextFieldBox = new HBox(customerEmailTextField);
        customerEmailTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerEmailTextFieldBox, new Insets(5, 10, 0, 0));

        this.customerEmailBox = new HBox(customerEmailLabelBox, customerEmailTextFieldBox);
        HBox.setHgrow(customerEmailLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerEmailTextFieldBox, Priority.ALWAYS);

        //customer address
        Label customerAddressLabel = new Label("Customer Address: ");
        HBox customerAddressLabelBox = new HBox(customerAddressLabel);
        customerAddressLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(customerAddressLabelBox, new Insets(5, 0, 0, 10));

        TextField customerAddressTextField = new TextField();
        customerAddressTextField.setPromptText("ex: Banegårdsgade 2, 8700 Horsens");
        customerAddressTextField.setPrefWidth(175);
        HBox customerAddressTextFieldBox = new HBox(customerAddressTextField);
        customerAddressTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerAddressTextFieldBox, new Insets(5, 10, 0, 0));

        this.customerAddressBox = new HBox(customerAddressLabelBox, customerAddressTextFieldBox);
        HBox.setHgrow(customerAddressLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerAddressTextFieldBox, Priority.ALWAYS);

        //save and cancel buttons
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        this.handleAddProjectButtonsBox = new HBox(saveButton, cancelButton);
        handleAddProjectButtonsBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(cancelButton, new Insets(10, 10, 10, 5));
        HBox.setMargin(saveButton, new Insets(10, 0, 10, 0));

        VBox form = new VBox();
        form.getChildren().addAll(dropDownBox, projectNameBox, startDateBox,
                hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox);

        dropdown.setOnAction(event -> {
            form.getChildren().clear();
            this.populateFormWithCommonFields(form);
            if (dropdown.getValue().equals("Industrial")) {
                form.getChildren().addAll(this.formFieldsBuilder.generateIndustrialDetails(false, null));
                timelineTextField.setText(DefaultFieldValues.INDUSTRIAL_TIMELINE);
            } else if (dropdown.getValue().equals("Residential")) {
                form.getChildren().addAll(this.formFieldsBuilder.generateResidentialDetails(false, null));
                timelineTextField.setText(DefaultFieldValues.RESIDENTIAL_TIMELINE);
            } else if (dropdown.getValue().equals("Commercial")) {
                form.getChildren().addAll(this.formFieldsBuilder.generateCommercialDetails(false, null));
                timelineTextField.setText(DefaultFieldValues.COMMERCIAL_TIMELINE);
            } else {
                form.getChildren().addAll(this.formFieldsBuilder.generateRoadDetails(false, null));
                timelineTextField.setText(DefaultFieldValues.ROAD_TIMELINE);
            }
            form.getChildren().add(handleAddProjectButtonsBox);
        });
        cancelButton.setOnAction(e -> {
            this.close();
        });

        saveButton.setOnAction(e -> {
            //validate form and display alert if invalid
            if (dropdown.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Project type not selected");
                alert.setContentText("Please select a project type");
                alert.showAndWait();
                return;
            }
            if (projectNameTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Project name not entered");
                alert.setContentText("Please enter a project name");
                alert.showAndWait();
                return;
            }
            if (startDatePicker.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Start date not selected");
                alert.setContentText("Please select a start date");
                alert.showAndWait();
                return;
            }
            if (hoursNeededTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Hours needed not entered");
                alert.setContentText("Please enter hours needed");
                alert.showAndWait();
                return;
            }
            if (materialExpensesNeededTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Material expenses needed not entered");
                alert.setContentText("Please enter material expenses needed");
                alert.showAndWait();
                return;
            }
            if (timelineTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Timeline not entered");
                alert.setContentText("Please enter a timeline");
                alert.showAndWait();
                return;
            }
            if (budgetTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Budget not entered");
                alert.setContentText("Please enter a budget");
                alert.showAndWait();
                return;
            }
            if (customerNameTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Customer name not entered");
                alert.setContentText("Please enter a customer name");
                alert.showAndWait();
                return;
            }
            if (customerPhoneTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Customer phone number not entered");
                alert.setContentText("Please enter a customer phone number");
                alert.showAndWait();
                return;
            }
            if (customerEmailTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Customer email not entered");
                alert.setContentText("Please enter a customer email");
                alert.showAndWait();
                return;
            }
            if (customerAddressTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Customer address not entered");
                alert.setContentText("Please enter a customer address");
                alert.showAndWait();
                return;
            }
            Customer cust = new Customer(customerNameTextField.getText(),
                    customerPhoneTextField.getText(),
                    customerEmailTextField.getText(),
                    customerAddressTextField.getText());
            Resources res = new Resources(0,
                    Integer.parseInt(hoursNeededTextField.getText()),
                    0,
                    Double.parseDouble(materialExpensesNeededTextField.getText()));


            if (dropdown.getValue().equals("Industrial")) {
                if (formFieldsBuilder.getIndustrialSizeTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Industrial size not entered");
                    alert.setContentText("Please enter an industrial size");
                    alert.showAndWait();
                    return;
                }
                IndustrialProject iProject = new IndustrialProject(cust, res,
                        //TODO: Resolve the expected end date question
                        startDatePicker.getValue(), startDatePicker.getValue(),null,
                        UUID.randomUUID(),
                        projectNameTextField.getText(),
                        timelineTextField.getText(),
                        Double.parseDouble(budgetTextField.getText()),
                        Double.parseDouble(formFieldsBuilder.getIndustrialSizeTextField().getText()),
                        formFieldsBuilder.getIndustrialTypeOfFacilityTextField().getText()
                );

                try {
                    projectsListManager.addProject(iProject);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }


            } else if (dropdown.getValue().equals("Residential")) {
                if (formFieldsBuilder.getResidentialSizeTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Residential size not entered");
                    alert.setContentText("Please enter a residential size");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getResidentialKitchensTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Residential kitchens not entered");
                    alert.setContentText("Please enter a residential kitchens");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getResidentialBathroomsTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Residential bathrooms not entered");
                    alert.setContentText("Please enter a residential bathrooms");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getResidentialPlumbingRoomsTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Residential plumbing rooms not entered");
                    alert.setContentText("Please enter a residential plumbing rooms");
                    alert.showAndWait();
                    return;
                }
                ResidentialProject rProject = new ResidentialProject(cust, res,
                        startDatePicker.getValue(), startDatePicker.getValue(),
                        null,
                        UUID.randomUUID(),
                        projectNameTextField.getText(),
                        timelineTextField.getText(),
                        Double.parseDouble(budgetTextField.getText()),
                        Double.parseDouble(formFieldsBuilder.getResidentialSizeTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getResidentialKitchensTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getResidentialBathroomsTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getResidentialPlumbingRoomsTextField().getText()),
                        false);

                try {
                    projectsListManager.addProject(rProject);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }

            } else if (dropdown.getValue().equals("Commercial")) {

                if (formFieldsBuilder.getCommercialSizeTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Commercial size not entered");
                    alert.setContentText("Please enter a commercial size");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getCommercialFloorsTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Commercial floors not entered");
                    alert.setContentText("Please enter a commercial floors");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getCommercialUseTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Commercial use not entered");
                    alert.setContentText("Please enter a commercial use");
                    alert.showAndWait();
                    return;
                }
                CommercialProject cProject = new CommercialProject(cust, res,
                        startDatePicker.getValue(), startDatePicker.getValue(),null,
                        UUID.randomUUID(),
                        projectNameTextField.getText(),
                        timelineTextField.getText(),
                        Double.parseDouble(budgetTextField.getText()),
                        Double.parseDouble(formFieldsBuilder.getCommercialSizeTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getCommercialFloorsTextField().getText()),
                        formFieldsBuilder.getCommercialUseTextField().getText());

                try {
                    projectsListManager.addProject(cProject);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (dropdown.getValue().equals("Road Construction")) {
                if (formFieldsBuilder.getRoadLengthTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Road length not entered");
                    alert.setContentText("Please enter a road length");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getRoadWidthTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Road width not entered");
                    alert.setContentText("Please enter a road width");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getRoadBridgesTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Road bridges not entered");
                    alert.setContentText("Please enter a road bridges");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getRoadTunnelsTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Road tunnels not entered");
                    alert.setContentText("Please enter a road tunnels");
                    alert.showAndWait();
                    return;
                }
                if (formFieldsBuilder.getRoadChallengesTextField().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Road challenges not entered");
                    alert.setContentText("Please enter a road challenges");
                    alert.showAndWait();
                    return;
                }
                RoadConstructionProject roadProject = new RoadConstructionProject(cust, res,
                        startDatePicker.getValue(), startDatePicker.getValue(),null, UUID.randomUUID(),
                        projectNameTextField.getText(), timelineTextField.getText(),
                        Double.parseDouble(budgetTextField.getText()),
                        Double.parseDouble(formFieldsBuilder.getRoadLengthTextField().getText()),
                        Double.parseDouble(formFieldsBuilder.getRoadWidthTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getRoadBridgesTextField().getText()),
                        Integer.parseInt(formFieldsBuilder.getRoadTunnelsTextField().getText()),
                        formFieldsBuilder.getRoadChallengesTextField().getText());

                try {
                    projectsListManager.addProject(roadProject);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }
            }
            ProjectsTable.refreshProjectsAfterDeletion(table);
            this.close();
        });

        modalLayout.getChildren().addAll(form);

        Scene modalScene = new Scene(modalLayout, 400, 550);
        this.setScene(modalScene);
        this.setResizable(false);

        this.showAndWait();
    }

    /**
     * inserts in @param form all the default elements that every type of projects requires:
     * dropdowns, text fields, labels, date pickers
     */
    private void populateFormWithCommonFields(VBox form) {
        form.getChildren().addAll(dropDownBox, projectNameBox, startDateBox,
                hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox);
    }
}
