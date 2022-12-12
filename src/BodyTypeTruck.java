public enum BodyTypeTruck {

    N1(0, 3.5f),
    N2(3.5f, 12),
    N3(12, 25);

    private float weigtNumberUp;
    private float weigtNumberDown;

    public float getWeigtNumberUp() {
        return weigtNumberUp;
    }

    public float getWeigtNumberDown() {
        return weigtNumberDown;
    }

    BodyTypeTruck(float weigtNumberUp, float weigtNumberDown) {
        this.weigtNumberUp = weigtNumberUp;
        this.weigtNumberDown = weigtNumberDown;
    }

    public static BodyTypeTruck change(float weigtTruck) {
        weigtTruck = Math.abs(weigtTruck);
        if (weigtTruck <= 3.5f) {
            return BodyTypeTruck.N1;
        } else if (weigtTruck <= 12) {
            return BodyTypeTruck.N2;
        } else {
            return BodyTypeTruck.N3;
        }
    }
}
