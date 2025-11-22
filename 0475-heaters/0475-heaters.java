class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        //for each house we have to find nearest heater
        //either ahead or back

        TreeMap<Integer,Integer> heatersMap = new TreeMap<>();

        for(int i = 0; i < heaters.length; i++){

            heatersMap.put(heaters[i], heaters[i]);

        }

        int radius = 0;

        for(int i = 0; i < houses.length; i++){

            if( ! heatersMap.containsKey(houses[i])){

                Map.Entry<Integer,Integer> lowerEntry = heatersMap.lowerEntry(houses[i]);
                Map.Entry<Integer, Integer> higherEntry = heatersMap.higherEntry(houses[i]);

                int lowerValue = Integer.MAX_VALUE;
                int higherValue = Integer.MAX_VALUE;

                if(lowerEntry != null){
                    lowerValue = houses[i] - lowerEntry.getValue();
                }

                if(higherEntry != null){
                    higherValue = higherEntry.getValue() - houses[i];
                }


                radius = Math.max( radius, Math.min(lowerValue,higherValue));


            }

        }


        return radius;
        
    }
}