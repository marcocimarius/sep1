package org.example.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * A menu bar containing options for the user to choose from.
 * @version 1.0
 * @author Dimitar Nizamov, Marius Marcoci
 */
public class OptionsMenu extends MenuBar {
    private Menu optionsMenu;

    private MenuItem addNewMenuItem;
    private MenuItem refreshMenuItem;
    private MenuItem exitMenuItem;

    /**
     * Constructor initializing the options menu
     * Adds all the menu items to the menu
     */
    public OptionsMenu() {
        super();
        optionsMenu = new Menu("Options");
        addNewMenuItem = new MenuItem("Add New");
        refreshMenuItem = new MenuItem("Refresh");
        exitMenuItem = new MenuItem("Exit");
        optionsMenu.getItems().addAll(addNewMenuItem, refreshMenuItem, exitMenuItem);
        this.getMenus().add(optionsMenu);
    }

    /**
     * Getter for the addNewMenuItem
     * @return the addNewMenuItem
     */
    public MenuItem getAddNewMenuItem() {
        return addNewMenuItem;
    }

    /**
     * Getter for the refreshMenuItem
     * @return the refreshMenuItem
     */
    public MenuItem getRefreshMenuItem() {
        return refreshMenuItem;
    }

    /**
     * Getter for the exitMenuItem
     * @return the exitMenuItem
     */
    public MenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    /**
     * Adds an event handler to handle when the refresh menu item is clicked
     * @param event The event handler that will be added
     */
    public void onRefreshMenuItemClick(EventHandler<ActionEvent> event) {
        refreshMenuItem.setOnAction(event);
    }

}
