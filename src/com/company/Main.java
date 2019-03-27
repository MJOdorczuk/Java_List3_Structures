package com.company;

import Structures.Pair;
import Structures.SetOnArray;
import Structures.SetOnDynamicArray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        try {
            Pair pair = new Pair("",0);
        } catch (Exception e) {
            System.out.println("Empty key detected");
        }
        try {
            Pair pair = new Pair(null,0);
        } catch (Exception e) {
            System.out.println("Null key detected");
        }
        Pair pair = new Pair("pair",2);
        if(pair.getValue() == 2 && pair.toString() == "pair")
        {
            System.out.println("getValue and toString working");
        }
        pair.setValue(15);
        Pair pair2 = new Pair("pair",15);
        if(pair.equals(pair2)) System.out.println("equals is working");
        SetOnArray soa = new SetOnArray(5);
        soa.push(new Pair("1",1));
        soa.push(new Pair("2",2));
        soa.push(new Pair("3",3));
        try {
            soa.push(new Pair("3",4));
        } catch (Exception e) {
            System.err.println(e);
        }
        soa.push(new Pair("4",4));
        soa.push(new Pair("5",5));
        try {
            soa.push(new Pair("6",6));
        } catch (Exception e) {
            System.err.println(e);
        }
        soa.set(new Pair("2",4));
        System.out.println(soa.read("2"));
        System.out.println(soa.count());
        soa.purge();
        System.out.println(soa.count());
        SetOnDynamicArray soda = new SetOnDynamicArray();
        for(int i = 0; i < 100; i++)
        {
            soda.push(new Pair(""+i,i));
        }
        System.out.println(soda.count());
        try {
            soda.push(new Pair("15",15));
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(soda.search("16").getValue());
    }
}
