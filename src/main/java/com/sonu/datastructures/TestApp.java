package com.sonu.datastructures;

import com.sonu.datastructures.Arrays.Array;
import com.sonu.datastructures.Queues.RotateString;
import com.sonu.datastructures.Stacks.BalancedParanthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestApp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            rotateString();
        } finally {
            br.close();
        }

    }

    static void rotateString() {
        String test = "Sonu Jose Parekaden";
        RotateString rs = new RotateString();
        System.out.println(test);
        System.out.println("=========");
        System.out.println(rs.rotate(test, 4));
    }

    static void balancedParanthesis() {
        String testFail = "{{{{}}{{}{}{}{}{}{}}}}}{";
        String testSuccess = "{{{{{}}}}}{{{}}{}}";
        BalancedParanthesis bp = new BalancedParanthesis();
        System.out.println(bp.isBalanced(testFail, "{", "}"));
        System.out.println(bp.isBalanced(testSuccess, "{", "}"));
    }

    static void testArray(){
        Array array = new Array();
        int[][] test = { {1,2,3},{4,5,6},{7,8,9}};
        array.print(test);
        System.out.println("==============");
        array.print(array.compliment(test));
    }
}
