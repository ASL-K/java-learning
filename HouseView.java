package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utils;

public class HouseView {
    private boolean loop = true;//控制显示主菜单
    private char key = ' ';//接收用户选择
    private HouseService houseService = new HouseService(10);//设置数组的大小为10


    //根据id修改房屋信息
    public void update()
    {
        System.out.println("===========修改房屋信息============");
        System.out.println("请选择待修改房屋编号(-1表示退出)");
        int updateId=Utils.readInt();
        if(updateId==-1)
        {
            System.out.println("===========放弃修改房屋信息============");
            return;
        }
        //根据输入得到updateId,查找对象
        House house = houseService.findById(updateId);//返回的是引用类型 就是数组的元素
        //因此对house.setxxx(),就会修改HouseService中house的数组的元素
        if(house==null)
        {
            System.out.println("===========修改房屋信息不存在============");
            return;
        }
        System.out.println("姓名("+house.getName()+"):");
        String name=Utils.readString(8,"");//用户直接回车表示不修改该信息
        if(!"".equals(name))
        {
            house.setName(name);
        }
        System.out.println("电话("+house.getPhone()+"):");
        String phone=Utils.readString(12,"");//用户直接回车表示不修改该信息
        if(!"".equals(phone))
        {
            house.setPhone(phone);
        }
        System.out.println("地址("+house.getAddress()+"):");
        String address=Utils.readString(18,"");//用户直接回车表示不修改该信息
        if(!"".equals(address))
        {
            house.setAddress(address);
        }
        System.out.println("租金("+house.getRent()+"):");
        int rent=Utils.readInt(-1);//用户直接回车表示不修改该信息
        if(rent!=-1)
        {
            house.setRent(rent);
        }
        System.out.println("状态("+house.getState()+"):");
        String state=Utils.readString(3,"");//用户直接回车表示不修改该信息
        if(!"".equals(state))
        {
            house.setState(state);
        }
        System.out.println("===========修改房屋信息成功============");
    }
    //根据id查找房屋信息
    public void findHouse()
    {
        System.out.println("===========查找房屋信息============");
        System.out.println("请输入要查找的id:");
        int findId=Utils.readInt();
        //调用方法
        House house=houseService.findById(findId);
        if(house!=null)
        {
            System.out.println(house);
        }else {
            System.out.println("===========查找房屋信息不存在============");
        }

    }

    //完成退出确认
    public void exit()
    {
        char c=Utils.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }

    //编写delHouse() 接收输入的id 调用Service 的del方法
    public void delHouse()
    {
        System.out.println("===========删除房屋信息============");
        System.out.println("请输入待删除房屋的编号(-1退出):");
        int delId=Utils.readInt();
        if(delId==-1)
        {
            System.out.println("===========放弃删除房屋============");
            return;
        }

        //注意该方法本身就有循环判断的逻辑，必须输入Y/N
        char choice=Utils.readConfirmSelection();
        if(choice=='Y')
        {
            if(houseService.del(delId))
            {
                System.out.println("===========删除房屋信息成功============");
            }else {
                System.out.println("===========房屋编号不存在，删除失败============");
            }

        }else {
            System.out.println("===========放弃删除房屋信息============");
        }
    }

    //编写addHouse()接收输入，创建House 对象 调用add方法
    public void addHouse()
    {
        System.out.println("===========添加房屋============");
        System.out.print("姓名: ");
        String name=Utils.readString(8);
        System.out.print("电话: ");
        String phone=Utils.readString(12);
        System.out.print("地址: ");
        String address=Utils.readString(16);
        System.out.print("月租: ");
        int rent=Utils.readInt();
        System.out.print("状态: ");
        String state=Utils.readString(8);
        //创建一个新的House对象，注意id是系统分配的
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house))
        {
            System.out.println("===========添加房屋成功============");
        }else {
            System.out.println("===========添加房屋失败============");
        }
    }

    //编写listHouse()显示房屋列表
    public void listHouse()
    {
        System.out.println("===========房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] house = houseService.list();//得到所有房屋信息
        for(int i=0;i<house.length;i++)
        {
            if(house[i]==null)
            {
                break;
            }
            System.out.println(house[i]);
        }
        System.out.println("===========房屋列表显示完毕============");
    }
    //显示主菜单
    public void mainMenu()
    {
        do{
            System.out.println("\n===========房屋出租系统菜单============");
            System.out.println("\t\t\t1.新增房源");
            System.out.println("\t\t\t2.查找房源");
            System.out.println("\t\t\t3.删除房屋信息");
            System.out.println("\t\t\t4.修改房屋信息");
            System.out.println("\t\t\t5.房屋列表");
            System.out.println("\t\t\t6.退出");
            System.out.println("请输入你的选择（1-6)");
            key= Utils.readChar();
            switch(key)
            {
                case'1':
                   addHouse();
                    break;
                case'2':
                    findHouse();
                    break;
                case'3':
                   delHouse();
                    break;
                case'4':
                    update();
                    break;
                case'5':
                    listHouse();
                    break;
                case'6':
                   exit();
                    break;
            }
        }while(loop);

    }
}
