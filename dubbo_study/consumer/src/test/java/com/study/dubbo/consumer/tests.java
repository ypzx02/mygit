package com.study.dubbo.consumer;

import com.study.dubbo.model.UserDO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName tests
 * @Description TODO
 * @Author whj
 * @Date 2019/6/24 20:17
 * @Version 1.0
 */
public class tests {


    public static void main(String[] args) {
        ArrayList<UserDO> flows = new ArrayList<UserDO>();
        for (int i=0;i<1000000;i++){
            UserDO flow = new UserDO();
            flow.setName("tom" + i);
            flow.setId("00" + i);
            flow.setGender(i);
            flow.setAge(i);
            flows.add(flow);
        }

        /***
         * @since 1.8
         */
      /*  List<String> list = flows.stream().map(UserDO::getId).collect(Collectors.toList())
                            ;
        String max = list.parallelStream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).get();*/
        long time1 = System.currentTimeMillis();
        Collections.sort(flows, new Comparator<UserDO>() {
            @Override
            public int compare(UserDO o1, UserDO o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        String max1 = flows.get(0).getId();
        long time2 = System.currentTimeMillis();
        long time = time2 - time1;
        System.out.println("sort----执行了："+time+"秒！");
        System.out.println("-------------分割线-------------");
        long time3 = System.currentTimeMillis();
        ArrayList<String> strings = new ArrayList<>();
        for (UserDO userDO:flows){
            strings.add(userDO.getId());
        }
        String max3 = Collections.max(strings);
        long time4 = System.currentTimeMillis();
        long time5 = time4 - time3;
        System.out.println("max----执行了："+time5+"秒！");


    }


}
