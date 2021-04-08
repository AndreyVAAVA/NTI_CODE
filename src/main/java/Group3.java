import java.util.ArrayList;

public class Group3 extends Thread {
    ArrayList<ArrayList<ArrayList<Object>>> list = new ArrayList<>();
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
        var list1 = new ArrayList<ArrayList<Object>>();
        int count = 0;
        int counter1 = 0;
        int true_counter = 0;
        Object zer = (Object) 0;
        boolean state = true;
        int aver_low = (int) Math.round(Math.random() * 20 + 40);
        for (var elem:int_list) {
            for (int id = 137; id < 233; id+=5) {
                true_counter++;
                // We checking if he attended classes
                ArrayList<Object> lst = new ArrayList<>();
                lst.add(id);
                for (int i = 1; i < Main.lessns_am; i++) {
                    state = i != (int) Math.round(Math.random() * 13) && true_counter != (int) Math.round(Math.random() * 6) && true_counter != (int) Math.round(Math.random() * 3) && true_counter != (int) Math.round(Math.random() * 5) && true_counter != (int) Math.round(Math.random() * 7) && true_counter != (int) Math.round(Math.random() * 4) && true_counter != (int) Math.round(Math.random() * 2) && true_counter != (int) Math.round(Math.random() * 9) && true_counter != (int) Math.round(Math.random() * 4) && true_counter != (int) Math.round(Math.random() * 8) && true_counter != (int) Math.round(Math.random() * 11) && true_counter != (int) Math.round(Math.random() * 3) && true_counter != (int) Math.round(Math.random() * 9) && true_counter != (int) Math.round(Math.random() * 10)&& true_counter != (int) Math.round(Math.random() * 16)&& true_counter != (int) Math.round(Math.random() * 19)&& true_counter != (int) Math.round(Math.random() * 18);

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
                        list1.add(new Object[]{id, elem, state});
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
