package com.Face.service.impl;

import com.Face.dao.TestDataDao;
import com.Face.model.TestData;
import com.Face.service.ITestDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service("iTestDataService")
public class TestDataServiceImpl implements ITestDataService {

    @Autowired
    private TestDataDao testDataDao;

    @Override
    public int insertTestData(TestData testData) {
        if(testData.getId() == null || testData.equals("")){
            testData.setId(UUID.randomUUID().toString());
        }
        //TODO
        //加入客户的ID
        return testDataDao.insertTestData(testData);
    }

    @Override
    public PageInfo selectAllTestData(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TestData> testDataList = testDataDao.selectAllTestData();
        PageInfo pageResult = new PageInfo(testDataList);
        pageResult.setList(testDataList);
        return pageResult;
    }
}
