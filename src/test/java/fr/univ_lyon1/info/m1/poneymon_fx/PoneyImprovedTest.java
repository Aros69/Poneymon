package fr.univ_lyon1.info.m1.poneymon_fx;

import fr.univ_lyon1.info.m1.poneymon_fx.model.PoneyModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PoneyImprovedTest {

    private PoneyModel poney;

    /**
     * initialisation PoneyModel
     */
    @Before
    public void setUp() {
        poney = new PoneyModel("green", 0, true);
    }




    /**
     * Test for the boost
     */
    @Test
    public void testBoost() {

        poney.setSpeed(0.25);


        poney.turnIntoNianPoney();
        assert(poney.getSpeed() == 0.5);
        assert(poney.isNianPoney());
        assertTrue(!poney.canBoost());

        poney.turnIntoNianPoney();

        assert(poney.getSpeed() == 0.5);
        assert(poney.isNianPoney());
        assertTrue(!poney.canBoost());

    }


    /**
     * loose NianMode after a turn
     */
    @Test
    public void looseNianMode()
    {
        poney.turnIntoNianPoney();

        poney.setX(0.999);
        poney.setNbLap(1);
        poney.setSpeed(1);

        poney.update(500);

        assertEquals(poney.isNianPoney() , false);
        assertEquals(poney.canBoost() , false);
        assert (poney.getSpeed() < 1);

        poney.turnIntoNianPoney();

        assertEquals(poney.canBoost() , false);
        assertTrue(!poney.canBoost());

    }




}
