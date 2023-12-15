package org.example.exeptions;

public class ProcedureNotFoundException extends RuntimeException{
    public ProcedureNotFoundException() {
        super("Procedure not found");
    }
}
