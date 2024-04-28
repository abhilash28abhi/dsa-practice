package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
 * You are given two integer arrays students and sandwiches. Return the number of students that are unable to eat.
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively.
 * All students stand in a queue. Each student either prefers square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack.
 * At each step:
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 *
 * Example 1:
 *
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 * Example 2:
 *
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 */
public class _2_NoOfStudentsLunch {

    public static void main(String[] args) {
        Queue<Integer> students = new LinkedList<>();
        students.add(1);students.add(1);//students.add(1);
        students.add(0);students.add(0);//students.add(1);
        Stack<Integer> sandwiches = new Stack<>();
        sandwiches.push(1);
        sandwiches.push(0);//sandwiches.push(0);
        sandwiches.push(1);sandwiches.push(0);//sandwiches.push(1);

        System.out.println("No of students who were unable to eat is : " + studentsUnableToEat(students, sandwiches));
    }

    //TC is O(N)
    //SC is O(1)
    private static int studentsUnableToEat(Queue<Integer> students, Stack<Integer> sandwiches) {
        int notEatenCount = 0;

        while (!students.isEmpty() && notEatenCount < students.size()) {
            Integer studentFromFront = students.poll();
            Integer sandwichAtTop = sandwiches.peek();
            if (studentFromFront == sandwichAtTop) {
                sandwiches.pop();
                notEatenCount = 0;
            } else {
                notEatenCount++;
                students.add(studentFromFront);
            }
        }
        return students.size();
    }
}
