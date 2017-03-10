// leetcode problem number: 11. Container With Most Water
// Problem statement : Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Idea : start with end and start, to get area better than more width, height has to increase.

public class ContainerWater
{
    public int maxArea(int[] height)
    {
        int i=0,j=0;
        j= height.length-1;
        int maxArea=0,h=0,w=0;
        while(i<j)
        {
            h = Math.min(height[i],height[j]);
            w = j-i;
            if(maxArea < (h*w))
                maxArea = h*w;
            if(h == height[i])
                i++;
            else 
                j--;
        }
        return maxArea;
    }
}