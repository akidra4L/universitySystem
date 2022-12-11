package classes;

public class ID {
    private String numberID;
    private boolean isAvailable;
    private Date dateCreation;
    private Date dateExpiration;
    
    public String getNumberID() {
        return this.numberID;
    }
    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }
    
    private boolean getIsAvailable() {
        return this.isAvailable;
    }
    private void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    private Date getDateCreation() {
        return this.dateCreation;
    }
    private void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    private Date getDateExpiration() {
        return this.dateExpiration;
    }
    private void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
