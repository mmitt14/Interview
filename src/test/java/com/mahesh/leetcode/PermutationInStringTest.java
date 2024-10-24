package com.mahesh.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PermutationInStringTest {

    @Test
    public void checkInclusion_Arrays_positive(){
        assertTrue(PermutationInString.checkInclusion_Arrays("ab", "eidbaooo"));
    }

    @Test
    public void checkInclusion_Arrays_false(){
        assertFalse(PermutationInString.checkInclusion_Arrays("ab", "eidboaoo"));
    }

    @Test
    public void checkInclusion_HashMap_positive(){
        assertTrue(PermutationInString.checkInclusion_HashMap("ab", "eidbaooo"));
    }

    @Test
    public void checkInclusion_HashMap_false(){
        assertFalse(PermutationInString.checkInclusion_HashMap("ab", "eidboaoo"));
    }
}
