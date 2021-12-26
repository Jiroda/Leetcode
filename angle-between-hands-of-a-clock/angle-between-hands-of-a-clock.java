class Solution {
    public double angleClock(int hour, int minutes) {
        int oneminAngle = 360/60;
        int onehourAngle = 360/12;
        
        double minutesAngle = minutes*oneminAngle;
        //The hour hand moves a additionally when the minutes>0
        double hourAngle = (hour % 12 + minutes/60.0) * onehourAngle;
        
        double difference = Math.abs(hourAngle-minutesAngle);
        
        //Return the smallest angle
        return Math.min(difference, 360-difference);
    }
}