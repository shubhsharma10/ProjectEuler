// Leetcode problem number: 67 Add binary string
// Problem Statement:
//  Given two binary strings, return their sum (also a binary string).
// For example,
// a = "11"
// b = "1"
// Return "100".

// Idea: get ecah char from last and use sum and carry for sum  XOR operator and for carry AND operator


import java.util.*;
import java.lang.*;

public class BinaryStringSum
{
    public String addBinary(String a, String b) 
    {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int i = len1-1;
        int j = len2-1;
        int carry=0,sum=0;
        while(i >= 0 ||  j >= 0)
        {
            int p = (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
            int q = (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;
            sum = p ^ q ^ carry;
            carry = ((p + q + carry) >= 2) ? 1 : 0 ;
            sb.append(String.valueOf(sum));
            i--;
            j--;
        }
        if(carry == 1)
            sb.append(String.valueOf(carry));
        
        String result = sb.reverse().toString();
        return result;
    }
}