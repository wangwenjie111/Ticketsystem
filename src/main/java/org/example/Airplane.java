package org.example;

public class Airplane {
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber) {
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;
        validateTotalSeats();
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {

        this.businessSitsNumber = businessSitsNumber;
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economySitsNumber) {

        this.economySitsNumber = economySitsNumber;
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }
    public void setCrewSitsNumber(int crewSitsNumber) {

        this.crewSitsNumber = crewSitsNumber;
    }

    private void validateTotalSeats() {
        int totalSeats = businessSitsNumber + economySitsNumber + crewSitsNumber;
        if (totalSeats < 1 || totalSeats > 300) {
            throw new IllegalArgumentException("Total seats number must be in the range [1, 300]");
        }
    }

    public String toString() {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

    public static Airplane getAirPlaneInfo(int airplane_id) {
        // TODO Auto-generated method stub
        return null;
    }
}