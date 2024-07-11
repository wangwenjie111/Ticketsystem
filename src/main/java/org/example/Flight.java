package org.example;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;


public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;

    public Flight(){}
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane)
    {
        this.flightID=flight_id;
        this.departTo = departTo;
        this.departFrom = departFrom;
        this.code = code;
        this.company = company;
        this.airplane = airplane;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid) {
        this.flightID = flightid;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString()
    {
        return "Flight{" + airplane.toString() +
                ", date to=" +  getDateTo() + ", " + '\'' +
                ", date from='" + getDateFrom() + '\'' +
                ", depart from='" + getDepartFrom() + '\'' +
                ", depart to='" + getDepartTo() + '\'' +
                ", code=" + getCode() + '\'' +
                ", company=" + getCompany() + '\'' +
                ", code=" + getCode() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Flight flight;
        Airplane airplane;
        airplane = new Airplane(1, "Boeing 737", 12, 150, 6);
        flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane);

        Timestamp invalidDate =flight.getDateTo(); // 日期格式无效
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy, HH:mm:ss");
        String formattedTimestamp1 = dateFormat.format(invalidDate);
        System.out.println(formattedTimestamp1);
        System.out.println(formattedTimestamp1.equals(invalidDate));
    }
}
