import java.util.ArrayList;

public class Group4 extends Thread{
    ArrayList<ArrayList<ArrayList<Object>>> list = new ArrayList<>();
    ArrayList<Integer> int_list = new ArrayList<Integer>(3);

    /**
     * Don't launch it manually. Do calling only by another methods of this class.
     */
    @Override
    public void run() {
        /*String[] what1 = {"Essay", "Lecture", "Lesson", "HomeWork", "Task"};
        String[] what2 = {"Lecture", "Lesson", "HomeWork", "Task", "Exam"};
        String[] what3 = {"Lecture", "HomeWork", "Exam", "Essay"};
        String[] what4 = {"Lecture", "HomeWork", "Task", "Exam"};*/
        var list1 = new ArrayList<ArrayList<Object>>();
        int count = 0;
        int counter1 = 0;
        int true_counter = 0;
        Object zer = (Object) 0;
        boolean state = true;
        int aver_chaos = (int) Math.round(Math.random() * 100);
        for (var elem:int_list) {
            for (int id = 50; id < 211; id+=7) {
                true_counter++;
                // We checking if he attended classes
                ArrayList<Object> lst = new ArrayList<>();
                lst.add(id);
                for (int i = 1; i < Main.lessns_am; i++) {
                    state = i != (int) Math.round(Math.random() * 19) && true_counter != (int) Math.round(Math.random() * 17) && true_counter != (int) Math.round(Math.random() * 3) && true_counter != (int) Math.round(Math.random() * 5) && true_counter != (int) Math.round(Math.random() * 6) && true_counter != (int) Math.round(Math.random() * 8);
                    lst.add(state);
                }
                list1.add(lst);
                /*if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    if (what1[counter1].equals("Sochinenie") || what1[counter1].equals("HomeWork") || what1[counter1].equals("Task") || what1[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, elem, state});
                        else
                            list1.add(new Object[]{id, elem, state});
                    } else
                        list1.add(new Object[]{id, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    if (what2[counter1].equals("Sochinenie") || what2[counter1].equals("HomeWork") || what2[counter1].equals("Task") || what2[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, elem, state});
                        else
                            list1.add(new Object[]{id, elem, state});
                    } else
                        list1.add(new Object[]{id, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    if (what3[counter1].equals("Sochinenie") || what3[counter1].equals("HomeWork") || what3[counter1].equals("Task") || what3[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, elem, state});
                        else
                            list1.add(new Object[]{id, elem, state});
                    } else
                        list1.add(new Object[]{id, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    if (what4[counter1].equals("Sochinenie") || what4[counter1].equals("HomeWork") || what4[counter1].equals("Task") || what4[counter1].equals("Exam")) {
                        if (state)
                            list1.add(new Object[]{id, elem, state});
                        else
                            list1.add(new Object[]{id, elem, state});
                    } else
                        list1.add(new Object[]{id, elem, state});

                }*/
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
            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<ArrayList<Object>>) list1.clone());
            list1.clear();
        }
    }

    /**
     * This method automatically start thread and return students with all data
     * @param list
     * @param int_list
     * @return ArrayList<ArrayList<Object[]>>
     * @throws InterruptedException
     */
    public ArrayList<ArrayList<ArrayList<Object>>> write(ArrayList<ArrayList<ArrayList<Object>>> list, ArrayList<Integer> int_list) throws InterruptedException {
        this.int_list = int_list;
        this.list = list;
        this.start();
        this.join();
        return this.list;
    }
}
