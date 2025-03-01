package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.example.model.project.CommercialProject;
import org.example.model.project.IndustrialProject;
import org.example.model.project.ResidentialProject;
import org.example.model.project.RoadConstructionProject;

/**
 * A class that generates the form fields for the different types of projects
 * handles the creation of the form fields and exposes getters for each of them
 *
 * @author Dimitar Nizamov, Marius Marcoci
 * @version 1.0
 */
public class FormFieldsBuilder {

    private TextField industrialSizeTextField;
    private TextField industrialTypeOfFacilityTextField;
    private TextField commercialSizeTextField;
    private TextField commercialFloorsTextField;
    private TextField commercialUseTextField;
    private TextField residentialSizeTextField;
    private TextField residentialKitchensTextField;
    private TextField residentialBathroomsTextField;
    private TextField residentialPlumbingRoomsTextField;
    private TextField roadLengthTextField;
    private TextField roadWidthTextField;
    private TextField roadBridgesTextField;
    private TextField roadTunnelsTextField;
    private TextField roadChallengesTextField;

    /**
     * Constructor initializing the form fields
     */
    public FormFieldsBuilder() {

    }

    /**
     * Generates the form fields for the industrial project
     * @param disable if true the fields will be disabled
     * @param project the project that will be used to fill the fields
     * @return a VBox containing the form fields
     */
    public VBox generateIndustrialDetails(boolean disable, IndustrialProject project) {
        //industrial size
        Label industrialSizeLabel = new Label("Size (m^2): ");
        HBox industrialSizeLabelBox = new HBox(industrialSizeLabel);
        industrialSizeLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(industrialSizeLabelBox, new Insets(5, 0, 0, 10));

        this.industrialSizeTextField = new TextField();
        industrialSizeTextField.setPromptText("ex: 670.5");
        if (project != null) {
            industrialSizeTextField.setText(String.valueOf(project.getSize()));
        }
        industrialSizeTextField.setPrefWidth(175);
        industrialSizeTextField.setDisable(disable);
        HBox industrialSizeTextFieldBox = new HBox(industrialSizeTextField);
        industrialSizeTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(industrialSizeTextFieldBox, new Insets(5, 10, 0, 0));

        HBox industrialSizeBox = new HBox(industrialSizeLabelBox, industrialSizeTextFieldBox);
        HBox.setHgrow(industrialSizeLabelBox, Priority.ALWAYS);
        HBox.setHgrow(industrialSizeTextFieldBox, Priority.ALWAYS);

        //type of industrial facility
        Label industrialTypeOfFacilityLabel = new Label("Type of Facility: ");
        HBox industrialTypeOfFacilityLabelBox = new HBox(industrialTypeOfFacilityLabel);
        industrialTypeOfFacilityLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(industrialTypeOfFacilityLabelBox, new Insets(5, 0, 0, 10));

        this.industrialTypeOfFacilityTextField = new TextField();
        industrialTypeOfFacilityTextField.setPromptText("ex: warehouse");
        if (project != null) {
            industrialTypeOfFacilityTextField.setText(project.getTypeOfIndustrialFacility());
        }
        industrialTypeOfFacilityTextField.setPrefWidth(175);
        industrialTypeOfFacilityTextField.setDisable(disable);
        HBox industrialTypeOfFacilityTextFieldBox = new HBox(industrialTypeOfFacilityTextField);
        industrialTypeOfFacilityTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(industrialTypeOfFacilityTextFieldBox, new Insets(5, 10, 0, 0));

        HBox industrialTypeOfFacilityBox = new HBox(industrialTypeOfFacilityLabelBox, industrialTypeOfFacilityTextFieldBox);
        HBox.setHgrow(industrialTypeOfFacilityLabelBox, Priority.ALWAYS);
        HBox.setHgrow(industrialTypeOfFacilityTextFieldBox, Priority.ALWAYS);

        return new VBox(industrialSizeBox, industrialTypeOfFacilityBox);
    }

