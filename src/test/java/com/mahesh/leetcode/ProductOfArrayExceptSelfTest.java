package com.mahesh.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void checkInclusion_Arrays_positive(){
        int [] input = {1,2,3,4};
        int [] output = {24,12,8,6};
        assertArrayEquals(output, ProductOfArrayExceptSelf.productExceptSelf(input));
    }
}
