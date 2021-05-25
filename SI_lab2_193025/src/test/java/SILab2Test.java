import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SILab2Test {

    private List<Time> createList(Integer... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    public void testOne() {
        RuntimeException ex;

        //1
        assertEquals(0, SILab2.function(createList()));

        //2
        assertEquals(3720, SILab2.function(createList(1,1,1)));

        //3
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(-1,1,1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //4
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(25,1,1)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //5
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,-1,1)));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        //6
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,60,1)));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        //7
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,30,-1)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //8
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,30,60)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //9
        assertEquals(45030, SILab2.function(createList(12,30,30)));

        //10
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,1,1)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //11
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,0,1)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //12
        assertEquals(86400, SILab2.function(createList(24,0,0)));
    }
}