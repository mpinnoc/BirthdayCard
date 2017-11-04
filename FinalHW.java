//Michelle Pinnock
//Birthday Card

import java.util.Scanner;
import java.io.*;

public class Card //3a Superclass
   {
      private String name;       //3aData members
      private String message;
         
         public Card()
            {
               name = "";
               message = "";
            }
         public Card(String n, String m)
            {
               name = n;
               message = m;
            }
         public void setMessage(String m)    //3a Mutator
            {
               message = m;
            }
         public String getMessage()    //3a Accessor
            {
               return message;
            }
         public void setName(String n)    //3a Mutator
            {
               name = n;
            }
         public String getName()    //3a Accessor
            {
               return name;
            }
         public String toString()      //toString method
            {
               String str = "Dear " + getName() + "'"
                                                + "\n     " + message; 
                                      
               return str ;  
            }
   }
 class BirthdayCard extends Card    //3b Subclass
   {
      protected int money;
      
      public BirthdayCard()
         {
            super();
            money = 0;
         }
      public BirthdayCard(String n, String m, int my)
         {
            super(n,m);
            money = my;
         }
      public void setMoney(int my) throws NegativeAmountOfMoney    //3b Mutator & 2 Exception handling
         {
            if(money < 0)
               throw new NegativeAmountOfMoney(money);
            money = my;
         }
      public int getMoney()      //3b Accessor
         {
            return money;
         }
      public String toString()      //3b toString Method
         {
            String str = "Dear " + getName() + ","
                                             + "\n    Happy Birthday. I hope you enjoy this giftcard  with $" + money;       //3e Overriding method  
            return str ;                       
         }

   }
class NegativeAmountOfMoney extends Exception      //2 Exception handling
   {
      public NegativeAmountOfMoney()
      {
         super("Error: Negative amount of money.");
      }
      public NegativeAmountOfMoney(double money)
      {
         super("Error: Negative amount of money: " + money);
      }
   }
class Polymorphic    //3g Polymorphism
   {
      public static void main(String[] args) throws IOException
         {
            Card[] tests = new Card[3];
            
            tests[0] = new Card();
            tests[0].setName("Rebecca");
            tests[0].setMessage("Happy Aniversy!!");
            
            tests[1] = new BirthdayCard();
            tests[1].setName("Jimmy Thomson");
            try      //2 Exception handling
               {
                  ((BirthdayCard)tests[1]).setMoney(500);
                  //((BirthdayCard)tests[2]).setMoney(-10);

               }
            catch(NegativeAmountOfMoney e)
               {
                  System.out.println(e.getMessage());
               }
            catch(Exception e)
               {
                  System.out.println(e.getMessage());
               }

            for(int i = 0; i < tests.length; i++)
               {
                  System.out.println(tests[i]);
               }

            Scanner keyboard = new Scanner(System.in); 
            String fileName;
            Address adresss;
            
            System.out.println("Where would you like to mail this card to?");
            	 
      		Address cardAddress = new Address("Newark", "NJ", "07102", "USA");
      
      		System.out.println(cardAddress);
        }
   }
   
class Address
   {
   	String city;
   	String state;
   	String zipCode;
   	String country;
   	
   	Address()
      	{
      		city = "";
            state = "";
            zipCode = "";
            country = "";
      	}
   	Address(String cty, String st, String zip, String ctry)
      	{
      		city = cty;
      		state = st;
      		zipCode = zip;
      		country = ctry;
      	}
   	public void setCity(String cty)
   	   {	
            city = cty;
         }
   	public void setState(String st)
   	   {	
            state = st;
         }
   	public void setZipCode(String zip)
   	   {	
            zipCode = zip;
         }
   	public void setCountry(String ctry)
   	   {	
            country = ctry;
         }
   	public String getCity()
   	   {	
            return city;
         }
   	public String getState()
   	   {	
            return state;
         }
   	public String getZipCode()
   	   {	
            return zipCode;
         }
   	public String getCountry()
   	   {	
            return country;
         }
   	public String toString()
      	{
      		String str = "The address is " + city + ", "
      						+ state + ", " + zipCode + ", "
      						+ country;
      		return str;
      	}
   }