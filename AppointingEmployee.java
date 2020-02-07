import java.util.Scanner;


class Employee{
    int age;
    String name , lname;
 
    Employee(String name, String lname, int age){
        this.name = name;
        this.age = age;
        this.lname = lname;
    }

    Employee(){


    }
 
    public Integer getAge(){
        return this.age;
    }
 
    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lname;
    }

    public void setLastName(){
        lname="";
    	for(int i=0;i<name.length();i++){
    		if(name.charAt(i)==' '){
    			lname = name.substring(i+1,name.length());
    			name = name.substring(0,i-1);
    			break;
    		}

    	}

    }

    public void setAge(Integer age){
        this.age = age;
    }
 
    public void setName(String name){

         this.name = name;
    }
 
    @Override
    public String toString(){
        return "\n(" + this.getName() + "," + this.getLastName() + "," + this.getAge() + ")" ;
    }
}
 
 
 
 
 
 
class SortByName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getName().compareTo(((Employee)secondObj).getName());
    }
}
 
class SortByLastName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return (((Employee)firstObj).getLastName().toUpperCase().compareTo(((Employee)secondObj).getLastName().toUpperCase()));
    }
}

 
class SortByAge implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getAge().compareTo(((Employee)secondObj).getAge());
    }
}
 
 
class AppointingEmployee{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        java.util.List employeeList = new java.util.ArrayList();
        Employee emp = new Employee();
        employeeList.add(new Employee("Ayushman", "Khurana", 65));
        employeeList.add(new Employee("Samrat","Das", 31));
        employeeList.add(new Employee("Abhi","Ghosh", 35));
    
        int more =1, choice;
        while(more == 1){
            emp = null;
            emp = new Employee();
            System.out.print("Enter name of Employee:: ");
            emp.setName(sc.nextLine());
            sc.nextLine();	//skipping input
            emp.setLastName();
            System.out.print("Enter age :: ");
            emp.setAge(sc.nextInt());
            employeeList.add(emp);
            System.out.print("Want to add more employees??... press 1 to continue ..:: ");
            more = sc.nextInt();
        }
        more =1;

        System.out.println("\t\t\t\t....SORTING PROCESS...");
        while(more == 1){

            System.out.println("1 Sort by First Name \n2 Sort by Last \n3 Sort by Age");
            System.out.println("Enter your choice:: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:System.out.println("\t\tList before sorting (by first name) : " + employeeList);
                       java.util.Collections.sort(employeeList, new SortByName());
                       System.out.println("\t\tList after sorting (by first name): " + employeeList);
                       	break;
                case 2:
                       	System.out.println("\t\tList before sorting (by Last name) : " + employeeList);
                       java.util.Collections.sort(employeeList, new SortByLastName());
                       System.out.println("\t\tList after sorting (by Last name): " + employeeList);
                       


                       break;
                case 3: System.out.println("\t\tList before sorting (by age) : " + employeeList);
                        java.util.Collections.sort(employeeList, new SortByAge());
                        System.out.println("\t\tList after sorting (by age) : " + employeeList);
                        break;
                default :System.out.print("Wrong Input!!..");
            }
            System.out.print("Want to sort more??.... press 1 to continue..");
            more = sc.nextInt();
        }

    }
}
 
 
 
    // 1. Add New Employee
    //     - Enter name
    //     - ENter Age
    // Do you want to add more(y/n) :n
 
    // Sort by:
    // 1. First name
    // 2. Last name
    // 3. Age
 
 
 
 
// Comparator
//  - public int compare(Object first, Object second);