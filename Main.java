import java.io.*;
import java.util.*;

class Food implements Serializable
{
    int itemno;
    int quantity;   
    float price; 
    Food(int i, int q)
    {
        itemno = i;
        quantity = q;
    }
}
class Singleroom implements Serializable
{
    String name;
    String contact;
    String gender;   
    ArrayList<Food> food =new ArrayList<>();
    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}
class Doubleroom extends Singleroom implements Serializable
{ 
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}
class Room
{
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }      
        
        switch (i) {
        case 1:Luxury_Double_Room.luxury_doubleroom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
            break;
        case 2:Deluxe_Double_Room.deluxe_doubleroom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
            break;
        case 3:Luxury_Single_Room.luxury_singleroom[rn]=new Singleroom(name,contact,gender);
            break;
        case 4:Deluxe_Single_Room.deluxe_singleroom[rn]=new Singleroom(name,contact,gender);
            break;
        default:System.out.println("Wrong option");
            break;
        }
    }

    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) 
        {
            case 1:               
                if(Luxury_Double_Room.luxury_doubleroom[rn]!=null)
                    System.out.println("Room used by "+Luxury_Double_Room.luxury_doubleroom[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    Luxury_Double_Room.bill(rn,rtype);
                    Luxury_Double_Room.luxury_doubleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }   
            break;

            case 2:
                if(Deluxe_Double_Room.deluxe_doubleroom[rn]!=null)
                    System.out.println("Room used by "+Deluxe_Double_Room.deluxe_doubleroom[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    Deluxe_Double_Room.bill(rn,rtype);
                    Deluxe_Double_Room.deluxe_doubleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }       
            break;

            case 3:
                if(Luxury_Single_Room.luxury_singleroom[rn]!=null)
                    System.out.println("Room used by "+Luxury_Single_Room.luxury_singleroom[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    Luxury_Single_Room.bill(rn,rtype);
                    Luxury_Single_Room.luxury_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }   
            break;

            case 4:
                if(Deluxe_Single_Room.deluxe_singleroom[rn]!=null)
                    System.out.println("Room used by "+Deluxe_Single_Room.deluxe_singleroom[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    Deluxe_Single_Room.bill(rn,rtype);
                    Deluxe_Single_Room.deluxe_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
            break;

            default:
                System.out.println("\nEnter valid option : ");
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try
        {
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();
                switch(rtype){
                case 1: Luxury_Double_Room.luxury_doubleroom[rn].food.add(new Food(i,q));
                    break;
                case 2: Deluxe_Double_Room.deluxe_doubleroom[rn].food.add(new Food(i,q));
                    break;
                case 3: Luxury_Single_Room.luxury_singleroom[rn].food.add(new Food(i,q));
                    break;
                case 4: Deluxe_Single_Room.deluxe_singleroom[rn].food.add(new Food(i,q));
                    break;                                                 
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Do you want to order anything else ? (y/n)");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            wish=sc.next().charAt(0); 
            }while(wish=='y'||wish=='Y');  
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }

}
class Luxury_Double_Room extends Doubleroom
{
    static Doubleroom luxury_doubleroom[]=new Doubleroom[10];
    static double room_cost = 4000;
    static Scanner sc = new Scanner(System.in);
    static void features()
    {
        System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
    }

    static void availability()
    {
        int count =0;
        for(int j=0;j<luxury_doubleroom.length;j++)
        {
            if(luxury_doubleroom[j]==null)
                count++;
        }
        System.out.println("Number of rooms available : "+count);
    }

    static void bookroom()
    {
        int rn;
        System.out.println("\nChoose room number from : ");
        for(int j=0;j<luxury_doubleroom.length;j++)
        {
            if(luxury_doubleroom[j]==null)
            {
                System.out.print(j+1+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try
        {
            rn=sc.nextInt();
            rn--;
            if(luxury_doubleroom[rn]!=null)
                throw new NotAvailable();
            else
                Room.CustDetails(1,rn);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        int foodPrice[] = {50,60,70,30};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
        amount+=room_cost;
        System.out.println("\nRoom Charge - "+amount);
        System.out.println("\n===============");
        System.out.println("Food Charges:- ");
        System.out.println("===============");
        System.out.println("Item   Quantity    Price");
        System.out.println("-------------------------");
        for(Food obb:luxury_doubleroom[rn].food)
        {
            obb.price = obb.quantity*foodPrice[obb.itemno-1]; 
            amount+=obb.price;
            String format = "%-10s%-10s%-10s%n";
            System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
        }
        System.out.println("===============");
        System.out.println("Your total amount is: "+ amount);
        System.out.println("===============");
    }

}
class Deluxe_Double_Room extends Doubleroom
{
    static Doubleroom deluxe_doubleroom[]=new Doubleroom[20];
    static double room_cost = 3000;
    static Scanner sc = new Scanner(System.in);
    static void features()
    {
        System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
    }

    static void availability()
    {
        int count =0;
        for(int j=0;j<deluxe_doubleroom.length;j++)
        {
            if(deluxe_doubleroom[j]==null)
                count++;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bookroom()
    {
        int rn;
        System.out.println("\nChoose room number from : "); 
        for(int j=0;j<deluxe_doubleroom.length;j++)
        {
            if(deluxe_doubleroom[j]==null)
            {
                System.out.print(j+11+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try
        {
            rn=sc.nextInt();
            rn=rn-11;
            if(deluxe_doubleroom[rn]!=null)
                throw new NotAvailable();
            Room.CustDetails(2,rn);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
        amount+=room_cost;
        System.out.println("\nRoom Charge - "+amount);
        System.out.println("\n===============");
        System.out.println("Food Charges:- ");
        System.out.println("===============");
        System.out.println("Item   Quantity    Price");
        System.out.println("-------------------------");
        for(Food obb:deluxe_doubleroom[rn].food)
        {
            amount+=obb.price;
            String format = "%-10s%-10s%-10s%n";
            System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
        }
    }
    
}
class Luxury_Single_Room extends Singleroom
{
    static Singleroom luxury_singleroom[]=new Singleroom[10];
    static double room_cost = 2200;
    static Scanner sc = new Scanner(System.in);
    static void features()
    {
        System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
    }

    static void availability()
    {
        int count =0;
        for(int j=0;j<luxury_singleroom.length;j++)
        {
            if(luxury_singleroom[j]==null)
                count++;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bookroom()
    {
        int rn;
        System.out.println("\nChoose room number from : ");
        for(int j=0;j<luxury_singleroom.length;j++)
        {
            if(luxury_singleroom[j]==null)
            {
                System.out.print(j+31+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try
        {
            rn=sc.nextInt();
            rn=rn-31;
            if(luxury_singleroom[rn]!=null)
                throw new NotAvailable();
            Room.CustDetails(3,rn);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
        amount+=room_cost;
        System.out.println("\nRoom Charge - "+amount);
        System.out.println("\n===============");
        System.out.println("Food Charges:- ");
        System.out.println("===============");
        System.out.println("Item   Quantity    Price");
        System.out.println("-------------------------");
        for(Food obb:luxury_singleroom[rn].food)
        {
            amount+=obb.price;
            String format = "%-10s%-10s%-10s%n";
            System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
        }
    }
    
}
class Deluxe_Single_Room extends Singleroom
{
    static Singleroom deluxe_singleroom[]=new Singleroom[20];
    static double room_cost = 1200;
    static Scanner sc = new Scanner(System.in);
    static void features()
    {
        System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
    }

    static void availability()
    {
        int count =0;
        for(int j=0;j<deluxe_singleroom.length;j++)
        {
            if(deluxe_singleroom[j]==null)
                count++;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bookroom()
    {
        int rn;
        System.out.println("\nChoose room number from : ");
        for(int j=0;j<deluxe_singleroom.length;j++)
        {
            if(deluxe_singleroom[j]==null)
            {
                System.out.print(j+41+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try
        {
            rn=sc.nextInt();
            rn=rn-41;
            if(deluxe_singleroom[rn]!=null)
                throw new NotAvailable();
            Room.CustDetails(4,rn);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
        amount+=room_cost;
        System.out.println("\nRoom Charge - "+amount);
        System.out.println("\n===============");
        System.out.println("Food Charges:- ");
        System.out.println("===============");
        System.out.println("Item   Quantity    Price");
        System.out.println("-------------------------");
        for(Food obb: deluxe_singleroom[rn].food)
        {
            amount+=obb.price;
            String format = "%-10s%-10s%-10s%n";
            System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
        }
    }

    
}
public class Main 
{
    public static void display_room_choices()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------"); 
    }

    public static void room_choice(int ch,int op_choice)
    {
        switch(ch)
        {
            case 1: // Luxury double room
            switch(op_choice)
            {
                case 1: 
                    Luxury_Double_Room.features();
                break;

                case 2: 
                    Luxury_Double_Room.availability();
                break;

                case 3:
                    Luxury_Double_Room.bookroom();                     
                break;

                default:
                    System.out.println("Invalid Input");
            } 

            break;

            case 2: // Deluxe double room
            switch(op_choice)
            {
                case 1: 
                    Deluxe_Double_Room.features();
                break;

                case 2: 
                    Deluxe_Double_Room.availability();
                break;

                case 3:
                    Deluxe_Double_Room.bookroom();                     
                break;

                default:
                    System.out.println("Invalid Input");
            }
            break;
            
            case 3: // Luxury single room
            switch(op_choice)
            {
                case 1: 
                    Luxury_Single_Room.features();
                break;

                case 2: 
                    Luxury_Single_Room.availability();
                break;

                case 3:
                    Luxury_Single_Room.bookroom();                     
                break;

                default:
                    System.out.println("Invalid Input");
            }
            break;

            case 4: // Deluxe single room
            switch(op_choice)
            {
                case 1: 
                    Deluxe_Single_Room.features();
                break;

                case 2: 
                    Deluxe_Single_Room.availability();
                break;

                case 3:
                    Deluxe_Single_Room.bookroom();                     
                break;

                default:
                    System.out.println("Invalid Input");
            }
            break;
        }

    }
    public static void main(String[] args)
    {
        try
        {           
            Scanner sc = new Scanner(System.in);
            int op_choice;
            char wish;
            x:
            do
            {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                op_choice = sc.nextInt();
                //display_room_choices();     
                //room_choice(sc.nextInt(),op_choice);
                switch(op_choice)
                {
                    case 1: 
                        display_room_choices();  
                        room_choice(sc.nextInt(),op_choice);
                    break;

                    case 2:
                        display_room_choices();  
                        room_choice(sc.nextInt(),op_choice);
                    break;

                    case 3:
                        display_room_choices();  
                        room_choice(sc.nextInt(),op_choice);                    
                    break;

                    case 4:
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");        
                        System.out.print("Room Number -");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                        op_choice = sc.nextInt();
                        if(op_choice>60)
                            System.out.println("Room doesn't exist");
                        else if(op_choice>40)
                            Room.order(op_choice-41,4);
                        else if(op_choice>30)
                            Room.order(op_choice-31,3);
                        else if(op_choice>10)
                            Room.order(op_choice-11,2);
                        else if(op_choice>0)
                            Room.order(op_choice-1,1);
                        else
                            System.out.println("Room doesn't exist");
                    break;

                    case 5:                 
                        System.out.print("Room Number -");
                        op_choice = sc.nextInt();
                        if(op_choice>60)
                            System.out.println("Room doesn't exist");
                        else if(op_choice>40)
                            Room.deallocate(op_choice-41,4);
                        else if(op_choice>30)
                            Room.deallocate(op_choice-31,3);
                        else if(op_choice>10)
                            Room.deallocate(op_choice-11,2);
                        else if(op_choice>0)
                            Room.deallocate(op_choice-1,1);
                        else
                            System.out.println("Room doesn't exist");
                    break;

                    case 6:
                    break x;
                        
                }

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nContinue : (y/n)");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                wish=sc.next().charAt(0); 
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0); 
                }
                    
            }while(wish=='y'||wish=='Y');    
            
        }        
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}
