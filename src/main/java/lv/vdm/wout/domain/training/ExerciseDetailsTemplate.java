package lv.vdm.wout.domain.training;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ExerciseDetailsTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    protected Double weight;
    protected Integer repCount;
    protected Double distance;
    protected Integer executionDuration;
    protected Integer durationOfRest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getRepCount() {
        return repCount;
    }

    public void setRepCount(Integer repCount) {
        this.repCount = repCount;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getExecutionDuration() {
        return executionDuration;
    }

    public void setExecutionDuration(Integer executionDuration) {
        this.executionDuration = executionDuration;
    }

    public Integer getDurationOfRest() {
        return durationOfRest;
    }

    public void setDurationOfRest(Integer durationOfRest) {
        this.durationOfRest = durationOfRest;
    }
}
