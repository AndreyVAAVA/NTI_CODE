import java.util.ArrayList;

public class Group2 extends Thread{
    ArrayList<ArrayList<Object[]>> list = new ArrayList<ArrayList<Object[]>>();
    ArrayList<Integer> int_list = new ArrayList<Integer>(3);
    /**
     * Don't launch it manually. Do calling only by another methods of this class.
     */
    @Override
    public void run() {
        String[] what1 = {"Sochinenie", "Lecture", "Lesson", "HomeWork", "Task"};
        String[] what2 = {"Lecture", "Lesson", "HomeWork", "Task", "Exam"};
        String[] what3 = {"Lecture", "HomeWork", "Exam"};
        String[] what4 = {"Lecture", "HomeWork", "Task", "Exam"};
        var list1 = new ArrayList<Object[]>();
        int count = 0;
        int counter1 = 0;
        int true_counter = 0;
        boolean state = true;
        int aver_mid = (int) Math.round(Math.random() * 20 + 60);
        for (var elem:int_list) {
            for (int id = 24; id < 360; id+=24) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*15 || true_counter == 12 || true_counter == 6)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_mid, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_mid, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_mid, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_mid, elem, state});
                }
                if (aver_mid < 55)
                    aver_mid += 25;
                else if (aver_mid < 62)
                    aver_mid += 6;
                else if (aver_mid > 70)
                    aver_mid -= 8;
                else
                    aver_mid -= 3;
                counter1++;
            }
//            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }
    }
    /**
     * This method automatically start thread and return students with all data
     * @param list
     * @param int_list
     * @return
     * @throws InterruptedException
     */
    public ArrayList<ArrayList<Object[]>> write(ArrayList<ArrayList<Object[]>> list, ArrayList<Integer> int_list) throws InterruptedException {
        this.int_list = int_list;
        this.list = list;
        this.start();
        this.join();
        return this.list;
    }
}
