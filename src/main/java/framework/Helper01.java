package framework;


public class Helper01 {
    
     public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
     }
     
     public static String generateTitle() {
        return "Srpska Televizija -" + getRandomInteger();
    }
     
     public static String generateTitleName() {
        return "Oliver Vukovic -" + getRandomInteger();
    }
              
}
