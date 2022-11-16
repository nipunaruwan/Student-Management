import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Example{

   public static void main(String[] args){

       Scanner input = new Scanner(System.in);

       clearConsole();
       displayMainBanner();
       printStart();

       String[] sId = new String[0];
       String[] studentName = new String[0];
       int[] programmingMarks = new int[0];
       int[] dbmsMarks = new int[0];

       int[] total = new int[0];
       int[] sortedMarks = new int[0];
       int[] indexArray = new int[0];
       String[] studentTempName = new String[0];
       String[] studentTempsId = new String[0];
       int[] tempPromMarks = new int[0];
       int[] tempDbmsMarks = new int[0];


       char dis;
       int option;


       do{
           System.out.print("\nEnter an option to continue: ");
           option = input.nextInt();
           clearConsole();
           switch(option){

               case 1:{
                   do {
                       starRow();
                       banner1();
                       starRow();
                       System.out.println();
                       String id = inputId();
                       if(isDuplicate(sId, id))
                       {
                           System.out.println("Duplicate number\n");
                       }
                       else
                       {
                           sId = insertId(sId, id);
                           studentName = insertName(studentName);
                           programmingMarks = extendProMark(sId);
                           dbmsMarks = extendDbmsMark(sId);
                           System.out.println();
                           System.out.println("Student has been successfully added.");
                       }
                       System.out.print("Do you want to add a new Student(y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }

               case 2:{
                   do {
                       starRow();
                       banner2();
                       starRow();

                       System.out.println();
                       String id = inputId();
                       if(isDuplicate(sId, id)) {
                           System.out.println("Duplicate number\n");
                       }
                       else
                       {
                           sId = insertId(sId, id);
                           studentName = insertName(studentName);
                           System.out.println();
                           int index = findIndex(sId, id);
                           programmingMarks = insertProMarks(sId, programmingMarks, index);
                           dbmsMarks = insertDbmsMarks(sId, dbmsMarks, index);
                           System.out.println();
                           System.out.println("\nStudent has been successfullt added.");
                           
                       }
                       System.out.print("Do you want to add a new Student(y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }

               case 3:{

                   do {
                       starRow();
                       banner3();
                       starRow();

                       System.out.println();
                       String id = inputId();
                       if(isValidId(sId, id))
                       {
                           int index = findIndex(sId, id);
                           System.out.println();
                           System.out.println();
                           System.out.println("Student Name: " +studentName[index]);
                           programmingMarks = insertProMarks(sId, programmingMarks, index);
                           dbmsMarks = insertDbmsMarks(sId, dbmsMarks, index);
                           System.out.println();
                           System.out.println("\nMarks has been Successfully added.");
                       }
                       else
                       {
                           System.out.println("\nInvalid Student ID");
                           System.out.println("Student has not been successfully added.\n");
                       }

                       System.out.print("Do you want to add a new Student(y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }
               case 4:{

                   do {
                       starRow();
                       banner4();
                       starRow();

                       System.out.println();
                       String id = inputId();
                       if(isValidId(sId, id))
                       {
                           int index = findIndex(sId, id);
                           System.out.print("(New name)");
                           String name = inputName();
                           System.out.println();
                           updateDetails(studentName, index, name);
                           System.out.println("\nStudent details has been updated successfully.");
                       }

                       else {
                           System.out.println("\nInvalid Student ID.");
                       }

                       System.out.print("Do you want to update another student details (y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }

               case 5:{

                   do {
                       starRow();
                       banner5();
                       starRow();

                       System.out.println();
                       String id = inputId();
                       if(isValidId(sId, id))
                       {
                           String name = inputName();
                           System.out.println();
                           int index = findIndex(sId, id);
                           if(isValidId(sId, id) && findName(studentName, index, name))
                           {
                               programmingMarks = insertProMarks(sId, programmingMarks, index);
                               dbmsMarks = insertDbmsMarks(sId, dbmsMarks, index);
                               System.out.println();
                               System.out.println("\nStudent details has been updated successfully.\n");
                           }
                           else
                               System.out.println("\nInvalid name try again");

                       }
                       else
                           System.out.println("\nInvalid Student ID");

                       System.out.print("Do you want to update another student details (y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }

               case 6:{

                   do {
                       starRow();
                       banner6();
                       starRow();

                       System.out.println();
                       String id = inputId();
                       if(isValidId(sId, id))
                       {
                           int index = findIndex(sId, id);
                           System.out.println("Do you want to delete student(y/n): " +studentName[index]);
                           dis = input.next().charAt(0);

                           if(dis=='y')
                           {
                               studentName = deleteStudentName(studentName, index);
                               programmingMarks = deleteProMarks(programmingMarks, index);
                               dbmsMarks = deleteDbmsMarks(dbmsMarks, index);
                               sId = deleteStudentId(sId, id);
                               System.out.println("Student has been successfully deleted. ");
                               System.out.print("\nDo you want to delete another student detail (y/n): ");
                               dis = input.next().charAt(0);
                               clearConsole();
                           }
                           else
                           {

                               if(dis=='y')
                               {
                                   clearConsole();
                                   starRow();
                                   banner6();
                                   starRow();
                                   System.out.print("\nDo you want to delete another student detail (y/n): ");
                                   dis = input.next().charAt(0);

                               }
                               else
                               {
                                   clearConsole();
                                   dis = 'n';
                               }
                           }

                       }
                       else
                       {
                           System.out.println("\nInvalid Student ID");
                           System.out.print("\nDo you want to delete another student detail (y/n): ");
                           dis = input.next().charAt(0);
                           clearConsole();

                       }

                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }



               case 7:{

                   total = totalMarks(programmingMarks, dbmsMarks);
                   indexArray = indexArray(total);

                   studentTempName = handle(indexArray, studentName);
                   studentTempName = reverse(studentTempName);

                   studentTempsId = handle(indexArray, sId);
                   studentTempsId = reverse(studentTempsId);

                   total = sort(total);
                   total = reverse(total);

                   tempDbmsMarks = dbmsMarks;
                   tempDbmsMarks = sort(tempDbmsMarks);
                   tempDbmsMarks = reverse(tempDbmsMarks);

                   tempPromMarks = programmingMarks;
                   tempPromMarks = sort(tempPromMarks);
                   tempPromMarks = reverse(tempPromMarks);

                   do {
                       starRow();
                       banner7();
                       starRow();


                       System.out.println();
                       String id = inputId();
                       if(isValidId(sId, id))
                       {
                           String name = inputName();
                           System.out.println();

                           if(isValidId(studentName, name))
                           {
                               int index = findIndex(studentTempsId, id);
                               String rank = rank(index+1);

                               if(programmingMarks[index]==0 || dbmsMarks[index]==0)
                                   System.out.println("Marks are yet to be added !!!");

                             else
                               {
                                   System.out.println("+-----------------------------------------------------+");
                                   System.out.printf("|%-40s | %-10d| %n" ,"Programming Fundamentals Marks" ,tempPromMarks[index]);
                                   System.out.printf("|%-40s | %-10d| %n" ,"Database Management Systems Marks" ,tempDbmsMarks[index]);
                                   System.out.printf("|%-40s | %-10d| %n" ,"Total marks" ,total[index]);
                                   System.out.printf("|%-40s | %-10d| %n" ,"Avg. Marks" , total[index]/2);
                                   System.out.printf("|%-40s | %d%-9s| %n" ,"Rank" , index+1, rank);
                                   System.out.println("+-----------------------------------------------------+");
                               }
                           }
                           else
                               System.out.println("\nInvalid Student name");

                       }
                       else
                           System.out.println("\nInvalid Student ID");

                       System.out.print("Do you want to search another student details? (y/n): ");
                       dis = input.next().charAt(0);
                       clearConsole();
                   }while(dis != 'n');
                   displayMainBanner();
                   printStart();
                   break;
               }

               case 8:{
                   starRow();
                   banner8();
                   starRow();
                   System.out.println();

                   total = totalMarks(programmingMarks, dbmsMarks);
                   indexArray = indexArray(total);
                   studentTempName = handle(indexArray, studentName);
                   studentTempsId = handle(indexArray, sId);
                   sortedMarks = sort(total);

                   if(isLegalSize(studentTempsId,studentTempName,sortedMarks))
                   {
                       System.out.println("+--------------------------------------------------------------------+");
                       System.out.printf("|%-10s |%-10s |%-10s |%-15s |%-15s| %n", "RANK", "ID", "Name", "Total Marks", "Avg.marks");
                       System.out.println("+--------------------------------------------------------------------+");

                       for(int i=sId.length-1,j=0;i>=0;i--,j++)
                       {
                           System.out.printf("|%-10d |%-10s |%-10s |%-15s |%-15.2f|", (j+1), studentTempsId[i], studentTempName[i], sortedMarks[i] ,(float)sortedMarks[i]/2);
                           System.out.println();
                       }
                       System.out.println("+--------------------------------------------------------------------+");
                   }
                   else
                       System.out.println("Blank array warning, please fill arrays first !!!");

                   System.out.print("\nDo you want to go back to the menu(y/n): ");
                   dis = input.next().charAt(0);

                   if(dis=='y')
                   {
                       clearConsole();
                       displayMainBanner();
                       printStart();
                       break;
                   }
                   else
                   {
                       System.out.print("OK !!! press any key to quit when you want.");
                       dis = input.next().charAt(0);
                       clearConsole();
                       displayMainBanner();
                       printStart();
                       break;
                   }
               }

               case 9:{

                   starRow();
                   banner9();
                   starRow();
                   System.out.println();

                   indexArray = indexArray(programmingMarks);
                   studentTempName = handle(indexArray, studentName);
                   studentTempsId = handle(indexArray, sId);
                   sortedMarks = sort(programmingMarks);

                   tempDbmsMarks = dbmsMarks;
                   tempDbmsMarks = handle(indexArray, dbmsMarks);

                   tempPromMarks = programmingMarks;
                   tempPromMarks = sort(tempPromMarks);

                   if(isLegalSize(studentTempsId,studentTempName,sortedMarks))
                   {
                       System.out.println("+---------------------------------------------------------------------------+");
                       System.out.printf("|%-20s|%-20s|%-20s |%-12s| %n" ,"ID", "Name", "DBMS Marks", "PF Marks");
                       System.out.println("+---------------------------------------------------------------------------+");

                       for(int i=sId.length-1,j=0;i>=0;i--,j++)
                       {
                           System.out.printf("|%-19s |%-19s |%-20d |%-12d|" ,studentTempsId[i], studentTempName[i], tempPromMarks[i] , tempDbmsMarks[i]);
                           System.out.println();
                       }
                       System.out.println("+---------------------------------------------------------------------------+");
                   }
                   else
                       System.out.println("Blank array warning, please fill arrays first !!!");

                   System.out.print("\nDo you want to go back to the menu(y/n): ");
                   dis = input.next().charAt(0);

                   if(dis=='y')
                   {
                       clearConsole();
                       displayMainBanner();
                       printStart();
                       break;
                   }
                   else
                   {
                       System.out.println("OK !!!");
                       break;
                   }
               }

               case 10:{

                   starRow();
                   banner10();
                   starRow();
                   System.out.println();

                   total = totalMarks(programmingMarks, dbmsMarks);
                   indexArray = indexArray(dbmsMarks);
                   studentTempName = handle(indexArray, studentName);
                   studentTempsId = handle(indexArray, sId);
                   sortedMarks = sort(total);

                   tempDbmsMarks = dbmsMarks;
                   tempDbmsMarks = sort(tempDbmsMarks);

                   tempPromMarks = programmingMarks;
                   tempPromMarks = handle(indexArray, programmingMarks);

                   if(isLegalSize(studentTempsId,studentTempName,sortedMarks))
                   {
                       System.out.println("+---------------------------------------------------------------------------+");
                       System.out.printf("|%-20s|%-20s|%-20s |%-11s| %n" ,"ID", "Name", "DBMS Marks", "PF Marks");
 
                    System.out.println("+---------------------------------------------------------------------------+");
                       for(int i=sId.length-1,j=0;i>=0;i--,j++)
                       {
                           System.out.printf("|%-20s|%-20s|%-21d| %-10d|" ,studentTempsId[i], studentTempName[i], tempDbmsMarks[i] , tempPromMarks[i]);
                           System.out.println();
                       }
                       System.out.println("+---------------------------------------------------------------------------+");
                   }
                   else
                       System.out.println("Blank array warning, please fill arrays first !!!");

                   System.out.print("\nDo you want to go back to the menu(y/n): ");
                   dis = input.next().charAt(0);

                   if(dis=='y')
                   {
                       clearConsole();
                       displayMainBanner();
                       printStart();
                       break;
                   }
                   else
                   {
                       System.out.println("OK !!!");
                       break;
                   }
               }
           }
       }while(true);
   }

    public static String rank(int index){

       switch (index){
           case 1: return "(first)";
           case 2: return "(Second)";
           case 3: return "(Third)";
           case 4: return "(Fourth)";
           case 5: return "(Fifth)";
           case 6: return "(Sixth)";
           case 7: return "(Seventh)";
           case 8: return "(Eighth)";
           case 9: return "(Ninth)";
           case 10: return "(Tenth)";
           case 11: return "(Eleventh)";
           case 12: return "(Twelfth)";
           case 13: return "(Thirteenth)";
           case 14: return "(Fourteenth)";
           case 15: return "(Fifteenth)";
           case 16: return "(Sixteenth)";
           case 17: return "(Seventeenth)";
           case 18: return "(Eighteenth)";
           case 19: return "(Nineteenth)";
           case 20: return "(Twentieth)";
           case 21: return "(Twenty First)";
           case 22: return "(Twenty Second)";
           case 23: return "(Twenty Third)";
           case 24: return "(Twenty Fourth)";
           case 25: return "(Twenty Fifth)";
           default: return "(Invalid)";
       }
    }

    public static int[] extendProMark(String[] arr){

       int[] newArray = new int[size(arr)];
       return newArray;
    }

    public static int[] extendDbmsMark(String[] arr){

        int[] newArray = new int[size(arr)];
        return newArray;
    }

    public static String[] reverse(String[] arr){

       String[] newArray = new String[size(arr)];

       for(int i=arr.length-1,j=0;i>=0;i--,j++)
           newArray[i] = arr[j];

       return newArray;
    }

    public static int[] reverse(int[] arr){

        int[] newArray = new int[size(arr)];

        for(int i=arr.length-1,j=0;i>=0;i--,j++)
            newArray[i] = arr[j];

        return newArray;
    }

    public static boolean isLegalSize(String[] arr1, String[] arr2, int[] arr3){

       return arr1.length>0 && arr2.length>0 && arr3.length>0;
    }

    public static String[] handle(int[] index, String[] name){
        String[] newName = new String[index.length];
        for(int i=0;i<index.length;i++)  {
            newName[i] = name[i];
        }
        for(int i=0;i<index.length;i++) {
            name[index[i]] = newName[i];
        }
        return name;
    }

    public static int[] handle(int[] index, int[] name){

        int[] newName = new int[index.length];

        for(int i=0;i<index.length;i++)
        {
            newName[i] = name[i];
        }

        for(int i=0;i<index.length;i++)
        {
            name[index[i]] = newName[i];
        }

        return name;

    }

   public static int[] indexArray(int[] originalArr){

       int[] newArray = new int[size(originalArr)];

       for(int i=0;i<size(originalArr);i++)
       {
           newArray[i] = originalArr[i];
       }

       newArray = sort(newArray);
       int[] indexArray = new int[size(originalArr)];

       for(int i=0;i<newArray.length;i++)
       {
           for(int j=0;j<newArray.length;j++)
           {
               if(originalArr[i]==newArray[j])
                   indexArray[i] = j;
           }
       }

       return indexArray;
   }

   public static int[] totalMarks(int[] programmingArray, int[] dbmsArray){ //To get the total

       int[] marksArray = new int[size(programmingArray)];

       for(int i=0;i<dbmsArray.length;i++)
       {
           marksArray[i] = programmingArray[i] + dbmsArray[i];
       }

       return marksArray;
   }

   public static int[] sort(int[] arr){

       int[] newArray = new int[arr.length];

       for(int i=0;i<arr.length;i++)
       {
           newArray[i] = arr[i];
       }

       for(int i=newArray.length;i>0;i--)
       {
           int index = 0;
           int max = newArray[0];

           for(int j=1;j<i;j++)
           {
               if(newArray[j]>max)
               {
                   index = j;
                   max = newArray[j];
               }
           }
           newArray[index] = newArray[i-1];
           newArray[i-1] = max;
       }
       return newArray;
   }

   public static String[] deleteStudentId(String[] arr, String id){

       for(int i=arr.length-1;i>0;i--)
       {
           for(int j=0;j<i;j++)
           {
               if(arr[j].equals(id))
               {
                   String temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }

       String[] newArray = new String[arr.length-1];

       for(int i=0;i<arr.length-1;i++)
       {
           newArray[i] = arr[i];
       }

       return newArray;
   }

    public static String[] deleteStudentName(String[] arr, int index){

        String temp = arr[index];
        arr[index] = arr[size(arr)-1];
        arr[size(arr)-1] = temp;

        String[] newArray = new String[arr.length-1];

        for(int i=0;i<arr.length-1;i++)
        {
            newArray[i] = arr[i];
        }

        return newArray;
    }

    public static int[] deleteProMarks(int[] arr, int index){

        int temp = arr[index];
        arr[index] = arr[size(arr)-1];
        arr[size(arr)-1] = temp;

        int[] newArray = new int[arr.length-1];

        for(int i=0;i<arr.length-1;i++)
        {
            newArray[i] = arr[i];
        }

        return newArray;
    }

    public static int[] deleteDbmsMarks(int[] arr, int index){

        int temp = arr[index];
        arr[index] = arr[size(arr)-1];
        arr[size(arr)-1] = temp;

        int[] newArray = new int[arr.length-1];

        for(int i=0;i<arr.length-1;i++)
        {
            newArray[i] = arr[i];
        }

        return newArray;
    }

   public static boolean findName(String[] arr, int index, String name){

       if(arr[index].equals(name))
           return true;
       else
           return false;
   }

   public static void updateDetails(String[] arr,int index, String name){ arr[index]=name; }

   public static boolean isValidId(String[] arr, String id){

       for(int i=0;i<arr.length;i++)
       {
           if(arr[i].equals(id))
               return true;
       }
       return false;
   }

   public static int findIndex(String[] arr, String id){

       int index = 0;

       for(int i=0;i<arr.length;i++)
       {
           if(arr[i].equals(id))
           {
               index = i;
               break;
           }
       }
       return index;
   }

   public static void print(String[] arr){

       for(String x:arr)
           System.out.println(x);
   }

	public static String inputId(){

       Scanner input = new Scanner(System.in);

       System.out.print("Enter ID: ");
       String id = input.nextLine();

       return id;
   }

    public static String inputName(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        return name;
    }

   public static void printStart(){

       System.out.printf("%-40s %s\n" ,"[1] Add New Student", "[2] Add New Student with marks");
       System.out.printf("%-40s %s\n" ,"[3] Add marks", "[4] update student details");
       System.out.printf("%-40s %s\n" ,"[5] update marks", "[6] delete student");
       System.out.printf("%-40s %s\n" ,"[7] print student details", "[8] print student ranks");
       System.out.printf("%-40s %s\n" ,"[9] Best in programming fundamentals", "[10] Best in Database Management System");
   }


   public static String[] insertId(String[] arr, String id){

       int length = size(arr);
       String[] newArray = new String[length+1];

       for(int i=0;i<length;i++)
       {
           newArray[i] = arr[i];
       }

       newArray[length] = id;

       return newArray;
   }

    public static String[] insertName(String[] arr){

       Scanner input = new Scanner(System.in);

        int length = size(arr);
        String[] newArray = new String[length+1];

        for(int i=0;i<length;i++)
        {
            newArray[i] = arr[i];
        }
        System.out.print("Enter student Name: ");
        String name = input.nextLine();

        newArray[length] = name;
        return newArray;
    }

    public static int[] insertProMarks(String[] arr, int[] proArray, int index){

        Scanner input = new Scanner(System.in);

        int[] newArray = new int[arr.length];

        for(int i=0;i<newArray.length-1;i++)
        {
            newArray[i] = proArray[i];
        }

        System.out.print("Enter Programming Fundamentals Marks: ");
        int mark = input.nextInt();

        if(mark<0 || mark>100)
        {
            do{
                System.out.print("Invalid mark. Please try again(0-100): ");
                mark = input.nextInt();

            }while(mark<0 || mark>100);
        }
        newArray[index] = mark;

        return  newArray;
    }

    public static int[] insertDbmsMarks(String[] arr, int[] dbmsArray, int index){

        Scanner input = new Scanner(System.in);

        int[] newArray = new int[arr.length];

        for(int i=0;i<newArray.length-1;i++)
        {
            newArray[i] = dbmsArray[i];
        }

        System.out.print("Enter Data Base Management Marks: ");
        int mark = input.nextInt();

        if(mark<0 || mark>100)
        {
            do{
                System.out.print("Invalid mark. Please try again(0-100): ");
                mark = input.nextInt();

            }while(mark<0 || mark>100);
        }
            newArray[index] = mark;

        return newArray;
    }

    public static boolean isDuplicate(String[] arr, String data){

       for(int i=0;i<arr.length;i++)
       {
           if(arr[i].equals(data))
               return true;
       }
       return false;
    }

   public static int size(int[] arr){

       return arr.length;
   }


    public static int size(String[] arr){

        return arr.length;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    public static void starRow(){

       for(int i=0;i<92;i++)
           System.out.print("*");

       System.out.print("\n");
    }

    public static void mainBanner(){

       System.out.print("|");
       for(int i=0;i<25;i++)
           System.out.print(" ");

       System.out.print("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");

        for(int i=0;i<26;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void displayMainBanner(){
       starRow();
       mainBanner();
       starRow();
       System.out.println("\n");
    }

    public static void banner1(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("ADD NEW STUDENT");

        for(int i=0;i<40;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner2(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("ADD NEW STUDENT WITH MARKS");

        for(int i=0;i<29;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner3(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("Add marks");

        for(int i=0;i<46;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner4(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("update student details");

        for(int i=0;i<33;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner5(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("update marks");

        for(int i=0;i<43;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner6(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("delete student");

        for(int i=0;i<41;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner7(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("print student details");

        for(int i=0;i<34;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner8(){

        System.out.print("|");
        for(int i=0;i<35;i++)
            System.out.print(" ");

        System.out.print("print student ranks");

        for(int i=0;i<36;i++)
            System.out.print(" ");

        System.out.print("|\n");
    }

    public static void banner9(){

        System.out.print("|");
        for(int i=0;i<30;i++)
            System.out.print(" ");

        System.out.print("Best in programming fundamentals");

        for(int i=0;i<28;i++)
            System.out.print(" ");

        System.out.print("|\n\n");
    }

    public static void banner10(){

        System.out.print("|");
        for(int i=0;i<30;i++)
            System.out.print(" ");

        System.out.print("Best in Database Management System");

        for(int i=0;i<26;i++)
            System.out.print(" ");

        System.out.print("|\n\n");
    }
}

