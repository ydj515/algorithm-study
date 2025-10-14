import java.util.*;
class Solution {

    class Truck {
        int weight = 0;
        int index = 0;

        public Truck(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 대기중인 트럭
        Queue<Truck> restTruckQueue = new LinkedList<>();

        // 다리위를 이동중인 트럭
        Queue<Truck> movingTruckQueue = new LinkedList<>();

        // 트럭의 무게를 모두 add
        for (int i = 0; i < truck_weights.length; i++) {
            restTruckQueue.offer(new Truck(truck_weights[i], 0)); // add
        }

        // 이동 시간
        int time = 0;

        // 다리위에있는 총 무게
        int totalWeight = 0;

        while (!restTruckQueue.isEmpty() || !movingTruckQueue.isEmpty()) {

            time++;

            // 이동중인 트럭이 없다면
            if (!movingTruckQueue.isEmpty()) {

                Truck tempTruck = movingTruckQueue.peek();

                if (time - tempTruck.index >= bridge_length) { // 다리를 다 건넜다면
                    totalWeight -= tempTruck.weight; // 다리에 있는 무게에서 제거
                    movingTruckQueue.poll(); // 다리위의 list에서 제거
                }
            }

            if (!restTruckQueue.isEmpty()) { // peek로 꺼내어 다리위에 더 트럭을 올릴 수 있는지 검사하기전에 empty일 경우 오류가 나서 오류처리해줌
                if (totalWeight + restTruckQueue.peek().weight <= weight) {
                    Truck truck = restTruckQueue.poll();
                    totalWeight += truck.weight;

                    movingTruckQueue.offer(new Truck(truck.weight, time)); // 다리위의 트럭 큐에 추가
                }
            }
        }

        return time;
    }

}