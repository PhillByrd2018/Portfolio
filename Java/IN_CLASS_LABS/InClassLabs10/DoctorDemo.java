
/**
 * Driver to test Doctor class for Lab10.
 
   NOTE: this file won't compile until the Doctor class is complete as
   described in #3 of the assignment.
 * 
 */
public class DoctorDemo
{
    public static void main(String [] args){

        Person a = new Doctor("Hu","Pastry Chef");
        Person b = new Doctor("Hu","Computer Science");
        Person c = new Doctor("Su","Computer Science");
        Person d = new Doctor("Su", "Computer Science");
        System.out.println("The next line should say that \"Dr. Su's specialty is Computer Science");
        System.out.println("Dr. " + d.getName() + "'s specialty is " + ((Doctor) d).getSpecialty() + "\n");
   
        Person n = null;
        Person m = new Person("Hu");
        String x = "Hu";
        System.out.println(a + " and \n" + b + " are equal(should be false): " + a.equals(b) +"\n");
        System.out.println(a + " and \n" + c + " are equal(should be false): " + a.equals(c) +"\n");
        System.out.println(c + " and \n" + d + " are equal(should be true): " + c.equals(d) +"\n");
        System.out.println(d + " and \n" + n + " are equal(should be false): " + d.equals(n) +"\n");
        System.out.println(a + " and \n" + x + "\n are equal(should be false): " + a.equals(x) +"\n");
        System.out.println(a + " and \n" + m + "\n are equal(should be false): " + a.equals(m) +"\n");
    
        
    }
}
