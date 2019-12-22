package com.andres.thefirst.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String S = "abppplee";
        List<String> D = new ArrayList<>();
        D.add("able");
        D.add("ale");
        D.add("apple");
        D.add("bale");
        D.add("kangaroo");

        FindLongestWordV2 findLongestWord = new FindLongestWordV2(S, D);
        String longestWord = findLongestWord.find();
        assertEquals("Found: ", "apple", longestWord);
    }
}
