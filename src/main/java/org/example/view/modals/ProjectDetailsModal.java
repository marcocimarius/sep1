package org.example.view.modals;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.model.project.*;
import org.example.view.FormFieldsBuilder;

/**
 * A modal window for displaying the details of a project
 *
 * @author Dimitar Nizamov, Marius Marcoci
 * @version 1.0
 */
public class ProjectDetailsModal extends Stage {
    private Project project;

    /**
     * Constructor for the DeleteProjectModal
     * sets the project attribute
     * calls the method which creates the modal
     * @param project the project whose details will be shown
     */
    public ProjectDetailsModal(Project project) {
        super();
        this.project = project;
        initDetailsModal();
    }

    /**
     * method that creates the modal with all the necessary labels, text fields, buttons, date pickers
     * inserts the modal's elements with the project's information
     */
    private void initDetailsModal() {
        this.setTitle("Details");

        this.initModality(Modality.APPLICATION_MODAL);

        StackPane modalLayout = new StackPane();

        //project name
        Label projectNameLabel = new Label("Project name: ");
        HBox projectNameLabelBox = new HBox(projectNameLabel);
        projectNameLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(projectNameLabelBox, new Insets(5, 0, 0, 10));

        TextField projectNameTextField = new TextField();
        projectNameTextField.setText(this.project.getName());
        projectNameTextField.setPrefWidth(175);
        projectNameTextField.setDisable(true);
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

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setValue(this.project.getStartDate());
        startDatePicker.setDisable(true);
        HBox startDatePickerBox = new HBox(startDatePicker);
        startDatePickerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(startDatePickerBox, new Insets(5, 10, 0, 0));

        HBox startDateBox = new HBox(startDateLabelBox, startDatePickerBox);
        HBox.setHgrow(startDateLabelBox, Priority.ALWAYS);
        HBox.setHgrow(startDatePickerBox, Priority.ALWAYS);


        Label endDateLabel = new Label("End date: ");
        HBox endDateLabelBox = new HBox(endDateLabel);
        endDateLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(endDateLabelBox, new Insets(5, 0, 0, 10));

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setValue(this.project.getEndDate());
        endDatePicker.setDisable(true);
        HBox endDatePickerBox = new HBox(endDatePicker);
        endDatePickerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(endDatePickerBox, new Insets(5, 10, 0, 0));

        HBox endDateBox = new HBox(endDateLabelBox, endDatePickerBox);
        HBox.setHgrow(endDateLabelBox, Priority.ALWAYS);
        HBox.setHgrow(endDatePickerBox, Priority.ALWAYS);

        //project hours needed
        Label hoursNeededLabel = new Label("Hours Needed: ");
        HBox hoursNeededLabelBox = new HBox(hoursNeededLabel);
        hoursNeededLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(hoursNeededLabelBox, new Insets(5, 0, 0, 10));

        TextField hoursNeededTextField = new TextField();
        hoursNeededTextField.setText(String.valueOf(this.project.getResources().getHoursNeeded()));
        hoursNeededTextField.setPrefWidth(175);
        hoursNeededTextField.setDisable(true);
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

        TextField materialExpensesNeededTextField = new TextField();
        materialExpensesNeededTextField.setText(String.valueOf(this.project.getResources().getMaterialExpensedNeeded()));
        materialExpensesNeededTextField.setPrefWidth(175);
        materialExpensesNeededTextField.setDisable(true);
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

        TextField timelineTextField = new TextField();
        timelineTextField.setText(this.project.getTimeline());
        timelineTextField.setPrefWidth(175);
        timelineTextField.setDisable(true);
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

        TextField budgetTextField = new TextField();
        budgetTextField.setPrefWidth(175);
        budgetTextField.setText(String.valueOf(this.project.getBudget()));
        budgetTextField.setDisable(true);
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

        TextField customerNameTextField = new TextField();
        customerNameTextField.setPrefWidth(175);
        customerNameTextField.setText(this.project.getCustomer().getName());
        customerNameTextField.setDisable(true);
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

        TextField customerPhoneTextField = new TextField();
        customerPhoneTextField.setPrefWidth(175);
        customerPhoneTextField.setText(this.project.getCustomer().getPhoneNumber());
        customerPhoneTextField.setDisable(true);
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

        TextField customerEmailTextField = new TextField();
        customerEmailTextField.setPrefWidth(175);
        customerEmailTextField.setText(this.project.getCustomer().getEmail());
        customerEmailTextField.setDisable(true);
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

        TextField customerAddressTextField = new TextField();
        customerAddressTextField.setPrefWidth(175);
        customerAddressTextField.setText(this.project.getCustomer().getAddress());
        customerAddressTextField.setDisable(true);
        HBox customerAddressTextFieldBox = new HBox(customerAddressTextField);
        customerAddressTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(customerAddressTextFieldBox, new Insets(5, 10, 0, 0));

        HBox customerAddressBox = new HBox(customerAddressLabelBox, customerAddressTextFieldBox);
        HBox.setHgrow(customerAddressLabelBox, Priority.ALWAYS);
        HBox.setHgrow(customerAddressTextFieldBox, Priority.ALWAYS);

        VBox form = new VBox();
        form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox);
        FormFieldsBuilder formFieldsBuilder = new FormFieldsBuilder();

        if (this.project.getType().equals("Industrial")) {
            IndustrialProject industrialProject = (IndustrialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateIndustrialDetails(true, industrialProject));
        } else if (this.project.getType().equals("Residential")) {
            ResidentialProject residentialProject = (ResidentialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateResidentialDetails(true, residentialProject));
        } else if (this.project.getType().equals("Commercial")) {
            CommercialProject commercialProject = (CommercialProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateCommercialDetails(true, commercialProject));
        } else {
            RoadConstructionProject roadConstructionProject = (RoadConstructionProject) this.project;
            form.getChildren().clear();
            form.getChildren().addAll(projectNameBox, startDateBox, endDateBox,
                    hoursNeededBox, materialExpensesNeededBox, timelineBox, budgetBox,
                    customerNameBox, customerPhoneBox, customerEmailBox, customerAddressBox,
                    formFieldsBuilder.generateRoadDetails(true, roadConstructionProject));
        }

        modalLayout.getChildren().addAll(form);

        Scene modalScene = new Scene(modalLayout, 400, 550);
        this.setScene(modalScene);
        this.setResizable(false);

        this.showAndWait();
    }
}
