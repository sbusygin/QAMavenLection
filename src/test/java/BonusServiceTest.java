import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void schouldCalculateRegistredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = true;
        long expected = 30;


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