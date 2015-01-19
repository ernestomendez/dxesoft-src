package mx.com.oxsoftware.dxesoft.model.entities.contact;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import mx.com.oxsoftware.dxesoft.utils.CustomDateDeserializer;
import mx.com.oxsoftware.dxesoft.utils.CustomDateSerializer;
import mx.com.oxsoftware.dxesoft.utils.Gender;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ernesto on 11/8/14.
 *
 * Represents the contact into the data base.
 */
@Entity
@Table(name = "contact")
@XmlRootElement
public class Contact extends AbstractEntity {

    @Column(name = "Contact_name", length = 200)
    private String contactName;

    @Column(name = "Last_name", length = 60)
    private String lastName;

    @Column(name = "Apellido_materno", length = 60)
    private String apellidoMaterno;

//    @Column(length = 50)
//    private String titulo;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "Web_page")
    private String webPage;

    @Column(name = "Creation_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private DateTime creationDate;

    @Column(name = "Birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private DateTime birthDate;

//    @Column(length = 15)
//    private String rfc;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Email> emails;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> addresses;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
