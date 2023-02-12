package ptf.rs.utils;

public class Validators {
    public static void checkRequiredField(String con, String fieldName){
        if(con.isBlank()) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
    }
    public static void checkNaslovLength(String con, String fieldName){
        if(con.isBlank()) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
        if(con.length() > 500) throw new IllegalStateException("\"" + fieldName + " cannot have more than 500 characters!!");
    }
    public static void checkNazivOsobeLength(String con, String fieldName){
        if(con.isBlank()) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
        if(con.length() > 100) throw new IllegalStateException("\"" + fieldName + " cannot have more than 500 characters!!");
    }
    public static void checkOpisLength(String con, String fieldName){
        if(con.isBlank()) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
        if(con.length() > 5000) throw new IllegalStateException("\"" + fieldName + " cannot have more than 500 characters!!");
    }

}
