package model;

public class RequestStatus {
    private int statusId;
    private String name;

    public RequestStatus() {
    }

    public RequestStatus(int statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestStatus{" + "statusId=" + statusId + ", name=" + name + '}';
    }
    
    
}
