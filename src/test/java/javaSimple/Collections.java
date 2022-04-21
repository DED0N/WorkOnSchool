package javaSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Collections {

    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

/*
        try {
            array[3] = 1;
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Oops");
        }
*/

        String[] arrayStr = {"1", "2", "3", "4"};
        System.out.println(arrayStr[1]);


        ArrayList<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        list.get(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }


        list.forEach(s -> System.out.println("forEach: " + s));

        list.stream().filter(s -> s.length() < 14).forEach(s -> System.out.println("filter method: " + s));

        list.stream().filter(s -> s.contains("1")).forEach(s -> System.out.println("filter method/contains: " + s));

        ArrayList<String> secondList = (ArrayList<String>) list.stream().filter(s -> s.length() < 14).collect(Collectors.toList());

        secondList.forEach(s -> System.out.println("Second list items: " + s));


        HashMap<String, String> map = new HashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value1");
        map.put("Key3", "Value1");
        map.put("Key4", "Здорова");
        System.out.println(map.get("Key1"));

        Set<String> set;
        set = map.keySet();
        set.forEach(s -> System.out.println("Keys: " + s));

        for (String s : set) {
            System.out.println("Key value: " + s + " = " + map.get(s));
        }


    }
}
