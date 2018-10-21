package com.rosebuds.prasad.schoolproject;

class Parents {

    String name,email,pnum,studId;

    public Parents(){}

    public Parents(String name, String email, String pnum, String studId) {
        this.name = name;
        this.email = email;
        this.pnum = pnum;
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPnum() {
        return pnum;
    }

    public String getStudId() {
        return studId;
    }
}
