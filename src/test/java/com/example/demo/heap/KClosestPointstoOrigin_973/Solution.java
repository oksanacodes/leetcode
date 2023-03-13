package com.example.demo.heap.KClosestPointstoOrigin_973;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
973. K Closest Points to Origin
https://leetcode.com/problems/k-closest-points-to-origin/description/


Given an array of points where points[i] = [xi, yi] represents a point on
the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance
(i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to
be unique (except for the order that it is in).



Time: O(N*log(N)) - Converting an array into a Heap takes O(N) time (it isn't actually sorting; it's putting them into an order that allows us to get the maximums,
each in O(logN) time. The main loop iterates up to N−1 times.
This time however, it's doing one O(logN) operation each time;
This means that we're doing O(NlogN) operations.
Space: O(N) - to create a priority queue
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k){
        int n = points.length;
        PriorityQueue<Point> minHeap = new PriorityQueue<>(n , new PointComparator());

        for (int [] point: points){
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(
                    Math.pow(x,2)+Math.pow(y,2)
            );
            Point p = new Point(x,y,distance);
            minHeap.add(p);
        }

        int[][] result = new int[k][2];
        int i=0;
        while(!minHeap.isEmpty() && k>0){
            Point point = minHeap.poll();
            result[i][0]=point.x;
            result[i][1]= point.y;
            i++;
            k--;
        }
        return result;
    }

    @Test
    public void t(){
        int[][] points ={{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] result = kClosest(points, k);
        // Output should be[[3,3],[-2,4]]
        Assertions.assertEquals(2, result.length);

        System.out.println(Arrays.stream(result[0]).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(result[1]).boxed().collect(Collectors.toList()));
    }

    public class Point{
        int x;
        int y;
        double distance;

        public Point(int x,int y, double distance){
            this.x= x;
            this.y=y;
            this.distance= distance;
        }
    }
    public class PointComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.distance>o2.distance){
                return 1;
            }else if(o1.distance==o2.distance){
                return 0;
            }
            return -1;
        }
    }
}
