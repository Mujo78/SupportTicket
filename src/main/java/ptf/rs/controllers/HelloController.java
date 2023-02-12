package ptf.rs.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ptf.rs.Config;
import ptf.rs.View;
import ptf.rs.models.SupportTicket;
import ptf.rs.repository.CRUDRepository;
import ptf.rs.utils.Utilities;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


        @FXML
        public TableView<SupportTicket> ticketTable;

    private final CRUDRepository<SupportTicket> spportRepository;
    public HelloController(CRUDRepository<SupportTicket> spportRepository) {
        this.spportRepository = spportRepository;
    }

    public HelloController(){
        this(Config.ticket);
    }
    @FXML
    void showNewTicketForm(ActionEvent event) {
        Utilities.displaySeparateModel("New ticket", View.createView("views/supportTicketForm.fxml"));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadItems();
        ticketTable.refresh();
    }
    @FXML
    void refreshPage(ActionEvent event) {
        reloadItems();
        ticketTable.refresh();
    }

    @FXML
    void showAgentAdding(ActionEvent event) {
        Utilities.displaySeparateModel("New agent", View.createView("views/addAgent.fxml"));
    }

    public void reloadItems(){
        ticketTable.setItems(FXCollections.observableArrayList(spportRepository.readAll()));
    }

}