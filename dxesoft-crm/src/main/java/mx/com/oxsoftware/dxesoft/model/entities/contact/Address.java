package mx.com.oxsoftware.dxesoft.model.entities.contact;

import com.fasterxml.jackson.annotation.JsonBackReference;
import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Date: 1/12/15
 * User: ernesto
 */
@Entity
@Table(name = "address")
public class Address extends AbstractEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_id", referencedColumnName = "Id")
    @JsonBackReference
    private Contact contact;

    @Column(name = "Street", length = 100)
    private String street;

    @Column(name = "Street_type", length = 80)
    private String streetType;

    @Column(name = "Street_number", length = 10)
    private String streetNumber;

    @Column(name = "Apartment_number", length = 10)
    private String appartmentNumber;

    @Column(name = "Colonia", length = 100)
    private String colonia;

    @Column(name = "Zip_code", length = 10)
    private String zipCode;

    @Column(name = "Address_type", length = 45)
    private String addressType;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}
