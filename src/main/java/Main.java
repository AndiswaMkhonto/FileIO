public class Main {
    public static void main(String[] args) {
       Visitor v = new Visitor();
        //  class method
        Visitor andi = new Visitor();
        //  invoke save function
        andi.save("Andiswa Mkhonto", 25, "2/01/2020", "12:25", "It was a nice day to visit", "Sibusiso Malinga");
        //invoke load function
        andi.load("Andiswa Mkhonto");

    }
}
