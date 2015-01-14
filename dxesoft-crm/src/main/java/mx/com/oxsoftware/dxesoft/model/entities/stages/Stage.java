package mx.com.oxsoftware.dxesoft.model.entities.stages;

import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Date: 1/12/15
 * User: ernesto
 *
 * Represents the stages that an opportunity can be in.
 */
@Entity
@Table(name = "stage")
public class Stage extends AbstractEntity {

    @Column(name = "Stage_name")
    private String stageName;

    @Column(name = "Active")
    private boolean isActive;

    @Column(name = "Order")
    private int order;

    @Column(name = "Is_final")
    private boolean isFinal;

    @Column(name = "Creation_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }
}
