package com.mahesh.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PermutationInStringTest {

    @Test
    public void checkInclusion_positive(){
        assertTrue(PermutationInString.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void checkInclusion_false(){
        assertFalse(PermutationInString.checkInclusion("ab", "eidboaoo"));
    }
}
