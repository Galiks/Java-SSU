package com.turchenkov.NewSpring.dataTransferObject;

public class RollbackDto {

    private Long operationID;

    public RollbackDto() {
    }

    public RollbackDto(Long operationID) {
        this.operationID = operationID;
    }

    public Long getOperationID() {
        return operationID;
    }

    public void setOperationID(Long operationID) {
        this.operationID = operationID;
    }

    @Override
    public String toString() {
        return "RollbackDto{" +
                "operationID=" + operationID +
                '}';
    }
}
