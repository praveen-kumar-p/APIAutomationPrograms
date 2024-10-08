package org.example.ex_22092024.verification;

import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class verification002 {


    @Test
    public void test_verify_assertj(){

        String name = "Pramod";
        assertThat(name).isNotEmpty().isEqualTo("Pramod").isNotNull();

        List<String> names = Arrays.asList("Praveen", "Shantha", "Prakash");
        assertThat(names).hasSize(3);
        assertThat(names).isNotNull();

        LocalDate date = LocalDate.now();
        System.out.println(date);
        assertThat(date)
                .isAfterOrEqualTo(LocalDate.of(2021, 1, 1));
                assertThat(date).isBeforeOrEqualTo(LocalDate.of(2023, 12, 31));
                assertThat(date).isBetween(LocalDate.of(2021, 1, 01),
        LocalDate.of(2023, 12, 31));

        File file = new File("Testdata.json");
        assertThat(file).exists().isFile().canRead();

        Map<String, Integer> ages = new HashMap<>();
        ages.put("Praveen",  28);
        ages.put("Prakash",  50);

        assertThat(ages).hasSize(2).containsEntry("Praveen", 28).doesNotContainValue(60);
    }
}
