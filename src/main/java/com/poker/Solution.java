package com.poker;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr1
     *  2. INTEGER_ARRAY arr2
     */

    public static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
        int moves = 0;
        Iterator<Integer> itr1 = arr1.iterator();
        Iterator<Integer> itr2 = arr2.iterator();
        while(itr1.hasNext()) {
            int modNum = 1;
            int n1 = itr1.next();
            int n2 = itr2.next();
            do {
                modNum*=10;
                int arr1num = n1%modNum/(modNum/10);
                int arr2num = n2%modNum/(modNum/10);
                int diff = Math.abs(arr1num-arr2num);
                int cntr = Math.min(diff,10-diff);
                moves += diff;
            }
            while(n1%modNum < n1 );
        }
        boolean a= !!true;
        return moves;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(237);
        arr1.add(984);
        arr1.add(560);
        arr1.add(640);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(804);
        arr2.add(951);
        arr2.add(563);
        arr2.add(342);
        int result = Result.minimumMoves(arr1,arr2);

        BufferedWriter bufferedWriter = null;
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        BufferedReader bufferedReader = null;
        bufferedReader.close();
        bufferedWriter.close();
    }
}
