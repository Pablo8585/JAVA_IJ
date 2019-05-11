package struktury_danych.lista;

public class Lista {

    private ElemLista first;

    private ElemLista last;

    public Lista(){
        first = last = null;
    }

    public void addFirst(int value) {
        ElemLista newElem = new ElemLista(value);

        if (first == null) {
            first = last = newElem;
        } else { // jezeli lista jest pusta nowy element staje sie zarowno pierwszym i ostatnim
            newElem.setNext(first);
            first.setPrev(newElem);
            first = newElem;
        }
    }

    public void addLast(int value) {
        ElemLista newElem = new ElemLista(value);

        if (last == null) {
            last = first = newElem;
        } else { // jeżeli jakies elementy sa juz w liscie
            last.setNext(newElem);
            newElem.setPrev(last);
            last = newElem;
        }
    }

    public int peekFirst(){
        //TODO if null then exception
        return first.getValue();
    }

    public int peekLast(){
        //TODO if null then exception
        return last.getValue();
    }

    public int pollFirst(){
        // zapamietanie wartosci first zanim stracimy do niego referencje
        int value = first.getValue();
        first = first.getNext();

        if (first == null){ // jezeli lista staje sie pusta to musimy takze zaktualizowac lasta o null
            last = null;
        }else {
            first.setPrev(null);
        }

        return value;
    }

    public int pollLast() {
        //TODO if null then exception

        int value = last.getValue(); // zapamietanie wartosci z lasta zanim stracimy do niego referencje

        last = last.getPrev(); // ustawiamy nowego lasta (poprzedzajacy starego lasta)

        if (last != null) {
            last.setNext(null); // usuniecie referencji do starego lasta, aby sie do niego juz wiecej nie dostac
        }else {
            // last == null, lista zaczyna być pusta, zatem musimy takze zaktualizowac first o null
            first = null;
        }
        // if (last == null) {
        //     first = null
        // }

        return value;
    }

    public boolean isEmpty(){
//        if (first == null){
//            return true;
//        }else {
//            return false
//        }
        return first == null;
    }

    public void show(){
        ElemLista pointer = first;
        while (pointer != null){
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getNext();
        }
        System.out.println("KONIEC_LISTY");
    }

    public void showReverse(){
        ElemLista pointer = last;
        while (pointer != null){
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getPrev();
        }
        System.out.println("POCZATEK");
    }

    public ElemLista search(int value){
        ElemLista pointer = first;

        while (pointer != null){
            if (pointer.getValue() == value){
                return pointer;
            }
            pointer = pointer.getNext();
        }
        return null; // nie znaleziono szukanej wartosci
    }

    // zwraca true jezeli znaleziono taka wartosc w liscie wpp. false
    public boolean contains(int value){
  //      ElemLista found = search(value);
   //     if (found != null){
   //         return true;
   //     }else {
   //         return false
   //     }

        return search(value) != null;
    }

    // true - jezeli znaleziono i usunieto element o takiej wartosci, wpp. false - nie znaleziono
    public boolean remove(int value){
        ElemLista found =  search(value);

        if (found == null){
            return false;
        }

        if (found == first){
            pollFirst();
        }else if (found == last){
            pollLast();
        }else {
            found.getPrev().setNext(found.getNext()); //pobieramy poprzednika i ustawiamy jego następnika poprzez następnika znalezionego
            found.getNext().setPrev(found.getPrev());
        }
        return true;
    }


}
