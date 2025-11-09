class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planet = mass;
        for(int asteroid : asteroids) {
            if(asteroid > planet) {
                return false;
            }
            planet += asteroid;
        }
        return true;
    }
}