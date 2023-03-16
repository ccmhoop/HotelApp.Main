package Data;

import java.io.*;
import java.util.*;

public class Guests{

    private final ArrayList<String> voornaam = new ArrayList<String>();
    private final ArrayList<String> achternaam = new ArrayList<String>();
    private final ArrayList<String> orderNumb = new ArrayList<String>();
    private final ArrayList<String> orders = new ArrayList<String>();


    public void write(){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\voornaam.txt"));
            for (String vn : voornaam) {
                write.write(vn+"\n");
            }
            write.close();
            write = new BufferedWriter(new FileWriter("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\achternaam.txt"));
            for (String an : achternaam) {
                write.write(an+"\n");
            }
            write.close();
            write= new BufferedWriter(new FileWriter("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\orderNumb.txt"));
            for (String orNumb : orderNumb) {
                write.write(orNumb+"\n");
            }
            write.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void read (){
        try {
            String line;
            BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\orderNumb.txt"));
            while((line = read.readLine()) != null) {
                orderNumb.add(line);
            }
            read.close();
            read = new BufferedReader(new FileReader("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\voornaam.txt"));
            while((line = read.readLine()) != null) {
                voornaam.add(line);
            }
            read.close();
            read = new BufferedReader(new FileReader("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\achternaam.txt"));
            while((line = read.readLine()) != null) {
                achternaam.add(line);
            }
            read.close();
        } catch (IOException ignored){
        }
    }
    public void fullOrder(String a){
        try {
            File myObj = new File("C:\\Users\\ccmar\\IdeaProjects\\HotelApp\\src\\Data\\TXT\\Orders\\"+a+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void setName(String a,String b,String c){
       voornaam.add(a);
       achternaam.add(b);
       orderNumb.add(c);
    }
    /*
    public void printName(){
        for (int i = 0; i < voornaam.size(); i++) {
           int j = i + 1;
            System.out.println(j + ":" + voornaam.get(i) +" "+ achternaam.get(i));
        }
    }
     */
    public String rndUnique() {
        Random ran = new Random();
        int x = ran.nextInt(8998) + 1001;
        String a= String.valueOf(x);
        int brea = 0;
        do {
            if (orderNumb.contains(a)) {
                System.out.println("Copy"+  x);
                x = ran.nextInt(8998) +1001;
                a = String.valueOf(x);
                brea++;
            }
            else {
             // System.out.println(x);
                break;
            }
        }while(brea <10);
        a =String.valueOf(x);
        if (orderNumb.contains(a)){
            System.out.println("Null");
            return null;
        }
        return a;
    }
    public Integer getGuest (String a){
        Integer position = orderNumb.indexOf(a);
        if(position == -1){
            System.out.println("Entry does not exist");
            return null;
        }
            System.out.println(position);
            return position;
    }

    public String Checkin(int a){
        return (voornaam.get(a)+" "+achternaam.get(a));
    }

}
