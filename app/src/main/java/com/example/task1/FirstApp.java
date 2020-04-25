package com.example.task1;

import java.util.*;
public class FirstApp {

    public List <Integer> options = new LinkedList <>();
    public List <Integer> answer = new LinkedList <>();
    public int op3 [] = new int [3];
    public int n;

    public int getRandomElement (List <Integer> options) {
        Random random = new Random();
        return options.get(random.nextInt(options.size()));
    }

    public void getValue () {
        for (int i=1 ; i<=n ; i++) {
            int temp = n%i;
            if(temp==0) {
                answer.add(i);
            }
        }
        for(int i=1 ; i<=n ; i++) {
            options.add(i);
        }
        options.removeAll(answer);

    }

    public void getOptions () {
        Random random = new Random() ;
        int temp = random.nextInt(3);
        op3 [temp] = getRandomElement(answer);
        for(int i=0 ; i<3 ; i++) {
            if(temp != i) {
                op3 [i] = getRandomElement(options);
            }
        }
    }





}

