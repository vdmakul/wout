package lv.vdm.wout.config;

import lv.vdm.wout.App;
import lv.vdm.wout.domain.Difficulty;
import lv.vdm.wout.domain.Media;
import lv.vdm.wout.domain.body.BodyPart;
import lv.vdm.wout.domain.body.Muscle;
import lv.vdm.wout.domain.body.MuscleUtilisation;
import lv.vdm.wout.domain.body.UtilisationLevel;
import lv.vdm.wout.domain.exercise.Exercise;
import lv.vdm.wout.domain.exercise.ExerciseClass;
import lv.vdm.wout.domain.exercise.Inventory;
import lv.vdm.wout.domain.exercise.TechnicalLevel;
import lv.vdm.wout.domain.person.Trainee;
import lv.vdm.wout.domain.person.Trainer;
import lv.vdm.wout.domain.training.ExerciseDetails;
import lv.vdm.wout.domain.training.Training;
import lv.vdm.wout.domain.training.Workout;
import lv.vdm.wout.domain.training.planned.PlannedExerciseDetails;
import lv.vdm.wout.domain.training.planned.PlannedTraining;
import lv.vdm.wout.domain.training.planned.PlannedWorkout;
import lv.vdm.wout.repository.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class PersistenceIntegrationTest {

    @Autowired
    private ExerciseRepository exerciseRepo;
    @Autowired
    private InventoryRepository inventoryRepo;
    @Autowired
    private MuscleRepository muscleRepo;
    @Autowired
    private BodyPartRepository bodyPartRepo;
    @Autowired
    private MuscleUtilisationRepository muscleUtilisationRepo;
    @Autowired
    private MediaRepository mediaRepo;
    @Autowired
    private TrainingRepository trainingRepo;
    @Autowired
    private WorkoutRepository workoutRepo;
    @Autowired
    private ExerciseDetailsRepository exerciseDetailsRepo;
    @Autowired
    private TraineeRepository traineeRepo;
    @Autowired
    private TrainerRepository trainerRepo;
    @Autowired
    private PlannedTrainingRepository plannedTrainingRepo;
    @Autowired
    private PlannedWorkoutRepository plannedWorkoutRepo;
    @Autowired
    private PlannedExerciseDetailsRepository plannedExerciseDetailsRepo;


    @After
    public void tearDown() throws Exception {
        //order matters
        plannedExerciseDetailsRepo.deleteAll();
        plannedWorkoutRepo.deleteAll();
        plannedTrainingRepo.deleteAll();
        trainerRepo.deleteAll();
        traineeRepo.deleteAll();
        exerciseDetailsRepo.deleteAll();
        workoutRepo.deleteAll();
        trainingRepo.deleteAll();
        exerciseRepo.deleteAll();
        inventoryRepo.deleteAll();
        muscleUtilisationRepo.deleteAll();
        bodyPartRepo.deleteAll();
        muscleRepo.deleteAll();
    }

    @Test
    public void thatExerciseInventoryWorks() {
        Inventory chinupBar = new Inventory("chinup_bar", "Chin-up bar");
        inventoryRepo.save(chinupBar);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise running = new Exercise("running", "Running", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise chinUp = new Exercise("chinup", "Chin-up", TechnicalLevel.NOVICE, ExerciseClass.BASE);
        chinUp.requires(chinupBar);

        exerciseRepo.save(jogging);
        exerciseRepo.save(running);
        exerciseRepo.save(chinUp);

        List<Exercise> exercises = new ArrayList<>();
        for (Exercise exercise : exerciseRepo.findAll()) {
            exercises.add(exercise);
        }
        assertEquals(3, exercises.size());

        assertEquals("jogging", exerciseRepo.findByUniqueCode("jogging").getUniqueCode());
    }

    @Test
    public void thatMuscleAndBodyPartWorks() {
        BodyPart arm = new BodyPart("arm", "Arm");
        bodyPartRepo.save(arm);

        Muscle biceps = new Muscle("biceps", arm);
        biceps.setBodyPart(arm);
        muscleRepo.save(biceps);

        arm = bodyPartRepo.findByUniqueCode("arm");
        assertNotNull(arm);
        assertEquals(1, arm.getMuscles().size());
        assertEquals("biceps", arm.getMuscles().iterator().next().getUniqueCode());
    }

    @Test
    public void thatMuscleUtilisationWorks() {
        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        exerciseRepo.save(jogging);

        BodyPart arm = new BodyPart("arm", "Arm");
        bodyPartRepo.save(arm);

        Muscle biceps = new Muscle("biceps", arm);
        biceps.setBodyPart(arm);
        muscleRepo.save(biceps);

        MuscleUtilisation mu = new MuscleUtilisation(biceps, UtilisationLevel.MEDIUM);
        mu.setExercise(jogging);
        muscleUtilisationRepo.save(mu);

        assertEquals(1, muscleUtilisationRepo.findByMuscle(biceps).size());
        assertEquals(1, muscleUtilisationRepo.findByMuscleUniqueCode("biceps").size());
    }

    @Test
    public void thatMuscleLinksMedia() {
        Media image = new Media("image", "http://image.com/image.png", "image/png");
        mediaRepo.save(image);

        BodyPart arm = new BodyPart("arm", "Arm");
        bodyPartRepo.save(arm);

        Muscle biceps = new Muscle("biceps", arm);
        biceps.link(image);
        biceps.setBodyPart(arm);
        muscleRepo.save(biceps);

        Media media = muscleRepo.findByUniqueCode("biceps").getMedias().iterator().next();
        assertEquals("image", media.getName());
        assertEquals("http://image.com/image.png", media.getUrl());
        assertEquals("image/png", media.getContentType());
    }

    @Test
    public void thatInventoryLinksMedia() {
        Media image = new Media("image", "http://image.com/image.png", "image/png");
        mediaRepo.save(image);

        Inventory chinupBar = new Inventory("chinup_bar", "Chin-up bar");
        chinupBar.link(image);
        inventoryRepo.save(chinupBar);

        Media media = inventoryRepo.findByUniqueCode("chinup_bar").getMedias().iterator().next();
        assertEquals("image", media.getName());
        assertEquals("http://image.com/image.png", media.getUrl());
        assertEquals("image/png", media.getContentType());
    }

    @Test
    public void thatExerciseHasMuscleUtilization() {
        BodyPart torso = new BodyPart("torso", "Torso");
        bodyPartRepo.save(torso);

        Muscle cardiac = new Muscle("cardiac", torso);
        muscleRepo.save(cardiac);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        jogging.utilizes(new MuscleUtilisation(cardiac, UtilisationLevel.SUPPORTING));
        exerciseRepo.save(jogging);

        assertEquals(1, exerciseRepo.findByUniqueCode("jogging").getMuscleUtilisations().size());
    }

    @Test
    public void thatTrainingWorks() {
        Trainee trainee = new Trainee("trainee");
        traineeRepo.save(trainee);

        Date startTime = new Date(123456789);
        Date endTime = new Date(987654321);

        Training training = new Training(trainee, startTime);
        training.setDifficulty(Difficulty.EASY);
        training.setComments("comments");
        training.setEndTime(endTime);
        trainingRepo.save(training);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        exerciseRepo.save(jogging);

        Workout workout = new Workout(jogging);
        workout.setDifficulty(Difficulty.NORMAL);
        ExerciseDetails exerciseDetails = new ExerciseDetails(workout);
        exerciseDetails.setDifficulty(Difficulty.EASY);
        exerciseDetails.setComments("details comments");
        exerciseDetails.setWeight(1d);
        exerciseDetails.setRepCount(2);
        exerciseDetails.setDistance(3d);
        exerciseDetails.setExecutionDuration(4);
        exerciseDetails.setDurationOfRest(5);

        workout.with(exerciseDetails);
        training.attach(workout);
        workoutRepo.save(workout);
        trainingRepo.save(training);

        exerciseDetailsRepo.save(exerciseDetails);

        List<Training> all = new ArrayList<>();
        for (Training tr : trainingRepo.findAll()) {
            all.add(tr);
        }

        assertEquals(1, all.size());
        assertEquals(Difficulty.EASY, all.get(0).getDifficulty());
        assertEquals("comments", all.get(0).getComments());
        assertEquals(startTime, all.get(0).getStartTime());
        assertEquals(endTime, all.get(0).getEndTime());

        assertEquals(1, all.get(0).getWorkouts().size());
        Workout wout = all.get(0).getWorkouts().iterator().next();
        assertEquals(Difficulty.NORMAL, wout.getDifficulty());

        Set<ExerciseDetails> detailz = wout.getExerciseDetails();
        assertEquals(1, detailz.size());
        ExerciseDetails details = detailz.iterator().next();
        assertEquals(1, details.getWeight(), 0);
        assertEquals(2, details.getRepCount(), 0);
        assertEquals(3, details.getDistance(), 0);
        assertEquals(4, details.getExecutionDuration(), 0);
        assertEquals(5, details.getDurationOfRest(), 0);
    }

    @Test
    public void thatTrainersWork() {
        Trainee trainee = new Trainee("trainee");
        traineeRepo.save(trainee);

        Trainer trainer = new Trainer("trainer");
        trainer.mentor(trainee);
        trainerRepo.save(trainer);

        assertNotNull(traineeRepo.findOne("trainee"));
        assertNotNull(traineeRepo.findOne("trainee").getTrainer());
        assertEquals("trainer", traineeRepo.findOne("trainee").getTrainer().getLogin());
    }

    @Test
    public void thatPlanningWorks() {
        PlannedTraining plannedTraining = new PlannedTraining();
        plannedTrainingRepo.save(plannedTraining);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        exerciseRepo.save(jogging);

        PlannedWorkout plannedWorkout = new PlannedWorkout();
        plannedWorkout.setExercise(jogging);
        plannedTraining.attach(plannedWorkout);

        plannedWorkoutRepo.save(plannedWorkout);

        PlannedExerciseDetails plannedExerciseDetails = new PlannedExerciseDetails();
        plannedWorkout.with(plannedExerciseDetails);
        plannedExerciseDetailsRepo.save(plannedExerciseDetails);

        Iterator<PlannedTraining> iterator = plannedTrainingRepo.findAll().iterator();
        assertTrue(iterator.hasNext());
        PlannedTraining training = iterator.next();
        assertEquals(1, training.getPlannedWorkouts().size());
        assertEquals(1, training.getPlannedWorkouts().iterator().next().getPlannedDetails().size());
    }

}

