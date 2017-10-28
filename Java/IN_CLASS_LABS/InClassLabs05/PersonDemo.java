public class PersonDemo {
    
    public static void main(String [] args) {
         Person p1 = new Person ("Bee", 17);
         Person p2 = new Person( );
         // 1. Show memory for p1 and p2, on the right
    
    
         p2.what(p1);
         // 2. Show memory for p1 and p2, on the right
    
    
         Person p3 = p2.mystery();
         p1 = null;
         // 3. Shown memory for p1, p2 and p3, on the right
    
         // 4. Show the output of the following statements
         System.out.println(p1 == p2);
         System.out.println(p1.equals(p2));
         System.out.println(p1 == p3);
         System.out.println(p1.equals(p3));
    
         System.out.println(p2 == p3);
    
         System.out.println(p2.equals(p3));

    } // end main
} // end of PersonDemo

