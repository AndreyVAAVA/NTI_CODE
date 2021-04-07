import java.util.ArrayList;

public class Group3 extends Thread {
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
        int aver_low = (int) Math.round(Math.random() * 20 + 40);
        for (var elem:int_list) {
            for (int id = 137; id < 233; id+=5) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*19 || true_counter == Math.random()*19 || true_counter == Math.random()*3 || true_counter == Math.random()*5 || true_counter == 4 || true_counter == 7)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_low, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_low, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_low, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_low, elem, state});
                }
                if (aver_low < 30)
                    aver_low += 12;
                else if (aver_low < 37)
                    aver_low += 17;
                else if (aver_low > 50)
                    aver_low -= 9;
                else
                    aver_low -= 2;
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
