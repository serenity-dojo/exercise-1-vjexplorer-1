package serenitylabs.tutorials.vetclinic.tasks;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {

    private Pet pet;
    private PetHotel petHotel;

    public CheckIn(Pet pet,PetHotel petHotel){
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checks in #pet to #hotel")
    @Override
    public <T extends Actor> void performAs(T Actor){
        petHotel.checkIn(pet);
    }

    public static CheckInBuilder aPet(Pet pet) {
        return  new CheckInBuilder(pet);
    }

    public static class CheckInBuilder {
        private Pet pet;
        public CheckInBuilder(Pet pet){
            this.pet = pet;
        }
        public Performable into(PetHotel petHotel){
           // return new CheckIn(pet,petHotel);
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet,petHotel);
        }
    }
}
