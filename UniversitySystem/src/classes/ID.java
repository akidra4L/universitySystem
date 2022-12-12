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
    
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return this.dateExpiration;
    }
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
