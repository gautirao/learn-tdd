package com.goutham.tdd;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcultorTest {

    @Test
    void should_return_0_wheninput_isempty() {
        Assertions.assertThat(Calculator.add("")).isEqualTo(0);
    }
    @Test
    void should_return_number_for_one_number() {
        Assertions.assertThat(Calculator.add("4")).isEqualTo(4);
    }
    @Test
    void should_return_sum_of_two_numbers() {
        Assertions.assertThat(Calculator.add("4,5")).isEqualTo(9);

    }
    @Test
    void should_return_sum_of_unknown_amount_of_numbers() {
        Assertions.assertThat(Calculator.add("4,5,2")).isEqualTo(11);

    }
    @Test
    void should_return_sum_of_numbers_split_by_commas_and_new_lines() {
        Assertions.assertThat(Calculator.add("4,5")).isEqualTo(9);

    }

//    @Test
//    void should_return_sum_of_numbers_split_by_custom_delimiter() {
//    }
//
    @Test
    void should_throw_exception_for_comma_next_to_new_line() {

        Assertions.assertThatThrownBy(() -> Calculator.add("1,\n2")).isInstanceOf(NumberFormatException.class);
    }
    @Test
    void should_throw_exception_for_negative_numbers() {
        Assertions.assertThatThrownBy(() -> Calculator.add("1,-2,3,-5")).hasMessageContaining("Negatives not allowed ")
                .hasMessageContaining("-2 -5");

    }


}
