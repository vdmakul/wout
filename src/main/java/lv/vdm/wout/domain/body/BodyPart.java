package lv.vdm.wout.domain.body;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class BodyPart {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;

    @Transient
    private BodyPart placement; //todo

    //todo remove EAGER and configure OpenSessionInViewFilter for view generation?
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyPart", fetch = FetchType.EAGER)
    private Collection<Muscle> muscles;

    protected BodyPart() {
    }

    public BodyPart(String uniqueCode, String name) {
        this.uniqueCode = uniqueCode;
        this.name = name;
    }

    public void attach(Muscle muscle) {
        getMuscles().add(muscle);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BodyPart getPlacement() {
        return placement;
    }

    public void setPlacement(BodyPart placement) {
        this.placement = placement;
    }

    public Collection<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(Collection<Muscle> muscles) {
        this.muscles = muscles;
    }
}
