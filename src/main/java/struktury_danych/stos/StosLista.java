package struktury_danych.stos;

public class StosLista {

    private StosElem top;

    public StosLista(){
        top = null;
    }

    public void push(int wartosc){
        StosElem newElem = new StosElem(wartosc, top);
        top = newElem;
    }

    public int peek() throws StosPustyException{
        if (isEmpty()){
            throw new StosPustyException("Stos pusty! Uwazaj!");
        }
        return top.getValue();
    }

    public int pop() throws StosPustyException{
        if (isEmpty()){
            throw new StosPustyException("Stos pusty! Tak nie wolno!");
        }
        int wartosc = top.getValue();

       // StosElem elem = top;
       // top = elem.getPrev();
        top = top.getPrev();

        return wartosc;
    }

    public boolean isEmpty(){
       // if (top == null){
       //     return true;
       // }else {
       //     return false;
       // }
        return top == null;
    }

    public void pokaz(){
        StosElem pointer = top;
        while (pointer != null){
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getPrev();
        }
        System.out.println();
    }


}
