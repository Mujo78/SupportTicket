package ptf.rs.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class SupportTicket extends BaseClass {
    private String nazivProblema; // 500 karaktera najvise
    private String nazivOsobe; // 100 karaktera
    private String datumVrijemePrijave;
    private String opisProblema;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ticket_agent",
            joinColumns = {@JoinColumn(name = "ticketID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "agentID", referencedColumnName = "id")}
    )
    private Set<Agent> selectAgent;
    private String emailPrijave;
    private String telefonPrijave;

    private LocalDateTime datumRjesavanja = LocalDateTime.now();

    private String statusProblema = "Otvoren";
    @Enumerated(EnumType.ORDINAL)
    private Prioritet prioriteti;

    @Enumerated(EnumType.ORDINAL)
    private NacinPrijave nacinPrijave;
    @Enumerated(EnumType.ORDINAL)
    private TipUsluge tipUsluge;

    @Override
    public String toString() {
        return "SupportTicket{" +
                "nazivProblema='" + nazivProblema + '\'' +
                ", nazivOsobe='" + nazivOsobe + '\'' +
                ", datumVrijemePrijave='" + datumVrijemePrijave + '\'' +
                ", opisProblema='" + opisProblema + '\'' +
                ", selectAgent=" + selectAgent +
                ", emailPrijave='" + emailPrijave + '\'' +
                ", telefonPrijave='" + telefonPrijave + '\'' +
                ", prioriteti=" + prioriteti +
                ", nacinPrijave=" + nacinPrijave +
                ", tipUsluge=" + tipUsluge +
                '}';
    }

    public LocalDateTime getDatumRjesavanja() {
        return datumRjesavanja;
    }

    public void setDatumRjesavanja(LocalDateTime datumRjesavanja) {
        this.datumRjesavanja = datumRjesavanja;
    }

    public String getStatus() {
        return statusProblema;
    }

    public void setStatus(String status) {
        this.statusProblema = status;
    }

    public String getNazivProblema() {
        return nazivProblema;
    }

    public void setNazivProblema(String nazivProblema) {
        this.nazivProblema = nazivProblema;
    }

    public String getNazivOsobe() {
        return nazivOsobe;
    }


    public void setNazivOsobe(String nazivOsobe) {
        this.nazivOsobe = nazivOsobe;
    }

    public String getDatumVrijemePrijave() {
        return datumVrijemePrijave;
    }

    public void setDatumVrijemePrijave(String datumVrijemePrijave) {
        this.datumVrijemePrijave = datumVrijemePrijave;
    }

    public String getOpisProblema() {
        return opisProblema;
    }

    public void setOpisProblema(String opisProblema) {
        this.opisProblema = opisProblema;
    }

    public Set<Agent> getSelectAgent() {
        return selectAgent;
    }

    public String getSelectAgentString() {
        return selectAgent.stream().map(Agent::getNazivAgenta).collect(Collectors.joining(", "));
    }

    public void setSelectAgent(Set<Agent> selectAgent) {
        this.selectAgent = selectAgent;
    }

    public String getEmailPrijave() {
        return emailPrijave;
    }

    public void setEmailPrijave(String emailPrijave) {
        this.emailPrijave = emailPrijave;
    }

    public String getTelefonPrijave() {
        return telefonPrijave;
    }

    public void setTelefonPrijave(String telefonPrijave) {
        this.telefonPrijave = telefonPrijave;
    }

    public Prioritet getPrioriteti() {
        return prioriteti;
    }

    public void setPrioriteti(Prioritet prioriteti) {
        this.prioriteti = prioriteti;
    }

    public NacinPrijave getNacinPrijave() {
        return nacinPrijave;
    }

    public void setNacinPrijave(NacinPrijave nacinPrijave) {
        this.nacinPrijave = nacinPrijave;
    }

    public TipUsluge getTipUsluge() {
        return tipUsluge;
    }

    public void setTipUsluge(TipUsluge tipUsluge) {
        this.tipUsluge = tipUsluge;
    }

    public enum TipUsluge{
        PITANJE("Pitanje"), INCIDENT("Incident"), PROBLEM("Problem"),ZAHTJEV_ZA_PROMJENOM("Zahtjev za promjenom");

        private final String name;

        TipUsluge(String name){ this.name=name;}

        @Override
        public String toString() {
            return name;
        }
    }
    public enum NacinPrijave{
        EMAIL("Email"), TELEFON("Telefon"), WEB_STRANICA("Web stranica");

        private final String name;

        NacinPrijave(String name){ this.name=name;}

        @Override
        public String toString() {
            return name;
        }
    }
    public enum Prioritet{
        NISKO("Nisko"), SREDNJE("Srednje"), VISOKO("Visoko"), HITNO("Hitno");

        private final String name;

        Prioritet(String name){ this.name=name;}

        @Override
        public String toString() {
            return name;
        }
    }
}
