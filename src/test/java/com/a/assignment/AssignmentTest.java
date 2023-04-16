package com.a.assignment;

import com.a.assignment.controller.Assignments;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssignmentTest {


    @Test
    void testCase1 ()
    {
        String input1 = "abd(jnb)asdf";
        assertEquals("abd(bnj)asdf",Assignments.reverseSubstringinside(input1));
    }
    @Test
    void testCase2 ()
    {
        String input2 = "abdjnbasdf";
        assertEquals("abdjnbasdf",Assignments.reverseSubstringinside(input2));
    }
    @Test
    void testCase3 ()
    {
        String input3 = "dd(df)a(ghhh)";
        assertEquals("dd(fd)a(hhhg)",Assignments.reverseSubstringinside(input3));
    }
}
