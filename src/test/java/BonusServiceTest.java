import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'registered user, bonus under limit',100060,true,30",
            "'registered user, bonus over limit',100000060,true,500",
            "'unregistered user, bonus over limit',100060,false,10",
            "'unregistered user, bonus over limit',100000060,false,500"
    }, delimiter = ',')
    void schouldCalculateRegistredAndUnderLimit(String testName, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }


    @org.junit.jupiter.api.Test
    void schouldCalculateRegistredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100000060;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void schouldCalculateNoRegistredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 10;


        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void schouldCalculateNoRegistredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100000060;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }
}