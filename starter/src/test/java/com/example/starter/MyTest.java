package com.example.starter;

import java.util.*;

public class MyTest {


  public static void main(String[] args) {
      List<List<String>> res = new ArrayList<>();

    //声明一个布尔数组，用来判断某个索引位置的数字是否被使用过了
    boolean[] used = {};
    String arrs[] = {"a","b"};
    System.out.println(String.valueOf(arrs));
    List<List<String>> lists = permute(arrs,res,used);
    ArrayList<String> strings1 = new ArrayList<>();
    for (List<String> strings : lists){
      StringBuilder builder = new StringBuilder();
      for (String s :strings){
        builder.append(s).append(",");
      }
      strings1.add(builder.deleteCharAt(builder.length() -1).toString());
    }
    System.out.println(strings1);
  }

  public static List<List<String>> permute(String[] arrs, List<List<String>> res,boolean[] used) {
    if (arrs.length == 0) {
      return res;
    }
    used = new boolean[arrs.length];
    List<String> preList = new ArrayList<>();
    generatePermutation(arrs, 0, preList,res,used);
    return res;
  }
  /**
   * 回溯
   * @param arrs 给定数组
   * @param index 当前考察的索引位置
   * @param preList 先前排列好的子序列
   */
  private static void generatePermutation(String[] arrs,int index,List<String> preList,List<List<String>> res,boolean[] used) {
    //index 等于给定数组的长度时，说明一种排列已经形成，直接将其加入成员变量 res 里
    if (index == arrs.length) {
      //这里需要注意java的值传递
      //此处必须使用重新创建对象的形式，否则 res 列表中存放的都是同一个引用
      res.add(new ArrayList<>(preList));
      return;
    }
    for(int i = 0; i < arrs.length ;i++) {
      if (!used[i]) {
        preList.add(arrs[i]);
        used[i] = true;
        generatePermutation(arrs, index + 1, preList,res,used);
        //一定要记得回溯状态
        preList.remove(preList.size() - 1);
        used[i] = false;
      }
    }
    return;
  }
}
