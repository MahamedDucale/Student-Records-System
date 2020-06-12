package com.elec0021;

import java.util.*;

public class IntStringOrderedListTest {
    public static void main(String[] args){
        IntegerOrderedList iol = new IntegerOrderedList("IOL");//intialise integerorderedlist
        StringOrderedList sol = new StringOrderedList("SOL");//intialise stringorderedlist
        Scanner in = new Scanner(System.in);
        int num,numin;//variables
        String strin;
        boolean bol;
        ListNode returnnode;
        while(true){//while loop exits when exit specified
        System.out.println("1.)Enter string\n2.)Enter integer\n3.)Remove integer\n4.)Remove string\n5.)Print Lists\n6.)Exit");//prompt user for input
        try{
            num = in.nextInt();
            switch(num){
                case 1://inserts string into linked list
                    System.out.println("Enter string");
                    in.useDelimiter("\\n");
                    strin = in.next();
                    bol = sol.insert(strin);
                    if(!bol){
                        throw new Exception();
                    }else{
                    break;
                    }
                case 2://inserts integer into linked list
                    System.out.println("Enter number");
                    numin = in.nextInt();
                    bol = iol.insert(numin);
                    if(!bol){
                        throw new Exception();
                    }else{
                        break;
                    }
                case 3://removes string from linked list
                    System.out.println("Enter string to remove");
                    in.useDelimiter("\\n");
                    strin = in.next();
                    returnnode = sol.remove(strin);
                    if(returnnode == null){
                        throw new Exception();
                    }else{
                        break;
                    }
                case 4://removes integer from linked list
                    System.out.println("Enter integer to remove");
                    numin = in.nextInt();
                    returnnode = iol.remove(numin);
                    if(returnnode == null){
                        throw new Exception();
                    }else{
                        break;
                    }
                case 5://prints linked lists
                    System.out.println(sol.toString() + "\n" + iol.toString());
                    break;
                case 6://exits program
                    System.exit(0);
                    break;
            }
        }catch(Exception e){
            System.out.print("Invalid value please try again\n");
            in.nextLine();
        }
        }
    }
}
class IntegerOrderedList extends OrderedList {
    @Override
    protected int compare(Object obj1,Object obj2){//compare returns difference of ints
        int int1 = (Integer) obj1;
        int int2 = (Integer) obj2;
        return (int1 - int2);
    }
    public IntegerOrderedList(String IOLname){
        super(IOLname);
    }//constructor sets name of integerorderedlist
}
class StringOrderedList extends OrderedList{
    @Override
    protected int compare(Object obj1,Object obj2){//returns string value difference
        String str1 = (String) obj1;
        String str2 = (String) obj2;
        return str1.compareTo(str2);
    }
    public StringOrderedList(String SOLname){//sets list name
        super(SOLname);
    }
}
