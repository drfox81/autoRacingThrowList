public enum BodyTypeCar {

    SEDAN("седан"), HATCHBACK("хэтчбэк"), COUPE("купе"), STATION("универсал"), OFFROAD("внедорожник"),
    CROSSOVER("кроссовер"), PICKUP("пикап"), VAN("фургон"), MINIVAN("минивэн"), DEFOULT("не указан");
    private final String type;

    BodyTypeCar(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static BodyTypeCar change(String str) {
        BodyTypeCar[] bodyTypes = BodyTypeCar.values();
        for (BodyTypeCar i : BodyTypeCar.values()) {
            if (str.equals(i.getType())) {
                return i;
            }
        }
        return BodyTypeCar.DEFOULT;
    }
}