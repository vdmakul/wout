package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;

import java.util.Date;
import java.util.List;

public class Training {
    private List<Workout> workouts;
    private Difficulty difficulty;
    private Date startTime;
    private Date endTime;
    private String comments;
}
