package Student_Management_System;

class Address {

    String street = null;
    String landmark = null;
    String district = null;
    String state = null;
    String country = null;

    public Address() {
    }

    public Address(String street, String landmark, String district, String state, String country) {
        this.street = street;
        this.landmark = landmark;
        this.district = district;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", landmark=" + landmark + ", district=" + district + ", state=" + state + '}';
    }

}
