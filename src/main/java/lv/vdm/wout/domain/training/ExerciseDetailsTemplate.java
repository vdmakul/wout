package lv.vdm.wout.domain.training;

public abstract class ExerciseDetailsTemplate {
    protected Double weight;
    protected Integer repCount;
    protected Double distance;
    protected Integer executionDuration;
    protected Integer restDuration;

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

    public Integer getRestDuration() {
        return restDuration;
    }

    public void setRestDuration(Integer restDuration) {
        this.restDuration = restDuration;
    }
}
