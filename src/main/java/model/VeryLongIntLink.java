package model;


import java.util.LinkedList;
import java.util.ListIterator;

public class VeryLongIntLink {
    protected LinkedList<Integer> digits;
    ListIterator itr ;

    public VeryLongIntLink(String s) throws NullPointerException{
        this.digits = new LinkedList<Integer>();
        char c;
        int digit;
        if(s.isEmpty()) throw  new NullPointerException();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(Character.isDigit(c)){
                digit = Character.getNumericValue(c);
                this.digits.add(digit);
            }
        }
        removeZeros();
    }
    
    public void add(VeryLongIntLink ovl) throws NullPointerException{
        int largerSize, partialSum, carry = 0;
        this.setListIterator();
        ovl.setListIterator();
        LinkedList<Integer> sumDigits= new LinkedList<Integer>();
        if(this.digits.size()>ovl.digits.size())
            largerSize=this.digits.size();
        else
            largerSize=ovl.digits.size();
        for (int i = 0; i < largerSize; i++) {
            partialSum = this.least() + ovl.least() + carry;
            carry = partialSum / 10 ;
            sumDigits.addFirst(partialSum % 10);
        }
        if(carry==1)
            sumDigits.addFirst(carry);
        this.digits = sumDigits;
    }

    private int least() {
        if(this.itr.hasPrevious()){
           return   (int) this.itr.previous( );
        }
        return 0;
    }
    
        public void setListIterator() {
        this.itr = this.digits.listIterator(this.digits.size());
    }

    private void removeZeros() {
        if(this.digits.getFirst()==0){
            this.digits.removeFirst();
            removeZeros();
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Integer digit : this.digits) {
            str += digit;
        }
        return str ;
    }

}
