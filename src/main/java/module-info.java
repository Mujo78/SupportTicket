module ptf.rs.mujokalabuzic_rs_z4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;
    requires java.sql;



    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.persistence;
    opens ptf.rs.models to org.hibernate.orm.core;


    opens ptf.rs to javafx.fxml;
    opens ptf.rs.controllers to javafx.fxml;
    exports ptf.rs;
    exports ptf.rs.controllers;
    exports ptf.rs.models;
    exports ptf.rs.repository;
}