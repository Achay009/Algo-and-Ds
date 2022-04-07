package com.company;

public class ReverseWords {
    public static void solution(String s){
        s=s.trim();
        String[] arr = s.split(" ");
        String out="";
        for(int i=arr.length-1;i>-1;i--){
            if (arr[i] == "") continue;
            out+=arr[i]+" ";
        }
        System.out.println("this is the reversed word:  " + out.substring(0,out.length()-1));
    }
}
