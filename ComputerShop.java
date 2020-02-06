import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class ComputerShop{
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        Computer product = new Computer();
         
        List list = new java.util.ArrayList();
 
        int choice, again=1;

        while(again == 1){
            System.out.println("Provide your choice for :: ");
            System.out.println("\t\t1..Add new Computer product..");
            System.out.println("\t\t2..Display all Computer items..");
            System.out.println("\t\t3..Search for Computer items");
            System.out.println("\t\t4..Delete a Computer item (product id) ..");
            System.out.println("\t\t5..Update Computer item..");
            System.out.print("\t\t\tEnter the choice::");
            choice = sc.nextInt();
            switch(choice){
                case 1: //product = product.addProduct();
                        list.add(new Computer().addProduct());
                        System.out.println("\t\t\tProduct adding successful...!!!");
                        break;
                case 2: System.out.println("List of Computers are :: " + list);
                        break;
                case 3: product.searchProduct(list);
                        break;

                case 4:product.removeProduct(list);
                        break;
                case 5:product.updateProduct(list);
                        break;
            }


            System.out.print("Please enter 1 to continue...");
            again = sc.nextInt();
        }
        }
}

 
class Computer{
    private String brand, color;
    private int hddSize, ramSize, id;
    
 
    Computer(){             //Default Constructor
    }
    

    Computer(String brand, String color, int hddSize, int ramSize, int id){
        this.brand = brand;
        this.color = color;
        this.hddSize = hddSize;
        this.ramSize = ramSize;
        this.id = id;
    }

    //GETTERS

    public Integer getID(){
        return this.id;
    }


    public String getColor(){
        return this.color;
    }
 
    public String getBrand(){
        return this.brand;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
     
    public Integer getRamSize(){
        return this.ramSize;
    }

    //SETTERS

    public void setID(Integer id){
     this.id = id;
    }


    public void setColor(String color){
         this.color = color;
    }
 
    public void setBrand(String brand){
        this.brand = brand;
    }
 
    public void setHddSize(Integer hddSize){
        this.hddSize = hddSize;
    }
     
    public void setRamSize(Integer ramSize){
        this.ramSize = ramSize;
    }


    @Override
    public String toString(){
        return "\nComputer : (" + this.getBrand()
            + ", " + this.getColor()
            + ", " + this.getHddSize()
            + ", " + this.getRamSize()
            + ", " + this.getID()
            + ")";
    }

     public Boolean equals(List list){

        Boolean ret = false;
        for (Object obj : list) {
            if(((Computer)obj).getBrand().equals(this.getBrand())  || ((Computer)obj).getColor().equals(this.getColor()) || 
               ((Computer)obj).getHddSize().equals(this.getHddSize()) ||((Computer)obj).getRamSize().equals(this.getRamSize())
               || ((Computer)obj).getID().equals(this.getID() )){
                 System.out.println(((Computer)obj));
                ret = true;
            }
        }
        return ret;
    }

    public Computer addProduct(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name of the BRAND :");
        this.brand = scan.next();

        System.out.print("Enter COLOR of the product :");
        this.color = scan.next();

        System.out.print("Enter HDD-SIZE : ");
        this.hddSize = scan.nextInt();

        System.out.print("Enter RAM-SIZE :");
        this.ramSize = scan.nextInt();

        System.out.print("Enter product ID :");
        this.id = scan.nextInt();

        return this;

    }


    public void updateProduct(List list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter product ID to update product");
        int update_id = scan.nextInt();
        for (Object obj : list) {
            if(((Computer)obj).getID().equals(update_id)){
                System.out.print("Enter option to update: ");
                System.out.print("\n1 Brand\n2 Color\n3 HDD Size\n4 Ram Size\n5 ID");
                int option = scan.nextInt();
                System.out.print("Enter the vale:: ");
                switch(option){
                    case 1: ((Computer)obj).setBrand(scan.next());
                            System.out.println(((Computer)obj) + "has been updated...");
                            break;
                    case 2: ((Computer)obj).setColor(scan.next());
                            System.out.println(((Computer)obj) + "has been updated...");
                            break;
                    case 3: ((Computer)obj).setHddSize(scan.nextInt());
                            System.out.println(((Computer)obj) + "has been updated...");
                            break;
                   case 4: ((Computer)obj).setRamSize(scan.nextInt());
                            System.out.println(((Computer)obj) + "has been updated...");
                            break;
                   case 5: ((Computer)obj).setID(scan.nextInt());
                            System.out.println(((Computer)obj) + "has been updated...");
                            break;
                }           
               
                return;
            }
        }
        System.out.print("Invalid item..");
        return;


    }
 
    public void removeProduct(List list){
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter product ID to delete product");
        int del_id = scan.nextInt();
        for (Object obj : list) {
            if(((Computer)obj).getID().equals(del_id)){
                 System.out.println(((Computer)obj) + "has been removed...");
                list.remove((Computer)obj);
                return;
            }
        }
        System.out.print("Invalid item..");
        return;
    }


    public void searchProduct(List list){

        int moreSearch =1;
        char type;
        Scanner scan = new Scanner(System.in);
        Computer temp = new Computer();
        while(moreSearch == 1){
            System.out.println("a.. Search by Brand Name..");
            System.out.println("b.. Search by product Color..");
            System.out.println("c.. Search by HDD Size..");
            System.out.println("d.. Search by RAM Size..");
            System.out.println("e.. Search by ID..");
            System.out.print("Enter search type.. :: ");
            type = scan.next().charAt(0);
            switch (type) {
                case 'a': System.out.print("Enter Brand Name to Search: ");
                          temp.brand = scan.next();
                          if(temp.equals(list) == false)
                            System.out.println("Item not found..");
                          break;
                case 'b': System.out.print("Enter Item color to Search: ");
                          temp.color = scan.next();
                          if(temp.equals(list) == false)
                            System.out.println("Item not found..");
                          break;
                case 'c': System.out.print("Enter HDD Size to Search: ");
                            temp.hddSize = scan.nextInt();
                           if(temp.equals(list) == false)
                            System.out.println("Item not found..");
                          break;
                case 'd': System.out.print("Enter Ram Size to Search: ");
                          temp.ramSize = scan.nextInt();
                           if(temp.equals(list) == false)
                            System.out.println("Item not found..");
                          break;
                case 'e':System.out.print("Enter ID to Search: ");
                          temp.id = scan.nextInt();
                           if(temp.equals(list) == false)
                            System.out.println("Item not found..");
                          break;
                
            }
        System.out.print("\tWant to search more?? press 1 to continue :: ");
        moreSearch = scan.nextInt();
        }
    }
 
}