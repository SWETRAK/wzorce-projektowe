package com.example;

import com.example.models.papers.Magazine;
import com.example.models.papers.MagazineFactory;
import com.example.models.papers.Newspaper;
import com.example.models.papers.NewspaperFactory;
import com.example.models.papers.Paper;
import com.example.models.users.Client;
import com.example.models.users.Manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("System księgarni");

        Manager manager = Manager.getInstance();
        manager.printInfo();

        Client client1 = new Client.Builder("Klient", "Pierwszy", "klient.pierwszy@gmail.com")
                .phoneNumber("123456789")
                .build();

        client1.printInfo();

        Client client2 = new Client.Builder("Klient", "Drugi", "klient.drugi@gmail.com")
                .build();

        client2.printInfo();

        System.out.println("Client 1 phone number: " + client1.getPhoneNumber());
        System.out.println("Client 2 phone number: " + client2.getPhoneNumber());

        List<Paper> papers = new ArrayList<>();

        Newspaper newspaper1 = new NewspaperFactory().create("ISDN1");
        newspaper1.setDescription("Description1");
        newspaper1.setTitle("Title1");
        newspaper1.setPages(100);
        newspaper1.setPaperId(1);
        newspaper1.setPublishedDate(new Date());

        Newspaper newspaper2 = (Newspaper)newspaper1.copy();
        newspaper2.setPaperId(2);

        Magazine magazine1 = new MagazineFactory().create("ISDN2");
        magazine1.setDescription("Description2");
        magazine1.setTitle("Title2");
        magazine1.setPages(100);
        magazine1.setPaperId(3);
        magazine1.setPublishedDate(new Date());

        Magazine magazine2 = (Magazine)magazine1.copy();
        magazine2.setPaperId(3);

        papers.add(magazine1);
        papers.add(magazine2);
        papers.add(newspaper1);
        papers.add(newspaper2);

        papers.forEach(System.out::println);

    }
}