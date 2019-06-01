import State.MovieDownloader;
import State.Power.On.MyFile;
import javafx.util.Pair;

import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
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

        System.out.println("Menu");
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
        System.out.println("For resume please press 12");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        while(true){
            for(Map.Entry<Integer,String> pair:events.entrySet()){
                System.out.print(pair.getKey() + " - " + pair.getValue() + " | ");
            }
            System.out.println();
            System.out.println("Please enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            reader.close();
            switch(n){
                case 1:
                    movieDownloader.getPowerStateOff();
                    break;
                case 2:
                    movieDownloader.getPowerStateOnMachine();
                    break;
                case 3:
                    movieDownloader.getNetworkStateOff();
                    break;
                case 4:
                    Scanner reader1 = new Scanner(System.in);
                    System.out.println("Please enter thw file name: ");
                    String s = reader.nextLine();
                    reader.close();
                    Scanner reader2 = new Scanner(System.in);
                    System.out.println("Please enter a number: ");
                    int sizeOfFile = reader.nextInt();
                    reader.close();
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
                default:
                    if(n < 0 || n > 12){
                        System.out.println("Number has to be between 0 to 12");
                    }
                    if(!reader.hasNextInt()){
                        System.out.println("Invalid Input");
                    }
            }
        }


    }

}