package edu.wmich.cs3310.KennethRivard;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> hash = new ArrayList<Integer>();

        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        Map<Integer, String> reverseHashMap = new HashMap<Integer, String>();

        //create a file and write to it
        String filename = "hashTable.txt";
        int choice;
        do {
            System.out.println("\nSecurity 101: Hash and Protect!" +
                    "\nType [1] to add a student to the hash table" +
                    "\nType [2] to find a student by the hash value" +
                    "\nType [3] to find a student by name" +
                    "\nType [4] to delete a student" +
                    "\nType [5] to print the hash table" +
                    "\nType [0] to EXIT the program\n");
            choice = in.nextInt();
            try {
                switch (choice) {
                    case 0: //create and write to file then quit the program
                        FileWriter fstream;
                        BufferedWriter out;

                        fstream = new FileWriter("hashTable.txt");
                        out = new BufferedWriter(fstream);
                        int count = 0;

                        Iterator<Map.Entry<Integer, String>> it = reverseHashMap.entrySet().iterator();

                        while(it.hasNext() && count < reverseHashMap.size()) {
                            Map.Entry<Integer, String> pairs = it.next();
                            out.write(pairs.getValue() + " : " + pairs.getKey() + "\n");
                        }
                        out.close();

                        System.out.println("Exiting . . .");
                        break;

                    case 1: //name insertion
                        System.out.println("How many students would you like to add?");
                        int inputNum = in.nextInt();
                        int decrement = inputNum;
                        for(int num = 0; num < inputNum; num++) {
                            System.out.println("Enter a name to hash it: " + "["+decrement--+"] left");
                            String inputHash = in2.nextLine();
                            int hashInt = 7;
                            int strlen = inputHash.length();
                            for(int i = 0; i < strlen; i++) {
                                hashInt = hashInt^inputHash.charAt(i);
                            }//end for
                            name.add(inputHash + " : " + hashInt);
                            hashMap.put(inputHash, hashInt);
                            reverseHashMap.put(hashInt, inputHash);
                        }//end for
                        break;

                    case 2: //find student by hashValue
                        System.out.println("Enter student hash value: ");
                        int hashSearch = in2.nextInt();

                        boolean found = false;
                        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                            found = false;
                            for(int i = 0; i < reverseHashMap.size(); i++) {
                                if(entry.getValue().equals(hashSearch)) {
                                    found = true;
                                    System.out.println("Student with Hash Value: " + hashSearch + " found!");
                                }
                            }
                            if(found == false) {
                                System.out.println(entry.getKey() + " : " + entry.getValue());
                                System.out.println("Student with Hash Value " + hashSearch + " not found!");
                            }
                        }
                        break;

                    case 3: //find student by name
                        System.out.println("Enter student name: ");
                        String nameSearch = in3.nextLine();

                        boolean find = false;
                        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                            find = false;
                            for(int i = 0; i < reverseHashMap.size(); i++) {
                                if(entry.getKey().equals(nameSearch)) {
                                    find = true;
                                    System.out.println(nameSearch + " found!");
                                }//end if
                            }//end for
                            if(find == false) {
                                System.out.println(entry.getKey() + " : " + entry.getValue());
                                System.out.println(nameSearch + " not found!");
                            }//end if
                        }//end for

                        break;

                    case 4: //delete student from hashTable
                        System.out.println("Enter student hash value: ");
                        if(!in3.hasNextInt()) {
                            System.out.println("ERROR! Only system administrators can delete students!\n" +
                                    "Please enter the hash value of the student.");
                        }//end if
                        else {
                            int inputDelete2 = in3.nextInt();
                            reverseHashMap.remove(inputDelete2);
                            System.out.println("Successfully deleted student!");
                        }//end else

                        break;

                    case 5: //show all information in hashTable
                        System.out.println("Printing Hash Table . . .");
                        for(Map.Entry<Integer, String> entry2 : reverseHashMap.entrySet() ) {
                            System.out.println(entry2.getKey() + " : " + entry2.getValue());
                        }//end for
                        break;

                    default: //if 0 through 5 are not entered
                        System.out.println("Error: Please choose an " +
                                "appropriate operation");
                        break;
                }//end switch
            }//end try

            //catches file IO errors
            catch (IOException e) {
                e.printStackTrace();
            }//end try catch

        }while(choice != 0); //end program upon user entering 0 from main menu

    }//end main

}//end class Main
