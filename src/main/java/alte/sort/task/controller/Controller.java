package alte.sort.task.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//class controller link client and server
@RestController
//all request to path "/sort"
@RequestMapping("sort")
//annotation for different hosts
@CrossOrigin
public class Controller {

    //request by client, get number and send List arrays
    @GetMapping
    public List<Integer[]> result(@RequestParam(value = "number", defaultValue = "10") String number) {
        return handler(number);
    }
    //function generation random arrays
    private List<Integer[]> handler(String number) {
        int num = Integer.parseInt(number);
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = ((int) (Math.random() * num) + 1);
        }
        return functionSort(arr);
    }
    //function bubble sort
    private List<Integer[]> functionSort(Integer[] arr) {
        List<Integer[]> data = new ArrayList<>();
        data.add(arr.clone());
        int size = arr.length;
        //if temp = false, so no enter to if line 40
        boolean temp;
        for (int i = 0; i < size; i++) {
            temp = false;
            for (int j = 1; j < (size - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    swapElement(arr, j);
                    temp = true;
                }
            }
            data.add(arr.clone());
            if (temp == false) {
                return data;
            }
        }
        return data;
    }
    //function swap two numbers
    private void swapElement(Integer[] arr, int j) {
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
    }
}
