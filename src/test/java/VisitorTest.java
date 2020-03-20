import org.junit.Test;


import static org.junit.Assert.assertSame;

public class VisitorTest {
    @Test
    public void save() {
        assertSame(Visitor.save("andi", 33,"324","456634","none","Marcus"), Visitor.save("Sibu", 44, "56756", "3453462","zero", "lebo"));
    }

    @Test
    public void load() {
        assertSame("Andiswa","Andiswa");
    }
}