    /**
     * Generates the form fields for the commercial project
     * @param disable if true the fields will be disabled
     * @param project the project that will be used to fill the fields
     * @return a VBox containing the form fields
     */
    public VBox generateCommercialDetails(boolean disable, CommercialProject project) {
        //commercial size
        Label commercialSizeLabel = new Label("Size (m^2): ");
        HBox commercialSizeLabelBox = new HBox(commercialSizeLabel);
        commercialSizeLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(commercialSizeLabelBox, new Insets(5, 0, 0, 10));

        this.commercialSizeTextField = new TextField();
        commercialSizeTextField.setPromptText("ex: 670.5");
        if (project != null) {
            commercialSizeTextField.setText(String.valueOf(project.getSize()));
        }
        commercialSizeTextField.setPrefWidth(175);
        commercialSizeTextField.setDisable(disable);
        HBox commercialSizeTextFieldBox = new HBox(commercialSizeTextField);
        commercialSizeTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(commercialSizeTextFieldBox, new Insets(5, 10, 0, 0));

        HBox commercialSizeBox = new HBox(commercialSizeLabelBox, commercialSizeTextFieldBox);
        HBox.setHgrow(commercialSizeLabelBox, Priority.ALWAYS);
        HBox.setHgrow(commercialSizeTextFieldBox, Priority.ALWAYS);


        //commercial number of floors
        Label commercialFloorsLabel = new Label("Number of Floors: ");
        HBox commercialFloorsLabelBox = new HBox(commercialFloorsLabel);
        commercialFloorsLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(commercialFloorsLabelBox, new Insets(5, 0, 0, 10));

        this.commercialFloorsTextField = new TextField();
        commercialFloorsTextField.setText(DefaultFieldValues.COMMERCIAL_FLOORS);
        if (project != null) {
            commercialFloorsTextField.setText(String.valueOf(project.getNumberOfFloors()));
        }
        commercialFloorsTextField.setPrefWidth(175);
        commercialFloorsTextField.setDisable(disable);
        HBox commercialFloorsTextFieldBox = new HBox(commercialFloorsTextField);
        commercialFloorsTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(commercialFloorsTextFieldBox, new Insets(5, 10, 0, 0));

        HBox commercialFloorsBox = new HBox(commercialFloorsLabelBox, commercialFloorsTextFieldBox);
        HBox.setHgrow(commercialFloorsLabelBox, Priority.ALWAYS);
        HBox.setHgrow(commercialFloorsTextFieldBox, Priority.ALWAYS);


        //intended use of building
        Label commercialUseLabel = new Label("Intended Use: ");
        HBox commercialUseLabelBox = new HBox(commercialUseLabel);
        commercialUseLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(commercialUseLabelBox, new Insets(5, 0, 0, 10));

        this.commercialUseTextField = new TextField();
        commercialUseTextField.setPromptText("ex: Retail");
        if (project != null) {
            commercialUseTextField.setText(project.getIntendedUseOfBuilding());
        }
        commercialUseTextField.setPrefWidth(175);
        commercialUseTextField.setDisable(disable);
        HBox commercialUseTextFieldBox = new HBox(commercialUseTextField);
        commercialUseTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(commercialUseTextFieldBox, new Insets(5, 10, 0, 0));

        HBox commercialUseBox = new HBox(commercialUseLabelBox, commercialUseTextFieldBox);
        HBox.setHgrow(commercialUseLabelBox, Priority.ALWAYS);
        HBox.setHgrow(commercialUseTextFieldBox, Priority.ALWAYS);

        return new VBox(commercialSizeBox, commercialFloorsBox, commercialUseBox);
    }

