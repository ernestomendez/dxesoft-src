package mx.com.oxsoftware.dxesoft.model.entities.contact;

import com.fasterxml.jackson.annotation.JsonBackReference;
import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import mx.com.oxsoftware.dxesoft.utils.PhoneType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ernesto on 12/11/14.
 *
 * Represents the Phone numbers in the database.
 */
@Entity
@Table(name = "phone_number")
public class PhoneNumber extends AbstractEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_id", referencedColumnName = "Id")
    @JsonBackReference
    private Contact contact;

    @Column(name = "International_code", length = 3)
    private String internationalCode;

    @Column(name = "Phone_number", length = 14)
    private String number;

    @Column(name = "extension", length = 5)
    private String extension;

    @Column(name = "Phone_type")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(String internationalCode) {
        this.internationalCode = internationalCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
