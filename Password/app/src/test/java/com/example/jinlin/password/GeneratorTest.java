package com.example.jinlin.password;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by Jinlin on 3/13/17.
 */
public class GeneratorTest {

    //test invalid cases
    @Test
    public void generator() throws Exception {
        String password = Generator.generator(6,3,2);
        assertEquals(password.length(), 6);
    }

    @Test
    public void sourceGeneratorTestNumLength() throws Exception {
        ArrayList<Character> testNum = Generator.sourceGenerator(5, "num");
        assertEquals(testNum.size(),5);
        assertNotEquals(Generator.num.indexOf(testNum.get(0)), -1);
    }

    @Test
    public void sourceGeneratorTestSymLength() throws Exception {
        ArrayList<Character> testSym = Generator.sourceGenerator(3, "sym");
        assertEquals(testSym.size(),3);
        assertNotEquals(Generator.sym.indexOf(testSym.get(0)), -1);
    }

    @Test
    public void sourceGeneratorTestLetLength() throws Exception {
        ArrayList<Character> testLet = Generator.sourceGenerator(7, "let");
        assertEquals(testLet.size(),7);
        assertNotEquals(Generator.let.indexOf(testLet.get(0)), -1);
    }

}