// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 853.
// Date: 2019.7.8

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CarFleet {

    class Car implements Comparable {
        int pos;
        float time;

        Car(int pos, int speed, int target) {
            this.pos = target - pos;
            this.time = ((float) target - pos) / speed;
        }

        @Override
        public int compareTo(Object o) {
            Car c2 = (Car) o;
            return -1 * Integer.compare(this.pos, c2.pos);
        }
    }

    int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; ++i) {
            cars.add(new Car(position[i], speed[i], target));
        }

        Collections.sort(cars);

        int cnt = 0;
        float time = 0;
        for (int i = cars.size() - 1; i >= 0; --i) {
            Car car = cars.get(i);
            if (car.time > time) {
                ++cnt;
                time = car.time;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int[] pos = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 1};
        carFleet.carFleet(12, pos, speed);
    }
}