    /**
     * Generates the form fields for the residential project
     * @param disable if true the fields will be disabled
     * @param project the project that will be used to fill the fields
     * @return a VBox containing the form fields
     */
    public VBox generateResidentialDetails(boolean disable, ResidentialProject project) {
        //residential size
        Label residentialSizeLabel = new Label("Size (m^2): ");
        HBox residentialSizeLabelBox = new HBox(residentialSizeLabel);
        residentialSizeLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(residentialSizeLabelBox, new Insets(5, 0, 0, 10));

        this.residentialSizeTextField = new TextField();
        residentialSizeTextField.setPromptText("ex: 670.5");
        if (project != null) {
            residentialSizeTextField.setText(String.valueOf(project.getSize()));
        }
        residentialSizeTextField.setPrefWidth(175);
        residentialSizeTextField.setDisable(disable);
        HBox residentialSizeTextFieldBox = new HBox(residentialSizeTextField);
        residentialSizeTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(residentialSizeTextFieldBox, new Insets(5, 10, 0, 0));

        HBox residentialSizeBox = new HBox(residentialSizeLabelBox, residentialSizeTextFieldBox);
        HBox.setHgrow(residentialSizeLabelBox, Priority.ALWAYS);
        HBox.setHgrow(residentialSizeTextFieldBox, Priority.ALWAYS);

        //residential number of kitchens
        Label residentialKitchensLabel = new Label("Number of Kitchens: ");
        HBox residentialKitchensLabelBox = new HBox(residentialKitchensLabel);
        residentialKitchensLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(residentialKitchensLabelBox, new Insets(5, 0, 0, 10));

        this.residentialKitchensTextField = new TextField();
        residentialKitchensTextField.setText(DefaultFieldValues.RESIDENTIAL_KITCHENS);
        if (project != null) {
            residentialKitchensTextField.setText(String.valueOf(project.getNumberOfKitchen()));
        }
        residentialKitchensTextField.setPrefWidth(175);
        residentialKitchensTextField.setDisable(disable);
        HBox residentialKitchensTextFieldBox = new HBox(residentialKitchensTextField);
        residentialKitchensTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(residentialKitchensTextFieldBox, new Insets(5, 10, 0, 0));

        HBox residentialKitchensBox = new HBox(residentialKitchensLabelBox, residentialKitchensTextFieldBox);
        HBox.setHgrow(residentialKitchensLabelBox, Priority.ALWAYS);
        HBox.setHgrow(residentialKitchensTextFieldBox, Priority.ALWAYS);

        //residential number of bathrooms
        Label residentialBathroomsLabel = new Label("Number of Bathrooms: ");
        HBox residentialBathroomsLabelBox = new HBox(residentialBathroomsLabel);
        residentialBathroomsLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(residentialBathroomsLabelBox, new Insets(5, 0, 0, 10));

        this.residentialBathroomsTextField = new TextField();
        residentialBathroomsTextField.setText(DefaultFieldValues.RESIDENTIAL_BATHROOMS);
        if (project != null) {
            residentialBathroomsTextField.setText(String.valueOf(project.getNumberOfBathrooms()));
        }
        residentialBathroomsTextField.setPrefWidth(175);
        residentialBathroomsTextField.setDisable(disable);
        HBox residentialBathroomsTextFieldBox = new HBox(residentialBathroomsTextField);
        residentialBathroomsTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(residentialBathroomsTextFieldBox, new Insets(5, 10, 0, 0));

        HBox residentialBathroomsBox = new HBox(residentialBathroomsLabelBox, residentialBathroomsTextFieldBox);
        HBox.setHgrow(residentialBathroomsLabelBox, Priority.ALWAYS);
        HBox.setHgrow(residentialBathroomsTextFieldBox, Priority.ALWAYS);

        //residential number of plumbing rooms
        Label residentialPlumbingRoomsLabel = new Label("Number of PlumbingRooms: ");
        HBox residentialPlumbingRoomsLabelBox = new HBox(residentialPlumbingRoomsLabel);
        residentialPlumbingRoomsLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(residentialPlumbingRoomsLabelBox, new Insets(5, 0, 0, 10));

        this.residentialPlumbingRoomsTextField = new TextField();
        residentialPlumbingRoomsTextField.setText(DefaultFieldValues.RESIDENTIAL_PLUMBING_ROOMS);
        if (project != null) {
            residentialPlumbingRoomsTextField.setText(String.valueOf(project.getNumberOfRoomsWithPlumbing()));
        }
        residentialPlumbingRoomsTextField.setPrefWidth(175);
        residentialPlumbingRoomsTextField.setDisable(disable);
        HBox residentialPlumbingRoomsTextFieldBox = new HBox(residentialPlumbingRoomsTextField);
        residentialPlumbingRoomsTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(residentialPlumbingRoomsTextFieldBox, new Insets(5, 10, 0, 0));

        HBox residentialPlumbingRoomsBox = new HBox(residentialPlumbingRoomsLabelBox, residentialPlumbingRoomsTextFieldBox);
        HBox.setHgrow(residentialPlumbingRoomsLabelBox, Priority.ALWAYS);
        HBox.setHgrow(residentialPlumbingRoomsTextFieldBox, Priority.ALWAYS);

        return new VBox(residentialSizeBox, residentialKitchensBox, residentialBathroomsBox, residentialPlumbingRoomsBox);
    }

