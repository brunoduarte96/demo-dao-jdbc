package db;

public class DbINtegrityException extends  RuntimeException {

    public DbINtegrityException(String msg){
        super(msg);
    }
}
