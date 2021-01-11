import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    List<List> nodeList = new ArrayList<List>();

    public static void main(String[] args) {
        Problem3 ad = new Problem3();
        String filePath = "/Users/Vikas/Downloads/untitled/src/main/resources/triangle.txt";
        ad.readFile(filePath);
        int index = 0;
        int num1 = 0, num2 = 0, sum = 0;
        boolean first = true;
        for (List a : ad.nodeList) {
            if (first) {
                num1 = (Integer) a.get(index);
                sum = num1;

                first = false;
            } else {
                num1 = (Integer) a.get(index);
                num2 = (Integer) a.get(index + 1);
                if (num1 > num2) {
                    sum += num1;

                } else {
                    sum += num2;
                    index++;

                }
            }

        }
        System.out.println("\nThe sum total is = " + sum);
    }

    public void readFile(String path) {
        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new FileReader(path));
            String tmp = bis.readLine();
            while (tmp != null) {
                String[] nums = tmp.split("\\s+");
                List<Integer> a = new ArrayList<Integer>();
                for (int i = 0; i < nums.length; i++) {
                    a.add(Integer.parseInt(nums[i]));
                }
                nodeList.add(a);
                tmp = bis.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

}