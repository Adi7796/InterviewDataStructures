package Companies.Amazon;

import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents
its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class AsteroidCollision {
    public static void main(String[] args) {

        int[] asteroid = {5, 10, -5};
        AsteroidCollision obj = new AsteroidCollision();

        int[] ans = obj.asteroidCollision(asteroid);

        for(int i : ans)
        {
            System.out.print(i + " ");
        }
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length; i++)
        {
            boolean isCurrenAsteroidAdded = true;
            int currentAsteroid = asteroids[i];
            int top = 0;
            if(!stack.isEmpty()) {top = stack.peek();}

            // if both asteroids are travelling in the same direction
            // we just add the current asteroid
            if((currentAsteroid < 0 && top < 0) || currentAsteroid > 0 && top > 0)
            {
                isCurrenAsteroidAdded = true;
            }

            // if the top and current asteroid are travelling towards each other
            else if(currentAsteroid < 0 && top > 0)
            {

                // if both have the same size, they explode and we pop the top asteroid
                // we continue to the next asteroid
                if(Math.abs(currentAsteroid) == Math.abs(top))
                {
                    stack.pop();
                    continue;
                }

                // if the top asteroid size is greater then the current asteroid
                // both explode but the top asteroid remains in the stack
                if(Math.abs(currentAsteroid) < top) continue;

                    // otherwise
                else{

                    // loop till the top asteroid is positive since the current asteroid is negative
                    while(!stack.isEmpty() && stack.peek() > 0)
                    {

                        // if the top asteroid is smaller in size than the current asteroid
                        // they both explode and we remove the top asteroid and
                        // we continue with the next asteroid in the stack
                        if( Math.abs(stack.peek()) < Math.abs(currentAsteroid))
                        {
                            stack.pop();
                            continue;
                        }
                        // if both are of same size, we pop the top asteroid and dont
                        // add the currentAsteroid to the stack
                        else if(Math.abs(stack.peek()) == Math.abs(currentAsteroid))
                        {
                            stack.pop();
                        }

                        // since we have reached here the current asteroid will be destroyed,
                        // hence we wont add the current asteroid to the stack
                        // as the top asteroid would have beed greater than the current asteroid
                        isCurrenAsteroidAdded = false;
                        break;
                    }

                }
            }

            // if the top asteroid was travelling left and current asteroid
            // is travelling right, they will not meet and explode hence we just push into the stack
            else if(currentAsteroid > 0 && top < 0)
            {
                isCurrenAsteroidAdded = true;
            }

            if(isCurrenAsteroidAdded) stack.push(currentAsteroid);
        }

        int[] ans = new int[stack.size()];
        if(stack.isEmpty()) return ans;


        int i = stack.size()-1;
        while(!stack.isEmpty() && i>=0)
        {
            ans[i] = stack.pop();
            i--;
        }

        return ans;
    }

    public boolean isOppositeSigns(int a, int b)
    {
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }
}
