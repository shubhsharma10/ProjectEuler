import java.util.*;
//import java.lang.*;
//import java.io.*;

class RevBits
{
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
        String inputB = Integer.toBinaryString(n);
        int length = inputB.length();
        StringBuilder outputB = new StringBuilder();
        int i =0;
        System.out.println(inputB.toString());

        for(i=0;i<length;i++)
        {
        	outputB.append(Character.toString(inputB.charAt(length-i-1)));
        }
        if(length < 32)
        {
        	for(i=length;i<32;i++)
        		outputB.append("0");
        }
        System.out.println(outputB.toString());
        Long output = Long.parseLong(outputB.toString(),2);
        return output.intValue();
    }

    public static void main(String[] args)
    {
    	RevBits rv = new RevBits();
    	System.out.println(rv.reverseBits(43261596));
    }
}