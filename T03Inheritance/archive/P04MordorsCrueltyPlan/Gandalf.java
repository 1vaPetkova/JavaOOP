package T03Inheritance.archive.P04MordorsCrueltyPlan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
    }

    public int getFoodPoints() {
        return foodPoints;
    }

    public void eatFood(String food) {
        if (Foods.contains(food)) {
            Foods currentFood = Foods.valueOf(food.toUpperCase());
            this.foodPoints += currentFood.getPoints();
        } else {
            this.foodPoints -= 1;
        }
    }

    public String getMood() {
            if (foodPoints < -5) {
                return "Angry";
            } else if (foodPoints <= 0) {
                return "Sad";
            } else if (foodPoints <= 15) {
                return "Happy";
            }
            return "JavaScript";
    }
}
