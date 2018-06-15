
package flightseating;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;



public class Flight 
{
    Customer[][] flightCustomers = new Customer[12][6];
    //constructor
    Flight()
    {
        
    }
     public void readFlight()
   {   
        try
             {
       Scanner sc = new Scanner(new File("flight.txt"));

   System.out.println("        A B C D E F ");
   System.out.print("Row 0   ");
   int row = 0;
   int col = 0;
   while(sc.hasNextLine())
   {
        Customer customer = new Customer();
       if(col <=5)
       {
                String line = sc.nextLine();
       
       String[] splitLine = line.split(",");
      
       
       customer.customerName = splitLine[0]; 
       customer.ageType = splitLine[1];
       customer.classType = splitLine[2];
       customer.seatType = splitLine[3];
       flightCustomers[row][col] = customer;
          if(customer.customerName.equals("null"))
       {
           System.out.print("x ");
       }
       else
       {
           System.out.print("* ");
       }
       col++;
       }
           else
       {   
         col = 0;
           row++;
           if(row >=10)
           {
               System.out.print("\r\n" + "Row " + row + "  ");
           }
           else
           {
           System.out.print("\r\n" + "Row " + row + "   " );
           }
       }
  
      
    
   }
 
   
   
    System.out.println("");
     
        String choice;
  
  System.out.println("1-Add a booking");
  System.out.println("2- Cancel a booking");
  System.out.println("3 To view customers with seats");

  Scanner scan = new Scanner(System.in);
  choice = scan.nextLine();
             
  switch(choice)
  {
      case "1": addBooking();
                break;
      case "2": cancelBooking();
                break;
      case "3": viewCustomers();
                break; 
      case "xxc":reset();
                break;
      default: System.out.println("Invalid selection"); 
               System.out.println("press Enter to continue");
               System.in.read();
                readFlight();
               break;
               
 
     
          
  }
   }
             catch(IOException x)
             {
                 
             }
   }
   public void addBooking()
   {

      Scanner sc = new Scanner(System.in);
    System.out.println("Enter Which Row");
     int row = sc.nextInt();
     System.out.println("Enter Which col");
     
     char getCol = sc.next().charAt(0);
     int col = 0;
     switch(getCol)
             {
                 case 'a': col = 0;
                 break;
                 case 'b': col = 1;
                 break;
                 case 'c': col = 2;
                 break;
                 case 'd': col = 3;
                 break;
                 case 'e': col = 4;
                 break;
                 case 'f': col = 5;
                 break;
                 case 'x': System.exit(0);
             }
  
     if(flightCustomers[row][col].customerName.equals("null"))  
     {
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter your name");
         String name = scan.nextLine();     
         System.out.println("Adult or child(A/C");
         String ageType = scan.next();
         String classType ="";
         String seatType;
         switch(row)
         {
             case 0:
             case 1: 
             case 2: classType = "First class";
             break;
             case 3: case 4:
             case 5: classType = "Business class";
             break;
             default: classType = "Economy Class";
             break;
         }
         switch(col)
         {
             case 0:
             case 5: seatType = "Window";
             break;
             case 2:
             case 3: seatType = "Aisle";
             break;
                     default: seatType = "Middle";
         }
         
         try
        {
         FileWriter writeCust = new FileWriter("customer.txt",true);
     
          writeCust.write(name + "," + row +  "," + col + "," + ageType + "," + seatType + "," + classType +  "\r\n");
          writeCust.close();
        Customer customer = new Customer(name,ageType,classType,seatType); 
        flightCustomers[row][col] = customer;
        
            
        FileWriter write = new FileWriter("flight.txt");
        //rewrites flight to text file
            for(int writeRow = 0;writeRow < 12 ;writeRow++)
            {
               for(int writeCol = 0; writeCol < 6; writeCol++)
               {
                    write.write(flightCustomers[writeRow][writeCol].customerName + ","
                              + flightCustomers[writeRow][writeCol].ageType + ","
                              + flightCustomers[writeRow][writeCol].classType + ","
                              + flightCustomers[writeRow][writeCol].seatType + "\r\n");	
               }
            }
          write.close();
             
        }
        catch (IOException x)
        {
            
        }
    
     }
     else
     {
       System.out.println("Seat already booked");
     
       addBooking();
       
     }

   
 }
    public void reset() 
    {
        File file = new File("customer.txt");
        try
        {
        FileWriter wipe = new FileWriter("flight.txt");
        for(int rrow = 0; rrow <12; rrow++)
        {
            for(int rcol = 0; rcol<6; rcol++)
            {
                wipe.write("null,null,null,null" + "\r\n");
            }
        }
        file.delete();
       
       
        wipe.flush();
        wipe.close();
        FileWriter blankCustomer = new FileWriter("customer.txt");
        blankCustomer.write("");
     System.out.println("reset");
        }
        catch(IOException x)
        {
            
        }
    }
    public void cancelBooking()
    {
        try
        {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter which row");
        int row = scan.nextInt();
       
        System.out.println("Enter which col");
        int col = 0;
        char getCol = scan.next().charAt(0);
           switch(getCol)
             {
                 case 'a': col = 0;
                 break;
                 case 'b': col = 1;
                 break;
                 case 'c': col = 2;
                 break;
                 case 'd': col = 3;
                 break;
                 case 'e': col = 4;
                 break;
                 case 'f': col = 5;
                 break;
                 case 'x': System.exit(0);
             }
           
        
           String line;
           List<Customer> cusList = new ArrayList<Customer>();
        BufferedReader bufferedr = new BufferedReader(new FileReader("customer.txt"));
        
          while ((line = bufferedr.readLine())!=null )
                {
               
                  String[] cus = line.split(",");
                  String name = cus[0];
                  String Row = cus[1];
                  String Col = cus[2];
                  String ageType = cus[3];
                  String seatType = cus[4];
                  String classType = cus[5];
                  
                  Customer customer = new Customer(name,ageType,classType,seatType);
                  cusList.add(customer);
                }
        if(flightCustomers[row][col].customerName.equals("null"))
            {
               
                System.out.println("empty seat");
             
               
            }
            else
            {
                try
                {
                while(true)
                {
                System.out.println("Cancel seat for " + flightCustomers[row][col].customerName + " ? " + "(y/n)");
                 Scanner input = new Scanner(System.in);
                String choice = input.next();
                
               if(choice.equals("y"))
               {
                  ArrayList<String> customers = new ArrayList<String>();
                   Scanner delCust = new Scanner(new File("customer.txt"));
                   while(delCust.hasNextLine())
                   {
                       String delCustomer = delCust.nextLine();
                       if(delCustomer.contains(flightCustomers[row][col].customerName))
                       {   
                       }
                       else
                       {
                          customers.add(delCustomer);
                       }
                         
                   }
                   try
                   {
                  // FileWriter reWrite = new FileWriter("customer.txt");
                   BufferedWriter reWrite = new BufferedWriter(new FileWriter("customer.txt"));
                  for(String c : customers)
                  {
                      reWrite.write(c + " ");
                   //System.out.println(c);   
                  }
                   }
                   catch(IOException x)
                   {
                       System.out.println(x);
                   }
                    
                   flightCustomers[row][col].customerName = "null";
                   break;
               }
               else if(choice.equals("n"))
               {
                   readFlight();
               }
                }
                }
                catch(Exception x)
                {
                    System.out.println(x);
                }
                
           
               
            }
    
      
         
        }
        catch(Exception x) 
        {
 
        }
       
    }
    public void viewCustomers()
    {
        String line = "";
     ArrayList<String> customers = new ArrayList<String>();
    
        int custCount = 0;
    
      try
      {
   
       BufferedReader bufferedr = new BufferedReader(new FileReader("customer.txt"));
         while ((line = bufferedr.readLine())!=null)
         {
             String custName = line.split(",")[0];
           customers.add(custName);
           
         } 
      
         String[] custArray = new String[customers.size()];
         custArray = customers.toArray(custArray);
         if(customers.size()==0)
         {
             System.out.println("No Customers Found");
             System.in.read();
             readFlight();
         }
         else
         {
             
         
         Arrays.sort(custArray);
         for(String s :custArray)
         {
             System.out.println(s);
         }
         }
         
         System.out.println("Search for customer");
         Scanner scan = new Scanner(System.in);
         String search = scan.next();
        
         int bsResult = Arrays.binarySearch(custArray, search);
         if(bsResult<0)
         {
              System.out.println("not found"); 
             scan.next();
             viewCustomers();
           
         }
         if(custArray[bsResult].equals(search))
         {
             for(int i = 0; i<12;i++)
             {
               for(int j = 0;j<6;j++)
               {
                   if(flightCustomers[i][j].customerName.equals(custArray[bsResult]))
                   {
                       System.out.println(flightCustomers[i][j].customerName + " " + flightCustomers[i][j].ageType + " " + flightCustomers[i][j].classType + " " + flightCustomers[i][j].seatType);
                       break;
                   }
               }
             }

         }
         
       
         
      }
      catch(IOException x)
      {
          System.out.println(x);
      }
    }   
 
}
