import struktury_danych.StosTablice;
import struktury_danych.Tablice;
import struktury_danych.algorytmy.ONP;
import struktury_danych.kolejka.KolejkaLista;
import struktury_danych.lista.Lista;
import struktury_danych.stos.StosLista;
import struktury_danych.stos.StosPustyException;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // wywolajTablice();

       // wywolajStosTablice();

        //wywolajStosLista();

       // wywolajKolejkaLista();

       // new ONP().uruchom();

         wywolajLista();

    }

    public static void wywolajTablice() {
        int[] tab = {1, 2, 3, 4, 5, 6, 7, 8};
        Tablice tablice = new Tablice();

    }

    public static void wywolajStosTablice() {
        Scanner scanner = new Scanner(System.in);
        int rozmiar;
        StosTablice stos;

        System.out.println("Podaj rozmiat stosu: ");
        rozmiar = scanner.nextInt();

        stos = new StosTablice(rozmiar);

        while (true) {
            System.out.println("wybierz: 1. push, 2. pop, 3. peek, 4. isEmpty, 5. pokarz, 0. wyjscie");
            int num = scanner.nextInt();

            switch (num) {
                case 0:
                    System.out.println("koniec działania programu");
                    return;
                case 1:
                    try {
                        System.out.println("Podaj wartość na stos:");
                        int wartosc = scanner.nextInt();
                        stos.push(wartosc);
                        stos.pokarz();
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("wartosc pobrana ze stosu " + stos.pop());
                        stos.pokarz();
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("wartosc z podgladu " + stos.peek());
                        stos.pokarz();
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("czy stos pusty " + stos.isEmpty());
                    break;
                case 5:
                    stos.pokarz();
                    break;
                default:
                    System.out.println("niepoprawna operacja");
            }

        }


    }

    public static void wywolajStosLista(){
        StosLista stosLista = new StosLista();

        stosLista.push(1);
        stosLista.push(2);
        stosLista.push(3);
        System.out.println("Po pushach");
        stosLista.pokaz();

        stosLista.pop();
        stosLista.pop();
        System.out.println("Po popach");
        stosLista.pokaz();

        stosLista.peek();
        System.out.println("Po peekach");
        stosLista.pokaz();

        System.out.println("Nowy push");
        stosLista.push(5);
        stosLista.pokaz();

        try {
            stosLista.pop();
            stosLista.pop();
            stosLista.pop();
            stosLista.pop();
        } catch (StosPustyException e){
            System.out.println(e.getMessage());
        }

    }

    public static void wywolajKolejkaLista(){
        KolejkaLista kolejkaLista = new KolejkaLista();

        kolejkaLista.add(1);
        kolejkaLista.add(2);
        kolejkaLista.add(3);
        System.out.println("Po addach");
        kolejkaLista.pokaz();

        kolejkaLista.poll();
        kolejkaLista.poll();
        System.out.println("Po pallach");

        System.out.println("Po peeku" + kolejkaLista.peek());
        kolejkaLista.pokaz();


    }

    public static void wywolajLista(){
        Lista lista = new Lista();

        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);

        lista.show();

        lista.addLast(4);

        lista.show();

        lista.peekLast();

        lista.pollLast();
        lista.pollLast();

        lista.show();

        lista.pollFirst();

        lista.show();
        lista.showReverse();
    }






}
