import java.util.ArrayList;

public class Group4 extends Thread{
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
        int aver_chaos = (int) Math.round(Math.random() * 100);
        for (var elem:int_list) {
            for (int id = 50; id < 211; id+=7) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*19 || true_counter == Math.random()*19 || true_counter == Math.random()*3 || true_counter == Math.random()*5 || true_counter == 16 || true_counter == 23)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_chaos, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_chaos, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_chaos, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_chaos, elem, state});

                }
                if (aver_chaos < 20)
                    aver_chaos += 75;
                else if (aver_chaos < 30 )
                    aver_chaos -= 15;
                else if (aver_chaos < 62 && aver_chaos > 56)
                    aver_chaos -= 14;
                else if (aver_chaos > 70 && aver_chaos < 93)
                    aver_chaos -= 24;
                else if (aver_chaos > 63 && aver_chaos < 67)
                    aver_chaos += 18;
                else if (aver_chaos < 50 & aver_chaos > 35)
                    aver_chaos -= 15;
                else
                    aver_chaos -= 3;
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
