package data;


import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataGenerator {
    public static Stream<Arguments> provideTestData(){
        return Stream.of(
                Arguments.of("Stefan", "Lazarevic", "nekiMail@fake.fake", "33", "96000", "IT"),
                Arguments.of("Milorad", "Radovanovic", "mikimikimoj@tamo.fake", "42", "17600", "Logistic"),
                Arguments.of("Nedeljko", "Subotic", "vikendBoy@fake.taxey", "23", "24600", "HomeOffice"),
                Arguments.of("Saban", "Saulic", "sapke@fake.fake", "72", "152462", "podsatrom"),
                Arguments.of("Hranislava", "Milojevic", "hrana@fake.fake", "27", "122400", "usobi"),
                Arguments.of("Krunoslav", "Potpetica", "krune@fake.fake", "31", "41200", "otkuce")
        );

    }
}
