package T01WorkingWithAbstraction.exercise.P04TrafficLights;

public class TrafficLight {
    private Colour colour;


    public TrafficLight(Colour colour) {
        this.colour = colour;
    }

    public void updateTrafficLight() {
        switch (this.colour){
            case GREEN:
                this.colour= Colour.YELLOW;
                break;
            case RED:
                this.colour= Colour.GREEN;
                break;
            case YELLOW:
                this.colour= Colour.RED;
                break;
        }
    }

    public Colour getColour() {
        return colour;
    }
}
