# JavaFX Project with Embedded Static Website

This project contains a JavaFX application along with a static website located in the `sep1-website` folder.

## Project Structure

- `src/`: Contains the JavaFX application code.
- `sep1-website/`: Contains the static website files (HTML, CSS, JS).

## Setup and Running the JavaFX Application

### Requirements
- Java Development Kit (JDK)
- IntelliJ IDEA (or any other Java IDE)
- JavaFX SDK (included in JDK 11 and later)

### Steps to Run the JavaFX Application

1. Clone this repository.
2. Open IntelliJ IDEA.
3. Click on `File` -> `Open` and select the cloned project.
4. Set up JDK:
    - Go to `File` -> `Project Structure`.
    - Under `Project Settings`, select `Project` -> `Project SDK` and choose your installed JDK.
5. Configure JavaFX:
    - Go to `Run` -> `Edit Configurations`.
    - Click on the `+` icon and choose `Application`.
    - Set the following:
        - Name: `<Your Application Name>`
        - Main class: `<Your Main JavaFX Class>`
        - VM options: `--module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml`
6. Apply the changes and click `OK`.
7. Run the application by clicking the green `Run` button in IntelliJ.

## Opening the Static Website

To view the static website:

1. Navigate to the `sep1-website` folder in the project.
2. Locate the `index.html` file.
3. Right-click on `index.html` and select `Open in Browser` to view it in your default browser.
4. You can also serve the website using a local server such as [http-server](https://www.npmjs.com/package/http-server).

## Additional Notes

- You can modify the JavaFX application in the `src/` directory.
- Any changes to the static website can be made within the `sep1-website/` folder.

Feel free to reach out for any additional help or clarification.