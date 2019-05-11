package struktury_danych.lista;

public class Main {

    public static void main(String[] args) {

        wywolajLista();


    }



    public static void wywolajLista () {
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
