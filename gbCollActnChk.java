/**
  This programs shows when the system is calling the Garbage Collector
  It comes from the book: "JAVA 8 Les fondamentaux du langage Java" from Thierry GROUSSARD, ENI Editions, 501p. - ISBN: 978-2-7460-8976-1
  This script has been copied from book, then adapted with pers. modifications, and tested
*/

import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gbCollActnChk {
  public static void main(String[] args) {
    double tot=0, rmn=100, pct=0, prev=0;
    double lim=100;
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Please enter the memory usage limit for which to launch the Garbage Collector");
      System.out.println("Note: By default, should be launched auto. by system at 85 %");
      System.out.print("(0-100) ? ");
      lim = Double.parseDouble(reader.readLine());
      for (long j=1;;j++){
        tbCreation();
        tot=Runtime.getRuntime().totalMemory();
        rmn=Runtime.getRuntime().freeMemory();
        prev=pct;
        pct=(tot-rmn)/tot*100;
        if(pct<prev){
          System.out.println(j+"\tMemory Usage: "+pct+" %");
        }
        Thread.sleep(0);
        if(pct>lim) System.gc();
      }
    }catch(InterruptedException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  public static void tbCreation(){
    Person[] p;
    p=new Person[1000];
    for (int i=0;i<1000;i++){
      p[i]=new Person("Smith","John",LocalDate.of(1960,12,31));
    }
  }
}

class Person {
  private String lastName="myLastName";
  private String firstName="myFirstName";
  private LocalDate bthDate=LocalDate.of(1963,11,29);
  private int nb=0;
  private static int nbInstance;
  public String getLastName(){
    return lastName;
  }
  public void setLastName(String ln){
    lastName=ln.toUpperCase();
  }
  public String getFirstName(){
    return firstName;
  }
  public void setFirstName(String fn){
    firstName=fn.toLowerCase();
  }
  @Override
  protected void finalize() throws Throwable{
    //System.out.print("\u2020");
    super.finalize();
  }
  public int getNb(){
    return nb;
  }
  public int getNbInstance(){
    return nbInstance;
  }
  public Person(){
    firstName="";
    lastName="";
    bthDate=null;
    nbInstance++;
    nb=nbInstance;
  }
  public Person(String fn, String ln, LocalDate d){
    firstName=fn;
    lastName=ln;
    bthDate=d;
    nbInstance++;
    nb=nbInstance;
  }
}
