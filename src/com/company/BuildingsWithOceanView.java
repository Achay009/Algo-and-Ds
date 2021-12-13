package com.company;

import java.util.*;

public class BuildingsWithOceanView {
    public static void solution (int [] heights){
        Queue<Integer> positions = new LinkedList<>();
        int p1 = 0;
        int p2 = p1 + 1;
        while (p1 <= heights.length){

              if (p1 == heights.length-1){
                  positions.add(p1);
                  break;
              }

              if (heights[p2] >= heights[p1]){
                  p1++;
                  p2 = p1 + 1;
                  continue;
              }

              if (p2 == heights.length - 1){
                  positions.add(p1);
                  p1++;
                  p2 = p1 + 1;
                  continue;
              }

              if (p1 == heights.length -1){
                  positions.add(p1);
                  break;
              }

              p2++;
        }
//      System.out.println(positions);
        int [] result =  new int[positions.size()];
        int length = positions.size();

        for (int i = 0; i < length; i++){
            result[i] = positions.poll();
        }
        System.out.println(Arrays.toString(result));
    }
}
