package ptf.rs.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ptf.rs.Config;
import ptf.rs.models.Agent;
import ptf.rs.models.SupportTicket;
import ptf.rs.repository.CRUDRepository;
import ptf.rs.utils.Utilities;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import static ptf.rs.utils.Validators.*;

public class SupportTicketFormController implements Initializable {


        @FXML
        public ListView<Agent> agentList;


    @FXML
        private TextField datumObjave;

        @FXML
        private TextField emailUsera;

        @FXML
        private TextField imeUsera;

        @FXML
        private ComboBox<SupportTicket.NacinPrijave> nacinBox;

        @FXML
        private TextField nazivProblema;

        @FXML
        private TextArea opisProblema;

        @FXML
        private ComboBox<SupportTicket.Prioritet> prioritetBox;

        @FXML
        private TextField telefonUser;

        @FXML
        private ComboBox<SupportTicket.TipUsluge> tipBox;

        private SupportTicket createOne;


        private final CRUDRepository<SupportTicket> supportTicketRepository;

    private final CRUDRepository<Agent> agentRepository;
        public SupportTicketFormController(CRUDRepository<SupportTicket> supportTicketRepository, CRUDRepository<Agent> agentRepository) {
                this.supportTicketRepository = supportTicketRepository;

            this.agentRepository = agentRepository;
        }

    public SupportTicketFormController() {
            this(Config.ticket, Config.agents);
    }

    @FXML
        public void addNewSupportTicket(ActionEvent event) {
                try{
                    checkNazivOsobeLength(imeUsera.getText(), "Korisničko ime");
                    checkNaslovLength(nazivProblema.getText(), "Naziv problema");
                    checkOpisLength(opisProblema.getText(), "Opis problema");
                    checkRequiredField(datumObjave.getText(), "Datum objave");
                    List<Agent> agentSelected = agentList.getSelectionModel().getSelectedItems();

              createOne.setTipUsluge(tipBox.getSelectionModel().getSelectedItem());
                 createOne.setNazivProblema(nazivProblema.getText());
                createOne.setNazivOsobe(imeUsera.getText());
                   createOne.setDatumVrijemePrijave(datumObjave.getText());
               createOne.setNacinPrijave(nacinBox.getSelectionModel().getSelectedItem());
                 createOne.setPrioriteti(prioritetBox.getSelectionModel().getSelectedItem());
                 createOne.setOpisProblema(opisProblema.getText());
                    createOne.setSelectAgent(new HashSet<>(agentSelected));
                  createOne.setEmailPrijave(emailUsera.getText());
                 createOne.setStatus(createOne.getStatus());
                 createOne.setDatumRjesavanja(LocalDateTime.now());
             createOne.setTelefonPrijave(telefonUser.getText());
                    supportTicketRepository.save(createOne);


                    System.out.println(createOne);
                }catch (Exception ex){
                        Utilities.displayAlertMessage(ex.getMessage());
                }
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            reloadItems();
                tipBox.getItems().addAll(SupportTicket.TipUsluge.values());
                tipBox.getSelectionModel().selectFirst();

                nacinBox.getItems().addAll(SupportTicket.NacinPrijave.values());
                nacinBox.getSelectionModel().selectFirst();

                prioritetBox.getItems().addAll(SupportTicket.Prioritet.values());
                prioritetBox.getSelectionModel().selectFirst();


                agentList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                setCreateOne(new SupportTicket());


    }

        public void setCreateOne(SupportTicket createOne) {
                this.createOne = createOne;
                imeUsera.setText(createOne.getNazivOsobe());
                nazivProblema.setText(createOne.getNazivProblema());
                opisProblema.setText(createOne.getOpisProblema());
                emailUsera.setText(createOne.getEmailPrijave());

                telefonUser.setText(createOne.getTelefonPrijave());
                datumObjave.setText(createOne.getDatumVrijemePrijave());

                if (createOne.getSelectAgent() != null) {
                        agentList.getSelectionModel().clearSelection();
                        createOne.getSelectAgent().forEach(agents -> agentList.getSelectionModel().select(agents));
                }
        }

    public void reloadItems() {
        agentList.setItems(FXCollections.observableList(agentRepository.readAll()));
    }

}
