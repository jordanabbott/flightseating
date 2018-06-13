package flightseating;
import java.io.*;
import java.util.*;
/**
 *
 * @author Jordan
 */
public class FlightSeating 
{
 Customer[][] flightCustomers = new Customer[12][6];
    

 public static void main(String[] args) throws IOException
    {
       Flight flight = new Flight();
       
       flight.readFlight();
    
    }

    
}