    /**
     * Generates the form fields for the road project
     * @param disable if true the fields will be disabled
     * @param project the project that will be used to fill the fields
     * @return a VBox containing the form fields
     */
    public VBox generateRoadDetails(boolean disable, RoadConstructionProject project) {
        //road length
        Label roadLengthLabel = new Label("Length (m): ");
        HBox roadLengthLabelBox = new HBox(roadLengthLabel);
        roadLengthLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(roadLengthLabelBox, new Insets(5, 0, 0, 10));

        this.roadLengthTextField = new TextField();
        roadLengthTextField.setPromptText("ex: 670.5");
        if (project != null) {
            roadLengthTextField.setText(String.valueOf(project.getLength()));
        }
        roadLengthTextField.setPrefWidth(175);
        roadLengthTextField.setDisable(disable);
        HBox roadLengthTextFieldBox = new HBox(roadLengthTextField);
        roadLengthTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(roadLengthTextFieldBox, new Insets(5, 10, 0, 0));

        HBox roadLengthBox = new HBox(roadLengthLabelBox, roadLengthTextFieldBox);
        HBox.setHgrow(roadLengthLabelBox, Priority.ALWAYS);
        HBox.setHgrow(roadLengthTextFieldBox, Priority.ALWAYS);

        //road width
        Label roadWidthLabel = new Label("Width (m): ");
        HBox roadWidthLabelBox = new HBox(roadWidthLabel);
        roadWidthLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(roadWidthLabelBox, new Insets(5, 0, 0, 10));

        this.roadWidthTextField = new TextField();
        roadWidthTextField.setPromptText("ex: 670.5");
        if (project != null) {
            roadWidthTextField.setText(String.valueOf(project.getWidth()));
        }
        roadWidthTextField.setPrefWidth(175);
        roadWidthTextField.setDisable(disable);
        HBox roadWidthTextFieldBox = new HBox(roadWidthTextField);
        roadWidthTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(roadWidthTextFieldBox, new Insets(5, 10, 0, 0));

        HBox roadWidthBox = new HBox(roadWidthLabelBox, roadWidthTextFieldBox);
        HBox.setHgrow(roadWidthLabelBox, Priority.ALWAYS);
        HBox.setHgrow(roadWidthTextFieldBox, Priority.ALWAYS);

        //road number of bridges
        Label roadBridgesLabel = new Label("Number of Bridges: ");
        HBox roadBridgesLabelBox = new HBox(roadBridgesLabel);
        roadBridgesLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(roadBridgesLabelBox, new Insets(5, 0, 0, 10));

        this.roadBridgesTextField = new TextField();
        roadBridgesTextField.setText(DefaultFieldValues.ROAD_BRIDGES);
        if (project != null) {
            roadBridgesTextField.setText(String.valueOf(project.getNumberOfBridge()));
        }
        roadBridgesTextField.setPrefWidth(175);
        roadBridgesTextField.setDisable(disable);
        HBox roadBridgesTextFieldBox = new HBox(roadBridgesTextField);
        roadBridgesTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(roadBridgesTextFieldBox, new Insets(5, 10, 0, 0));

        HBox roadBridgesBox = new HBox(roadBridgesLabelBox, roadBridgesTextFieldBox);
        HBox.setHgrow(roadBridgesLabelBox, Priority.ALWAYS);
        HBox.setHgrow(roadBridgesTextFieldBox, Priority.ALWAYS);

        //road number of tunnels
        Label roadTunnelsLabel = new Label("Number of Tunnels: ");
        HBox roadTunnelsLabelBox = new HBox(roadTunnelsLabel);
        roadTunnelsLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(roadTunnelsLabelBox, new Insets(5, 0, 0, 10));

        this.roadTunnelsTextField = new TextField();
        roadTunnelsTextField.setPromptText("ex: 2");
        if (project != null) {
            roadTunnelsTextField.setText(String.valueOf(project.getNumberOfTunnels()));
        }
        roadTunnelsTextField.setPrefWidth(175);
        roadTunnelsTextField.setDisable(disable);
        HBox roadTunnelsTextFieldBox = new HBox(roadTunnelsTextField);
        roadTunnelsTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(roadTunnelsTextFieldBox, new Insets(5, 10, 0, 0));

        HBox roadTunnelsBox = new HBox(roadTunnelsLabelBox, roadTunnelsTextFieldBox);
        HBox.setHgrow(roadTunnelsLabelBox, Priority.ALWAYS);
        HBox.setHgrow(roadTunnelsTextFieldBox, Priority.ALWAYS);

        //road env challenges
        Label roadChallengesLabel = new Label("Any Environmental Challenges: ");
        HBox roadChallengesLabelBox = new HBox(roadChallengesLabel);
        roadChallengesLabelBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(roadChallengesLabelBox, new Insets(5, 0, 0, 10));

        this.roadChallengesTextField = new TextField();
        roadChallengesTextField.setText(DefaultFieldValues.ROAD_ENV_GEO_CHALLENGES);
        if (project != null) {
            roadChallengesTextField.setText(project.getEnvOrGeoChallenges());
        }
        roadChallengesTextField.setPrefWidth(175);
        roadChallengesTextField.setDisable(disable);
        HBox roadChallengesTextFieldBox = new HBox(roadChallengesTextField);
        roadChallengesTextFieldBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(roadChallengesTextFieldBox, new Insets(5, 10, 0, 0));

        HBox roadChallengesBox = new HBox(roadChallengesLabelBox, roadChallengesTextFieldBox);
        HBox.setHgrow(roadChallengesLabelBox, Priority.ALWAYS);
        HBox.setHgrow(roadChallengesTextFieldBox, Priority.ALWAYS);

        return new VBox(roadLengthBox, roadWidthBox, roadBridgesBox, roadTunnelsBox, roadChallengesBox);
    }

