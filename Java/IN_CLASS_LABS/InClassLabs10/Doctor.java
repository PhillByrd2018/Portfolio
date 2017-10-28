/**
 * 
 * Doctor class
 * 
 * This class simply models a doctor with a specialty. 
 * Phillip Byrd
 *
 */
public class Doctor extends Person{

    String specialty;

    public Doctor(String name, String specialty){
        super(name);
        this.specialty = specialty;

    }

    public String getSpecialty(){
        return this.specialty;

    }

    public String toString(){

        return "Name: " + super.getName() + "\n" + "Doctor Specialty: " + this.getSpecialty();
    }

    public boolean equals(Object otherDoctor){

        if (otherDoctor == null || !(otherDoctor instanceof Doctor))
            return false;
        else{
            Doctor other = (Doctor) otherDoctor;
            return (other.getName().equalsIgnoreCase(getName()) && other.getSpecialty().equalsIgnoreCase( getSpecialty()) );
        }

    }

} 