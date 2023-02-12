package ptf.rs.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import ptf.rs.Config;
import ptf.rs.models.Agent;
import ptf.rs.repository.CRUDRepository;
import ptf.rs.utils.Utilities;

import java.net.URL;
import java.util.ResourceBundle;

import static ptf.rs.utils.Validators.checkRequiredField;

public class AgentController implements Initializable {


        @FXML
        private TextField fullNameAgent;

        private Agent newAgent;

        private final CRUDRepository<Agent> agentRepository;

    public AgentController(CRUDRepository<Agent> agentRepository) {
        this.agentRepository = agentRepository;
    }

    public AgentController(){
        this(Config.agents);
    }
    @FXML
    void saveAgent(ActionEvent event) {
        try{
            checkRequiredField(fullNameAgent.getText(), "Full name");

            newAgent.setNazivAgenta(fullNameAgent.getText());

            agentRepository.save(newAgent);
            System.out.println("Uspjesno spremljen agent");
        }catch (Exception e){
            Utilities.displayAlertMessage(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNewAgent(new Agent());
    }


    public void setNewAgent(Agent newAgent) {
        this.newAgent = newAgent;
        fullNameAgent.setText(newAgent.getNazivAgenta());
    }
}

