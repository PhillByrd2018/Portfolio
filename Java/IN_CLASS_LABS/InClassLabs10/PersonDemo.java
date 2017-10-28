
/**
 * Use this class to test the Person class.
 * Note: This driver only works before the Doctor class is
 * modified, starting in part 3. 
 * 
 */
public class PersonDemo
{
    public static void main(String [] args){
        
       
        Person p = new Person("Syd");
        Person q = new Person("Stan");
        Person r = new Person("Syd");
        Doctor d = new Doctor();
        Person n = null;
        System.out.println(p.getName() + " and " + q.getName() + " are equal(should be false): " + p.equals(q));
        System.out.println(p.getName() + " and " + r.getName() + " are equal(should be true): " + p.equals(r));        
        System.out.println(q.getName() + " and " + d.getName() + " are equal(should be false): " + q.equals(d));  
        System.out.println(p.getName() + " and " + n + " are equal(should be false): " + p.equals(n));
   
    }
}
