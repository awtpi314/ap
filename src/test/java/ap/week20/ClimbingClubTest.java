package ap.week20;

import org.junit.Test;

public class ClimbingClubTest {
    @Test
    public void testDistinctPeakNames() {
        var cC = new ClimbingClub();
        cC.addClimbA(new ClimbInfo("A", 100));
        cC.addClimbA(new ClimbInfo("B", 1000));
        cC.addClimbA(new ClimbInfo("C", 10));
        cC.addClimbA(new ClimbInfo("D", 100));
        cC.addClimbA(new ClimbInfo("E", 10000));
        cC.addClimbA(new ClimbInfo("F", 1000));
        cC.addClimbA(new ClimbInfo("G", 10));
        cC.addClimbB(new ClimbInfo("H", 1000));
        cC.addClimbA(new ClimbInfo("A", 100));
        cC.addClimbA(new ClimbInfo("E", 10000));
        cC.addClimbA(new ClimbInfo("C", 10));
        cC.addClimbA(new ClimbInfo("B", 1000000));
        cC.addClimbA(new ClimbInfo("X", 1000));

        System.out.println(cC);
        cC.removeAll(1000);
        System.out.println(cC);
    }
}
