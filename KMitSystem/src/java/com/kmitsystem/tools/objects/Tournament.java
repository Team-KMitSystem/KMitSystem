package com.kmitsystem.tools.objects;

import com.kmitsystem.tools.DateKonverter;
import java.sql.Date;
import java.util.List;

/**
 * @author Malte
 */
public class Tournament { 
    
    private String name;
    private String password;
    private String description;
    private User leader;
    private Date start_date;
    private Date end_date;
    private Date create_date;
    private int nr_matchdays;
    private String venue;
    private Date term_of_application;
    private List<Table> table;
    
    public Tournament() {
        super();
    }
    
    public Tournament(String name) {
        this.name = name;
    }

    public Tournament(String name, String password, String description, User leader, Date start_date, Date end_date, Date create_date, int nr_matchdays, String venue, Date term_of_application) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.leader = leader;
        this.start_date = start_date;
        this.end_date = end_date;
        this.create_date = create_date;
        this.nr_matchdays = nr_matchdays;
        this.venue = venue;
        this.term_of_application = term_of_application;
    }

    public Tournament(String name, String password, String description, User leader, Date start_date, Date end_date, Date create_date, int nr_matchdays, String venue, Date term_of_application, List<Table> table) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.leader = leader;
        this.start_date = start_date;
        this.end_date = end_date;
        this.create_date = create_date;
        this.nr_matchdays = nr_matchdays;
        this.venue = venue;
        this.term_of_application = term_of_application;
        this.table = table;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }
    
    public String getStart_date() {
        return DateKonverter.getWebDateString(start_date);
    }
    
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return DateKonverter.getWebDateString(end_date);
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getNr_matchdays() {
        return nr_matchdays;
    }

    public void setNr_matchdays(int nr_matchdays) {
        this.nr_matchdays = nr_matchdays;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTerm_of_application() {
        return DateKonverter.getWebDateString(term_of_application);
    }

    public void setTerm_of_application(Date term_of_application) {
        this.term_of_application = term_of_application;
    }

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Tournament{" + "name=" + name + ", password=" + password + ", description=" + description + ", leader=" + leader + ", start_date=" + start_date + ", end_date=" + end_date + ", create_date=" + create_date + ", nr_matchdays=" + nr_matchdays + ", venue=" + venue + ", term_of_application=" + term_of_application + ", table=" + table + '}';
    }
}


