import State.MovieDownloader;
import State.Power.On.MyFile;
import javafx.util.Pair;

import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        /*System.out.println("Menu");
        System.out.println("Please press a number between 0 to 12");
        System.out.println("For turn on please press 0");
        System.out.println("For turn off please press 1");
        System.out.println("For turn the internet on please press 2");
        System.out.println("For turn the internet off please press 3");
        System.out.println("For file request please press 4");
        System.out.println("For download aborted please press 5");
        System.out.println("For download error please press 6");
        System.out.println("For error fixed please press 7");
        System.out.println("For movie on please press 8");
        System.out.println("For restart movie please press 9");
        System.out.println("For hold movie please press 10");
        System.out.println("For movie off please press 11");
        System.out.println("For resume please press 12");*/

        System.out.println("------------------------------------------------------");
        MovieDownloader movieDownloader=new MovieDownloader();
        HashMap<Integer,String> events=new HashMap<>();
        events.put(0,"Turn on");
        events.put(1,"Turn off");
        events.put(2,"Internet on");
        events.put(3,"Internet off");
        events.put(4,"File request");
        events.put(5,"Download aborted");
        events.put(6,"Download error");
        events.put(7,"Error fixed");
        events.put(8,"Movie on");
        events.put(9,"Restart movie");
        events.put(10,"Hold movie");
        events.put(11,"Movie off");
        events.put(12,"Resume");
        events.put(13,"Change Disk Space");
        events.put(14,"Get downloader data");
        events.put(15,"Exit program");
        Scanner reader;  // Reading from System.in
        while(true){
            System.out.println("------------------------------------------------------");
            int counter=0;
            for(Map.Entry<Integer,String> pair:events.entrySet()){
                if(counter%7==0){
                    System.out.println();
                }
                System.out.print(pair.getKey() + " - " + pair.getValue() + " | ");
                counter++;
            }
            System.out.println();
            System.out.println("Please enter a number: ");
            int n=0;
            boolean goodInput;
            do {
                reader = new Scanner(System.in);  // Reading from System.in
                goodInput=true;
                try {
                    n = reader.nextInt(); // Scans the next token of the input as an int.
                    if(n<0 || n>=events.size()){
                        System.out.println("Enter a Number between 0 to " + (events.size()-1));
                        goodInput=false;
                    }
                }
                catch (Exception e){
                    System.out.println("Please enter a number");
                    goodInput=false;
                }
            }
            while (!goodInput);
            System.out.println("------------------------------------------------------");
            switch(n){
                case 0:
                    movieDownloader.turnOn();
                    break;
                case 1:
                    movieDownloader.turnOff();
                    break;
                case 2:
                    movieDownloader.internetOn();
                    break;
                case 3:
                    movieDownloader.internetOff();
                    break;
                case 4:
                    Scanner reader1 = new Scanner(System.in);
                    System.out.println("Please enter the file's name: ");
                    String s;
                    do{
                        s = reader1.nextLine();
                        if(s.isEmpty()){
                            System.out.println("Please enter a valid name");
                        }
                    }
                    while (s.isEmpty());
                    //reader1.close();


                    double sizeOfFile=0;
                    //reader2.close();
                    boolean allGood;
                    do{
                        Scanner reader2 = new Scanner(System.in);
                        allGood = true;
                        try{
                            System.out.println("Please enter the file's size: ");

                            sizeOfFile = reader2.nextDouble();
                            if(sizeOfFile<=0){
                                System.out.println("Please enter a positive number");
                                allGood = false;
                            }
                        }
                        catch (Exception e){
                            System.out.println("Please enter a number");
                            allGood = false;
                        }
                    }
                    while (!allGood);
                    MyFile myfile = new MyFile(s,sizeOfFile);
                    movieDownloader.fileRequest(myfile);
                    break;
                case 5:
                    movieDownloader.downloadAborted();
                    break;
                case 6:
                    movieDownloader.downloadError();
                    break;
                case 7:
                    movieDownloader.errorFixed();
                    break;
                case 8:
                    movieDownloader.movieOn();
                    break;
                case 9:
                    movieDownloader.restartMovie();
                    break;
                case 10:
                    movieDownloader.holdMovie();
                    break;
                case 11:
                    movieDownloader.movieOff();
                    break;
                case 12:
                    movieDownloader.resume();
                    break;
                case 13:
                    double space2Add=0;
                    //reader2.close();
                    boolean fine;
                    do{
                        Scanner reader3 = new Scanner(System.in);
                        fine = true;
                        try{
                            System.out.println("How much space do you want to add?");
                            space2Add = reader3.nextDouble();
                            if(space2Add*(-1)>movieDownloader.getSpaceLeft()){
                                System.out.println("You cant discard so much space because it is used");
                                allGood = false;
                            }
                        }
                        catch (Exception e){
                            System.out.println("Please enter a number");
                            allGood = false;
                        }
                    }
                    while (!fine);
                    movieDownloader.addSpace(space2Add);
                    break;
                case 14:
                    if(movieDownloader.isOn()){
                        double speed=movieDownloader.getSpeed();
                        double spaceAvailable = movieDownloader.getSpaceLeft();
                        int points = movieDownloader.getPoints();
                        int queueSize = movieDownloader.getQueueSize();
                        System.out.println("You have " + spaceAvailable + " space left.");
                        System.out.println("You have " + points + " points.");
                        System.out.println("You have download speed of " + speed + " units per second.");
                        System.out.println("There are " + queueSize + " files waiting to be downloaded.");
                    }
                    else{
                        System.out.println("MovieDownloader is off");
                    }
                    break;
                case 15:
                    System.out.println("------------------------------------------------------");
                    System.out.println("Thank you for using our program, have a nice day!");
                    return;
            }
        }


    }

}