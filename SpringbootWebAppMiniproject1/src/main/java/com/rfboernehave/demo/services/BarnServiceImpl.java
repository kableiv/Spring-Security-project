package com.rfboernehave.demo.services;

import com.rfboernehave.demo.domains.Barn;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BarnServiceImpl implements BarnService {

    ArrayList<Barn> boern = new ArrayList<>();

   public BarnServiceImpl() {

       boern.add(new Barn(0,"Oliver", "Ødegaard", 3, "12345667", new Date()));
       boern.add(new Barn(1,"Mohammed", "Naji", 4, "12345662", new Date()));
       boern.add(new Barn(2,"Lauritz", "Ninjasen", 3, "12367667", new Date()));
       boern.add(new Barn(3,"Christian", "Bjørk", 5, "22345667", new Date()));
       boern.add(new Barn(4,"Brian", "Gunnersen", 3, "12344765", new Date()));

   }

    @Override
    public ArrayList<Barn> hentAlleBoern() {
        return boern;
    }

    public void printToFile() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new File("src/main/resources/børn.txt"));

        for (int i = 0; i < boern.size(); i++) {

            printStream.println("Id: " + boern.get(i).getId()
                    + "\nFornavn: " + boern.get(i).getFornavn()
                    + "\nEfternavn: " + boern.get(i).getEfternavn()
                    + "\nAlder: " + boern.get(i).getAlder()
                    + "\nCpr: " + boern.get(i).getCpr()
                    + "\nIndmeldelsesdato: " + boern.get(i).getIndmeldelsesdato()
                    + "\n"
            );

        }

   }




}
