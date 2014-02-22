package lv.vdm.wout.domain.body;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BodyPart {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;

    //todo remove EAGER and configure OpenSessionInViewFilter for view generation?
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyPart", fetch = FetchType.EAGER)
    private Set<Muscle> muscles = new HashSet<>();

    @SuppressWarnings("unused")
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

    public Set<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(Set<Muscle> muscles) {
        this.muscles = muscles;
    }
}
