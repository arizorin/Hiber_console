package ru.techcenter;
import ru.techcenter.dao.UserDao;
import ru.techcenter.rolfcenter.Autos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int num = 0;
        String text;
        String brand, model;
        boolean exit = false;
        UserDao dao = new UserDao();
        Autos newClient = new Autos();

        while (!exit) {
            System.out.println
                    ("1 - Add Client\n" +
                            "2 - Remove Client\n" +
                            "3 - Update Client\n" +
                            "4 - Find Client by ID\n" +
                            "5 - Show all Clients\n" +
                            "Any - Exit\n" +
                            " Your Choice: ");
            num = scan.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Enter ID, ex:1009: ");
                    num = scan.nextInt();
                    newClient.setCLIENT_ID(num);
                    System.out.println("Enter CAR MODEL(BRAND), ex:BMW,Audi etc.: ");
                    brand = scan.next();
                    newClient.setMODEL(brand);
                    System.out.println("Enter CAR SERIES), ex:G63, M5 etc.: ");
                    model = scan.next();
                    newClient.setSERIES(model);
                    dao.AddClient(newClient);
                    break;

                case 2:
                    System.out.println("Enter ID, ex:1009: ");
                    num = scan.nextInt();
                    newClient.setCLIENT_ID(num);
                    dao.DeleteClient(newClient);
                    break;

                case 3:
                    System.out.println("Enter ID, ex:1009: ");
                    num = scan.nextInt();
                    newClient.setCLIENT_ID(num);
                    System.out.println("Enter CAR MODEL(BRAND), ex:BMW,Audi etc.: ");
                    brand = scan.next();
                    newClient.setMODEL(brand);
                    System.out.println("Enter CAR SERIES), ex:G63, M5 etc.: ");
                    model = scan.next();
                    newClient.setSERIES(model);
                    dao.UpdateClient(newClient);
                    break;

                case 4:
                    System.out.println("Enter ID, ex:1009: ");
                    num = scan.nextInt();
                    newClient.setCLIENT_ID(num);
                    System.out.println(dao.FindClient(1004));
                    break;

                case 5:
                    System.out.println(dao.ShowAll().toString());
                    break;

                default: exit = true;


            }


        }
    }
}
