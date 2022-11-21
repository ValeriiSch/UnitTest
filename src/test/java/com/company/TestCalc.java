package com.company;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class TestCalc {

    Calculator calc;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running Tests");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Tests complete");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        calc = new Calculator();
    }

    @AfterEach
    public void completeTest() {
        System.out.println("Test complete");
    }


    @org.junit.jupiter.api.Test
    public void test_divide_zero() {
        int a = 5;
        int b = 0;
        var expected = ArithmeticException.class;

        Assertions.assertThrows(expected, () -> calc.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("args_div")
    public void test_divide(int a, int b, int expected) {
        int result = calc.divide(a, b);

        Assertions.assertEquals(expected, result);
        Assertions.assertNotNull(result);
        Assertions.assertDoesNotThrow(() -> calc.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("args_mul")
    public void test_multiply(int a, int b, int expected) {
        int result = calc.mult(a, b);

        Assertions.assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("args_add")
    public void test_add(int a, int b, int expected) {
        int result = calc.add(a, b);

        Assertions.assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("args_sub")
    public void test_sub(int a, int b, int expected) {
        int result = calc.sub(a, b);

        Assertions.assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("args_pos")
    public void test_isPositive(int a, Boolean expected) {
        Boolean result = calc.isPositive(a);

        Assertions.assertEquals(expected, result);
        Assertions.assertDoesNotThrow(() -> calc.isPositive(a));
    }

    @Test
    public void test_isNegativeTrue() {
        int a = -10;
        Boolean result = calc.isNegative(a);

        Assertions.assertTrue(result);
        Assertions.assertDoesNotThrow(() -> calc.isNegative(a));
    }

    @Test
    public void test_isNegativeFalse() {
        int a = 10;
        Boolean result = calc.isNegative(a);

        Assertions.assertFalse(result);
        Assertions.assertDoesNotThrow(() -> calc.isNegative(a));
    }

    @Test
    public void test_isZero() {
        int a = 0;
        Boolean result = calc.isZero(a);

        Assertions.assertTrue(result);
        Assertions.assertDoesNotThrow(() -> calc.isZero(a));
    }

    @Test
    public void test_isNotZero() {
        int a = 10;
        Boolean result = calc.isZero(a);

        Assertions.assertFalse(result);
        Assertions.assertDoesNotThrow(() -> calc.isZero(a));
    }

    private static Stream<Arguments> args_div(){
        return Stream.of(Arguments.of(5,3,1), Arguments.of(15,3,5), Arguments.of(10,3,3));
    }

    private static Stream<Arguments> args_mul(){
        return Stream.of(Arguments.of(5,3,15), Arguments.of(15,3,45), Arguments.of(10,3,30));
    }

    private static Stream<Arguments> args_add(){
        return Stream.of(Arguments.of(5,3,8), Arguments.of(15,3,18), Arguments.of(10,3,13));
    }

    private static Stream<Arguments> args_sub(){
        return Stream.of(Arguments.of(5,3,2), Arguments.of(15,3,12), Arguments.of(10,3,7));
    }

    private static Stream<Arguments> args_pos(){
        return Stream.of(Arguments.of(5,true), Arguments.of(0,false), Arguments.of(-10,false));
    }

}
