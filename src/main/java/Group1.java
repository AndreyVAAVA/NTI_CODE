import java.util.ArrayList;
import java.util.List;

public class Group1 extends Thread{
    ArrayList<ArrayList<Object[]>> list = new ArrayList<ArrayList<Object[]>>();
    ArrayList<Integer> int_list = new ArrayList<Integer>(3);
    /**
     * Don't launch it manually. Do calling only by another methods of this class.
     */
    @Override
    public void run() {
        String[] what1 = {"Essay", "Lecture", "Lesson", "HomeWork", "Task"};
        String[] what2 = {"Lecture", "Lesson", "HomeWork", "Task", "Exam"};
        String[] what3 = {"Lecture", "HomeWork", "Exam", "Essay"};
        String[] what4 = {"Lecture", "HomeWork", "Task", "Exam"};
        var list1 = new ArrayList<Object[]>();

        int aver_cool = (int) Math.round(Math.random() * 20 + 80);
        int count = 0;
        int counter1 = 0;
        int true_counter = 0;
        Object zer = (Object) 0;
        boolean state = true;
        for (var elem:int_list) {
            for (int id = 0; id < 12; id++) {
//                true_counter++;
                state = true_counter != (int) Math.round(Math.random() * 8);
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    if (what1[counter1].equals("Sochinenie") || what1[counter1].equals("HomeWork") || what1[counter1].equals("Task") || what1[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, what1[counter1], aver_cool, elem, state});
                        else
                            list1.add(new Object[]{id, what1[counter1], zer, elem, state});
                    } else {
                        list1.add(new Object[]{id, what1[counter1], "No result for this", elem, state});
                    }
                } else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    if (what2[counter1].equals("Sochinenie") || what2[counter1].equals("HomeWork") || what2[counter1].equals("Task") || what2[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, what2[counter1], aver_cool, elem, state});
                        else
                            list1.add(new Object[]{id, what2[counter1], zer, elem, state});
                    } else {
                        list1.add(new Object[]{id, what2[counter1], "No result for this", elem, state});
                    }
                } else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    if (what3[counter1].equals("Sochinenie") || what3[counter1].equals("HomeWork") || what3[counter1].equals("Task") || what3[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, what3[counter1], aver_cool, elem, state});
                        else
                            list1.add(new Object[]{id, what3[counter1], zer, elem, state});
                    } else {
                        list1.add(new Object[]{id, what3[counter1], "No result for this", elem, state});
                    }
                } else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    if (what4[counter1].equals("Sochinenie") || what4[counter1].equals("HomeWork") || what4[counter1].equals("Task") || what4[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, what4[counter1], aver_cool, elem, state});
                        else
                            list1.add(new Object[]{id, what4[counter1], zer, elem, state});
                    } else {
                        list1.add(new Object[]{id, what4[counter1], "No result for this", elem, state});
                    }
                }
                if (aver_cool < 90)
                    aver_cool += 7;
                else
                    aver_cool -= 2;
                counter1++;

            }
            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }

    }
    /**
     * This method automatically start thread and return students with all data
     * @param int_list
     * @return ArrayList<ArrayList<Object[]>>
     * @throws InterruptedException
     */
    public ArrayList<ArrayList<Object[]>> write(ArrayList<Integer> int_list) throws InterruptedException {
            this.int_list = int_list;
            this.start();
            this.join();
            return list;
    }
}
