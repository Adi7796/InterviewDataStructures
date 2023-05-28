package com.Graphs;

public class Practise {
    public static void main(String[] args) {
        String st = "122.0.330.k";
        String[] str = st.split("\\.");
        for(String s: str)
            System.out.println(s);
        boolean flag=false;
        for(int i=0;i<4;i++)
        {
            int number = Integer.parseInt(str[i]);
            if(number>=0 && number<=255)
                flag=true;
            else flag=false;
        }
        System.out.println(flag);
    }
}
