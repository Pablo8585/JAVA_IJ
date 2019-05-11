package struktury_danych.algorytmy;

import struktury_danych.stos.StosLista;
import struktury_danych.stos.StosPustyException;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ONP {

    public void uruchom(){
        Scanner scanner = new Scanner(System.in);
        String wyrazenie;
        String[] podzielone;
        StosLista stos = new StosLista();

        System.out.println("Podaj wyrazenie w odwroconej notacji Polskiej");
        wyrazenie = scanner.nextLine();

        podzielone = wyrazenie.split(" ");

        for (String element : podzielone) {
            try {
                int wartosc = Integer.parseInt(element);
                stos.push(wartosc);

            }catch (NumberFormatException e){
                int wartoscDruga = stos.pop();
                int wartoscPierwsza = stos.pop();
                int wynik = 0;

                switch (element){
                    case "+":
                        wynik = wartoscPierwsza + wartoscDruga;
                        break;
                    case "-":
                        wynik = wartoscPierwsza - wartoscDruga;
                        break;
                    case "*":
                        wynik = wartoscPierwsza * wartoscDruga;
                        break;
                    case "/":
                        wynik = wartoscPierwsza / wartoscDruga;
                        break;
                        default:
                            System.out.println("nieprawidlowy znak");


                }
                stos.push(wynik);

            }

        }

        int ostatecznyWynik = stos.pop();
        System.out.println("Wynik : " + ostatecznyWynik);

    }


}
