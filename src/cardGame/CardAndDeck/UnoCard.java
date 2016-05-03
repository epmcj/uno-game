/**
 * This class represent one card in a normal deck of uno
 * 
*/
public class UnoCard {
    /**
     * This enum represent a type which elements are color of a deck card.
    */
    public enum Color {
        BLUE   { public String toString() { return "B"; }},
        RED    { public String toString() { return "R"; }},
        GREEN  { public String toString() { return "G"; }},
        YELLOW { public String toString() { return "Y"; }},
        BLACK  { public String toString() { return "K"; }}
    }

    /**
     * This enum represent a type which elements are numbers of the card.
    */
    public enum Value {
        ZERO { public String toString() { return "0";}},
        ONE { public String toString() { return "1";}},
        TWO { public String toString() { return "2";}},
        THREE { public String toString() { return "3";}},
        FOUR { public String toString() { return "4";}},
        FIVE { public String toString() { return "5";}},
        SIX { public String toString() { return "6";}},
        SEVEN { public String toString() { return "7";}},
        EIGHT { public String toString() { return "8";}},
        NINE  { public String toString() { return "9";}},
        SKIP { public String toString() { return "10";}},
        REVERSE { public String toString() { return "11";}},
        DRAWTWO { public String toString() { return "12";}},
        WILD { public String toString() { return "13";}},
        WILDDRAWFOUR { public String toString() { return "14";}},
    }

    private final Color color;
    private final Value value;

    public UnoCard(final Color color, final Value value){
        this.color = color;
        this.value = value;
    }

    public String toString() { return value.toString() + " " + color.toString();}
}
