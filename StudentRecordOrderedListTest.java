package com.elec0021;

import java.util.Scanner;

public class StudentRecordOrderedListTest {
    public static void main(String[] args) {
        StudentRecordOrderedList srol = new StudentRecordOrderedList("SROL");//intialise studentrecordlist
        StudentRecord sr = new StudentRecord("","",0,0);//intialise student record
        Scanner in = new Scanner(System.in);//set variables
        int num, numin;
        float fin;
        String strin;
        boolean bol;
        ListNode returnnode;
        while (true) {//while loop exits if user specifies
            System.out.println("1.)Enter student record\n2.)Remove student record\n3.)Print a student record\n4.)Print all student records\n5.)Exit");
            try {
                num = in.nextInt();
                switch (num) {
                    case 1://inserts student record
                        sr = new StudentRecord("","",0,0);
                        System.out.println("Enter surname");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.surname = strin;
                        System.out.println("Enter name");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.name = strin;
                        System.out.println("Enter student number");
                        numin = in.nextInt();
                        sr.studentNo = numin;
                        System.out.println("Enter average mark");
                        fin = (float) in.nextDouble();
                        sr.averageMark = fin;
                        bol = srol.insert(sr);
                        if(!bol){
                            throw new Exception();
                        }else{
                            break;
                        }
                    case 2://removes student record
                        sr = new StudentRecord("","",0,0);
                        System.out.println("Enter surname");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.surname = strin;
                        System.out.println("Enter name");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.name = strin;
                        returnnode = srol.remove(sr);
                        if(returnnode == null){
                            throw new Exception();
                        }else{
                            break;
                        }
                    case 3://prints a student record
                        sr = new StudentRecord("","",0,0);
                        System.out.println("Enter surname");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.surname = strin;
                        System.out.println("Enter name");
                        in.useDelimiter("\\n");
                        strin = in.next();
                        sr.name = strin;
                        returnnode = srol.find(sr);
                        if(returnnode == null){
                            throw new Exception();
                        }else{
                            sr = (StudentRecord) returnnode.data;
                            System.out.println(sr.toString());
                            break;
                        }
                    case 4://prints all student record
                        System.out.println(srol.toString());
                        break;
                    case 5://exits program
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.print("Invalid value please try again\n");
                in.nextLine();
            }
        }
    }
}
class StudentRecordOrderedList extends OrderedList {
    protected int compare(Object obj1,Object obj2){//compare method returns the difference of string values of concatenated surname and name
        StudentRecord s1 = (StudentRecord) obj1;
        StudentRecord s2 = (StudentRecord) obj2;
        String str1 = s1.surname.concat(s1.name);
        String str2 = s2.surname.concat(s2.name);
        return str1.compareTo(str2);
    }
    public StudentRecordOrderedList(String SROL){//constructor sets name
        super(SROL);
    }
}
class StudentRecord {//student record structure
    public String surname;
    public String name;
    public int studentNo;
    public float averageMark;
    public String toString (){
        String out = new String();
        out = this.surname + " " + this.name + " " + studentNo + " " + averageMark;
        return out;
    }
    public StudentRecord (String surname_in,String name_in,int studentNo_in,float averageMark_in){//constructor sets attributes
        this.surname = surname_in;
        this.name = name_in;
        this.studentNo = studentNo_in;
        this.averageMark = averageMark_in;
    }
}
