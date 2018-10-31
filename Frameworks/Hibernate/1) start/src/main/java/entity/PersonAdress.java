package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable  // юзается в др
public class PersonAdress {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "house")
    private String house;

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return house;
    }
    public void setAddress(String house) {
        this.house = house;
    }
    @Override
    public String toString() {
        return "PersonAdress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + house + '\'' +
                '}';
    }
}
