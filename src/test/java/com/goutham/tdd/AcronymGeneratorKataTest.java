package com.goutham.tdd;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AcronymGeneratorKataTest {
    AcronymGenerator generator = new AcronymGenerator();

    @ParameterizedTest
    @CsvSource({
            "'',''",
            "Tom,T",
            "Martin Sheen,MS",
            "martin sheen,MS",
            "martin roger sheen,MRS",
            "martin-roger sheen,MRS",
            "martin sheen-tiger,MST",
            "martin von sheen,MvS"


    })
    void returnsAcronymsOfFullName(String fullName , String expectedAcronym){
        assertThat(generator.generate(fullName)).isEqualTo(expectedAcronym);
    }
}