    /**
     * Getter for the commercialFloorsTextField
     * @return the commercialFloorsTextField
     */
    public TextField getCommercialFloorsTextField() {
        return commercialFloorsTextField;
    }

    /**
     * Getter for the commercialSizeTextField
     * @return the commercialSizeTextField
     */
    public TextField getCommercialSizeTextField() {
        return commercialSizeTextField;
    }

    /**
     * Getter for the commercialUseTextField
     * @return the commercialUseTextField
     */
    public TextField getCommercialUseTextField() {
        return commercialUseTextField;
    }

    /**
     * Getter for the industrialSizeTextField
     * @return the industrialSizeTextField
     */
    public TextField getIndustrialSizeTextField() {
        return industrialSizeTextField;
    }

    /**
     * Getter for the industrialTypeOfFacilityTextField
     * @return the industrialTypeOfFacilityTextField
     */
    public TextField getIndustrialTypeOfFacilityTextField() {
        return industrialTypeOfFacilityTextField;
    }

    /**
     * Getter for the residentialBathroomsTextField
     * @return the residentialBathroomsTextField
     */
    public TextField getResidentialBathroomsTextField() {
        return residentialBathroomsTextField;
    }

    /**
     * Getter for the residentialKitchensTextField
     * @return the residentialKitchensTextField
     */
    public TextField getResidentialKitchensTextField() {
        return residentialKitchensTextField;
    }

    /**
     * Getter for the residentialPlumbingRoomsTextField
     * @return the residentialPlumbingRoomsTextField
     */
    public TextField getResidentialPlumbingRoomsTextField() {
        return residentialPlumbingRoomsTextField;
    }

    /**
     * Getter for the residentialSizeTextField
     * @return the residentialSizeTextField
     */
    public TextField getResidentialSizeTextField() {
        return residentialSizeTextField;
    }

    /**
     * Getter for the roadBridgesTextField
     * @return the roadBridgesTextField
     */
    public TextField getRoadBridgesTextField() {
        return roadBridgesTextField;
    }

    /**
     * Getter for the roadChallengesTextField
     * @return the roadChallengesTextField
     */
    public TextField getRoadChallengesTextField() {
        return roadChallengesTextField;
    }

    /**
     * Getter for the roadLengthTextField
     * @return the roadLengthTextField
     */
    public TextField getRoadLengthTextField() {
        return roadLengthTextField;
    }

    /**
     * Getter for the roadTunnelsTextField
     * @return the roadTunnelsTextField
     */
    public TextField getRoadTunnelsTextField() {
        return roadTunnelsTextField;
    }

    /**
     * Getter for the roadWidthTextField
     * @return the roadWidthTextField
     */
    public TextField getRoadWidthTextField() {
        return roadWidthTextField;
    }

}
