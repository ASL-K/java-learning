package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

public class HouseService {
    private House[] houses;//保存House对象
    private int houseNums=1;//记录当前有多少个房屋信息
    private int idCounter=1;//记录当前房屋自增长到什么值
    public HouseService(int size)
    {
        //new house
        houses=new House[size];//当创建HouseService对象，指定数组大小
        //为了配合测试列表信息，初始化一个House对象
        houses[0]=new House(1,"jack","122","海定区",2000,"未出租");
    }

    //find方法 返回House对象或者null
    public House findById(int findId)//查找房屋编号
    {
        //遍历数组
        for(int i=0;i<houseNums;i++)
        {
            if (findId == houses[i].getId())
            {
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId)
    {
        //应当先找到删除的房屋信息对应的下标
        //下标和房屋的编号不是一回事
        int index=-1;
        for(int i=0;i<houseNums;i++)
        {
            if(delId==houses[i].getId())
            {//要删除的房屋id，是数组下标为i的元素
                index=i;//就使用index记录i
            }
        }
        if(index==-1)
        {//说明index在数组中不存在
            return false;
        }
        for(int i=index;i<houseNums-1;i++)
        {
            houses[i]=houses[i+1];
        }
        //把当有存在的房屋信息的最后一个 设置null
        houses[--houseNums]=null;
        return true;

    }

    //add方法，添加新对象，返回bollen
    public boolean add(House newHouse)
    {
        //判断是否还可以继续添加(暂时不考虑数组扩容的问题)
        if(houseNums>=houses.length)
        {//已满
            System.out.println("数组已满，不能再添加了");
            return false;
        }
        //把newHouse对象加入到新增加了一个房屋
        houses[houseNums++]=newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
    //list方法，返回houses
    public House[] list()
    {
        return houses;
    }
}
