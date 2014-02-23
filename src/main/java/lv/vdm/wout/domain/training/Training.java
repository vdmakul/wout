package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;
import lv.vdm.wout.domain.person.Trainee;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Training {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainee_id", nullable = false)
    private Trainee trainee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training", fetch = FetchType.EAGER) //todo fix eager
    private Set<Workout> workouts = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    private String comments;


    @SuppressWarnings("unused")
    protected Training() {
    }

    public Training(Trainee trainee, Date startTime) {
        assert trainee != null;
        assert startTime != null;
        this.trainee = trainee;
        this.startTime = startTime;
    }

    public void attach(Workout workout) {
        workout.setTraining(this);
        getWorkouts().add(workout);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
