package model;

import java.util.ArrayList;
import java.util.Collections;

public class VeryLongInt {
    protected ArrayList<Integer> digits;

    public VeryLongInt(String s) throws NullPointerException{
        this.digits = new ArrayList<Integer>(s.length());
        char c;
        int digit;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(Character.isDigit(c)){
                digit = Character.getNumericValue(c);
                this.digits.add(digit);
            }
        }
        removeZeros();
    }
    
    public void add(VeryLongInt ovl) throws NullPointerException{
        int largerSize, partialSum, carry = 0;
        ArrayList<Integer> sumDigits= new ArrayList<Integer>();
        if(this.digits.size()>ovl.digits.size())
            largerSize=this.digits.size();
        else
            largerSize=ovl.digits.size();
        for (int i = 0; i < largerSize; i++) {
            partialSum = this.least(i) + ovl.least(i) + carry;
            carry = partialSum / 10 ;
            sumDigits.add(partialSum % 10);
        }
        if(carry==1)
            sumDigits.add(carry);
        Collections.reverse(sumDigits);
        this.digits = sumDigits;
    }

    private int least(int i) {
        if(i>=this.digits.size())
            return 0;
         return this.digits.get(this.digits.size()-i-1);
    }

    private void removeZeros() {
        int l = 0;
        for (int i = 0; i < this.digits.size(); i++) {
            if(this.digits.get(i)!=0)
                break;
            else if(this.digits.get(i+1)==0)
                continue;
            else {
                l = i+1;
                break;
                    }
        }
        ArrayList<Integer> as =new ArrayList<>(this.digits.subList(l, this.digits.size()));
        this.digits = as ;
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
