package Application;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static filmImp filmImp = new filmImp();

    public static void main(String[] args) {

        System.out.println("enter your choice");
        System.out.println("1.add details\n 2. update details\n 3.display details\n 4. oscar nomination films\n5.exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addDetails();
                break;
            case 2:
                updateDetails();
                break;
            case 3:
                displayDetails();
                break;
            case 4:
                oscarnomination();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("invalid choice....");

        }
        main(args);
    }

    private static void oscarnomination() {
        filmImp dao=new filmImp();
        List<film> filmList = dao.oscarnomination();
        System.out.println(" FILMId \tFNAME \t FLANG \t FYEAR \t  FRATING ");
        System.out.println("-----------------------------------");
        for (film p : filmList) {
            System.out.println(p.getFid() + "    " + p.getFname() + "         " + p.getFlang() + "      " + p.getFyear() + "     " + p.getFrating());


        }

    }

    private static void displayDetails() {
        filmImp dao = new filmImp();
        List<film> filmList = dao.displayDetails();
        System.out.println(" FILMId \t\t FNAME \t\t FLANG \t\t FYEAR \t\t  FRATING ");
        System.out.println("-----------------------------------");
        for (film p : filmList) {
            System.out.println(p.getFid() + "    " + p.getFname() + "    " + p.getFlang() + "    " + p.getFyear() + "    " + p.getFrating());


        }
    }
        private static void updateDetails () {

            System.out.println("ENTER FILM ID");
            int fId = sc.nextInt();

            System.out.println("ENTER FILM YEAR");
            int fyear = sc.nextInt();


            film q = new film();
            q.setFyear(fyear);
            filmImp dao = new filmImp();
            int count = dao.updateDetails(q, fId);
            if (count > 0) {
                System.out.println("FILM YEAR Updated Successfully !!");
            } else {
                System.err.println("Question Not Updated !!");
            }
        }

        private static void addDetails ()
        {
            System.out.println("ENTER THE FILM NAME");
            String fname = sc.next();
            System.out.println("ENTER THE YEAR");
            int fyear = sc.nextInt();
            System.out.println("ENTER THE LANG");
            String flang = sc.next();
            System.out.println("ENTER THE RATING");
            int frating = sc.nextInt();

            film q = new film();

            q.setFname(fname);
            q.setFyear(fyear);
            q.setFlang(flang);
            q.setFrating(frating);

            filmImp dao = new filmImp();


            int count = dao.addDetails(q);
            if (count > 0) {
                System.out.println(count + " FILM ADDED SUCCESSFULLY");
            } else {
                System.err.println("SOMETHING WENT WRONG");
            }

        }

    }

