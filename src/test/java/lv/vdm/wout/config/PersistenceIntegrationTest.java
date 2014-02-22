package lv.vdm.wout.config;

import lv.vdm.wout.App;
import lv.vdm.wout.domain.Media;
import lv.vdm.wout.domain.body.BodyPart;
import lv.vdm.wout.domain.body.Muscle;
import lv.vdm.wout.domain.body.MuscleUtilisation;
import lv.vdm.wout.domain.body.UtilisationLevel;
import lv.vdm.wout.domain.exercise.Exercise;
import lv.vdm.wout.domain.exercise.ExerciseClass;
import lv.vdm.wout.domain.exercise.Inventory;
import lv.vdm.wout.domain.exercise.TechnicalLevel;
import lv.vdm.wout.repository.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
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


    @After
    public void tearDown() throws Exception {
        //order matters
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
        BodyPart arm = new BodyPart("arm", "Arm");
        bodyPartRepo.save(arm);

        Muscle biceps = new Muscle("biceps", arm);
        biceps.setBodyPart(arm);
        muscleRepo.save(biceps);

        MuscleUtilisation mu = new MuscleUtilisation(biceps, UtilisationLevel.MEDIUM);
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

}

