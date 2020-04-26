package com.example.service.impl;

import com.example.mapper.StuMapper;
import com.example.pojo.Stu;
import com.example.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hufei
 * @date 2020/4/25
 */
@Service
public class StuServiceImpl implements StuService {

    private StuMapper stuMapper;

    @Override
    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("parent");
        stu.setAge(22);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void saveChild() {
        saveChild1();
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveChild2();
    }

    private void saveChild1() {
        Stu stu = new Stu();
        stu.setName("child1");
        stu.setAge(11);
        stuMapper.insert(stu);
    }

    private void saveChild2() {
        Stu stu = new Stu();
        stu.setName("child2");
        stu.setAge(11);
        stuMapper.insert(stu);
    }



    @Autowired
    public void setStuMapper(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }
}
