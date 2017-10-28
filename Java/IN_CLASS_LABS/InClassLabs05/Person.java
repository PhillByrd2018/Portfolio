
/**
 * Code for in class lab 5 (Spring 2017)
 * 
 * Stores name and age for a person and provides 
 *    basic functionality to manipulate objects 
 * 
 * @author (McCauley) 
 */
public class Person {
     // instance variables
     private String name;
     private int age;
     
     // constructors - initialize instance variables
     public Person (String name, int age) { this.name = name; this.age = age;}
     public Person ( ) { name = ""; age = 0; }
   
     public String getName( ) { return name; }
     public int getAge( ) { return age; }
     public boolean equals(Person another)
       {return this.name.equalsIgnoreCase(another.name) && 
               this.getAge() == another.getAge();
     }
     public boolean isSameAge(Person another) { 
         return this.getAge() == another.getAge();}
     public boolean isSameName(Person another) { 
         return this.name.equalsIgnoreCase(another.name);}
     public boolean isOlderThan(Person another) { 
         return age > another.age; }
     public void birthday( ) { age++; }
     public void what(Person another) { age = another.age; name = another.name; }
     // Notice that the next method returns a Person object
     public Person mystery() { return new Person(name, age);}
}

